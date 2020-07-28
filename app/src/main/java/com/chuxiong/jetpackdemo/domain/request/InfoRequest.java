package com.chuxiong.jetpackdemo.domain.request;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.chuxiong.jetpackdemo.data.bean.LibraryInfo;
import com.chuxiong.jetpackdemo.data.repositroy.DataRepository;
import com.chuxiong.jetpackdemo.data.repositroy.DataResult;
import com.chuxiong.jetpackdemo.domain.NetState;

import java.util.List;

/**
 * @Description
 * @Author chuxiong
 * @Time 2020/7/28 17:31
 */
public class InfoRequest extends BaseRequest {
    private MutableLiveData<List<LibraryInfo>>mLibraryInfoMutableLiveData;
    public LiveData<List<LibraryInfo>> getLibraryLiveData(){
        if (mLibraryInfoMutableLiveData ==null) {
            mLibraryInfoMutableLiveData = new MutableLiveData<>();
        }
        return mLibraryInfoMutableLiveData;
    }

    /**
     * 网络请求
     */
    public  void requestLibraryInfo(){
        DataRepository.getInstance().getLibraryInfo(new DataResult<>(new DataResult.Result<List<LibraryInfo>>() {
            @Override
            public void onResult(List<LibraryInfo> libraryInfos, NetState netState) {
                mLibraryInfoMutableLiveData.setValue(libraryInfos);
            }
        }));
    }
}
