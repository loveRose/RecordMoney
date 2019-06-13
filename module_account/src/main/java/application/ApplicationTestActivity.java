package application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.lvyerose.recordmoney.lib_base.base.BaseActivity;
import com.lvyerose.recordmoney.lib_base.route.PagerRouteConstant;
import com.lvyerose.recordmoney.lib_base.route.common.TransmitFragmentService;
import com.lvyerose.recordmoney.module_account.R;

public class ApplicationTestActivity extends BaseActivity {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    Fragment fragment;
    /**
     * 获取SPI机制的服务对象
     */
    @Autowired(name = PagerRouteConstant.MODULE_ACCOUNT_SERVICE_ACCOUNT_FRAGMENT)
    TransmitFragmentService frameworkAccountFragmentService;

    @Override
    protected int setContentLayout() {
        return R.layout.module_account_activity_application_test;
    }

    @Override
    protected void startAction(Bundle savedInstanceState) {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragment = frameworkAccountFragmentService.getFragment();
        fragmentTransaction.add(R.id.content_view, fragment);
        fragmentTransaction.commitAllowingStateLoss();
    }
}
