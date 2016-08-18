package com.example.mypc.dogliveshow.utils.anchordetailutils;

import android.util.Log;

import com.example.mypc.dogliveshow.bean.moreanchor.AnchorDetailBean;

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

public class AnchorDetailConvertFactory extends Converter.Factory {

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return new DetailsConvert();
    }


    static class DetailsConvert implements Converter<ResponseBody, AnchorDetailBean> {

        @Override
        public AnchorDetailBean convert(ResponseBody value) throws IOException {
            AnchorDetailBean anchorDetailBean = null;
            try {
                anchorDetailBean = new AnchorDetailBean();
                JSONObject object = new JSONObject(value.string());
                JSONObject lives = object.optJSONObject("lives");
                List<AnchorDetailBean.VideosBean.GameinfoBean> list = new ArrayList<>();
                List<AnchorDetailBean.LivesBean.GameinfoBean> llist = new ArrayList<>();
                AnchorDetailBean.VideosBean av = new AnchorDetailBean.VideosBean();
                AnchorDetailBean.LivesBean al = new AnchorDetailBean.LivesBean();
                if (object.has("videos")) {
                    JSONObject videos = object.optJSONObject("videos");
                    JSONArray gameinfo = videos.getJSONArray("gameinfo");
                    for (int i = 0; i < gameinfo.length(); i++) {
                        AnchorDetailBean.VideosBean.GameinfoBean gameinfoBean = new AnchorDetailBean.VideosBean.GameinfoBean();
                        JSONObject jsonObject = gameinfo.getJSONObject(i);
                        String commentator = jsonObject.getString("commentator");
                        String sourcename = jsonObject.getString("sourcename");
                        String viewtimes = jsonObject.getString("viewtimes");
                        String id = jsonObject.optString("id","1");
                        String title = jsonObject.getString("title");
                        String duration = jsonObject.getString("duration");
                        String jsid = jsonObject.optString("jsid","");
                        String name = jsonObject.getString("name");
                        String rawcoverimage = jsonObject.getString("rawcoverimage");
                        String avatar = jsonObject.getString("avatar");
                        gameinfoBean.setCommentator(commentator);
                        gameinfoBean.setSourcename(sourcename);
                        gameinfoBean.setViewtimes(viewtimes);
                        gameinfoBean.setId(id);
                        gameinfoBean.setTitle(title);
                        gameinfoBean.setJsid(jsid);
                        gameinfoBean.setDuration(duration);
                        gameinfoBean.setName(name);
                        gameinfoBean.setRawcoverimage(rawcoverimage);
                        gameinfoBean.setAvatar(avatar);
                        Log.i("TAG", "gameinfoBean: "+gameinfoBean.toString());
                        list.add(gameinfoBean);
                    }
                    av.setGameinfo(list);
                    anchorDetailBean.setLives(al);
                }
                JSONArray liveinfo = lives.getJSONArray("gameinfo");
                for (int i = 0; i < liveinfo.length(); i++) {
                    AnchorDetailBean.LivesBean.GameinfoBean gameinfoBean1 = new AnchorDetailBean.LivesBean.GameinfoBean();
                    JSONObject jsonObject = liveinfo.getJSONObject(i);
                    String commentator = jsonObject.getString("commentator");
                    String sourcename = jsonObject.getString("sourcename");
                    String id = jsonObject.optString("id","1");
                    String title = jsonObject.getString("title");
                    String jsid = jsonObject.optString("jsid","");
                    String name = jsonObject.getString("name");
                    String rawcoverimage = jsonObject.getString("rawcoverimage");
                    String roomid = jsonObject.getString("roomid");
                    String viewers = jsonObject.getString("viewers");
                    String rawcommentatorimage = jsonObject.getString("rawcommentatorimage");
                    gameinfoBean1.setCommentator(commentator);
                    gameinfoBean1.setSourcename(sourcename);
                    gameinfoBean1.setRoomid(roomid);
                    gameinfoBean1.setId(id);
                    gameinfoBean1.setTitle(title);
                    Log.i("TAG", "convert: "+title);
                    gameinfoBean1.setJsid(jsid);
                    gameinfoBean1.setViewers(viewers);
                    gameinfoBean1.setName(name);
                    gameinfoBean1.setRawcoverimage(rawcoverimage);
                    gameinfoBean1.setRawcommentatorimage(rawcommentatorimage);
                    llist.add(gameinfoBean1);
                }
                al.setGameinfo(llist);
                anchorDetailBean.setVideos(av);

            } catch (JSONException e) {
                e.printStackTrace();
            }
            return anchorDetailBean;
        }

    }
}