package com.example.harfi.googlemapstest2.util;

import android.app.Application;

import com.example.harfi.googlemapstest2.model.DaoMaster;
import com.example.harfi.googlemapstest2.model.DaoSession;

import org.greenrobot.greendao.database.Database;

/**
 * Created by harfi on 10/19/2017.
 */

public class AppController extends Application {

    public static final boolean ENCRYPTED = true;
    private static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        sqlLiteDatabase();
    }

    private void sqlLiteDatabase(){
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "location-db");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
