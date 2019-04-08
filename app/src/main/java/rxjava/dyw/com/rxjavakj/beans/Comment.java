package rxjava.dyw.com.rxjavakj.beans;

/**
 * Created by wdy on 2019/3/13.
 */

public class Comment {

    private String comment_id;
    private String content;
    private String datetime;
    private String record_id;
    private String category_id;
    private String username;
    private boolean localSetreport;
    private String uid;
    private String third_avatar;
    private String avatar;
    private String more_reply_num;
    private String rank;
    private String sex;
    private String r_img;
    private String winner_icon;
    private boolean is_more;
    private String vip_avatar_frame; // vip头像框
    private String vip_grade_mark; // vip等级标识
    private int isvip; // 2=vip，其他都不是

    public String getComment_id() {
        return comment_id;
    }

    public void setComment_id(String comment_id) {
        this.comment_id = comment_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getRecord_id() {
        return record_id;
    }

    public void setRecord_id(String record_id) {
        this.record_id = record_id;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isLocalSetreport() {
        return localSetreport;
    }

    public void setLocalSetreport(boolean localSetreport) {
        this.localSetreport = localSetreport;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getThird_avatar() {
        return third_avatar;
    }

    public void setThird_avatar(String third_avatar) {
        this.third_avatar = third_avatar;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getMore_reply_num() {
        return more_reply_num;
    }

    public void setMore_reply_num(String more_reply_num) {
        this.more_reply_num = more_reply_num;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getR_img() {
        return r_img;
    }

    public void setR_img(String r_img) {
        this.r_img = r_img;
    }

    public String getWinner_icon() {
        return winner_icon;
    }

    public void setWinner_icon(String winner_icon) {
        this.winner_icon = winner_icon;
    }

    public boolean isIs_more() {
        return is_more;
    }

    public void setIs_more(boolean is_more) {
        this.is_more = is_more;
    }

    public String getVip_avatar_frame() {
        return vip_avatar_frame;
    }

    public void setVip_avatar_frame(String vip_avatar_frame) {
        this.vip_avatar_frame = vip_avatar_frame;
    }

    public String getVip_grade_mark() {
        return vip_grade_mark;
    }

    public void setVip_grade_mark(String vip_grade_mark) {
        this.vip_grade_mark = vip_grade_mark;
    }

    public int getIsvip() {
        return isvip;
    }

    public void setIsvip(int isvip) {
        this.isvip = isvip;
    }
}