package com.chuxiong.jetpackdemo.ui.pager;

import com.chuxiong.jetpackdemo.BR;
import com.chuxiong.jetpackdemo.R;
import com.chuxiong.jetpackdemo.base.BaseFragment;
import com.chuxiong.jetpackdemo.base.DataBindingConfig;
import com.chuxiong.jetpackdemo.domain.callback.SharedViewModel;
import com.chuxiong.jetpackdemo.ui.state.MainViewModel;

/**
 * @Description
 * @Author chuxiong
 * @Time 2020/7/28 10:06
 */
public class MainFragment extends BaseFragment {
    private MainViewModel mMainViewModel;
    private SharedViewModel mSharedViewModel;

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.fragment_main,BR.vm,mMainViewModel)
                .addBindingParam(BR.click,new ClickProxy());
    }

    @Override
    protected void initViewModel() {
        mMainViewModel = getActivityViewModel(MainViewModel.class);
        mSharedViewModel = getAppViewModelProvider().get(SharedViewModel.class);
    }

    // TODO tip 2：此处通过 DataBinding 来规避 在 setOnClickListener 时存在的 视图调用的一致性问题，

    // 也即，有绑定就有绑定，没绑定也没什么大不了的，总之 不会因一致性问题造成 视图调用的空指针。
    // 如果这么说还不理解的话，详见 https://xiaozhuanlan.com/topic/9816742350

    public class ClickProxy {
        public void openMenu() {
            mSharedViewModel.openOrCloseDrawer.setValue(true);
        }

        public void search() {
        }

        public void login() {
        }
    }
}
