package com.lvyerose.recordmoney.module_data.account;

import com.lvyerose.recordmoney.lib_base.data.IAccountManager;
import com.lvyerose.recordmoney.module_data.DatabaseHelper;

import java.util.List;

/**
 * 用户信息管理类，包含增删改查等操作
 */
public class AccountManager implements IAccountManager {

    private AccountManager() {

    }

    private static final class SingletonHolder {
        private static final AccountManager instance = new AccountManager();
    }

    public static AccountManager getInstance() {
        return SingletonHolder.instance;
    }

    @Override
    public String getAccountUserName() {
        List<AccountEntity> list = DatabaseHelper.getInstance().query(DatabaseHelper.getInstance().getDaoSession().getAccountEntityDao());
        if (list != null && list.size() > 0) {
            return list.get(0).getUserName();
        }
        return null;
    }

    @Override
    public boolean isHaveAccount() {
        List<AccountEntity> list = DatabaseHelper.getInstance().query(DatabaseHelper.getInstance().getDaoSession().getAccountEntityDao());
        return list != null && list.size() > 0;
    }

    @Override
    public void saveAccount(String userName, String password) {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setUserName(userName);
        accountEntity.setPassword(password);
        DatabaseHelper.getInstance().insert(DatabaseHelper.getInstance().getDaoSession().getAccountEntityDao(), accountEntity);
    }
}
