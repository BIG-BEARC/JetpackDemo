package com.chuxiong.jetpackdemo.base;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.chuxiong.jetpackdemo.domain.NetworkStateManager;
import com.chuxiong.jetpackdemo.uitl.AdaptScreenUtils;
import com.chuxiong.jetpackdemo.uitl.BarUtils;
import com.chuxiong.jetpackdemo.uitl.ScreenUtils;

/**
 * @Description
 * @Author chuxiong
 * @Time 2020/7/28 11:23
 */
public abstract class BaseActivity extends DataBindingActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLifecycle().addObserver(NetworkStateManager.getInstance());
    }

    @Override
    protected void doBeforeOnCreate() {
        BarUtils.setStatusBarColor(this, Color.TRANSPARENT);
        BarUtils.setStatusBarLightMode(this, true);
    }

    @Override
    public Resources getResources() {
        if (ScreenUtils.isPortrait()) {
            return AdaptScreenUtils.adaptWidth(super.getResources(), 360);
        } else {
            return AdaptScreenUtils.adaptHeight(super.getResources(), 640);
        }
    }
}
