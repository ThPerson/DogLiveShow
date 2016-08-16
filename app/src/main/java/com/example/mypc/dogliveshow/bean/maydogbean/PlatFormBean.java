package com.example.mypc.dogliveshow.bean.maydogbean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by JiaFan on 2016/8/15 14:39
 * QQ：1319662955
 */
public class PlatFormBean {

    /**
     * iosdownloadurl : https://itunes.apple.com/us/app/xiong-maotv-guan-fang-ban/id1106329353?l=zh&ls=1&mt=8
     * rank : 1
     * isshow : 0
     * description : 熊猫TV是最娱乐的直播平台，由国民老公王思聪创办
     * androiddownloadurl : http://dl.pdim.gs/clients/android/pandalive_1.1.5.1364.apk
     * name : 熊猫
     * iconurl : http://img03.sogoucdn.com/app/a/07/1d1dc8b1bbd942295f1a41409861e797
     * sourcename_enum : 6
     * openurl :
     * android_package_name : com.panda.videoliveplatform
     * displayname : 熊猫tv
     */

    @SerializedName("iosdownloadurl")
    private String iosdownloadurl;
    @SerializedName("rank")
    private String rank;
    @SerializedName("isshow")
    private String isshow;
    @SerializedName("description")
    private String description;
    @SerializedName("androiddownloadurl")
    private String androiddownloadurl;
    @SerializedName("name")
    private String name;
    @SerializedName("iconurl")
    private String iconurl;
    @SerializedName("sourcename_enum")
    private String sourcenameEnum;
    @SerializedName("openurl")
    private String openurl;
    @SerializedName("android_package_name")
    private String androidPackageName;
    @SerializedName("displayname")
    private String displayname;

    public String getIosdownloadurl() {
        return iosdownloadurl;
    }

    public void setIosdownloadurl(String iosdownloadurl) {
        this.iosdownloadurl = iosdownloadurl;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getIsshow() {
        return isshow;
    }

    public void setIsshow(String isshow) {
        this.isshow = isshow;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAndroiddownloadurl() {
        return androiddownloadurl;
    }

    public void setAndroiddownloadurl(String androiddownloadurl) {
        this.androiddownloadurl = androiddownloadurl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconurl() {
        return iconurl;
    }

    public void setIconurl(String iconurl) {
        this.iconurl = iconurl;
    }

    public String getSourcenameEnum() {
        return sourcenameEnum;
    }

    public void setSourcenameEnum(String sourcenameEnum) {
        this.sourcenameEnum = sourcenameEnum;
    }

    public String getOpenurl() {
        return openurl;
    }

    public void setOpenurl(String openurl) {
        this.openurl = openurl;
    }

    public String getAndroidPackageName() {
        return androidPackageName;
    }

    public void setAndroidPackageName(String androidPackageName) {
        this.androidPackageName = androidPackageName;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }
}
