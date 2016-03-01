package com.myvic.mybilibili.base;

import android.app.Activity;
import android.view.View;

/**
 * Created by MyVic on 2016/2/29.
 */
public abstract class BasePager {

    public Activity mActivity;

    public View rootView;

    public BasePager(Activity activity) {
        this.mActivity = activity;
        rootView = initView();
    }

    public abstract View initView();

    /**
     * 加载数据时重写此方法
     */
    public void initData() {

    }

}
