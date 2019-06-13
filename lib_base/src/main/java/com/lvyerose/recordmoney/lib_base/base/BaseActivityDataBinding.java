package com.lvyerose.recordmoney.lib_base.base;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class BaseActivityDataBinding<T extends ViewDataBinding> extends BaseActivity {
    protected T dataBinding;

    @Override
    protected void setBaseContentView(int layoutId) {
        dataBinding = DataBindingUtil.setContentView(this, layoutId);
    }
}
