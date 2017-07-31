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
import pya.marlon.com.examplegreendao.adapter.ToyAdapter;
import pya.marlon.com.examplegreendao.bean.model.ToyBean;
import pya.marlon.com.examplegreendao.mapper.ToyMapper;
import pya.marlon.com.examplegreendao.sql.manager.ToySQLManager;
import pya.marlon.com.examplegreendao.sql.model.ToySQL;
import pya.marlon.com.examplegreendao.util.Constant;

public class ToyActivity extends AppCompatActivity {
    @BindView(R.id.rvToy) RecyclerView recyclerView;
    private int idPet;
    private ToySQLManager toySQLManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toy);
        ButterKnife.bind(this);

        idPet = getIntent().getIntExtra(Constant.ID_PET, -1);
        toySQLManager = new ToySQLManager();
        ToyAdapter adapter = new ToyAdapter(this, toysBean());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(false);
        recyclerView.setAdapter(adapter);
    }

    private List<ToyBean> toysBean() {
        List<ToyBean> toys = new ArrayList<>();
        for (ToySQL toySQL : toySQLManager.getListByFkId(this.idPet)) {
            toys.add(ToyMapper.getInstance().map(toySQL));
        }
        return toys;
    }
}
