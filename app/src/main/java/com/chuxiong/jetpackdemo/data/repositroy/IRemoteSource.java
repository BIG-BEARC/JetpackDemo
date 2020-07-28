package com.chuxiong.jetpackdemo.data.repositroy;

import com.chuxiong.jetpackdemo.data.bean.LibraryInfo;

import java.util.List;

/**
 * @Description
 * @Author chuxiong
 * @Time 2020/7/24 12:34
 */
public interface IRemoteSource {
    void getLibraryInfo(DataResult<List<LibraryInfo>> result);
}
