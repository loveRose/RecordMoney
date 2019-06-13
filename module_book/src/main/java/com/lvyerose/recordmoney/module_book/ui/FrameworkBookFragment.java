package com.lvyerose.recordmoney.module_book.ui;

import android.view.View;

import com.lvyerose.recordmoney.lib_base.base.BaseFragmentDataBinding;
import com.lvyerose.recordmoney.module_book.R;
import com.lvyerose.recordmoney.module_book.databinding.ModuleBookFrameworkFragmentHomeBinding;

public class FrameworkBookFragment extends BaseFragmentDataBinding<ModuleBookFrameworkFragmentHomeBinding> {

    @Override
    protected int setContentLayout() {
        return R.layout.module_book_framework_fragment_home;
    }

    @Override
    protected void onAfterSetView(View parentView) {
    }
}
