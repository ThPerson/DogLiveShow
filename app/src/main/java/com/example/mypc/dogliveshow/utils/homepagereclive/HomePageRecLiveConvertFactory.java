package com.example.mypc.dogliveshow.utils.homepagereclive;

import android.util.Log;

import com.example.mypc.dogliveshow.bean.homepagetitle.HomePage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by zhonghang on 16/8/1.
 */

public class HomePageRecLiveConvertFactory extends Converter.Factory {

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return new DetailsConvert();
    }


    static class DetailsConvert implements Converter<ResponseBody, HomePage> {

        @Override
        public HomePage convert(ResponseBody value) throws IOException {
            HomePage homepage = null;
            try {
                homepage = new HomePage();
                JSONObject jsonObject = new JSONObject(value.string());
                JSONObject rec_live = jsonObject.getJSONObject("rec_live");
                HomePage.RecLiveBean recLiveBean = new HomePage.RecLiveBean();
                JSONArray data_list = rec_live.getJSONArray("data_list");
                List<HomePage.RecLiveBean.DataListBean> mList = new ArrayList<>();
                for (int i = 0; i < data_list.length(); i++) {
                    HomePage.RecLiveBean.DataListBean hcd = new HomePage.RecLiveBean.DataListBean();
                    JSONObject jsonObject1 = data_list.getJSONObject(i);
                    JSONArray myArrayList = jsonObject1.getJSONArray("myArrayList");
                    List<HomePage.RecLiveBean.DataListBean.MyArrayListBean> xList = new ArrayList<>();
                    for (int j = 0; j < myArrayList.length(); j++) {
                        HomePage.RecLiveBean.DataListBean.MyArrayListBean hcdm
                                = new HomePage.RecLiveBean.DataListBean.MyArrayListBean();
                        JSONObject jsonObject2 = myArrayList.getJSONObject(j);
                        JSONObject map = jsonObject2.getJSONObject("map");
                        HomePage.RecLiveBean.DataListBean.MyArrayListBean.MapBean hcdmm = new
                                HomePage.RecLiveBean.DataListBean.MyArrayListBean.MapBean();
                        String name = map.getString("name");
//                        String roomid = map.optString("roomid","1");
                        String rawcommentatorimage = map.getString("rawcommentatorimage");
                        String commentator = map.getString("commentator");
                        String title = map.getString("title");
                        String viewers = map.getString("viewers");
                        String rawcoverimage = map.getString("rawcoverimage");
                        String sourcename = map.getString("sourcename");
                        hcdmm.setName(name);
                        hcdmm.setTitle(title);
                        hcdmm.setViewers(viewers);
                        hcdmm.setRawcoverimage(rawcoverimage);
                        hcdmm.setSourcename(sourcename);
                        hcdmm.setRawcommentatorimage(rawcommentatorimage);
//                        hcdmm.setRoomid(roomid);
                        hcdmm.setCommentator(commentator);
                        hcdm.setMap(hcdmm);
                        xList.add(hcdm);
                    }
//title: "国服韩服双第一!真!世界第一阿卡丽!!!",roomid: 3158218,sourcename: "全民",name: "英雄联盟",
                    //viewers: 319000,rawcoverimage: "http://snap.quanmin.tv/3158218-1471051023-17.jpg?imageView2/2/w/390/",
                    ///commentator: "六安王boon",
                    hcd.setMyArrayList(xList);
                    mList.add(hcd);
                }
                recLiveBean.setDataList(mList);
                homepage.setRecLive(recLiveBean);
            } catch (JSONException e1) {
                e1.printStackTrace();
            }
            return homepage;
        }

    }
}