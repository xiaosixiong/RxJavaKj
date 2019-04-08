package rxjava.dyw.com.rxjavakj.netutils;

/**
 * Created by wdy on 2019/3/22.
 */

public abstract class DataResponseListener<T> implements ResponseListener<T> {

    @Override
    public void onNetFault(String errorMsg, int errorCode) {
        //Todo 统一处理网络问题导致的请求错误
    }

}
