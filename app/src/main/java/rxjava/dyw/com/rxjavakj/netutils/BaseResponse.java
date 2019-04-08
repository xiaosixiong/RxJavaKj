package rxjava.dyw.com.rxjavakj.netutils;

/**
 * Created by wdy on 2019/3/13.
 */

public class BaseResponse<T> {
    private int status;
    public T data;
    int errorCode;
    String message;
    boolean isSuccess(){
        return status == 1;
    }
}
