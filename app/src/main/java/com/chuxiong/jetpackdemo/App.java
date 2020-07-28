package com.chuxiong.jetpackdemo;

import android.app.Application;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;

/**
 * @Description
 * @Author chuxiong
 * @Time 2020/7/24 12:36
 */
public class App extends Application implements ViewModelStoreOwner {

    private ViewModelStore mAppViewModelStore;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppViewModelStore = new ViewModelStore();
    }

    @Nullable
    @Override
    public ViewModelStore getViewModelStore() {
        return mAppViewModelStore;
    }
}
