package com.myvic.mybilibili.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.myvic.mybilibili.R;
import com.myvic.mybilibili.domain.SplashBean;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

public class SplashActivity extends Activity {

    private ImageView iv_splash;

    private static String SPLASH_URL = "http://app.bilibili.com/x/splash?plat=0&build=412000&channel=baidu&width=1080&height=1920";

    private Handler handler = new Handler(){
        public void handleMessage(Message msg){
            if(msg.what == 1) {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        iv_splash = (ImageView)findViewById(R.id.iv_splash);


        //getDataFromNet();

        handler.sendEmptyMessageDelayed(1,2000);

    }

    /**
     * 欢迎页面的背景图片的联网请求
     */
    private void getDataFromNet() {

        RequestParams params = new RequestParams(SPLASH_URL);

        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                System.out.println("联网请求成功--result==" + result);
                ProcessData(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                System.out.println("联网请求失败--" + ex.toString());

                iv_splash.setBackgroundResource(R.drawable.welcome2);
            }

            @Override
            public void onCancelled(CancelledException cex) {
                System.out.println("onCancelled--" + cex.toString());
            }

            @Override
            public void onFinished() {
                System.out.println("onFinished--" );
            }
        });

    }

    private void ProcessData(String json) {


        Gson gson = new Gson();
        SplashBean splashBean = gson.fromJson(json, SplashBean.class);
        String image = splashBean.getData().get(1).getImage();

        x.image().bind(iv_splash,image);
    }
}
