package com.example.mypc.dogliveshow.bean.headlinebean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by JiaFan on 2016/8/12 17:07
 * QQ：1319662955
 */
public class PicsBean {
    @SerializedName("width")
    private int width;
    @SerializedName("small_url")
    private String smallUrl;
    @SerializedName("height")
    private int height;
    @SerializedName("is_gif")
    private int isGif;
    @SerializedName("img_pos")
    private String imgPos;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getSmallUrl() {
        return smallUrl;
    }

    public void setSmallUrl(String smallUrl) {
        this.smallUrl = smallUrl;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getIsGif() {
        return isGif;
    }

    public void setIsGif(int isGif) {
        this.isGif = isGif;
    }

    public String getImgPos() {
        return imgPos;
    }

    public void setImgPos(String imgPos) {
        this.imgPos = imgPos;
    }
}
