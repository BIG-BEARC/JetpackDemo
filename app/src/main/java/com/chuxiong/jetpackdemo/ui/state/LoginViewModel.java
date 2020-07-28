package com.chuxiong.jetpackdemo.ui.state;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.chuxiong.jetpackdemo.domain.request.AccountRequest;

/**
 * @Description
 * @Author chuxiong
 * @Time 2020/7/28 19:12
 */
public class LoginViewModel extends ViewModel {
    public final ObservableField<String> name = new ObservableField<>();

    public final ObservableField<String> password = new ObservableField<>();

    public final ObservableBoolean loadingVisible = new ObservableBoolean();

    //TODO 将 request 作为 ViewModel 的成员暴露给 Activity/Fragment，
    // 如此便于语义的明确，以及实现多个 request 在 ViewModel 中的组合和复用。

    public final AccountRequest accountRequest = new AccountRequest();
}
