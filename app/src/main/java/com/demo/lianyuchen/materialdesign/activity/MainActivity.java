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
import android.widget.FrameLayout;

import com.demo.lianyuchen.materialdesign.R;
import com.demo.lianyuchen.materialdesign.fragment.FragmentOne;
import com.demo.lianyuchen.materialdesign.fragment.FragmentThree;
import com.demo.lianyuchen.materialdesign.fragment.FragmentTwo;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.collapsingToolbarLayout)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @BindView(R.id.frame_content)
    FrameLayout frameContent;
    @BindView(R.id.fabBtn)
    FloatingActionButton fabBtn;
    @BindView(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;
    @BindView(R.id.navigation)
    NavigationView navigation;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //设置ToolBar
        setSupportActionBar(toolbar);
        //设置抽屉DrawerLayout
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.drawer_open, R.string.drawer_close);
        mDrawerToggle.syncState();//初始化状态
        drawerLayout.setDrawerListener(mDrawerToggle);

        setupNavigationDrawerContent(navigation);
        setFragment(0);
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
                                drawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                            case R.id.item_two:
                                menuItem.setChecked(true);
                                setFragment(1);
                                collapsingToolbarLayout.setTitle("我的留言");
                                drawerLayout.closeDrawer(GravityCompat.START);
                                return true;
                            case R.id.item_three:
                                menuItem.setChecked(true);
                                setFragment(2);
                                collapsingToolbarLayout.setTitle("我的留言");
                                drawerLayout.closeDrawer(GravityCompat.START);
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

    @OnClick(R.id.fabBtn)
    public void showSnackbar() {
        Snackbar.make(coordinatorLayout, "I am Snackbar", Snackbar.LENGTH_SHORT).show();
    }
}
