package com.chuxiong.jetpackdemo.ui.state;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.chuxiong.jetpackdemo.domain.request.DownloadRequest;

/**
 * @Description
 * @Author chuxiong
 * @Time 2020/7/28 19:06
 */
public class SearchViewModel extends ViewModel {

    public final ObservableField<Integer> progress = new ObservableField<>();

    public final ObservableField<Integer> progress_cancelable = new ObservableField<>();

    //TODO 将 request 作为 ViewModel 的成员暴露给 Activity/Fragment，
    // 如此便于语义的明确，以及实现多个 request 在 ViewModel 中的组合和复用。

    public final DownloadRequest downloadRequest = new DownloadRequest();
}
