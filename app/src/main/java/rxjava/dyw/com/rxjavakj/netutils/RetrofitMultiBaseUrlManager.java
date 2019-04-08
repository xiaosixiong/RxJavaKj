package rxjava.dyw.com.rxjavakj.netutils;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rxjava.dyw.com.rxjavakj.BuildConfig;

/**
 * Created by wdy on 2019/3/13.
 */


public class RetrofitMultiBaseUrlManager {
    private static Map<String, Retrofit> retrofitMap = new HashMap<>();
    private static final int DEFAULT_TIME_OUT = 5;//超时时间 5s
    private static final int DEFAULT_READ_TIME_OUT = 10;

    private static synchronized Retrofit getRetrofit(String baseUrl) {
        if (retrofitMap.get(baseUrl) == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            if (BuildConfig.DEBUG) {
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            } else {
                interceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
            }
            builder.addInterceptor(interceptor);
            builder.connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS);//连接超时时间
            builder.writeTimeout(DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS);//写操作 超时时间
            builder.readTimeout(DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS);//读操作超时时间
            Retrofit retrofit = new Retrofit.Builder()
                    .client(builder.build())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(baseUrl)
                    .build();
            retrofitMap.put(baseUrl, retrofit);
        }
        return retrofitMap.get(baseUrl);
    }


    /**
     * 获取api接口实现
     *
     * @param baseUrl
     * @param apiClass
     * @param <T>
     * @return
     */
    public static <T> T getApiImp(String baseUrl, Class<T> apiClass) {
        return getRetrofit(baseUrl).create(apiClass);
    }
}
