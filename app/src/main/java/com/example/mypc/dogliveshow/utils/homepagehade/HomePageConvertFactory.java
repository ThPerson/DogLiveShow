package com.example.mypc.dogliveshow.utils.homepagehade;

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

public class HomePageConvertFactory extends Converter.Factory {

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
                JSONObject con_live = jsonObject.getJSONObject("con_live");
                HomePage.ConLiveBean hConlive = new HomePage.ConLiveBean();

                JSONArray data_list = con_live.getJSONArray("data_list");
                List<HomePage.ConLiveBean.DataListBean> mList = new ArrayList<>();
                for (int i = 0; i < data_list.length(); i++) {
                    HomePage.ConLiveBean.DataListBean hcd = new HomePage.ConLiveBean.DataListBean();
                    JSONObject jsonObject1 = data_list.getJSONObject(i);
                    JSONArray myArrayList = jsonObject1.getJSONArray("myArrayList");
                    List< HomePage.ConLiveBean.DataListBean.MyArrayListBean> xList = new ArrayList<>();
                    for (int j = 0; j < myArrayList.length(); j++) {

                        HomePage.ConLiveBean.DataListBean.MyArrayListBean hcdm
                                = new HomePage.ConLiveBean.DataListBean.MyArrayListBean();
                        JSONObject jsonObject2 = myArrayList.getJSONObject(j);
                        JSONObject map = jsonObject2.getJSONObject("map");
                        HomePage.ConLiveBean.DataListBean.MyArrayListBean.MapBean hcdmm = new
                                HomePage.ConLiveBean.DataListBean.MyArrayListBean.MapBean();
                        String name = map.getString("name");
//                        String roomid = map.getString("roomid");
                        String rawcommentatorimage = map.getString("rawcommentatorimage");
                        String commentator = map.getString("commentator");
                        hcdmm.setName(name);
                        hcdmm.setRawcommentatorimage(rawcommentatorimage);
//                        hcdmm.setRoomid(roomid);
                        hcdmm.setCommentator(commentator);
                        hcdm.setMap(hcdmm);
                        xList.add(hcdm);
                    }

                    hcd.setMyArrayList(xList);
                    mList.add(hcd);
                }
                hConlive.setDataList(mList);
                homepage.setConLive(hConlive);
            } catch (JSONException e1) {
                e1.printStackTrace();
            }
            return homepage;
        }

    }
}
