package com.lvyerose.recordmoney.module_book.ui;

import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.lvyerose.recordmoney.lib_base.base.BaseFragmentDataBinding;
import com.lvyerose.recordmoney.lib_base.route.PagerRouteConstant;
import com.lvyerose.recordmoney.lib_base.route.common.TransmitAccountManagerService;
import com.lvyerose.recordmoney.module_book.R;
import com.lvyerose.recordmoney.module_book.databinding.ModuleBookFrameworkFragmentHomeBinding;

public class FrameworkBookFragment extends BaseFragmentDataBinding<ModuleBookFrameworkFragmentHomeBinding> {
    @Autowired(name = PagerRouteConstant.MODULE_DATA_SERVICE_ACCOUNT_MANAGER)
    TransmitAccountManagerService accountManagerService;

    @Override
    protected int setContentLayout() {
        return R.layout.module_book_framework_fragment_home;
    }

    @Override
    protected void onAfterSetView(View parentView) {
        String accountName = accountManagerService.getAccountManager().getAccountUserName();
        dataBinding.tvAccountName.setText(accountName);

    }
}
