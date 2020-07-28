package com.chuxiong.jetpackdemo.base;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.SparseArray;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.chuxiong.jetpackdemo.App;

/**
 * @Description
 * @Author chuxiong
 * @Time 2020/7/28 10:47
 */
public abstract class DataBindingActivity extends AppCompatActivity {
    private ViewModelProvider mActivityProvider;
    private ViewModelProvider.Factory mFactory;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        doBeforeOnCreate();
        super.onCreate(savedInstanceState);
        initViewModel();
        DataBindingConfig dataBindingConfig = getDataBindingConfig();
        ViewDataBinding binding = DataBindingUtil.setContentView(this, dataBindingConfig.getLayoutId());
        binding.setLifecycleOwner(this);
        SparseArray bindingParams = dataBindingConfig.getBindingParams();
        for (int i = 0; i < bindingParams.size(); i++) {
            binding.setVariable(bindingParams.keyAt(i), bindingParams.valueAt(i));
        }
    }

    protected abstract void doBeforeOnCreate();

    /**
     *
     * @return
     */
    protected abstract DataBindingConfig getDataBindingConfig();

    /**
     * 初始化 ViewModel
     */
    protected abstract void initViewModel();

    /**
     *  获取各页面独有的 ViewModel 实例
     * @param modelClass
     * @param <T>
     * @return
     */
    protected <T extends ViewModel> T getActivityViewModel(Class<T> modelClass) {
        if (mActivityProvider == null) {
            mActivityProvider = new ViewModelProvider(this);
        }
        return mActivityProvider.get(modelClass);
    }

    /**
     *  获取全局 ViewModelProvider
     * @return
     */
    protected ViewModelProvider getAppViewModelProvider() {
        return new ViewModelProvider((App) this.getApplication(), getAppFactory(this));
    }


    private ViewModelProvider.Factory getAppFactory(Activity activity) {
        Application application = checkApplication(activity);
        if (mFactory == null) {
            mFactory = new ViewModelProvider.AndroidViewModelFactory(application);
        }
        return mFactory;
    }

    private Application checkApplication(Activity activity) {
        Application application = activity.getApplication();
        if (application == null) {
            throw new IllegalStateException("Your activity/fragment is not yet attached to "
                    + "Application. You can't request ViewModel before onCreate call.");
        }
        return application;
    }

}
