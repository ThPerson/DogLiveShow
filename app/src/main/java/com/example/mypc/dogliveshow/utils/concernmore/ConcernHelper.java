package com.example.mypc.dogliveshow.utils.concernmore;

import com.example.mypc.dogliveshow.config.UrlConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by MyPC on 2016/8/12.
 */
public class ConcernHelper {
    private static ConcernHelper ourInstance = new ConcernHelper();

    public static ConcernHelper getInstance() {
        return ourInstance;
    }

    private ConcernHelper() {
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
                .baseUrl(UrlConfig.Path.ANCHOR_MORE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    private void creatGson() {
        gson = new GsonBuilder()
                .serializeNulls()
                .create();

    }
}
