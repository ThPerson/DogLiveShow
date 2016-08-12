package com.example.mypc.dogliveshow.bean.homepagetitle;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public  class DataListForYouBean {
            /**
             * map : {"follows":0,"gamename_enum":1001,"channel_enum":1,"rawcoverimage":"http://i9.pdim.gs/45/7173291f73319038de8cf720e520e348/w338/h190.jpg","off_enum":0,"sourcename":"熊猫","gameurl":"http://www.panda.tv/cate/lol","id":"4203699705804065995","roomid":7000,"sourcesite":"www.panda.tv","title":"ll季后赛  WE v VG","allnum":0,"queryname_enum":1,"invalid":0,"nocopyright":0,"name":"英雄联盟","usehtml5":1,"fixrank":0,"sogoupv":135255,"gamecoverimage_width":0,"html5_allowpopup":1,"commentator":"LPL熊猫TV官方直播","renqi":229964,"viewers":2806393,"html5_autoplay":1,"url":"http://www.panda.tv/7000","rawcommentatorimage":"http://i2.pdim.gs/t019df5aa44cbccb49b.jpg","gamecoverimage_height":0,"html5_url":"http://m.panda.tv/room.html?roomid=7000","finalrank":1,"infotype":"live","sourcename_enum":6,"channel":"游戏"}
             */

            @SerializedName("myArrayList")
            private List<MyArrayListBean> myArrayList;

            public List<MyArrayListBean> getMyArrayList() {
                return myArrayList;
            }

            public void setMyArrayList(List<MyArrayListBean> myArrayList) {
                this.myArrayList = myArrayList;
            }

            public static class MyArrayListBean {
                /**
                 * follows : 0
                 * gamename_enum : 1001
                 * channel_enum : 1
                 * rawcoverimage : http://i9.pdim.gs/45/7173291f73319038de8cf720e520e348/w338/h190.jpg
                 * off_enum : 0
                 * sourcename : 熊猫
                 * gameurl : http://www.panda.tv/cate/lol
                 * id : 4203699705804065995
                 * roomid : 7000
                 * sourcesite : www.panda.tv
                 * title : ll季后赛  WE v VG
                 * allnum : 0
                 * queryname_enum : 1
                 * invalid : 0
                 * nocopyright : 0
                 * name : 英雄联盟
                 * usehtml5 : 1
                 * fixrank : 0
                 * sogoupv : 135255
                 * gamecoverimage_width : 0
                 * html5_allowpopup : 1
                 * commentator : LPL熊猫TV官方直播
                 * renqi : 229964
                 * viewers : 2806393
                 * html5_autoplay : 1
                 * url : http://www.panda.tv/7000
                 * rawcommentatorimage : http://i2.pdim.gs/t019df5aa44cbccb49b.jpg
                 * gamecoverimage_height : 0
                 * html5_url : http://m.panda.tv/room.html?roomid=7000
                 * finalrank : 1.0
                 * infotype : live
                 * sourcename_enum : 6
                 * channel : 游戏
                 */

                @SerializedName("map")
                private MapBean map;

                public MapBean getMap() {
                    return map;
                }

                public void setMap(MapBean map) {
                    this.map = map;
                }

                public static class MapBean {
                    @SerializedName("follows")
                    private int follows;
                    @SerializedName("gamename_enum")
                    private int gamenameEnum;
                    @SerializedName("channel_enum")
                    private int channelEnum;
                    @SerializedName("rawcoverimage")
                    private String rawcoverimage;
                    @SerializedName("off_enum")
                    private int offEnum;
                    @SerializedName("sourcename")
                    private String sourcename;
                    @SerializedName("gameurl")
                    private String gameurl;
                    @SerializedName("id")
                    private String id;
                    @SerializedName("roomid")
                    private int roomid;
                    @SerializedName("sourcesite")
                    private String sourcesite;
                    @SerializedName("title")
                    private String title;
                    @SerializedName("allnum")
                    private int allnum;
                    @SerializedName("queryname_enum")
                    private int querynameEnum;
                    @SerializedName("invalid")
                    private int invalid;
                    @SerializedName("nocopyright")
                    private int nocopyright;
                    @SerializedName("name")
                    private String name;
                    @SerializedName("usehtml5")
                    private int usehtml5;
                    @SerializedName("fixrank")
                    private int fixrank;
                    @SerializedName("sogoupv")
                    private int sogoupv;
                    @SerializedName("gamecoverimage_width")
                    private int gamecoverimageWidth;
                    @SerializedName("html5_allowpopup")
                    private int html5Allowpopup;
                    @SerializedName("commentator")
                    private String commentator;
                    @SerializedName("renqi")
                    private int renqi;
                    @SerializedName("viewers")
                    private int viewers;
                    @SerializedName("html5_autoplay")
                    private int html5Autoplay;
                    @SerializedName("url")
                    private String url;
                    @SerializedName("rawcommentatorimage")
                    private String rawcommentatorimage;
                    @SerializedName("gamecoverimage_height")
                    private int gamecoverimageHeight;
                    @SerializedName("html5_url")
                    private String html5Url;
                    @SerializedName("finalrank")
                    private double finalrank;
                    @SerializedName("infotype")
                    private String infotype;
                    @SerializedName("sourcename_enum")
                    private int sourcenameEnum;
                    @SerializedName("channel")
                    private String channel;

                    public int getFollows() {
                        return follows;
                    }

                    public void setFollows(int follows) {
                        this.follows = follows;
                    }

                    public int getGamenameEnum() {
                        return gamenameEnum;
                    }

                    public void setGamenameEnum(int gamenameEnum) {
                        this.gamenameEnum = gamenameEnum;
                    }

                    public int getChannelEnum() {
                        return channelEnum;
                    }

                    public void setChannelEnum(int channelEnum) {
                        this.channelEnum = channelEnum;
                    }

                    public String getRawcoverimage() {
                        return rawcoverimage;
                    }

                    public void setRawcoverimage(String rawcoverimage) {
                        this.rawcoverimage = rawcoverimage;
                    }

                    public int getOffEnum() {
                        return offEnum;
                    }

                    public void setOffEnum(int offEnum) {
                        this.offEnum = offEnum;
                    }

                    public String getSourcename() {
                        return sourcename;
                    }

                    public void setSourcename(String sourcename) {
                        this.sourcename = sourcename;
                    }

                    public String getGameurl() {
                        return gameurl;
                    }

                    public void setGameurl(String gameurl) {
                        this.gameurl = gameurl;
                    }

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public int getRoomid() {
                        return roomid;
                    }

                    public void setRoomid(int roomid) {
                        this.roomid = roomid;
                    }

                    public String getSourcesite() {
                        return sourcesite;
                    }

                    public void setSourcesite(String sourcesite) {
                        this.sourcesite = sourcesite;
                    }

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public int getAllnum() {
                        return allnum;
                    }

                    public void setAllnum(int allnum) {
                        this.allnum = allnum;
                    }

                    public int getQuerynameEnum() {
                        return querynameEnum;
                    }

                    public void setQuerynameEnum(int querynameEnum) {
                        this.querynameEnum = querynameEnum;
                    }

                    public int getInvalid() {
                        return invalid;
                    }

                    public void setInvalid(int invalid) {
                        this.invalid = invalid;
                    }

                    public int getNocopyright() {
                        return nocopyright;
                    }

                    public void setNocopyright(int nocopyright) {
                        this.nocopyright = nocopyright;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public int getUsehtml5() {
                        return usehtml5;
                    }

                    public void setUsehtml5(int usehtml5) {
                        this.usehtml5 = usehtml5;
                    }

                    public int getFixrank() {
                        return fixrank;
                    }

                    public void setFixrank(int fixrank) {
                        this.fixrank = fixrank;
                    }

                    public int getSogoupv() {
                        return sogoupv;
                    }

                    public void setSogoupv(int sogoupv) {
                        this.sogoupv = sogoupv;
                    }

                    public int getGamecoverimageWidth() {
                        return gamecoverimageWidth;
                    }

                    public void setGamecoverimageWidth(int gamecoverimageWidth) {
                        this.gamecoverimageWidth = gamecoverimageWidth;
                    }

                    public int getHtml5Allowpopup() {
                        return html5Allowpopup;
                    }

                    public void setHtml5Allowpopup(int html5Allowpopup) {
                        this.html5Allowpopup = html5Allowpopup;
                    }

                    public String getCommentator() {
                        return commentator;
                    }

                    public void setCommentator(String commentator) {
                        this.commentator = commentator;
                    }

                    public int getRenqi() {
                        return renqi;
                    }

                    public void setRenqi(int renqi) {
                        this.renqi = renqi;
                    }

                    public int getViewers() {
                        return viewers;
                    }

                    public void setViewers(int viewers) {
                        this.viewers = viewers;
                    }

                    public int getHtml5Autoplay() {
                        return html5Autoplay;
                    }

                    public void setHtml5Autoplay(int html5Autoplay) {
                        this.html5Autoplay = html5Autoplay;
                    }

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }

                    public String getRawcommentatorimage() {
                        return rawcommentatorimage;
                    }

                    public void setRawcommentatorimage(String rawcommentatorimage) {
                        this.rawcommentatorimage = rawcommentatorimage;
                    }

                    public int getGamecoverimageHeight() {
                        return gamecoverimageHeight;
                    }

                    public void setGamecoverimageHeight(int gamecoverimageHeight) {
                        this.gamecoverimageHeight = gamecoverimageHeight;
                    }

                    public String getHtml5Url() {
                        return html5Url;
                    }

                    public void setHtml5Url(String html5Url) {
                        this.html5Url = html5Url;
                    }

                    public double getFinalrank() {
                        return finalrank;
                    }

                    public void setFinalrank(double finalrank) {
                        this.finalrank = finalrank;
                    }

                    public String getInfotype() {
                        return infotype;
                    }

                    public void setInfotype(String infotype) {
                        this.infotype = infotype;
                    }

                    public int getSourcenameEnum() {
                        return sourcenameEnum;
                    }

                    public void setSourcenameEnum(int sourcenameEnum) {
                        this.sourcenameEnum = sourcenameEnum;
                    }

                    public String getChannel() {
                        return channel;
                    }

                    public void setChannel(String channel) {
                        this.channel = channel;
                    }
                }
            }
        }