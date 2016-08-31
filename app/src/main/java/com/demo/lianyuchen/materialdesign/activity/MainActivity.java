package com.demo.lianyuchen.materialdesign.activity;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.demo.lianyuchen.materialdesign.R;
import com.demo.lianyuchen.materialdesign.fragment.FragmentOne;
import com.demo.lianyuchen.materialdesign.fragment.FragmentThree;
import com.demo.lianyuchen.materialdesign.fragment.FragmentTwo;

public class MainActivity extends BaseActivity {

    private CoordinatorLayout rootLayout;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rootLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbarLayout);
        //设置ToolBar
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        //设置tabLayout
//        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
//        tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
//        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
//        tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));
//        tabLayout.addTab(tabLayout.newTab().setText("Tab 4"));
//        tabLayout.addTab(tabLayout.newTab().setText("Tab 5"));
//        tabLayout.addTab(tabLayout.newTab().setText("Tab 6"));
//        tabLayout.addTab(tabLayout.newTab().setText("Tab 7"));
//        tabLayout.addTab(tabLayout.newTab().setText("Tab 8"));
//        tabLayout.addTab(tabLayout.newTab().setText("Tab 9"));
        //设置抽屉DrawerLayout
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar,
                R.string.drawer_open, R.string.drawer_close);
        mDrawerToggle.syncState();//初始化状态
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        //设置导航栏NavigationView的点击事件
        NavigationView mNavigationView = (NavigationView) findViewById(R.id.navigation);

        setupNavigationDrawerContent(mNavigationView);
        setFragment(0);
        //设置FAB的点击事件
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabBtn);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(rootLayout, "I am Snackbar", Snackbar.LENGTH_SHORT).show();
            }
        });

//        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
//
//        // use this setting to improve performance if you know that changes
//        // in content do not change the layout size of the RecyclerView
//        mRecyclerView.setHasFixedSize(true);
//
//        // use a linear layout manager
//        mLayoutManager = new LinearLayoutManager(this);
//        mRecyclerView.setLayoutManager(mLayoutManager);
//
//        // specify an adapter (see also next example)
//        mAdapter = new MyAdapter(myDataset);
//        mRecyclerView.setAdapter(mAdapter);
    }

    private void setupNavigationDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.item_one:
                                menuItem.setChecked(true);
                                setFragment(0);
                                collapsingToolbarLayout.setTitle("我的动态");
                                mDrawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                            case R.id.item_two:
                                menuItem.setChecked(true);
                                setFragment(1);
                                collapsingToolbarLayout.setTitle("我的留言");
                                mDrawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                            case R.id.item_three:
                                menuItem.setChecked(true);
                                setFragment(2);
                                collapsingToolbarLayout.setTitle("我的留言");
                                mDrawerLayout.closeDrawer(GravityCompat.START);
                                return true;

                        }
                        return true;
                    }
                });
    }

    private void setFragment(int position) {
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        switch (position) {
            case 0:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                FragmentOne oneFragment = new FragmentOne();
                fragmentTransaction.replace(R.id.frame_content, oneFragment);
                fragmentTransaction.commit();

                break;
            case 1:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                FragmentTwo twoFragment = new FragmentTwo();
                fragmentTransaction.replace(R.id.frame_content, twoFragment);
                fragmentTransaction.commit();
                break;
            case 2:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                FragmentThree threeFragment = new FragmentThree();
                fragmentTransaction.replace(R.id.frame_content, threeFragment);
                fragmentTransaction.commit();
                break;
            default:

                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                FragmentOne fragment = new FragmentOne();
                fragmentTransaction.replace(R.id.frame_content, fragment);
                fragmentTransaction.commit();
                break;

        }
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {

    }

}
