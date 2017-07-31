package pya.marlon.com.examplegreendao.mapper;

import pya.marlon.com.examplegreendao.bean.model.ToyBean;
import pya.marlon.com.examplegreendao.sql.model.ToySQL;

/**
 * Created by marlonpya on 29/07/17.
 */

public class ToyMapper implements Mapper<ToyBean, ToySQL> {
    private static final ToyMapper instance = new ToyMapper();

    private ToyMapper() { }

    public static ToyMapper getInstance() {
        return instance;
    }

    @Override
    public ToyBean map(ToySQL sql) {
        return new ToyBean(sql.getId().intValue(), sql.getFk_idPet(), sql.getName(), sql.getIsNew());
    }

    @Override
    public ToySQL reverseMap(ToyBean bean) {
        return new ToySQL((long) bean.getId(), bean.getFk_idPet(), bean.getName(), bean.isNew());
    }
}
