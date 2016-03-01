package com.myvic.mybilibili.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.myvic.mybilibili.R;
import com.myvic.mybilibili.activity.LoginActivity;
import com.myvic.mybilibili.base.BaseFragment;

/**
 * Created by MyVic on 2016/2/29.
 * 关注界面
 */
public class AttentionFragment extends BaseFragment implements View.OnClickListener {
    private String title;
    private Button btn_attention_fragment_login;
    private View view;
    public AttentionFragment(String title) {
        super();
        this.title = title;
    }

    @Override
    protected View initView() {
//        TextView textView = new TextView(getActivity());
//        textView.setText(title);
//        textView.setTextColor(Color.RED);
//        textView.setTextSize(30);
        view = View.inflate(getActivity(), R.layout.fragment_attention,null);


        return view;
    }

    @Override
    protected void initData() {
        super.initData();
       // btn_attention_fragment_login = (Button) getActivity().findViewById(R.id.btn_attention_fragment_login);
        btn_attention_fragment_login = (Button) view.findViewById(R.id.btn_attention_fragment_login);
        btn_attention_fragment_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
    }
}
