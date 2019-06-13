package com.lvyerose.recordmoney.framework.welcome;

import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;
import com.lvyerose.recordmoney.framework.R;
import com.lvyerose.recordmoney.lib_base.base.BaseActivity;
import com.lvyerose.recordmoney.lib_base.route.PagerRouteConstant;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 欢迎页面
 */
public class WelcomeActivity extends BaseActivity {
    //欢迎页停留时间间隔 单位ms
    public final static long TIME_INTERVAL = 3000;
    Disposable timedDisposable;

    @Override
    protected int setContentLayout() {
        return R.layout.module_framework_activity_welcome;
    }

    @Override
    protected void startAction(Bundle savedInstanceState) {
        timedDisposable = Flowable.timer(TIME_INTERVAL, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe(result -> {
                    ARouter.getInstance()
                            .build(PagerRouteConstant.MODULE_MAIN_FRAMEWORK_MAIN)
//                            .withInt("index", 1)
                            .navigation();
                    onKeyBack();
                });
//        timedDisposable = Flowable.fromCallable(() -> {
//            Thread.sleep(TIME_INTERVAL);
//            return "DONE";
//        })
//                .subscribeOn(Schedulers.io())
//                .observeOn(Schedulers.single())
//                .subscribe(result -> {
//                    ARouter.getInstance()
//                            .build(PagerRouteConstant.MODULE_MAIN_FRAMEWORK_MAIN)
////                            .withInt("index", 1)
//                            .navigation();
//                    onKeyBack();
//                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (timedDisposable != null && !timedDisposable.isDisposed()) {
            timedDisposable.dispose();
            timedDisposable = null;
        }
    }
}
