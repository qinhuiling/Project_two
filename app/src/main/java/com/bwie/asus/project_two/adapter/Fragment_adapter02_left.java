package com.bwie.asus.project_two.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.asus.project_two.R;
import com.bwie.asus.project_two.bean.Bean02;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by ASUS on 2017/10/13.
 */

public class Fragment_adapter02_left extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Bean02.DatasBean.ClassListBean> list;

    public Fragment_adapter02_left(Context context, List<Bean02.DatasBean.ClassListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context,R.layout.recycler_left_item,null);
        LeftViewHolder leftViewHolder = new LeftViewHolder(view);
        return leftViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ((LeftViewHolder)holder).recycler_left_tv.setText(list.get(position).getGc_name());

        Picasso.with(context).load(list.get(position).getImage()).into(((LeftViewHolder) holder).recycler_left_iv);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class LeftViewHolder extends RecyclerView.ViewHolder{

        private final ImageView recycler_left_iv;
        private final TextView recycler_left_tv;

        public LeftViewHolder(View itemView) {
            super(itemView);

            recycler_left_iv = itemView.findViewById(R.id.recycler_left_iv);
            recycler_left_tv = itemView.findViewById(R.id.recycler_left_tv);
        }
    }

}
