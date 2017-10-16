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

import java.util.List;

/**
 * Created by ASUS on 2017/10/12.
 */

public class Scroll_adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Bean01.DataBean.SubjectsBean.GoodsListBeanX> list;

    public Scroll_adapter(Context context, List<Bean01.DataBean.SubjectsBean.GoodsListBeanX> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context,R.layout.scroll_item,null);
        SrcollViewHolder srcollViewHolder = new SrcollViewHolder(view);
        return srcollViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        SrcollViewHolder srcollViewHolder = new SrcollViewHolder(holder.itemView);
        Picasso.with(context).load(list.get(position).getGoods_img()).into(srcollViewHolder.iv_srcoll);
        srcollViewHolder.tv1_srcoll.setText(list.get(position).getGoodsName());
        srcollViewHolder.tv2_srcoll.setText("￥"+list.get(position).getShop_price()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class SrcollViewHolder extends RecyclerView.ViewHolder{

        private final ImageView iv_srcoll;
        private final TextView tv1_srcoll;
        private final TextView tv2_srcoll;

        public SrcollViewHolder(View itemView) {
            super(itemView);

            iv_srcoll = itemView.findViewById(R.id.iv_srcoll);
            tv1_srcoll = itemView.findViewById(R.id.tv1_srcoll);
            tv2_srcoll = itemView.findViewById(R.id.tv2_srcoll);

        }
    }

}
