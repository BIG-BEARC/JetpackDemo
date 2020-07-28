package com.chuxiong.jetpackdemo.ui.state;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.chuxiong.jetpackdemo.data.bean.LibraryInfo;
import com.chuxiong.jetpackdemo.domain.request.InfoRequest;

import java.util.List;

/**
 * @Description
 * @Author chuxiong
 * @Time 2020/7/28 17:30
 */
public class DrawerViewModel extends ViewModel {
    //TODO 此处用于绑定的状态，使用 LiveData 而不是 ObservableField，主要是考虑到 ObservableField 具有防抖的特性，不适合该场景。

    //如果这么说还不理解的话，详见 https://xiaozhuanlan.com/topic/9816742350

    public final MutableLiveData<List<LibraryInfo>> list = new MutableLiveData<>();

    //TODO 将 request 作为 ViewModel 的成员暴露给 Activity/Fragment，
    // 如此便于语义的明确，以及实现多个 request 在 ViewModel 中的组合和复用。

    public final InfoRequest infoRequest = new InfoRequest();
}
