package com.example.mypc.dogliveshow.bean.classifybean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2016/8/12.
 */
public class DataListBean {
    @SerializedName("name")
    private String name;
    @SerializedName("imgurl")
    private String imgurl;
    @SerializedName("width")
    private int width;
    @SerializedName("height")
    private int height;
    @SerializedName("livenum")
    private int livenum;
    @SerializedName("gameid")
    private String gameid;
    @SerializedName("category")
    private String category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLivenum() {
        return livenum;
    }

    public void setLivenum(int livenum) {
        this.livenum = livenum;
    }

    public String getGameid() {
        return gameid;
    }

    public void setGameid(String gameid) {
        this.gameid = gameid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}