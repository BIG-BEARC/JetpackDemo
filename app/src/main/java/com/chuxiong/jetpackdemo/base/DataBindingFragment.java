package com.chuxiong.jetpackdemo.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.chuxiong.jetpackdemo.App;

/**
 * @Description
 * @Author chuxiong
 * @Time 2020/7/28 14:25
 */
public abstract class DataBindingFragment extends Fragment {
    private static final Handler HANDLER = new Handler();
    protected AppCompatActivity mAppCompatActivity;
    protected ViewModelProvider mActivityProvider;
    private ViewModelProvider.Factory mFactory;

    protected boolean mAnimationLoaded;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mAppCompatActivity = (AppCompatActivity) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViewModel();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        DataBindingConfig dataBindingConfig = getDataBindingConfig();
        ViewDataBinding binding = DataBindingUtil.inflate(inflater, dataBindingConfig.getLayoutId(), container, false);
        binding.setLifecycleOwner(this);
        SparseArray bindingParams = dataBindingConfig.getBindingParams();
        for (int i = 0; i < bindingParams.size(); i++) {
            binding.setVariable(bindingParams.keyAt(i), bindingParams.valueAt(i));
        }
        return binding.getRoot();
    }


    @Nullable
    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        //TODO 错开动画转场与 UI 刷新的时机，避免掉帧卡顿的现象
        HANDLER.postDelayed(() -> {
            if (!mAnimationLoaded) {
                mAnimationLoaded = true;
                loadInitData();
            }
        }, 280);
        return super.onCreateAnimation(transit, enter, nextAnim);
    }

    protected void loadInitData() {

    }

    /**
     * 配置页面信息
     *
     * @return
     */
    protected abstract DataBindingConfig getDataBindingConfig();

    /**
     * 初始化 ViewModel
     */
    protected abstract void initViewModel();


    protected <T extends ViewModel> T getActivityViewModel(Class<T> modelClass) {
        if (mActivityProvider == null) {
            mActivityProvider = new ViewModelProvider(mAppCompatActivity);
        }
        return mActivityProvider.get(modelClass);
    }

    protected ViewModelProvider getAppViewModelProvider() {
        return new ViewModelProvider((App) mAppCompatActivity.getApplicationContext(), getFactory(mAppCompatActivity));
    }

    private ViewModelProvider.Factory getFactory(Activity activity) {
        checkActivity(this);
        Application application = checkApplication(activity);
        if (mFactory == null) {
            mFactory = ViewModelProvider.AndroidViewModelFactory.getInstance(application);
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

    private void checkActivity(Fragment fragment) {
        Activity activity = fragment.getActivity();
        if (activity == null) {
            throw new IllegalStateException("Can't create ViewModelProvider for detached fragment");
        }
    }
    protected void showLongToast(String text) {
        Toast.makeText(mAppCompatActivity.getApplicationContext(), text, Toast.LENGTH_LONG).show();
    }

    protected void showShortToast(String text) {
        Toast.makeText(mAppCompatActivity.getApplicationContext(), text, Toast.LENGTH_SHORT).show();
    }

    protected void showLongToast(int stringRes) {
        showLongToast(mAppCompatActivity.getApplicationContext().getString(stringRes));
    }

    protected void showShortToast(int stringRes) {
        showShortToast(mAppCompatActivity.getApplicationContext().getString(stringRes));
    }
}
