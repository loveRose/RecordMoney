package com.lvyerose.recordmoney.lib_base.route.common;

import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.template.IProvider;

import java.util.ArrayList;
import java.util.Map;

public interface TransmitFragmentService extends IProvider {
    Fragment getFragment();

    Fragment getFragment(ArrayList<String> paramKeys, Map<String, String> params);
}
