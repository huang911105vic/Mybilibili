package com.myvic.mybilibili.activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.myvic.mybilibili.R;
import com.myvic.mybilibili.adapter.TabFragmentAdapter;
import com.myvic.mybilibili.base.BaseActivity;
import com.myvic.mybilibili.base.BaseFragment;
import com.myvic.mybilibili.fragment.AttentionFragment;
import com.myvic.mybilibili.fragment.DiscoverFragment;
import com.myvic.mybilibili.fragment.DramaFragment;
import com.myvic.mybilibili.fragment.LiveFragment;
import com.myvic.mybilibili.fragment.RecommendFragment;
import com.myvic.mybilibili.fragment.ZoneFragment;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends BaseActivity {

    private DrawerLayout dl_main;

    private NavigationView ngv_main;

    private Toolbar tb_main_content_toolbar;

    private TabLayout tl_main_content_tablayout;

    private ViewPager vp_main_content_viewpager;

    //private List<BasePager> bas ePagers;
    private Intent intent;

    private CircleImageView civ_menu_header_icon;
    private CircleImageView civ_menu_header_moon;

    @Override
    protected void initView() {

        initResouce();

        ngv_main.setNavigationItemSelectedListener(new MainNavigationItemSelectedListener());


        initToolBar();
        initTabLayout();

    }

    private void initTabLayout() {

        List<String> tabList = new ArrayList<>();
        tabList.add("直播");
        tabList.add("番剧");
        tabList.add("推荐");
        tabList.add("分区");
        tabList.add("关注");
        tabList.add("发现");
        tl_main_content_tablayout.setTabMode(TabLayout.MODE_FIXED);//设置tab模式，当前为系统默认模式
        tl_main_content_tablayout.addTab(tl_main_content_tablayout.newTab().setText(tabList.get(0)));//添加tab选项卡
        tl_main_content_tablayout.addTab(tl_main_content_tablayout.newTab().setText(tabList.get(1)));
        tl_main_content_tablayout.addTab(tl_main_content_tablayout.newTab().setText(tabList.get(2)));
        tl_main_content_tablayout.addTab(tl_main_content_tablayout.newTab().setText(tabList.get(3)));
        tl_main_content_tablayout.addTab(tl_main_content_tablayout.newTab().setText(tabList.get(4)));
        tl_main_content_tablayout.addTab(tl_main_content_tablayout.newTab().setText(tabList.get(5)));

        List<BaseFragment> fragmentList = new ArrayList<>();
           // Fragment f1 = new LiveFragment();
            //推荐使用bundle传递数据 使用构造方法传递数据时 横竖屏切换回丢失数据
//            Bundle bundle = new Bundle();
//            bundle.putString("content", "http://blog.csdn.net/feiduclear_up \n CSDN 废墟的树");
//            f1.setArguments(bundle);
            fragmentList.add(new LiveFragment(tabList.get(0)));
            fragmentList.add(new DramaFragment(tabList.get(1)));
            fragmentList.add(new RecommendFragment(tabList.get(2)));
            fragmentList.add(new ZoneFragment(tabList.get(3)));
            fragmentList.add(new AttentionFragment(tabList.get(4)));
            fragmentList.add(new DiscoverFragment(tabList.get(5)));


        TabFragmentAdapter fragmentAdapter = new TabFragmentAdapter(getSupportFragmentManager(), fragmentList, tabList);
        vp_main_content_viewpager.setAdapter(fragmentAdapter);//给ViewPager设置适配器
        tl_main_content_tablayout.setupWithViewPager(vp_main_content_viewpager);//将TabLayout和ViewPager关联起来。
        tl_main_content_tablayout.setTabsFromPagerAdapter(fragmentAdapter);//给Tabs设置适配器
        //默认选择 推荐
        vp_main_content_viewpager.setCurrentItem(2);

    }

    /**
     * 初始化主页顶部状态
     */
    private void initToolBar() {
        setSupportActionBar(tb_main_content_toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        tb_main_content_toolbar.setTitle("未登录");
        tb_main_content_toolbar.setTitleTextColor(Color.WHITE);
        tb_main_content_toolbar.setLogo(R.drawable.bili_default_avatar);
        tb_main_content_toolbar.setNavigationIcon(R.drawable.ic_drawer_home);
        tb_main_content_toolbar.setOnMenuItemClickListener(new ToolBarOnMenuItemClickListener());

        civ_menu_header_icon.setOnClickListener(new HeaderOnClickListener());


    }

    class HeaderOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }
    /**
     *
     */
    class ToolBarOnMenuItemClickListener implements Toolbar.OnMenuItemClickListener {

        @Override
        public boolean onMenuItemClick(MenuItem item) {

            switch (item.getItemId()) {
                case R.id.item_tab_game:
                    //Toast.makeText(MainActivity.this, "游戏按钮", Toast.LENGTH_SHORT).show();
                    intent = new Intent(MainActivity.this, GameActivity.class);
                    startActivity(intent);
                    break;
                case R.id.item_tab_download:
                    //Toast.makeText(MainActivity.this, "下载按钮", Toast.LENGTH_SHORT).show();
                    intent = new Intent(MainActivity.this, HistoryActivity.class);
                    startActivity(intent);
                    break;
                case R.id.item_tab_search:
                    Toast.makeText(MainActivity.this, "搜索按钮", Toast.LENGTH_SHORT).show();
                    break;
            }
            return true;
        }
    }

    /**
     * 初始化顶部资源
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



    /**
     * 点击侧滑菜单按钮时
     */
    class MainNavigationItemSelectedListener implements NavigationView.OnNavigationItemSelectedListener {

        @Override
        public boolean onNavigationItemSelected(MenuItem menuItem) {

            switch (menuItem.getItemId()) {
                case R.id.main_leftmenu_home:
                    intent = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(intent);
                    break;
                case R.id.main_leftmenu_downlinemanager:
                    intent = new Intent(MainActivity.this, DownLineManagerActivity.class);
                    startActivity(intent);
                    break;
                case R.id.main_leftmenu_history:
                    intent = new Intent(MainActivity.this, HistoryActivity.class);
                    startActivity(intent);
                    break;
                case R.id.main_leftmenu_people:
                    intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                    break;
                case R.id.main_leftmenu_wallet:
                    intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                    break;
                case R.id.main_leftmenu_theme:
                    intent = new Intent(MainActivity.this, ThemeActivity.class);
                    startActivity(intent);
                    break;
                case R.id.main_leftmenu_shop:
                    intent = new Intent(MainActivity.this, AppSendActivity.class);
                    startActivity(intent);
                    break;
                case R.id.main_leftmenu_settings:
                    intent = new Intent(MainActivity.this, SettingsActivity.class);
                    startActivity(intent);
                    break;
                case R.id.main_leftmenu_mypokit:
                    intent = new Intent(MainActivity.this, CollectionActivity.class);
                    startActivity(intent);
                    break;
            }
            menuItem.setChecked(true);
            dl_main.closeDrawers();
            return true;
        }
    }
    /**
     * 初始化资源文件
     */
    private void initResouce() {
        dl_main = (DrawerLayout)findViewById(R.id.dl_main);
        ngv_main = (NavigationView)findViewById(R.id.ngv_main);
        tb_main_content_toolbar = (Toolbar)findViewById(R.id.tb_main_content_toolbar);
        tl_main_content_tablayout = (TabLayout)findViewById(R.id.tl_main_content_tablayout);
        vp_main_content_viewpager = (ViewPager)findViewById(R.id.vp_main_content_viewpager);
        civ_menu_header_icon = (CircleImageView)findViewById(R.id.civ_menu_header_icon);
        civ_menu_header_moon = (CircleImageView)findViewById(R.id.civ_menu_header_moon);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            dl_main.openDrawer(GravityCompat.START);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
