package com.cq.customview.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.cq.customview.R;
import com.cq.customview.fragment.two.ThisFourFragment;
import com.cq.customview.fragment.two.ThisOneFragment;
import com.cq.customview.fragment.two.ThisThreeFragment;
import com.cq.customview.fragment.two.ThisTwoFragment;
import com.cq.customview.widget.MyNavigateTabBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DrawableActivity extends AppCompatActivity {
    @BindView(R.id.id_drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.navigation_view)
    NavigationView mNavigationView;
    @BindView(R.id.id_toolbar)
    Toolbar mToolbar;
    //底部view和viewpager
    @BindView(R.id.main_container)
    ViewPager mFrameLayout;
    @BindView(R.id.mainTabBar)
    MyNavigateTabBar mNavigateTabBar;
    @BindView(R.id.tab_post_icon_a)
    ImageView mImageView;
    private static final String TAG_PAGE_HOME = "首页";
    private static final String TAG_PAGE_CITY = "同城";
    private static final String TAG_PAGE_PUBLISH = "发布";
    private static final String TAG_PAGE_MESSAGE = "消息";
    private static final String TAG_PAGE_PERSON = "我的";
    private List<Fragment> fragments;
    private ViewPagerFragment adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable_navagation_view);
        ButterKnife.bind(this);
        setContentBottom(savedInstanceState);
        setSupportActionBar(mToolbar);
        final ActionBar actionBar = getSupportActionBar();
//        actionBar.setHomeAsUpIndicator(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        setupDrawerContent(mNavigationView);
    }

    private void setupDrawerContent(NavigationView mNavigationView) {
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this,
                mDrawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
//                if (!mUserLearnedDrawer && !mFromSavedInstanceState) {
//                    mUserLearnedDrawer = true;
//                    saveToPreferences(getActivity(), KEY_USER_LEARNED_DWARER, mUserLearnedDrawer + "");
//                }
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
//                if (slideOffset < 0.6) {
//                    mToolbar.setAlpha(1 - slideOffset);
//                }
            }
        };
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.navigationview_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            mDrawerLayout.openDrawer(GravityCompat.START);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setContentBottom(Bundle savedInstanceState) {

        fragments = new ArrayList<>();
        fragments.add(new ThisOneFragment());
        fragments.add(new ThisTwoFragment());
        fragments.add(new ThisThreeFragment());
        fragments.add(new ThisFourFragment());
        adapter = new ViewPagerFragment(getSupportFragmentManager(), fragments);
        mFrameLayout.setAdapter(adapter);
        mNavigateTabBar.setTabSelectListener(new MyNavigateTabBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(MyNavigateTabBar.ViewHolder holder) {
                switch (holder.tabIndex) {
                    case 0:
                        mFrameLayout.setCurrentItem(0);
                        break;
                    case 1:
                        mFrameLayout.setCurrentItem(1);
                        break;
                    case 2:
                        mFrameLayout.setCurrentItem(2);
                        break;
                    case 3:
                        mFrameLayout.setCurrentItem(3);
                        break;
                }
            }
        });
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DrawableActivity.this, "我擦", Toast.LENGTH_SHORT).show();
            }
        });
        mFrameLayout.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        mNavigateTabBar.setCurrentSelectedTab(0);
                        break;
                    case 1:
                        mNavigateTabBar.setCurrentSelectedTab(1);
                        break;
                    case 2:
                        mNavigateTabBar.setCurrentSelectedTab(2);
                        break;
                    case 3:
                        mNavigateTabBar.setCurrentSelectedTab(3);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mNavigateTabBar.onRestoreInstanceState(savedInstanceState);

        //对应xml中的containerId
        //mNavigateTabBar.setFrameLayoutId(R.id.main_container);


        //对应xml中的navigateTabTextColor
        mNavigateTabBar.setTabTextColor(getResources().getColor(R.color.tab_text_normal));


        //对应xml中的navigateTabSelectedTextColor
        mNavigateTabBar.setSelectedTabTextColor(getResources().getColor(R.color.colorPrimary));


        mNavigateTabBar.addTab(ThisOneFragment.class, new MyNavigateTabBar.TabParam(R.mipmap.comui_tab_home, R.mipmap.comui_tab_home_selected, TAG_PAGE_HOME));
        mNavigateTabBar.addTab(ThisTwoFragment.class, new MyNavigateTabBar.TabParam(R.mipmap.comui_tab_city, R.mipmap.comui_tab_city_selected, TAG_PAGE_CITY));
        mNavigateTabBar.addTab(null, new MyNavigateTabBar.TabParam(0, 0, TAG_PAGE_PUBLISH));
        mNavigateTabBar.addTab(ThisThreeFragment.class, new MyNavigateTabBar.TabParam(R.mipmap.comui_tab_message, R.mipmap.comui_tab_message_selected, TAG_PAGE_MESSAGE));
        mNavigateTabBar.addTab(ThisFourFragment.class, new MyNavigateTabBar.TabParam(R.mipmap.comui_tab_person, R.mipmap.comui_tab_person_selected, TAG_PAGE_PERSON));

    }

    public class ViewPagerFragment extends FragmentPagerAdapter {
        List<Fragment> fragmentList;

        public ViewPagerFragment(FragmentManager fm, List<Fragment> fragmentList) {
            super(fm);
            this.fragmentList = fragmentList;
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawers();
            return;
        } else {
            super.onBackPressed();
        }

    }
}
