package com.lvyerose.recordmoney.lib_base.data;

public interface IAccountManager {
    String getAccountUserName();

    boolean isHaveAccount();

    void saveAccount(String userName, String password);

}
