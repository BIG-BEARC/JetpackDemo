package com.chuxiong.jetpackdemo.domain;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

import com.chuxiong.jetpackdemo.R;
import com.chuxiong.jetpackdemo.uitl.NetworkUtils;

import java.util.Objects;

/**
 * @Description
 * @Author chuxiong
 * @Time 2020/7/28 11:25
 */
public class NetworkStateReceive extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (Objects.equals(intent.getAction(), ConnectivityManager.CONNECTIVITY_ACTION)){
            if (!NetworkUtils.isConnected()) {
                Toast.makeText(context, context.getString(R.string.network_not_good), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
