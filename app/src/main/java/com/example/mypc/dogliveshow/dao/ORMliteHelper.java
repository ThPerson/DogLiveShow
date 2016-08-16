package com.example.mypc.dogliveshow.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by JiaFan on 2016/8/16 08:58
 * QQ：1319662955
 */
public class ORMliteHelper extends OrmLiteSqliteOpenHelper {
    private static String DATA_BASE_NAME = "user.db";
    private static int DB_VERSION = 1;
    public ORMliteHelper(Context context) {
        super(context, DATA_BASE_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, User.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource,User.class,true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
