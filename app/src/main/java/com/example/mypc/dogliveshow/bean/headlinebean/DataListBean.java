package com.example.mypc.dogliveshow.bean.headlinebean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by JiaFan on 2016/8/12 17:05
 * QQ：1319662955
 */
public class DataListBean {
    @SerializedName("see_count")
    private int seeCount;
    @SerializedName("push_time")
    private int pushTime;
    @SerializedName("name")
    private String name;
    @SerializedName("video_url")
    private String videoUrl;
    @SerializedName("collect_count")
    private int collectCount;
    @SerializedName("order_id")
    private int orderId;
    @SerializedName("agree_count")
    private int agreeCount;
    @SerializedName("excerpt")
    private String excerpt;
    @SerializedName("share_url")
    private String shareUrl;
    @SerializedName("content")
    private String content;
    /**
     * user_id : 37
     * user_name : 主播重案组
     * icon : http://img01.sogoucdn.com/app/a/07/bf1e26468628a4ce748214e47d2680c5
     */

    @SerializedName("user_info")
    private UserInfoBean userInfo;
    @SerializedName("comment_count")
    private int commentCount;
    @SerializedName("hate_count")
    private int hateCount;
    @SerializedName("key_id")
    private int keyId;
    @SerializedName("detail_url")
    private String detailUrl;
    @SerializedName("tags")
    private String tags;
    @SerializedName("page_type")
    private int pageType;
    @SerializedName("cate_list")
    private List<String> cateList;
    /**
     * width : 497
     * small_url : http://img02.sogoucdn.com/app/a/200650/9de959cdd95a9b7f04832988b045f067
     * height : 303
     * is_gif : 0
     * img_pos : left
     */

    @SerializedName("pics")
    private List<PicsBean> pics;
    /**
     * width : 0
     * name : 狗仔直播
     * imgUrl : None
     * height : 0
     */

    @SerializedName("cate_infos")
    private List<CateInfosBean> cateInfos;

    public int getSeeCount() {
        return seeCount;
    }

    public void setSeeCount(int seeCount) {
        this.seeCount = seeCount;
    }

    public int getPushTime() {
        return pushTime;
    }

    public void setPushTime(int pushTime) {
        this.pushTime = pushTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public int getCollectCount() {
        return collectCount;
    }

    public void setCollectCount(int collectCount) {
        this.collectCount = collectCount;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getAgreeCount() {
        return agreeCount;
    }

    public void setAgreeCount(int agreeCount) {
        this.agreeCount = agreeCount;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserInfoBean getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoBean userInfo) {
        this.userInfo = userInfo;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getHateCount() {
        return hateCount;
    }

    public void setHateCount(int hateCount) {
        this.hateCount = hateCount;
    }

    public int getKeyId() {
        return keyId;
    }

    public void setKeyId(int keyId) {
        this.keyId = keyId;
    }

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getPageType() {
        return pageType;
    }

    public void setPageType(int pageType) {
        this.pageType = pageType;
    }

    public List<String> getCateList() {
        return cateList;
    }

    public void setCateList(List<String> cateList) {
        this.cateList = cateList;
    }

    public List<PicsBean> getPics() {
        return pics;
    }

    public void setPics(List<PicsBean> pics) {
        this.pics = pics;
    }

    public List<CateInfosBean> getCateInfos() {
        return cateInfos;
    }

    public void setCateInfos(List<CateInfosBean> cateInfos) {
        this.cateInfos = cateInfos;
    }

}
