package com.lvyerose.recordmoney.lib_base.base;

import android.app.Application;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.launcher.ARouter;
import com.lvyerose.recordmoney.lib_base.BuildConfig;
import com.lvyerose.recordmoney.lib_base.route.PagerRouteConstant;
import com.lvyerose.recordmoney.lib_base.route.common.TransmitDatabaseHelperService;

public class BaseCommonApplication extends Application {

    TransmitDatabaseHelperService databaseHelperService;

    @Override
    public void onCreate() {
        super.onCreate();
        initARout();
        initSQLite();
    }

    private void initSQLite() {
        //通过主动查找服务获取实例
        databaseHelperService = (TransmitDatabaseHelperService) ARouter.getInstance().build(PagerRouteConstant.MODULE_DATA_SERVICE_DATABASE_HELPER).navigation();
        if (databaseHelperService != null) {
            databaseHelperService.getDatabaseHelper().initDatabase(this, "record_db", null);
        }
    }

    private void initARout() {
        if (isDebug()) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this); // 尽可能早，推荐在Application中初始化
    }

    public boolean isDebug() {
        return BuildConfig.DEBUG;
    }
}
