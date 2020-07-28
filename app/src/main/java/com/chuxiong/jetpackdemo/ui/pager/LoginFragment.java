package com.chuxiong.jetpackdemo.ui.pager;

import com.chuxiong.jetpackdemo.BR;
import com.chuxiong.jetpackdemo.R;
import com.chuxiong.jetpackdemo.base.BaseFragment;
import com.chuxiong.jetpackdemo.base.DataBindingConfig;
import com.chuxiong.jetpackdemo.ui.state.LoginViewModel;

/**
 * @Description
 * @Author chuxiong
 * @Time 2020/7/28 19:11
 */
public class LoginFragment extends BaseFragment {
    private LoginViewModel mLoginViewModel;

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.fragment_login, BR.vm, mLoginViewModel)
                .addBindingParam(BR.click, new ClickProxy());
    }

    @Override
    protected void initViewModel() {
        mLoginViewModel = getActivityViewModel(LoginViewModel.class);
    }

    public class ClickProxy {
        public void login() {
        }

        public void back() {
        }
    }
}
