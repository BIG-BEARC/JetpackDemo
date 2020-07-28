package com.chuxiong.jetpackdemo.ui.binding_adapter;

import androidx.core.view.GravityCompat;
import androidx.databinding.BindingAdapter;
import androidx.drawerlayout.widget.DrawerLayout;

/**
 * @Description
 * @Author chuxiong
 * @Time 2020/7/28 15:10
 */
public class DrawerBindingAdapter {
    @BindingAdapter(value = {"isOpenDrawer"}, requireAll = false)
    public static void openDraw(DrawerLayout drawerLayout, boolean isOpenDrawer) {
        if (isOpenDrawer && !drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.openDrawer(GravityCompat.START);
        } else {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    @BindingAdapter(value = {"allowDrawerOpen"}, requireAll = false)
    public static void allowDrawOpen(DrawerLayout drawerLayout, boolean allowDrawerOpen) {
        drawerLayout.setDrawerLockMode(allowDrawerOpen ? DrawerLayout.LOCK_MODE_UNLOCKED : DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
    }

    @BindingAdapter(value = {"bindDrawerListener"}, requireAll = false)
    public static void listenDrawerState(DrawerLayout drawerLayout, DrawerLayout.SimpleDrawerListener listener) {
        drawerLayout.addDrawerListener(listener);
    }

}
