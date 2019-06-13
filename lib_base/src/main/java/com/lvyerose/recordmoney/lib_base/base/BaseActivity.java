package com.lvyerose.recordmoney.lib_base.base;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.launcher.ARouter;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onBeforeSetView();
        setBaseContentView(setContentLayout());
        ARouter.getInstance().inject(this);
        onAfterSetView();
        startAction(savedInstanceState);
    }


    protected void setBaseContentView(@LayoutRes int layoutId) {
        setContentView(layoutId);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        saveInstanceState(outState);
        super.onSaveInstanceState(outState);
        //保存状态 用于恢复
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        //恢复状态
        restoreInstanceState(savedInstanceState);
    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        //创建时不同启动模式导致生命周期不创建 而是调用该方法
        newIntent(intent);
    }


    /**
     * 设置  setContentView() 的布局
     *
     * @return
     */
    protected abstract int setContentLayout();

    /**
     * onCreate方法全部执行完了，可以开始这个页面的逻辑操作了
     *
     * @param savedInstanceState 原onCreate里面的状态保存参数
     * @return
     */
    protected abstract void startAction(Bundle savedInstanceState);

    /**
     * 在调用 setContentView() 方法之前
     */
    protected void onBeforeSetView() {
    }

    /**
     * 在调用 setContentView() 方之后
     */
    protected void onAfterSetView() {
    }

    protected void onKeyBack() {
        finish();
    }

    protected void onKeyHome() {

    }

    protected void onKeyMenu() {

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            onKeyBack();
        } else if (keyCode == KeyEvent.KEYCODE_HOME) {
            onKeyHome();
        } else if (keyCode == KeyEvent.KEYCODE_MENU) {
            onKeyMenu();
        }
        return false;
    }

    /**
     * 用于提供给Activity刷新
     */
    protected void onRefresh() {

    }

    /**
     * onNewIntent 方法在创建Activity但无需重新创建实例的情况下调用
     *
     * @param intent
     */
    protected void newIntent(Intent intent) {
        //供子类重写接收
    }

    /**
     * 保存状态调用
     *
     * @param outState
     */
    protected void saveInstanceState(Bundle outState) {
        //供子类重写接收
    }

    /**
     * 恢复状态调用
     *
     * @param outState
     */
    protected void restoreInstanceState(Bundle outState) {
        //供子类重写接收
    }
}
