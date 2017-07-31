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
import pya.marlon.com.examplegreendao.PetActivity;
import pya.marlon.com.examplegreendao.bean.model.UserBean;
import pya.marlon.com.examplegreendao.util.Constant;

/**
 * Created by marlonpya on 30/07/17.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private List<UserBean> users;
    private LayoutInflater inflater;

    public UserAdapter(Context context, List<UserBean> users){
        this.inflater = LayoutInflater.from(context);
        this.users = users;
    }

    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.row_all, parent, false));
    }

    @Override
    public void onBindViewHolder(UserAdapter.ViewHolder holder, int position) {
        final UserBean user = users.get(position);
        holder.lblId.setText(user.getId() + "");
        holder.lblTitle.setText(user.getName());
        holder.lblDescription.setText(user.getLastName());
        holder.lblExtra.setText(user.getAge() + "");
    }

    @Override
    public int getItemCount() {
        return users.size();
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
            UserBean user = users.get(getAdapterPosition());
            Intent intent = new Intent(itemView.getContext(), PetActivity.class);
            intent.putExtra(Constant.ID_USER, user.getId());
            itemView.getContext().startActivity(intent);
        }
    }
}
