package pya.marlon.com.examplegreendao.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pya.marlon.com.examplegreedao.R;
import pya.marlon.com.examplegreendao.bean.model.ToyBean;

/**
 * Created by marlonpya on 30/07/17.
 */

public class ToyAdapter extends RecyclerView.Adapter<ToyAdapter.ViewHolder> {
    private static final String TAG = "ToyAdapter";
    private List<ToyBean> toys;
    private LayoutInflater inflater;

    public ToyAdapter(Context context, List<ToyBean> toys) {
        this.inflater = LayoutInflater.from(context);
        this.toys = toys;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.row_all, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final ToyBean toy = toys.get(position);
        holder.lblId.setText(toy.getId() + " " + toy.getFk_idPet());
        holder.lblTitle.setText(toy.getName());
        holder.lblDescription.setText(toy.isNew() + "");
    }

    @Override
    public int getItemCount() {
        return toys.size();
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
            ToyBean toy = toys.get(getAdapterPosition());
            Log.d(TAG, "onClick: " + toy.toString());
        }
    }
}
