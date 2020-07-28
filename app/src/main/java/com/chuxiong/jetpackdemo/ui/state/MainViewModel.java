package com.chuxiong.jetpackdemo.ui.state;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.chuxiong.jetpackdemo.data.bean.TestAlbum;
import com.chuxiong.jetpackdemo.domain.request.MusicRequest;

import java.util.List;

/**
 * TODO tip：每个页面都要单独准备一个 state-ViewModel，
 * 来托管 DataBinding 绑定的临时状态，以及视图控制器重建时状态的恢复。
 * <p>
 * 此外，state-ViewModel 的职责仅限于 状态托管，不建议在此处理 UI 逻辑，
 * UI 逻辑只适合在 Activity/Fragment 等视图控制器中完成，是 “数据驱动” 的一部分，
 * 将来升级到 Jetpack Compose 更是如此。
 * <p>
 * 如果这样说还不理解的话，详见 https://xiaozhuanlan.com/topic/9816742350
 * <p>
 * Create by KunMinX at 19/10/29
 */
public class MainViewModel extends ViewModel {
    public final ObservableBoolean initTabAndPage = new ObservableBoolean();
    public final ObservableField<String> pageAssetPath = new ObservableField<>();
    //TODO 将 request 作为 ViewModel 的成员暴露给 Activity/Fragment，
    // 如此便于语义的明确，以及实现多个 request 在 ViewModel 中的组合和复用。

    public final MutableLiveData<List<TestAlbum.TestMusic>> list = new MutableLiveData<>();

    public final MutableLiveData<Boolean> notifyCurrentListChanged = new MutableLiveData<>();
    public final MusicRequest musicRequest = new MusicRequest();

    {
        initTabAndPage.set(true);
        pageAssetPath.set("summary.html");
    }

}
