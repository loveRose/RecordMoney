package com.lvyerose.recordmoney.lib_base.route.common;

import com.alibaba.android.arouter.facade.template.IProvider;
import com.lvyerose.recordmoney.lib_base.route.expose.IDatabaseHelper;

public interface TransmitDatabaseHelperService extends IProvider {
    IDatabaseHelper getDatabaseHelper();
}
