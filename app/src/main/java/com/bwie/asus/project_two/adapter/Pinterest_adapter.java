package com.bwie.asus.project_two.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.asus.project_two.R;
import com.bwie.asus.project_two.bean.Bean01;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 2017/10/12.
 */

public class Pinterest_adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Bean01.DataBean.DefaultGoodsListBean> list;
    private List<Integer> list1;

    public Pinterest_adapter(Context context, List<Bean01.DataBean.DefaultGoodsListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View view = View.inflate(context,R.layout.pinterest_item,null);
        final PinterentViewHolder viewHolder = new PinterentViewHolder(view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(viewHolder.getPosition());
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        PinterentViewHolder viewHolder = new PinterentViewHolder(holder.itemView);
        ViewGroup.LayoutParams params = viewHolder.iv_pinterent.getLayoutParams();
        getRandom(list);
        params.height = list1.get(position);
        viewHolder.iv_pinterent.setLayoutParams(params);
        Picasso.with(context).load(list.get(position).getGoods_img()).into(viewHolder.iv_pinterent);
        viewHolder.tv_pinterent.setText(list.get(position).getGoods_name());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class PinterentViewHolder extends RecyclerView.ViewHolder{

        private final ImageView iv_pinterent;
        private final TextView tv_pinterent;

        public PinterentViewHolder(View itemView) {
            super(itemView);

            iv_pinterent = itemView.findViewById(R.id.iv_pinterent);
            tv_pinterent = itemView.findViewById(R.id.tv_pinterent);

        }
    }

    private void getRandom(List<Bean01.DataBean.DefaultGoodsListBean> lists){
        list1 = new ArrayList<>();
        for (int i = 0; i < lists.size(); i++) {
            list1.add((int) (200 + Math.random() * 200));
        }
    }

    public OnItemClickListener onItemClickListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

}
