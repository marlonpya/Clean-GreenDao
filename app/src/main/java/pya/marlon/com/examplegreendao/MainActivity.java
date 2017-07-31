package pya.marlon.com.examplegreendao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pya.marlon.com.examplegreedao.R;
import pya.marlon.com.examplegreendao.adapter.UserAdapter;
import pya.marlon.com.examplegreendao.bean.model.PetBean;
import pya.marlon.com.examplegreendao.bean.model.ToyBean;
import pya.marlon.com.examplegreendao.bean.model.UserBean;
import pya.marlon.com.examplegreendao.mapper.PetMapper;
import pya.marlon.com.examplegreendao.mapper.ToyMapper;
import pya.marlon.com.examplegreendao.mapper.UserMapper;
import pya.marlon.com.examplegreendao.sql.manager.PetSQLManager;
import pya.marlon.com.examplegreendao.sql.manager.ToySQLManager;
import pya.marlon.com.examplegreendao.sql.manager.UserSQLManager;
import pya.marlon.com.examplegreendao.sql.model.PetSQL;
import pya.marlon.com.examplegreendao.sql.model.ToySQL;
import pya.marlon.com.examplegreendao.sql.model.UserSQL;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.rvUser) RecyclerView recyclerView;
    private static final String TAG = "MainActivity";
    private UserSQLManager userSQLManager;
    private PetSQLManager petSQLManager;
    private ToySQLManager toySQLManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        userSQLManager = new UserSQLManager();
        petSQLManager = new PetSQLManager();
        toySQLManager = new ToySQLManager();


        workSQL();
        UserAdapter adapter = new UserAdapter(this, usersBean());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(false);
        recyclerView.setAdapter(adapter);

        show();
    }

    private List<UserBean> usersBean() {
        List<UserBean> users = new ArrayList<>();
        for (UserSQL userSQL : userSQLManager.getList()) {
            users.add(UserMapper.getInstance().map(userSQL));
        }
        return users;
    }

    private void workSQL() {
        UserBean boy = new UserBean(0, "pepe", "asd", 22);
        UserBean girl = new UserBean(0, "abigail", "day", 20);
        //boy
        PetBean dog = new PetBean(0, 0, "perro", "frank", 30.0);
        //girl
        PetBean cat = new PetBean(0, 0, "gato", "negro", 10.0);
        PetBean cactus = new PetBean(0, 0, "cactus", "2d", 2.0);

        //dog
        ToyBean peluche = new ToyBean(0, 0, "peluche", false);
        ToyBean carton = new ToyBean(0, 0, "cartón", false);
        ToyBean peluca = new ToyBean(0, 0, "peluca", true);
        //cat
        ToyBean bola = new ToyBean(0, 0, "bola", true);
        ToyBean carne = new ToyBean(0, 0, "carne", false);
        //cactus
        ToyBean abrigo = new ToyBean(0, 0, "abrigo", true);

        boy.setPets(Arrays.asList(dog));
        girl.setPets(Arrays.asList(cat, cactus));

        dog.setToys(Arrays.asList(peluche, carton, peluca));
        cat.setToys(Arrays.asList(bola, carne));
        cactus.setToys(Arrays.asList(abrigo));

        //users
        List<UserBean> users = Arrays.asList(boy, girl);
        for (UserBean user : users) {
            UserSQL userSql = UserMapper.getInstance().reverseMap(user);
            userSql.setId((long)userSQLManager.getLastId());
            userSQLManager.insert(userSql);

            for (PetBean pet : user.getPets()) {
                PetSQL petSql = PetMapper.getInstance().reverseMap(pet);
                petSql.setId((long)petSQLManager.getLastId());
                petSql.setFk_idUser(userSql.getId().intValue());
                petSQLManager.insert(petSql);

                for (ToyBean toy : pet.getToys()) {
                    ToySQL toySql = ToyMapper.getInstance().reverseMap(toy);
                    toySql.setId((long)toySQLManager.getLastId());
                    toySql.setFk_idPet(petSql.getId().intValue());
                    toySQLManager.insert(toySql);
                }
            }
        }

    }

    private void show() {
        List<UserSQL> users = userSQLManager.getList();
        for (UserSQL user : users) {
            Log.d(TAG, "show: " + user.toString());
        }

        List<PetSQL> pets = petSQLManager.getList();
        for (PetSQL pet : pets) {
            Log.d(TAG, "show: " + pet.toString());
        }

        List<ToySQL> toys = toySQLManager.getList();
        for (ToySQL toy : toys) {
            Log.d(TAG, "show: " + toy.toString());
        }
    }
}
