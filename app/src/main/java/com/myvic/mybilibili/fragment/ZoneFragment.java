package com.myvic.mybilibili.fragment;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.myvic.mybilibili.R;
import com.myvic.mybilibili.base.BaseFragment;

/**
 * Created by MyVic on 2016/2/29.
 * 分区界面
 */
public class ZoneFragment extends BaseFragment {
   // private String title;
    private GridView gv_zone_fragment;
    private View view;

    private String[] textlist = new String[]{"动画","音乐","直播","电视剧",
            "鬼畜 ","舞蹈","番剧","时尚","游戏","娱乐","电影",
            "直播","游戏"
    };
    private int[] imagelist = new int[]{R.mipmap.ic_category_t1,R.mipmap.ic_category_t3,
            R.mipmap.ic_category_live,R.mipmap.ic_category_t11,R.mipmap.ic_category_t119,
            R.mipmap.ic_category_t129,R.mipmap.ic_category_t13,R.mipmap.ic_category_t155,R.mipmap.ic_category_t36,R.mipmap.ic_category_t4,R.mipmap.ic_category_t13,R.mipmap.ic_category_t5,
            R.mipmap.ic_category_game_center};

    public ZoneFragment(String title) {
        super();
       // this.title = title;
    }

    @Override
    protected View initView() {
//        TextView textView = new TextView(getActivity());
//        textView.setText(title);
//        textView.setTextColor(Color.RED);
//        textView.setTextSize(30);
        view = View.inflate(getActivity(), R.layout.zone_fragment,null);
        return view;
    }

    @Override
    protected void initData() {
        super.initData();
        gv_zone_fragment = (GridView) view.findViewById(R.id.gv_zone_fragment);
        gv_zone_fragment.setAdapter(new ZoneBaseAdapter());
    }

    class ZoneBaseAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return textlist.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = View.inflate(getActivity(), R.layout.item_gridview_zone, null);
                holder.iv_item_zone_icon = (ImageView) convertView.findViewById(R.id.iv_item_zone_icon);
                holder.tv_item_zone_title = (TextView) convertView.findViewById(R.id.tv_item_zone_title);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.iv_item_zone_icon.setImageResource(imagelist[position]);
            holder.tv_item_zone_title.setText(textlist[position]);

            return convertView;
        }
    }

    static class ViewHolder {
        public ImageView iv_item_zone_icon;
        public TextView tv_item_zone_title;
    }
}
