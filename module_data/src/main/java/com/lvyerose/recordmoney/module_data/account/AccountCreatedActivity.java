package com.lvyerose.recordmoney.module_data.account;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.lvyerose.recordmoney.lib_base.base.BaseActivityDataBinding;
import com.lvyerose.recordmoney.lib_base.route.PagerRouteConstant;
import com.lvyerose.recordmoney.lib_base.route.common.TransmitAccountManagerService;
import com.lvyerose.recordmoney.module_data.R;
import com.lvyerose.recordmoney.module_data.databinding.ModuleDataActivityAccountCreatedBinding;

@Route(path = PagerRouteConstant.MODULE_DATA_ACTIVITY_ACCOUNT_CREATED)
public class AccountCreatedActivity extends BaseActivityDataBinding<ModuleDataActivityAccountCreatedBinding> {
    AccountEntity accountEntity;
    @Autowired(name = PagerRouteConstant.MODULE_DATA_SERVICE_ACCOUNT_MANAGER)
    TransmitAccountManagerService accountManagerService;

    @Override
    protected int setContentLayout() {
        return R.layout.module_data_activity_account_created;
    }

    @Override
    protected void startAction(Bundle savedInstanceState) {
        accountEntity = new AccountEntity();
        dataBinding.setAccount(accountEntity);
    }

    public void OnClickStartAccount(View view) {
        if (TextUtils.isEmpty(accountEntity.getUserName())) {
            Toast.makeText(this, "必须填写账户名称", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(accountEntity.getPassword())) {
            Toast.makeText(this, "必须填写账户密码", Toast.LENGTH_SHORT).show();
            return;
        }
        accountManagerService.getAccountManager().saveAccount(accountEntity.getUserName(), accountEntity.getPassword());

        ARouter.getInstance()
                .build(PagerRouteConstant.MODULE_MAIN_ACTIVITY_FRAMEWORK_MAIN)
                //.withInt("index", 1)
                .navigation();
    }
}
