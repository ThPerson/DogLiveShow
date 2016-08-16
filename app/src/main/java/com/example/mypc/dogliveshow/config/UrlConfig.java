package com.example.mypc.dogliveshow.config;

/**
 * Created by Administrator on 2016/8/12.
 */
public class UrlConfig {
    public static class Path{
        public static final String BASE_URL = "http://zhibo.sogou.com/";

        //主播头条基础URL
        public static final String HEAD_LINE_BASE_URL="http://v.sogou.com/";
        //栏目分类
        public static final String CLASSIFY_URL = "gamelivedata?";
        //主播头条URL
        public static final String HEAD_LINE_URL="app/liveheadlines/get_user_article/";

        public static final String HOMEPAGE_URL ="getAppIndexData";
        //栏目分类-->直播
        public static final String CLASSIFY_COMMENTATOR_URL ="livesearch?";
        //栏目分类-->视频
        public static final String CLASSIFY_VIDEO_URL ="searchgame?";
        //平台大全
        public static final String PLAT_FORM_URL ="mvc/app/platformconfig.jsp";

        public static final String CLASSIFY_VIDEO_URL = "searchgame?";
        public static final String CLASSIFY_PLAY_VIDEO = "http://www.quanmin.tv/json/rooms/";
        public static final String STEAM_QUANMIN_PATH = "http://hls.quanmin.tv/live/44397/playlist.m3u8";
        public static final String STEAM_KK_PATH = "http://hpull.kktv8.com/livekktv/95202888/playlist.m3u8";
        public static final String QUANMIN="www.quanmin.tv";
        public static final String KKTV5="www.kktv5.com";
        /*name: "标清",
src: "http://hls.quanmin.tv/live/44397_L3/playlist.m3u8"
},
4: {
name: "高清",
src: "http://hls.quanmin.tv/live/44397_L4/playlist.m3u8"
},
5: {
name: "超清",
src: "http://hls.quanmin.tv/live/44397/playlist.m3u8"
},*/
    }
    //栏目分类
    public static class ClassifyKey{
        public static final String SYSVER = "sysVer";
        public static final String PAGESIZE = "pageSize";
        public static final String SYSTEM = "system";
        public static final String APPVER = "appVer";
        public static final String TYPE = "type";
        public static final String PAGENO = "pageNo";
    }
    //平台大全
    public static class PlatFormKey{
        public static final String USER_ID="user_id";
        public static final String OS="os";
        public static final String USERKEY="userKey";
        public static final String NAME="name";
        public static final String SYSTEM="system";
        public static final String VERSION="version";
        public static final String APPID="appid";
    }
    //主播头条KEY
    public static class HeadLineKey{
        public static final String USER_ID="user_id";
        public static final String OS="os";
        public static final String USERKEY="userKey";
        public static final String ORDER_ID="order_id";
        public static final String PAGE_SIZE="page_size";
        public static final String CATE_ID="cate_id";
        public static final String IS_NEW="is_new";
        public static final String SYSTEM="system";
        public static final String VERSION="version";
        public static final String APPID="appid";
    }
//type=json&dataType=0&pageNo2=1&pageSize2=6&pageNo3=1&pageSize3=100&system=android&
// version=3.1.0&appid=ec1179d6bfd406ba4fac855010ee80c728df297d
    public static class HomePageTitleKey{
        public static final String TYPE = "type";
        public static final String DATATYPE = "dataType";
        public static final String PAGENO2 = "pageNo2";
        public static final String PAGESIZE2 = "pageSize2";
        public static final String PAGENO3 = "pageNo3";
        public static final String PAGESIZE3 = "pageSize3";
        public static final String SYSTEM = "system";
        public static final String VERSION = "version";
        public static final String APPID = "appid";
    }
    public static class CommentatorKey{
        public static final String SYSVER = "sysVer";
        public static final String SYSTEM = "system";
        public static final String APPVER = "appVer";
        public static final String RESULTTYPE = "resulttype";
        public static final String REQ_FROM = "req_from";


    }
}
