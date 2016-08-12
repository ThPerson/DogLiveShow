package com.example.mypc.dogliveshow.config;

/**
 * Created by Administrator on 2016/8/12.
 */
public class UrlConfig {
    public static class Path{
        public static final String BASE_URL = "http://zhibo.sogou.com/";
        public static final String CLASSIFY_URL = "gamelivedata?";
        public static final String HOMEPAGE_URL ="getAppIndexData";
    }
    public static class ClassifyKey{
        public static final String SYSVER = "sysVer";
        public static final String PAGESIZE = "pageSize";
        public static final String SYSTEM = "system";
        public static final String APPVER = "appVer";
        public static final String TYPE = "type";
        public static final String PAGENO = "pageNo";
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
}
