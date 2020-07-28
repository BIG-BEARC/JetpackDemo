package com.chuxiong.jetpackdemo.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

/**
 * @Description
 * @Author chuxiong
 * @Time 2020/7/28 14:55
 */
public abstract class BaseFragment extends DataBindingFragment {

    protected NavController nav() {
        return NavHostFragment.findNavController(this);
    }
}
