package pya.marlon.com.examplegreendao.sql.manager;

import android.util.Log;

import java.util.List;

import pya.marlon.com.examplegreendao.sql.model.UserSQL;
import pya.marlon.com.examplegreendao.sql.model.UserSQLDao;

/**
 * Created by marlonpya on 29/07/17.
 */

public class UserSQLManager extends BaseManagerSQL<UserSQL> {
    private static final String TAG = "UserSQLManager";

    @Override
    public void insert(UserSQL sql) {
        Log.d(TAG, "insert: " + sql.toString());
        daoSession.insertOrReplace(sql);
    }

    @Override
    public int getLastId() {
        List<UserSQL> list = daoSession.queryBuilder(UserSQL.class)
                .where(UserSQLDao.Properties.Id.isNotNull())
                .orderDesc(UserSQLDao.Properties.Id).limit(1).list();
        if (list.isEmpty()) {
            return 1;
        } else {
            return list.get(0).getId().intValue() + 1;
        }
    }

    @Override
    public List<UserSQL> getList() {
        return daoSession.queryBuilder(UserSQL.class).list();
    }

    @Override
    public List<UserSQL> getListByFkId(int id) {
        throw new IllegalArgumentException("not use");
    }
}
