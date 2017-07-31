package pya.marlon.com.examplegreendao.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pya.marlon.com.examplegreedao.R;
import pya.marlon.com.examplegreendao.ToyActivity;
import pya.marlon.com.examplegreendao.bean.model.PetBean;
import pya.marlon.com.examplegreendao.util.Constant;

/**
 * Created by marlonpya on 30/07/17.
 */

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.ViewHolder> {
    private List<PetBean> pets;
    private LayoutInflater inflater;

    public PetAdapter(Context context, List<PetBean> pets) {
        this.inflater = LayoutInflater.from(context);
        this.pets = pets;
    }

    @Override
    public PetAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.row_all, parent, false));
    }

    @Override
    public void onBindViewHolder(PetAdapter.ViewHolder holder, int position) {
        final PetBean pet = pets.get(position);
        holder.lblId.setText(pet.getId() + " " + pet.getFk_idUser());
        holder.lblTitle.setText(pet.getName());
        holder.lblDescription.setText(pet.getAlias());
        holder.lblExtra.setText(pet.getWeight() + "");
    }

    @Override
    public int getItemCount() {
        return pets.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.lblId) TextView lblId;
        @BindView(R.id.lblTitle) TextView lblTitle;
        @BindView(R.id.lblDescription) TextView lblDescription;
        @BindView(R.id.lblExtra) TextView lblExtra;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.btnClick)
        public void onClick() {
            PetBean pet = pets.get(getAdapterPosition());
            Intent intent = new Intent(itemView.getContext(), ToyActivity.class);
            intent.putExtra(Constant.ID_PET, pet.getId());
            itemView.getContext().startActivity(intent);
        }
    }
}
