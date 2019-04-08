package rxjava.dyw.com.rxjavakj.netutils;

/**
 * Created by wdy on 2019/3/14.
 */

public class DataAndMessage<T> {
    private String msg;
    private T data;
    public DataAndMessage(String msg, T data) {
        this.msg = msg;
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }
}
