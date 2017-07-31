package pya.marlon.com.examplegreendao.sql.manager;

import android.util.Log;

import java.util.List;

import pya.marlon.com.examplegreendao.sql.model.ToySQL;
import pya.marlon.com.examplegreendao.sql.model.ToySQLDao;

/**
 * Created by marlonpya on 29/07/17.
 */

public class ToySQLManager extends BaseManagerSQL<ToySQL> {
    private static final String TAG = "ToySQLManager";

    @Override
    public void insert(ToySQL sql) {
        Log.d(TAG, "insert: " + sql.toString());
        daoSession.insertOrReplace(sql);
    }

    @Override
    public int getLastId() {
        List<ToySQL> toys = daoSession.queryBuilder(ToySQL.class)
                .where(ToySQLDao.Properties.Id.isNotNull())
                .orderDesc(ToySQLDao.Properties.Id).limit(1).list();
        if (toys.isEmpty()) {
            return 1;
        } else {
            return toys.get(0).getId().intValue() + 1;
        }
    }

    @Override
    public List<ToySQL> getList() {
        return daoSession.queryBuilder(ToySQL.class).list();
    }

    @Override
    public List<ToySQL> getListByFkId(int id) {
        return daoSession.queryBuilder(ToySQL.class)
                .where(ToySQLDao.Properties.Fk_idPet.eq(id))
                .list();
    }
}
