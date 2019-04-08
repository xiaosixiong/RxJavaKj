package rxjava.dyw.com.rxjavakj.netutils;


import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by wdy on 2019/3/13.
 */
public class BaseSubscribe {

    protected <T> void toDetachAndSubscribe(Observable<? extends BaseResponse<T>> observable, ResponseListener<T> listener) {
        Observable<DataAndMessage<T>> detachedbservable = detachDataAndMessageFrom(observable);
        detachedbservable
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<>(listener));
    }

    private <T> Observable<DataAndMessage<T>> detachDataAndMessageFrom(Observable<? extends BaseResponse<T>> observable) {
        return observable.map(new Function<BaseResponse<T>, DataAndMessage<T>>() {

            @Override
            public DataAndMessage<T> apply(BaseResponse<T> tBaseResponse) throws Exception {
                if (!tBaseResponse.isSuccess()) {
                    throw new DataFaultException(tBaseResponse.errorCode, tBaseResponse.message);
                }
                return new DataAndMessage<>(tBaseResponse.message, tBaseResponse.data);
            }
        });
    }

}
