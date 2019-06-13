package com.lvyerose.recordmoney.module_account.spi;

import android.content.Context;

import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lvyerose.recordmoney.lib_base.base.BaseFragment;
import com.lvyerose.recordmoney.lib_base.route.PagerRouteConstant;
import com.lvyerose.recordmoney.lib_base.route.common.TransmitFragmentService;
import com.lvyerose.recordmoney.module_account.ui.FrameworkAccountFragment;

import java.util.ArrayList;
import java.util.Map;

@Route(path = PagerRouteConstant.MODULE_ACCOUNT_SERVICE_ACCOUNT_FRAGMENT)
public class TransmitFragmentServiceImpl implements TransmitFragmentService {
    @Override
    public Fragment getFragment() {
        return getFragment(null, null);
    }

    @Override
    public Fragment getFragment(ArrayList<String> paramKeys, Map<String, String> params) {
        return BaseFragment.newInstance(FrameworkAccountFragment.class, paramKeys, params);
    }

    @Override
    public void init(Context context) {

    }
}
