package rxjava.dyw.com.rxjavakj.netapi;


import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rxjava.dyw.com.rxjavakj.beans.Comment;
import rxjava.dyw.com.rxjavakj.beans.ZixunD;
import rxjava.dyw.com.rxjavakj.netutils.BaseResponse;

/**
 * Created by wdy on 2019/3/13.
 */

public interface HomeApiService {
    /**
     * 获取评论列表
     *
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST("comment/get_new_comment")
    Observable<BaseResponse<List<Comment>>> initComments(@FieldMap Map<String, String> params);

    /**
     * 获取资讯
     *
     * @return
     */
    @FormUrlEncoded
    @POST("article/get_all_article")
    Observable<BaseResponse<ZixunD>> initZixuns(@FieldMap Map<String, String> params);
}
