package com.example.mypc.dogliveshow.utils.homepagehade;

import com.example.mypc.dogliveshow.config.UrlConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;

/**
 * Created by MyPC on 2016/8/12.
 */
public class HomePageHeadHelper {
    private static HomePageHeadHelper ourInstance = new HomePageHeadHelper();

    public static HomePageHeadHelper getInstance() {
        return ourInstance;
    }

    private HomePageHeadHelper() {
    }
    public Retrofit retrofit;
    public Gson gson;
    public <T> T creatRetrfitService(Class<T> service){
        if(retrofit == null){
            creatGson();
            initRetrofit();
        }
        return retrofit.create(service);
    }

    private void initRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(UrlConfig.Path.BASE_URL)
                .addConverterFactory(new HomePageConvertFactory())
                .build();
    }

    private void creatGson() {
        gson = new GsonBuilder()
                .serializeNulls()
                .create();

    }
}
