package com.lvyerose.recordmoney.module_data.account;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 用户信息数据库存储类
 */
@Entity
public class AccountEntity {
    @NotNull
    private String userName;

    @NotNull
    private String password;

    @Generated(hash = 179584291)
    public AccountEntity(@NotNull String userName, @NotNull String password) {
        this.userName = userName;
        this.password = password;
    }

    @Generated(hash = 40307897)
    public AccountEntity() {
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
