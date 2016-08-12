package com.example.mypc.dogliveshow.utils.classifyutils;

/**
 * Created by Administrator on 2016/8/12.
 */
public class HttpUtils {
    private static HttpUtils ourInstance = new HttpUtils();

    public static HttpUtils getInstance() {
        return ourInstance;
    }

    private HttpUtils() {
    }

    public interface HttpCallback<T>{
        public void onSucess(T t);
        public void onFail();
    }
    //public void getClassifyD
}
