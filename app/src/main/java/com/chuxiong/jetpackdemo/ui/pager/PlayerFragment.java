package com.chuxiong.jetpackdemo.ui.pager;

import android.widget.SeekBar;

import com.chuxiong.jetpackdemo.BR;
import com.chuxiong.jetpackdemo.R;
import com.chuxiong.jetpackdemo.base.BaseFragment;
import com.chuxiong.jetpackdemo.base.DataBindingConfig;
import com.chuxiong.jetpackdemo.domain.callback.SharedViewModel;
import com.chuxiong.jetpackdemo.player.PlayerManager;
import com.chuxiong.jetpackdemo.ui.state.PlayerViewModel;

/**
 * @Description
 * @Author chuxiong
 * @Time 2020/7/28 18:03
 */
public class PlayerFragment extends BaseFragment {
    private SharedViewModel mSharedViewModel;
    private PlayerViewModel mPlayerViewModel;
    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.fragment_player, BR.vm,mPlayerViewModel)
                .addBindingParam(BR.click,new ClickProxy())
                .addBindingParam(BR.event,new EventHandler());
    }

    @Override
    protected void initViewModel() {
        mPlayerViewModel = getActivityViewModel(PlayerViewModel.class);
        mSharedViewModel = getAppViewModelProvider().get(SharedViewModel.class);
    }

    public class ClickProxy{

        public void playMode() {
            PlayerManager.getInstance().changeMode();
        }

        public void previous() {
            PlayerManager.getInstance().playPrevious();
        }

        public void togglePlay() {
            PlayerManager.getInstance().togglePlay();
        }

        public void next() {
            PlayerManager.getInstance().playNext();
        }

        public void showPlayList() {
            showShortToast(R.string.unfinished);
        }

        public void slideDown() {
            mSharedViewModel.closeSlidePanelIfExpanded.setValue(true);
        }

        public void more() {
        }
    }


    public class EventHandler implements SeekBar.OnSeekBarChangeListener{

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }
}
