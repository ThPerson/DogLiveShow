package com.example.mypc.dogliveshow.main.ui.homepage;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.mypc.dogliveshow.R;
import com.example.mypc.dogliveshow.base.BaseActivity;
import com.example.mypc.dogliveshow.config.UrlConfig;
import com.pili.pldroid.player.AVOptions;
import com.pili.pldroid.player.PLMediaPlayer;
import com.pili.pldroid.player.widget.PLVideoView;

public class PlayVideoActivity extends BaseActivity {
    private PLVideoView mVideoView;
    private View rootView;
    private String path;

    @Override
    public int getLayoutID() {
        return R.layout.activity_play_video;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        rootView = getWindow().getDecorView();
        rootView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        super.onCreate(savedInstanceState);
        mVideoView = (PLVideoView) findViewById(R.id.PLVideoView);
        Intent intent = getIntent();
        String roomid = intent.getStringExtra("roomid");
        String sourcesite = intent.getStringExtra("sourcesite");
        if (UrlConfig.Path.QUANMIN.equals(sourcesite)){
            path = UrlConfig.Path.STEAM_QUANMIN_PATH.replace("44397",roomid+"_L3");
        }else if(UrlConfig.Path.KKTV5.equals(sourcesite)){
            path = UrlConfig.Path.STEAM_KK_PATH.replace("95202888",roomid);
        }


        AVOptions options = new AVOptions();
        options.setInteger(AVOptions.KEY_PREPARE_TIMEOUT, 10 * 1000);

// 读取视频流超时时间，单位是 ms
// 默认值是：10 * 1000
        options.setInteger(AVOptions.KEY_GET_AV_FRAME_TIMEOUT, 10 * 1000);

// 当前播放的是否为在线直播，如果是，则底层会有一些播放优化
// 默认值是：0
        options.setInteger(AVOptions.KEY_LIVE_STREAMING, 1);

// 是否开启"延时优化"，只在在线直播流中有效
// 默认值是：0
        options.setInteger(AVOptions.KEY_DELAY_OPTIMIZATION, 1);

// 默认的缓存大小，单位是 ms
// 默认值是：2000
        options.setInteger(AVOptions.KEY_CACHE_BUFFER_DURATION, 2000);

// 最大的缓存大小，单位是 ms
// 默认值是：4000
        View loadingView = findViewById(R.id.LoadingView);
        mVideoView.setAVOptions(options);
        mVideoView.setBufferingIndicator(loadingView);
        mVideoView.setOnErrorListener(mOnErrorListener);
        mVideoView.setDisplayAspectRatio(PLVideoView.ASPECT_RATIO_PAVED_PARENT);
        mVideoView.setVideoPath(path);
//

//        mVideoView.setVolume(0.0f, 0.0f);
//        mVideoView.start();
        mVideoView.pause();
//        mVideoView.stopPlayback();

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        rootView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        return super.dispatchTouchEvent(ev);
    }


    private PLMediaPlayer.OnErrorListener mOnErrorListener = new PLMediaPlayer.OnErrorListener() {
        @Override
        public boolean onError(PLMediaPlayer plMediaPlayer, int errorCode) {
            switch (errorCode) {
                case PLMediaPlayer.ERROR_CODE_INVALID_URI:
                    Toast.makeText(PlayVideoActivity.this, "Invalid URL !", Toast.LENGTH_SHORT).show();
                    break;
                case PLMediaPlayer.ERROR_CODE_404_NOT_FOUND:
                    Toast.makeText(PlayVideoActivity.this, "404 resource not found !", Toast.LENGTH_SHORT).show();
                    break;
                case PLMediaPlayer.ERROR_CODE_CONNECTION_REFUSED:
                    Toast.makeText(PlayVideoActivity.this, "Connection refused !", Toast.LENGTH_SHORT).show();
                    break;
                case PLMediaPlayer.ERROR_CODE_CONNECTION_TIMEOUT:
                    Toast.makeText(PlayVideoActivity.this, "Connection timeout !", Toast.LENGTH_SHORT).show();
                    break;
                case PLMediaPlayer.ERROR_CODE_EMPTY_PLAYLIST:
                    Toast.makeText(PlayVideoActivity.this, "Empty playlist !", Toast.LENGTH_SHORT).show();
                    break;
                case PLMediaPlayer.ERROR_CODE_STREAM_DISCONNECTED:
                    Toast.makeText(PlayVideoActivity.this, "Stream disconnected !", Toast.LENGTH_SHORT).show();
                    break;
                case PLMediaPlayer.ERROR_CODE_IO_ERROR:
                    Toast.makeText(PlayVideoActivity.this, "Network IO Error !", Toast.LENGTH_SHORT).show();
                    break;
                case PLMediaPlayer.ERROR_CODE_UNAUTHORIZED:
                    Toast.makeText(PlayVideoActivity.this, "Unauthorized Error !", Toast.LENGTH_SHORT).show();
                    break;
                case PLMediaPlayer.ERROR_CODE_PREPARE_TIMEOUT:
                    Toast.makeText(PlayVideoActivity.this, "Prepare timeout !", Toast.LENGTH_SHORT).show();
                    break;
                case PLMediaPlayer.ERROR_CODE_READ_FRAME_TIMEOUT:
                    Toast.makeText(PlayVideoActivity.this, "Read frame timeout !", Toast.LENGTH_SHORT).show();
                    break;
                case PLMediaPlayer.MEDIA_ERROR_UNKNOWN:
                default:
                    Toast.makeText(PlayVideoActivity.this, "unknown error !", Toast.LENGTH_SHORT).show();
                    break;
            }
            // Todo pls handle the error status here, retry or call finish()
            finish();
            // If you want to retry, do like this:
            // mVideoView.setVideoPath(mVideoPath);
            // mVideoView.start();
            // Return true means the error has been handled
            // If return false, then `onCompletion` will be called
            return true;
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mVideoView.stopPlayback();
    }
}