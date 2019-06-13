package com.lvyerose.recordmoney.lib_base.base;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/**
 * 带DataBinding绑定功能的Fragment基类
 *
 * @param <T> DataBinding生成的中间类
 */
public abstract class BaseFragmentDataBinding<T extends ViewDataBinding> extends BaseFragment {
    protected T dataBinding;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state) {
        dataBinding = DataBindingUtil.inflate(inflater, setContentLayout(), container, false);
        parentView = dataBinding.getRoot();
        onAfterSetView(parentView);
        return parentView;
    }
}
