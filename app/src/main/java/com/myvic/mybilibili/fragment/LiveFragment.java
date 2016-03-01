package com.myvic.mybilibili.fragment;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.myvic.mybilibili.base.BaseFragment;

/**
 * Created by MyVic on 2016/2/29.
 * 直播界面
 */
public class LiveFragment extends BaseFragment {
    private String title;
    public LiveFragment(String title) {
        super();
        this.title = title;
    }

    @Override
    protected View initView() {
        TextView textView = new TextView(getActivity());
        textView.setText(title);
        textView.setTextColor(Color.RED);
        textView.setTextSize(30);
        return textView;
    }
}
