package com.lvyerose.recordmoney.module_data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.lvyerose.recordmoney.lib_base.data.IDatabaseHelper;
import com.lvyerose.recordmoney.module_data.dao.DaoMaster;
import com.lvyerose.recordmoney.module_data.dao.DaoSession;

import org.greenrobot.greendao.AbstractDao;

import java.util.List;


public final class DatabaseHelper implements IDatabaseHelper {
    public DaoSession daoSession;

    private DatabaseHelper() {

    }

    private static final class SingletonHolder {
        private static final DatabaseHelper databaseHelper = new DatabaseHelper();
    }

    public static DatabaseHelper getInstance() {
        return SingletonHolder.databaseHelper;
    }

    public void initDatabase(Context context, String dbName) {
        initDatabase(context, dbName, null);
    }

    public void initDatabase(Context context, String dbName, SQLiteDatabase.CursorFactory factory) {
        DaoMaster.OpenHelper helper = new DaoMaster.OpenHelper(context, dbName, factory) {

        };
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public long insert(AbstractDao dao, Object data) {
        return dao.insert(data);
    }

    public void update(AbstractDao dao, Object data) {
        dao.update(data);
    }

    public void delete(AbstractDao dao, Object data) {
        dao.delete(data);
    }

    public <T> List<T> query(AbstractDao dao) {
        return dao.queryBuilder().list();
    }


}
