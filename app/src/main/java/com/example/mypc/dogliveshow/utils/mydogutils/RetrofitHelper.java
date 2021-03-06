package com.example.mypc.dogliveshow.utils.mydogutils;

import com.example.mypc.dogliveshow.config.UrlConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by JiaFan on 2016/8/15 14:51
 * QQ：1319662955
 */
public class RetrofitHelper {
    private static RetrofitHelper ourInstance = new RetrofitHelper();

    public static RetrofitHelper getInstance() {
        return ourInstance;
    }

    private RetrofitHelper() {
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
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    private void creatGson() {
        gson = new GsonBuilder()
                .serializeNulls()
                .create();
    }
}
