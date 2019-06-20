package com.lvyerose.recordmoney.module_account.ui;

import android.view.View;

import com.lvyerose.recordmoney.lib_base.base.BaseFragmentDataBinding;
import com.lvyerose.recordmoney.module_account.R;
import com.lvyerose.recordmoney.module_account.databinding.ModuleAccountFrameworkFragmentHomeBinding;

public class FrameworkAccountFragment extends BaseFragmentDataBinding<ModuleAccountFrameworkFragmentHomeBinding> {

    @Override
    protected int setContentLayout() {
        return R.layout.module_account_framework_fragment_home;
    }

    @Override
    protected void onAfterSetView(View parentView) {
    }
}
