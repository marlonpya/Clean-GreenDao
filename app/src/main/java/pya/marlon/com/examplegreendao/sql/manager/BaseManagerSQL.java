package pya.marlon.com.examplegreendao.sql.manager;

import java.util.List;

import pya.marlon.com.examplegreendao.app.MyApplication;
import pya.marlon.com.examplegreendao.sql.model.DaoSession;

/**
 * Created by marlonpya on 29/07/17.
 */

public abstract class BaseManagerSQL<T> {
    protected DaoSession daoSession;

    public BaseManagerSQL() {
        this.daoSession = MyApplication.getInstance().getDaoSession();
    }

    abstract public void insert(T sql);

    abstract public int getLastId();

    abstract public List<T> getList();

    abstract public List<T> getListByFkId(int id);
}
