package com.example.mypc.dogliveshow.bean.classifybean.commentatorbean;

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
     * rawcoverimage : http://i8.pdim.gs/45/008e4e5ff87790d201353c1a843692ab/w338/h190.jpg
     * off_enum : 0
     * sourcename : 熊猫
     * gameurl : http://www.panda.tv/cate/lol
     * id : 4203699705804065995
     * roomid : 7000
     * sourcesite : www.panda.tv
     * title : ll升降赛  OMG v YM
     * allnum : 0
     * queryname_enum : 1
     * invalid : 0
     * nocopyright : 0
     * name : 英雄联盟
     * usehtml5 : 1
     * fixrank : 0
     * sogoupv : 136597
     * gamecoverimage_width : 0
     * html5_allowpopup : 1
     * commentator : LPL熊猫TV官方直播
     * renqi : 245910
     * viewers : 1978442
     * html5_autoplay : 1
     * url : http://www.panda.tv/7000
     * rawcommentatorimage : http://i2.pdim.gs/t019df5aa44cbccb49b.jpg
     * gamecoverimage_height : 0
     * html5_url : http://m.panda.tv/room.html?roomid=7000
     * finalrank : 1
     * infotype : live
     * sourcename_enum : 6
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