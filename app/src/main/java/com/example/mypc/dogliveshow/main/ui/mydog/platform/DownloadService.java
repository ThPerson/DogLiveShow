package com.example.mypc.dogliveshow.main.ui.mydog.platform;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.ResultReceiver;

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
    public static final int UPDATE_PROGRESS = 8344;
    public DownloadService() {
        super("DownloadService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        String path = intent.getStringExtra("url");
        String name = path.substring(path.lastIndexOf("/"));
        ResultReceiver receiver = (ResultReceiver)intent.getParcelableExtra("receiver");
        try {
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            if (conn.getResponseCode() == 200) {
                int fileLength = conn.getContentLength();
                InputStream stream = conn.getInputStream();
                String file = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + name;
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(file)));
                int len = 0;
                byte[] buffer = new byte[1024];
                long total = 0;
                while ((len = stream.read(buffer)) != -1) {
                    total += len;
                    Bundle resultData = new Bundle();
                    resultData.putInt("progress" ,(int) (total * 100f / fileLength));
                    receiver.send(UPDATE_PROGRESS, resultData);
                    bos.write(buffer, 0, len);
                    bos.flush();
                }

                Bundle resultData = new Bundle();
                resultData.putInt("progress" ,100);
                receiver.send(UPDATE_PROGRESS, resultData);
                //广播提示下载完成
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
