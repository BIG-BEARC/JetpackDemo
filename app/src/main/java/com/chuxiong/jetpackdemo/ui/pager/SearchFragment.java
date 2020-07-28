package com.chuxiong.jetpackdemo.ui.pager;

import com.chuxiong.jetpackdemo.BR;
import com.chuxiong.jetpackdemo.R;
import com.chuxiong.jetpackdemo.base.BaseFragment;
import com.chuxiong.jetpackdemo.base.DataBindingConfig;
import com.chuxiong.jetpackdemo.ui.state.SearchViewModel;

/**
 * @Description
 * @Author chuxiong
 * @Time 2020/7/28 19:05
 */
public class SearchFragment extends BaseFragment {
    private SearchViewModel mSearchViewModel;

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.fragment_search, BR.vm, mSearchViewModel)
                .addBindingParam(BR.click, new ClickProxy());
    }

    @Override
    protected void initViewModel() {
        mSearchViewModel = getActivityViewModel(SearchViewModel.class);
    }

    public class ClickProxy {
        public void subscribe() {
        }

        public void testDownload() {
        }

        public void testLifecycleDownload() {
        }

        public void back() {
        }

        public void testNav() {
        }
    }
}
