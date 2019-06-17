package com.lvyerose.recordmoney.module_data.spi;

import android.content.Context;


import com.alibaba.android.arouter.facade.annotation.Route;
import com.lvyerose.recordmoney.lib_base.route.PagerRouteConstant;
import com.lvyerose.recordmoney.lib_base.route.common.TransmitDatabaseHelperService;
import com.lvyerose.recordmoney.lib_base.route.expose.IDatabaseHelper;
import com.lvyerose.recordmoney.module_data.DatabaseHelper;

@Route(path = PagerRouteConstant.MODULE_DATA_SERVICE_DATABASE_HELPER)
public class TransmitDatabaseHelperServiceImpl implements TransmitDatabaseHelperService {

    @Override
    public void init(Context context) {

    }

    @Override
    public IDatabaseHelper getDatabaseHelper() {
        return DatabaseHelper.getInstance();
    }
}
