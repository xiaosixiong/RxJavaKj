package rxjava.dyw.com.rxjavakj.ui;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import rxjava.dyw.com.rxjavakj.beans.Comment;
import rxjava.dyw.com.rxjavakj.beans.Zixun;
import rxjava.dyw.com.rxjavakj.beans.ZixunD;
import rxjava.dyw.com.rxjavakj.netsubscribe.HomeSubscribe;
import rxjava.dyw.com.rxjavakj.netutils.DataResponseListener;
import rxjava.dyw.com.rxjavakj.netutils.ResponseListener;

/**
 * Created by wdy on 2019/3/13.
 */

public class MainActivity extends Activity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        HomeSubscribe business = new HomeSubscribe();
        business.getComment(this, new DataResponseListener<List<Comment>>() {


            @Override
            public void onDataFault(String errorMsg, int errorCode) {
                Log.d("wdy", "data error！，errorcode：" + errorCode + "，errorMsg：" + errorMsg);
            }

            @Override
            public void onDataSuccess(List<Comment> data, String msg) {
                Observable.just(data).flatMap(new Function<List<Comment>, ObservableSource<Comment>>() {
                    @Override
                    public ObservableSource<Comment> apply(List<Comment> comments) throws Exception {
                        return Observable.fromIterable(comments);
                    }
                }).filter(new Predicate<Comment>() {
                    @Override
                    public boolean test(Comment comment) throws Exception {
                        return !comment.getContent().equals("1");
                    }
                }).map(new Function<Comment, String>() {

                    @Override
                    public String apply(Comment comment) throws Exception {
                        return comment.getContent();
                    }
                }).subscribeOn(Schedulers.io()).
                        unsubscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<String>() {
                            @Override
                            public void onSubscribe(Disposable d) {
                                Log.d("wdy", "准备！");
                            }

                            @Override
                            public void onNext(String s) {
                                Log.d("wdy", s);
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.d("wdy", e.getMessage());
                            }

                            @Override
                            public void onComplete() {
                                Log.d("wdy", "结束");
                            }
                        });
            }
        });

        business.getZixun(this, new ResponseListener<ZixunD>() {
            @Override
            public void onNetFault(String errorMsg, int errorCode) {
                Log.d("wdy111", "net error！，errorcode：" + errorCode + "，errorMsg：" + errorMsg);
            }

            @Override
            public void onDataFault(String errorMsg, int errorCode) {
                Log.d("wdy111", "data error！，errorcode：" + errorCode + "，errorMsg：" + errorMsg);
            }

            @Override
            public void onDataSuccess(ZixunD data, String msg) {
                Observable.just(data).flatMap(new Function<ZixunD, ObservableSource<Zixun>>() {
                    @Override
                    public ObservableSource<Zixun> apply(ZixunD zixunD) throws Exception {
                        return Observable.fromIterable(zixunD.getList());
                    }
                }).filter(new Predicate<Zixun>() {
                    @Override
                    public boolean test(Zixun comment) throws Exception {
                        return !comment.getTitle().equals("1");
                    }
                }).map(new Function<Zixun, String>() {

                    @Override
                    public String apply(Zixun comment) throws Exception {
                        return comment.getTitle();
                    }
                }).subscribeOn(Schedulers.io()).
                        unsubscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<String>() {
                            @Override
                            public void onSubscribe(Disposable d) {
                                Log.d("wdy111", "准备！");
                            }

                            @Override
                            public void onNext(String s) {
                                Log.d("wdy111", s);
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.d("wdy111", e.getMessage());
                            }

                            @Override
                            public void onComplete() {
                                Log.d("wdy111", "结束");
                            }
                        });
            }

        });

    }

}
