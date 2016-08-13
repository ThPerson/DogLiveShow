package com.example.mypc.dogliveshow.bean.headlinebean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by JiaFan on 2016/8/12 17:08
 * QQ：1319662955
 */
public class CateInfosBean {
    @SerializedName("width")
    private String width;
    @SerializedName("name")
    private String name;
    @SerializedName("imgUrl")
    private String imgUrl;
    @SerializedName("height")
    private String height;

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
}
