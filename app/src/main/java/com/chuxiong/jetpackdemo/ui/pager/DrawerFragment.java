package com.chuxiong.jetpackdemo.ui.pager;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.chuxiong.jetpackdemo.BR;
import com.chuxiong.jetpackdemo.R;
import com.chuxiong.jetpackdemo.base.BaseFragment;
import com.chuxiong.jetpackdemo.base.DataBindingConfig;
import com.chuxiong.jetpackdemo.data.bean.LibraryInfo;
import com.chuxiong.jetpackdemo.domain.callback.SharedViewModel;
import com.chuxiong.jetpackdemo.ui.state.DrawerViewModel;

import java.util.List;

/**
 * @Description
 * @Author chuxiong
 * @Time 2020/7/28 17:25
 */
public class DrawerFragment extends BaseFragment {
    private DrawerViewModel mDrawerViewModel;

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.fragment_drawer, BR.vm, mDrawerViewModel)
                .addBindingParam(BR.click, new ClickProxy());
    }

    @Override
    protected void initViewModel() {
        mDrawerViewModel = getActivityViewModel(DrawerViewModel.class);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mDrawerViewModel.infoRequest.getLibraryLiveData().observe(getViewLifecycleOwner(), new Observer<List<LibraryInfo>>() {
            @Override
            public void onChanged(List<LibraryInfo> libraryInfos) {
                if (libraryInfos != null) {
                    mDrawerViewModel.list.setValue(libraryInfos);
                }
            }
        });

        mDrawerViewModel.infoRequest.requestLibraryInfo();
    }


    @Override
    protected void loadInitData() {
        super.loadInitData();
        if (null != mDrawerViewModel.infoRequest.getLibraryLiveData().getValue()) {
            mDrawerViewModel.list.setValue(mDrawerViewModel.infoRequest.getLibraryLiveData().getValue());
        }
    }

    public class ClickProxy {
        public void logoClick() {

        }
    }
}
