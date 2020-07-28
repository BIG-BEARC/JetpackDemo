package com.chuxiong.jetpackdemo;

import android.view.View;

import androidx.drawerlayout.widget.DrawerLayout;

import com.chuxiong.jetpackdemo.base.BaseActivity;
import com.chuxiong.jetpackdemo.base.DataBindingConfig;
import com.chuxiong.jetpackdemo.domain.callback.SharedViewModel;
import com.chuxiong.jetpackdemo.ui.state.MainActivityViewModel;

public class MainActivity extends BaseActivity {
    private MainActivityViewModel mMainActivityViewModel;
    private SharedViewModel mSharedViewModel;

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.activity_main, BR.vm, mMainActivityViewModel)
                .addBindingParam(BR.event, new EventHandler());
    }

    @Override
    protected void initViewModel() {
        mMainActivityViewModel = getActivityViewModel(MainActivityViewModel.class);
        mSharedViewModel = getAppViewModelProvider().get(SharedViewModel.class);
    }


    public class EventHandler extends DrawerLayout.SimpleDrawerListener {
        @Override
        public void onDrawerOpened(View drawerView) {
            super.onDrawerOpened(drawerView);
        }

        @Override
        public void onDrawerClosed(View drawerView) {
            super.onDrawerClosed(drawerView);
        }
    }
}
