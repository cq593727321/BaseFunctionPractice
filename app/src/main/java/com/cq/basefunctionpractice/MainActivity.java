package com.cq.basefunctionpractice;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;

import butterknife.Bind;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.id_viewpage)
    ViewPager mViewPager;

    // 四个Tab，每个Tab包含一个按钮
    @Bind(R.id.id_tab_weixin)
    LinearLayout mTabWeiXin;
    @Bind(R.id.id_tab_address)
    LinearLayout mTabAddress;
    @Bind(R.id.id_tab_frd)
    LinearLayout mTabFrd;
    @Bind(R.id.id_tab_settings)
    LinearLayout mTabSetting;
    // 四个按钮
     ImageButton mWeiXinImg;
     ImageButton mAddressImg;
     ImageButton mFrdImg;
     ImageButton mSettingImg;
    private PagerAdapter mPagerAdapter;
    private ArrayList<View> mViews = new ArrayList<View>();// 用来存放Tab01-04

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();
        initViewPager();
        initEvent();
    }

    private void initView() {

    }

    private void initViewPager() {

    }

    private void initEvent() {
    }
}
