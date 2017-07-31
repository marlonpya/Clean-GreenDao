package pya.marlon.com.examplegreendao.mapper;

import pya.marlon.com.examplegreendao.bean.model.PetBean;
import pya.marlon.com.examplegreendao.sql.model.PetSQL;

/**
 * Created by marlonpya on 29/07/17.
 */

public class PetMapper implements Mapper<PetBean, PetSQL> {
    private static final PetMapper instance = new PetMapper();

    private PetMapper() {}

    public static PetMapper getInstance() {
        return instance;
    }

    @Override
    public PetBean map(PetSQL sql) {
        //public PetBean(int id, int fk_idUser, String name, String alias, double weight) {
        return new PetBean(sql.getId().intValue(), sql.getFk_idUser(), sql.getName(), sql.getAlias(), sql.getWeight());
    }

    @Override
    public PetSQL reverseMap(PetBean bean) {
        return new PetSQL((long) bean.getId(),bean.getFk_idUser(), bean.getName(), bean.getAlias(), bean.getWeight());
    }
}
