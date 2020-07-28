package com.chuxiong.jetpackdemo.ui.state;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.chuxiong.jetpackdemo.domain.request.DownloadRequest;

/**
 * @Description
 * @Author chuxiong
 * @Time 2020/7/28 15:04
 */
public class MainActivityViewModel extends ViewModel {
    //TODO 演示 LiveData 来用作 DataBinding 数据绑定的情况。
    // 记得在视图控制器中要加入 mBinding.setLifecycleOwner(this);
    //详见 https://xiaozhuanlan.com/topic/9816742350
    public final MutableLiveData<Boolean> openDraw = new MutableLiveData<>();
    public final MutableLiveData<Boolean> allowDrawerOpen = new MutableLiveData<>();

    //TODO 将 request 作为 ViewModel 的成员暴露给 Activity/Fragment，
    // 如此便于语义的明确，以及实现多个 request 在 ViewModel 中的组合和复用。
    public final DownloadRequest mDownloadRequest = new DownloadRequest();

    {
        allowDrawerOpen.setValue(true);
        openDraw.setValue(false);
    }
}
