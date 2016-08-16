package com.example.mypc.dogliveshow.dao;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by JiaFan on 2016/8/16 09:01
 * QQ：1319662955
 */
@DatabaseTable(tableName = "user")
public class User implements Serializable {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private String name;
    @DatabaseField
    private String pwd;
    @DatabaseField
    private String favContent;
    @DatabaseField
    private String favUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getFavContent() {
        return favContent;
    }

    public void setFavContent(String favContent) {
        this.favContent = favContent;
    }

    public String getFavUrl() {
        return favUrl;
    }

    public void setFavUrl(String favUrl) {
        this.favUrl = favUrl;
    }
}

