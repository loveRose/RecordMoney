package com.lvyerose.recordmoney.lib_base.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public interface IDatabaseHelper {
    void initDatabase(Context context, String dbName);

    void initDatabase(Context context, String dbName, SQLiteDatabase.CursorFactory factory);
}
