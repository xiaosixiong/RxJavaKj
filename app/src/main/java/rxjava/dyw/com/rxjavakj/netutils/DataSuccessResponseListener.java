package rxjava.dyw.com.rxjavakj.netutils;

/**
 * Created by wdy on 2019/3/22.
 */

public abstract class DataSuccessResponseListener<T> extends DataResponseListener<T> {

    @Override
    public void onDataFault(String errorMsg, int errorCode) {
        //Todo 统一处理数据错误码等
    }
}
