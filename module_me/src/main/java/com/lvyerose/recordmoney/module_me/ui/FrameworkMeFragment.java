package com.lvyerose.recordmoney.module_me.ui;

import android.view.View;

import com.lvyerose.recordmoney.lib_base.base.BaseFragmentDataBinding;
import com.lvyerose.recordmoney.module_me.R;
import com.lvyerose.recordmoney.module_me.databinding.ModuleMeFrameworkFragmentHomeBinding;

public class FrameworkMeFragment extends BaseFragmentDataBinding<ModuleMeFrameworkFragmentHomeBinding> {

    @Override
    protected int setContentLayout() {
        return R.layout.module_me_framework_fragment_home;
    }

    @Override
    protected void onAfterSetView(View parentView) {
    }
}
