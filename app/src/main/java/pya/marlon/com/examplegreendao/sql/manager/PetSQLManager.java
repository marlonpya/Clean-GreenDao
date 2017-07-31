package pya.marlon.com.examplegreendao.sql.manager;

import android.util.Log;

import java.util.List;

import pya.marlon.com.examplegreendao.sql.model.PetSQL;
import pya.marlon.com.examplegreendao.sql.model.PetSQLDao;

/**
 * Created by marlonpya on 29/07/17.
 */

public class PetSQLManager extends BaseManagerSQL<PetSQL> {
    private static final String TAG = "PetSQLManager";

    @Override
    public void insert(PetSQL sql) {
        Log.d(TAG, "insert: " + sql.toString());
        daoSession.insertOrReplace(sql);
    }

    @Override
    public int getLastId() {
        List<PetSQL> pets = daoSession.queryBuilder(PetSQL.class)
                .where(PetSQLDao.Properties.Id.isNotNull())
                .orderDesc(PetSQLDao.Properties.Id)
                .limit(1).list();
        if (pets.isEmpty()) {
            return 1;
        } else {
            return pets.get(0).getId().intValue() + 1;
        }
    }

    @Override
    public List<PetSQL> getList() {
        return daoSession.queryBuilder(PetSQL.class).list();
    }

    @Override
    public List<PetSQL> getListByFkId(int id) {
        return daoSession.queryBuilder(PetSQL.class)
                .where(PetSQLDao.Properties.Fk_idUser.eq(id))
                .list();
    }
}
