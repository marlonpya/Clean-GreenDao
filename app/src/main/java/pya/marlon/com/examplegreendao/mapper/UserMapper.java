package pya.marlon.com.examplegreendao.mapper;

import pya.marlon.com.examplegreendao.bean.model.UserBean;
import pya.marlon.com.examplegreendao.sql.model.UserSQL;

/**
 * Created by marlonpya on 29/07/17.
 */

public class UserMapper implements Mapper<UserBean, UserSQL> {
    private static final UserMapper instance = new UserMapper();

    private UserMapper(){ }

    public static UserMapper getInstance() {
        return instance;
    }

    @Override
    public UserBean map(UserSQL sql) {
        return new UserBean(sql.getId().intValue(), sql.getName(), sql.getLastName(), sql.getAge());
    }

    @Override
    public UserSQL reverseMap(UserBean bean) {
        return new UserSQL((long) bean.getId(), bean.getName(), bean.getLastName(), bean.getAge());
    }
}
