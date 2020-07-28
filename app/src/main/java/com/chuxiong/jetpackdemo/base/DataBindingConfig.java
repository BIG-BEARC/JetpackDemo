package com.chuxiong.jetpackdemo.base;

import android.util.SparseArray;

import androidx.annotation.LayoutRes;
import androidx.lifecycle.ViewModel;

/**
 * @Description
 *
 * TODO tip:
 * 将 DataBinding 实例限制于 base 页面中，默认不向子类暴露，
 * 通过这样的方式，来彻底解决 视图调用的一致性问题，
 * 如此，视图刷新的安全性将和基于函数式编程的 Jetpack Compose 持平。
 * 而 DataBindingConfig 就是在这样的背景下，用于为 base 页面中的 DataBinding 提供绑定项。
 * <p>
 * 如果这样说还不理解的话，详见 https://xiaozhuanlan.com/topic/9816742350 和 https://xiaozhuanlan.com/topic/2356748910
 * <p>
 * Create by KunMinX at 20/4/18
 * @Author chuxiong
 * @Time 2020/7/28 10:41
 */
public class DataBindingConfig {
    private @LayoutRes
    int layoutId;
    private int vmVariableId;
    private ViewModel stateViewModel;

    private SparseArray<Object> bindingParams = new SparseArray<>();

    public DataBindingConfig(int layoutId, int vmVariableId, ViewModel stateViewModel) {
        this.layoutId = layoutId;
        this.vmVariableId = vmVariableId;
        this.stateViewModel = stateViewModel;
    }

    public DataBindingConfig addBindingParam(int vmVariableId, Object object) {
        if (bindingParams.get(vmVariableId) == null) {
            bindingParams.put(vmVariableId, object);
        }
        return this;
    }

    public int getLayoutId() {
        return layoutId;
    }

    public int getVmVariableId() {
        return vmVariableId;
    }

    public ViewModel getStateViewModel() {
        return stateViewModel;
    }

    public SparseArray<Object> getBindingParams() {
        return bindingParams;
    }
}
