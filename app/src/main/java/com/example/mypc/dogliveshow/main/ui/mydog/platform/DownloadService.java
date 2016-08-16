package com.example.mypc.dogliveshow.main.ui.mydog.platform;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by JiaFan on 2016/8/15 16:42
 * QQ：1319662955
 */
public class DownloadService extends IntentService{

    public DownloadService() {
        super("");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Bundle bundle = intent.getExtras();
        String path = bundle.getString("url");
        String name = bundle.getString("name");
        Log.i("TAG",path+name);
        try {
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            if (conn.getResponseCode() == 200) {
                InputStream stream = conn.getInputStream();
                String file = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + name;
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(file)));
                int len = 0;
                byte[] buffer = new byte[1024];
                while ((len = stream.read(buffer)) != -1) {
                    bos.write(buffer, 0, len);
                    bos.flush();
                }

                //Service得告诉Activity,图片下载并保存成功,Activity可以展示图片了.
                sendBroadcast(new Intent("completed"));

            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
