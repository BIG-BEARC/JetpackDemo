package com.chuxiong.jetpackdemo.player;

/**
 * @Description
 * @Author chuxiong
 * @Time 2020/7/28 18:50
 */
public class PlayerManager {
    private PlayerManager() {
    }

    public void changeMode() {

    }

    public void playPrevious() {

    }

    public void togglePlay() {

    }

    public void playNext() {

    }

    private static class Instance {
        private static PlayerManager S_MANAGER = new PlayerManager();
    }

    public static PlayerManager getInstance() {
        return Instance.S_MANAGER;
    }
}
