package com.myvic.mybilibili.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by MyVic on 2016/2/29.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        initView();
    }

    /**
     * 初始化子类view
     */
    protected abstract void initView();

    /**
     * 加载子类布局
     * @return
     */
    protected abstract int getContentView();


}
