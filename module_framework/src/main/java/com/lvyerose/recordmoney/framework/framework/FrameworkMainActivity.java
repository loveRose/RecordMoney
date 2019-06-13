package com.lvyerose.recordmoney.framework.framework;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.lvyerose.recordmoney.framework.R;
import com.lvyerose.recordmoney.framework.databinding.ModuleFrameworkActivityFrameworkMainBinding;
import com.lvyerose.recordmoney.lib_base.base.BaseActivityDataBinding;
import com.lvyerose.recordmoney.lib_base.route.PagerRouteConstant;
import com.lvyerose.recordmoney.lib_base.route.common.TransmitFragmentService;

/**
 * 项目主架构，协调各个部分的内容，提供架构级的容器和逻辑
 */
@Route(path = PagerRouteConstant.MODULE_MAIN_FRAMEWORK_MAIN)
public class FrameworkMainActivity extends BaseActivityDataBinding<ModuleFrameworkActivityFrameworkMainBinding> {
    private final static int MENU_ACCOUNT_INDEX = 0;
    private final static int MENU_BOOK_INDEX = 1;
    private final static int MENU_PERSONAL_INDEX = 2;

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    private BottomNavigationView menuNavigationView;

    Fragment fragmentAccount;
    Fragment fragmentBook;
    Fragment fragmentMe;

    /**
     * 获取SPI机制的服务对象
     */
    @Autowired(name = PagerRouteConstant.MODULE_ACCOUNT_SERVICE_ACCOUNT_FRAGMENT)
    TransmitFragmentService frameworkAccountFragmentService;
    @Autowired(name = PagerRouteConstant.MODULE_BOOK_SERVICE_BOOK_FRAGMENT)
    TransmitFragmentService frameworkBookFragmentService;
    @Autowired(name = PagerRouteConstant.MODULE_ME_SERVICE_ME_FRAGMENT)
    TransmitFragmentService frameworkMeFragmentService;

    /**
     *
     */
    @Autowired
    public int index = 0;

    @Override
    protected int setContentLayout() {
        return R.layout.module_framework_activity_framework_main;
    }

    @Override
    protected void startAction(Bundle savedInstanceState) {
        initFragment();
        initBottomNavigationView();
        showFragment(index);
        menuNavigationView.setSelectedItemId(menuNavigationView.getMenu().getItem(index).getItemId());
    }

    private void initFragment() {
        fragmentManager = getSupportFragmentManager();
    }

    private void initBottomNavigationView() {
        menuNavigationView = dataBinding.frameworkHomeMenuNavigation;
//        BottomNavigationViewHelper.disableShiftMode(menuNavigationView);
        menuNavigationView.setItemIconTintList(null);
        menuNavigationView.setOnNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.menu_framework_item_account) {
                showFragment(MENU_ACCOUNT_INDEX);
            } else if (itemId == R.id.menu_framework_item_book) {
                showFragment(MENU_BOOK_INDEX);
            } else if (itemId == R.id.menu_framework_item_me) {
                showFragment(MENU_PERSONAL_INDEX);
            }
            return true;
        });
        menuNavigationView.setOnNavigationItemReselectedListener(item -> {
            //重写该方法 用来屏蔽ItemSelected选择重复调用
        });
    }

    /**
     * 显示fragment
     */
    private void showFragment(int index) {
        this.index = index;
        fragmentTransaction = fragmentManager.beginTransaction();
        hideFragment(fragmentTransaction);
        switch (index) {
            case MENU_ACCOUNT_INDEX:
                if (fragmentAccount != null)
                    fragmentTransaction.show(fragmentAccount);
                else {
                    fragmentAccount = frameworkAccountFragmentService.getFragment();
                    fragmentTransaction.add(R.id.framework_home_content_view, fragmentAccount);
                }
                break;
            case MENU_BOOK_INDEX:
                if (fragmentBook != null)
                    fragmentTransaction.show(fragmentBook);
                else {
                    fragmentBook = frameworkBookFragmentService.getFragment();
                    fragmentTransaction.add(R.id.framework_home_content_view, fragmentBook);
                }
                break;
            case MENU_PERSONAL_INDEX:
                if (fragmentMe != null)
                    fragmentTransaction.show(fragmentMe);
                else {
                    fragmentMe = frameworkMeFragmentService.getFragment();
                    fragmentTransaction.add(R.id.framework_home_content_view, fragmentMe);
                }
                break;
        }
        fragmentTransaction.commitAllowingStateLoss();
    }

    /**
     * 隐藏fragment
     */
    private void hideFragment(FragmentTransaction ft) {
        if (fragmentAccount != null)
            ft.hide(fragmentAccount);
        if (fragmentBook != null)
            ft.hide(fragmentBook);
        if (fragmentMe != null)
            ft.hide(fragmentMe);
    }

    long tempTime = 0;

    @Override
    protected void onKeyBack() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - tempTime < 800) {
            super.onKeyBack();
        } else {
            Toast.makeText(this, getResources().getString(R.string.app_exit_hint), Toast.LENGTH_SHORT).show();
            tempTime = currentTime;
        }
    }

    /**
     * singleTask模式下再次走启动的时候走的生命周期
     * 注意使用参数intent 而非 getIntent
     *
     * @param intent 重启之后的intent携带内容
     */
    @Override
    protected void onNewIntent(Intent intent) {
        index = intent.getIntExtra("index", 0);
        showFragment(index);
        menuNavigationView.setSelectedItemId(menuNavigationView.getMenu().getItem(index).getItemId());
        super.onNewIntent(intent);
    }
}
