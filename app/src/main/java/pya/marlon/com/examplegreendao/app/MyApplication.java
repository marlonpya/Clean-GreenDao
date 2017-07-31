package pya.marlon.com.examplegreendao.app;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import pya.marlon.com.examplegreendao.sql.model.DaoMaster;
import pya.marlon.com.examplegreendao.sql.model.DaoSession;

/**
 * Created by marlonpya on 29/07/17.
 */

public class MyApplication extends Application {
    public DaoSession daoSession;
    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        setupDatabase();
    }

    public static MyApplication getInstance() {
        return instance;
    }

    private void setupDatabase() {
        DaoMaster.OpenHelper helper = new DaoMaster.DevOpenHelper(this, "example.db", null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster master = new DaoMaster(db);
        this.daoSession = master.newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
