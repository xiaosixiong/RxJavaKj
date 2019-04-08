package rxjava.dyw.com.rxjavakj.netutils;

/**
 * Created by wdy on 2019/3/13.
 */

public class DataFaultException extends Exception {

    private int errorCode;

    public DataFaultException(int errorCode, String message) {
        super(message);
        this.errorCode=errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

}
