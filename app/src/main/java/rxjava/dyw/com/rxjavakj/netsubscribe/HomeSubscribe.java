package rxjava.dyw.com.rxjavakj.netsubscribe;


import android.content.Context;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rxjava.dyw.com.rxjavakj.beans.Comment;
import rxjava.dyw.com.rxjavakj.beans.ZixunD;
import rxjava.dyw.com.rxjavakj.netapi.BaseUrlConfig;
import rxjava.dyw.com.rxjavakj.netapi.HomeApiService;
import rxjava.dyw.com.rxjavakj.netutils.BaseSubscribe;
import rxjava.dyw.com.rxjavakj.netutils.ResponseListener;
import rxjava.dyw.com.rxjavakj.netutils.RetrofitManager;
import rxjava.dyw.com.rxjavakj.netutils.RetrofitMultiBaseUrlManager;

/**
 * Created by wdy on 2019/3/13.
 */

public class HomeSubscribe extends BaseSubscribe {
    private HomeApiService api;
    private HomeApiService api2;

    public HomeSubscribe() {
        api = RetrofitManager.getInstance().create(HomeApiService.class);
        api2 = RetrofitMultiBaseUrlManager.getApiImp(BaseUrlConfig.BASE_URL_API, HomeApiService.class);
    }

    public void getComment(Context context, final ResponseListener<List<Comment>> listener) {
        Map<String, String> source = new HashMap<>();
        toDetachAndSubscribe(api.initComments(source), listener);
    }

    public void getZixun(Context context, final ResponseListener<ZixunD> listener) {
        Map<String, String> source = new HashMap<>();
        source.put("device_type", "1");
        toDetachAndSubscribe(api2.initZixuns(source), listener);
    }
}
