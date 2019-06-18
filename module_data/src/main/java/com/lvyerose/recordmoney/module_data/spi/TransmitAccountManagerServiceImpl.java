package com.lvyerose.recordmoney.module_data.spi;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lvyerose.recordmoney.lib_base.data.IAccountManager;
import com.lvyerose.recordmoney.lib_base.route.PagerRouteConstant;
import com.lvyerose.recordmoney.lib_base.route.common.TransmitAccountManagerService;
import com.lvyerose.recordmoney.module_data.account.AccountManager;

@Route(path = PagerRouteConstant.MODULE_DATA_SERVICE_ACCOUNT_MANAGER)
public class TransmitAccountManagerServiceImpl implements TransmitAccountManagerService {
    @Override
    public IAccountManager getAccountManager() {
        return AccountManager.getInstance();
    }

    @Override
    public void init(Context context) {

    }
}
