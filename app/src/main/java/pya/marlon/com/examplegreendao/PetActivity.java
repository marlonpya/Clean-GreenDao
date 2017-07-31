package pya.marlon.com.examplegreendao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pya.marlon.com.examplegreedao.R;
import pya.marlon.com.examplegreendao.adapter.PetAdapter;
import pya.marlon.com.examplegreendao.bean.model.PetBean;
import pya.marlon.com.examplegreendao.mapper.PetMapper;
import pya.marlon.com.examplegreendao.sql.manager.PetSQLManager;
import pya.marlon.com.examplegreendao.sql.model.PetSQL;
import pya.marlon.com.examplegreendao.util.Constant;

public class PetActivity extends AppCompatActivity {
    @BindView(R.id.rvPet) RecyclerView recyclerView;
    PetSQLManager petSQLManager;
    private int idUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet);
        ButterKnife.bind(this);

        idUser = getIntent().getIntExtra(Constant.ID_USER, -1);

        petSQLManager = new PetSQLManager();
        PetAdapter adapter = new PetAdapter(this, petsBean());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(false);
        recyclerView.setAdapter(adapter);
    }

    private List<PetBean> petsBean() {
        List<PetBean> pets = new ArrayList<>();
        for (PetSQL petSQL : petSQLManager.getListByFkId(this.idUser)) {
            pets.add(PetMapper.getInstance().map(petSQL));
        }
        return pets;
    }
}
