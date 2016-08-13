package com.example.mypc.dogliveshow.bean.headlinebean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by JiaFan on 2016/8/12 17:06
 * QQ：1319662955
 */
public class UserInfoBean {
    @SerializedName("user_id")
    private int userId;
    @SerializedName("user_name")
    private String userName;
    @SerializedName("icon")
    private String icon;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
