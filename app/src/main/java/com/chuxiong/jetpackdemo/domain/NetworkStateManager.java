package com.chuxiong.jetpackdemo.domain;

import android.content.IntentFilter;
import android.net.ConnectivityManager;

import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

import com.chuxiong.jetpackdemo.uitl.Utils;

/**
 * @Description 网络监听
 * @Author chuxiong
 * @Time 2020/7/28 11:23
 */
public class NetworkStateManager implements DefaultLifecycleObserver {
    private NetworkStateReceive mNetworkStateReceive;
    private NetworkStateManager() {
    }

    private static class InstanceHolder {
        private static NetworkStateManager instance = new NetworkStateManager();
    }

    public static NetworkStateManager getInstance() {
        return InstanceHolder.instance;
    }

    @Override
    public void onResume(@NonNull LifecycleOwner owner) {
        mNetworkStateReceive = new NetworkStateReceive();
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        Utils.getApp().getApplicationContext().registerReceiver(mNetworkStateReceive, filter);
    }

    @Override
    public void onPause(@NonNull LifecycleOwner owner) {
        Utils.getApp().getApplicationContext().unregisterReceiver(mNetworkStateReceive);
    }
}
