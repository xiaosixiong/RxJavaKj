package rxjava.dyw.com.rxjavakj.netutils;

/**
 * Created by wdy on 2019/3/14.
 */

public interface ResponseListener<T> {
    void onNetFault(String errorMsg, int errorCode);

    void onDataFault(String errorMsg, int errorCode);

    void onDataSuccess(T data, String msg);
}
