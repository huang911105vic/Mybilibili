package com.myvic.mybilibili.domain;

import org.xutils.x;

/**
 * Created by MyVic on 2016/2/28.
 */
public class Application extends android.app.Application{

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(true);
    }
}
