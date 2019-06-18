package com.lvyerose.recordmoney.lib_base.route.common;

import com.alibaba.android.arouter.facade.template.IProvider;
import com.lvyerose.recordmoney.lib_base.data.IAccountManager;

public interface TransmitAccountManagerService extends IProvider {
    IAccountManager getAccountManager();
}
