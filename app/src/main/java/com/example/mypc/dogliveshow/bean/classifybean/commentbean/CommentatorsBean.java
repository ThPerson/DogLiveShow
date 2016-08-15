package com.example.mypc.dogliveshow.bean.classifybean.commentbean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2016/8/13.
 */
public class CommentatorsBean {
    @SerializedName("returnnum")
    private int returnnum;
    @SerializedName("pagesize")
    private int pagesize;
    @SerializedName("allnum")
    private int allnum;
    @SerializedName("brand_allnum")
    private int brandAllnum;
    @SerializedName("cache2_allnum")
    private int cache2Allnum;
    @SerializedName("cache_allnum")
    private int cacheAllnum;
    /**
     * follows : 0
     * gamename_enum : 1001
     * channel_enum : 1
     * rawcoverimage : http://snap.quanmin.tv/2333-1471090269-654.jpg?imageView2/2/w/390/
     * off_enum : 0
     * sourcename : 全民
     * gameurl : http://www.quanmin.tv/game/lol
     * roomid : 2333
     * id : 7722409199044057000
     * jsdesc : 全民TV英雄联盟主播,人气最高解说
     * title : 小智:今天又没睡醒!
     * allnum : 0
     * sourcesite : www.quanmin.tv
     * queryname_enum : 1
     * invalid : 0
     * jsid : 4487421976824670700
     * nocopyright : 0
     * name : 英雄联盟
     * usehtml5 : 0
     * fixrank : 0
     * sogoupv : 107973
     * gamecoverimage_width : 0
     * html5_allowpopup : 1
     * commentator : 小智
     * renqi : 208208
     * viewers : 2881225
     * html5_autoplay : 0
     * url : http://www.quanmin.tv/v/2333
     * rawcommentatorimage : http://img03.sogoucdn.com/app/a/100520071/75d0c797420af70d7e259b45597026cb
     * gamecoverimage_height : 0
     * html5_url : http://m.quanmin.tv/v/2333
     * finalrank : 1
     * jstype : 解说达人
     * infotype : live
     * sourcename_enum : 7
     * channel : 游戏
     */

    @SerializedName("gameinfo")
    private List<GameinfoBean> gameinfo;

    public int getReturnnum() {
        return returnnum;
    }

    public void setReturnnum(int returnnum) {
        this.returnnum = returnnum;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public int getAllnum() {
        return allnum;
    }

    public void setAllnum(int allnum) {
        this.allnum = allnum;
    }

    public int getBrandAllnum() {
        return brandAllnum;
    }

    public void setBrandAllnum(int brandAllnum) {
        this.brandAllnum = brandAllnum;
    }

    public int getCache2Allnum() {
        return cache2Allnum;
    }

    public void setCache2Allnum(int cache2Allnum) {
        this.cache2Allnum = cache2Allnum;
    }

    public int getCacheAllnum() {
        return cacheAllnum;
    }

    public void setCacheAllnum(int cacheAllnum) {
        this.cacheAllnum = cacheAllnum;
    }

    public List<GameinfoBean> getGameinfo() {
        return gameinfo;
    }

    public void setGameinfo(List<GameinfoBean> gameinfo) {
        this.gameinfo = gameinfo;
    }


}