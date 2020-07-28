package com.chuxiong.jetpackdemo.data.repositroy;

import com.chuxiong.jetpackdemo.R;
import com.chuxiong.jetpackdemo.data.bean.LibraryInfo;
import com.chuxiong.jetpackdemo.domain.NetState;
import com.chuxiong.jetpackdemo.uitl.Utils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @Description
 * @Author chuxiong
 * @Time 2020/7/24 12:34
 */
public class DataRepository implements ILocalSource, IRemoteSource {
    private DataRepository() {
    }



    private static class Instance {
        private static DataRepository S_REQUEST_MANAGER = new DataRepository();
    }

    public static DataRepository getInstance() {
        return Instance.S_REQUEST_MANAGER;
    }

    @Override
    public void getLibraryInfo(DataResult<List<LibraryInfo>> result) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<LibraryInfo>>() {
        }.getType();
        List<LibraryInfo> list = gson.fromJson(Utils.getApp().getString(R.string.library_json), type);

        result.setResult(list, new NetState());
    }

}
