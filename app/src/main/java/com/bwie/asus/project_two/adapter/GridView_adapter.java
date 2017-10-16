package com.bwie.asus.project_two.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.asus.project_two.R;
import com.bwie.asus.project_two.bean.Bean01;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by ASUS on 2017/10/11.
 */

public class GridView_adapter extends BaseAdapter {
    //定义上下文
    private Context context;
    private List<Bean01.DataBean.Ad5Bean> list;

    //有参构造
    public GridView_adapter(Context context, List<Bean01.DataBean.Ad5Bean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = View.inflate(context,R.layout.gridview_item,null);
        ImageView iv_gridview = view.findViewById(R.id.iv_gridview);
        TextView tv_gridview = view.findViewById(R.id.tv_gridview);
        tv_gridview.setText(list.get(i).getTitle());
        DisplayImageOptions options = new DisplayImageOptions.Builder().build();
        ImageLoader.getInstance().displayImage(list.get(i).getImage(),iv_gridview);
        return view;
    }

//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = View.inflate(context, R.layout.gridview_item, null);
//        ViewHolder viewHolder = new ViewHolder(view);
//        return viewHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        ViewHolder viewHolder = new ViewHolder(holder.itemView);
//        Glide.with(context).load(list.get(position).getImage()).into(viewHolder.iv_gridview);
//    }
//
//    @Override
//    public int getItemCount() {
//        return list.size();
//    }
//
//    class ViewHolder extends RecyclerView.ViewHolder{
//
//        private final ImageView iv_gridview;
//
//        public ViewHolder(View itemView) {
//            super(itemView);
//            iv_gridview = itemView.findViewById(R.id.iv_gridview);
//        }
//    }

}
