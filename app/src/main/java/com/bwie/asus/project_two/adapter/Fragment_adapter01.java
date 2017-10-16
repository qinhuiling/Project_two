package com.bwie.asus.project_two.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.bwie.asus.project_two.R;
import com.bwie.asus.project_two.bean.Bean01;
import com.bwie.asus.project_two.banner.BannerImageLoader;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 2017/10/11.
 */

public class Fragment_adapter01 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private Bean01.DataBean data;

    public Fragment_adapter01(Context context, Bean01.DataBean data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType){
            case 0:
                View view1 = View.inflate(context, R.layout.fragment01_item01, null);
                ViewHolder1 viewHolder1 = new ViewHolder1(view1);
                return viewHolder1;
            case 1:
                View view2 = View.inflate(context, R.layout.fragment01_item02, null);
                ViewHolder2 viewHolder2 = new ViewHolder2(view2);
                return viewHolder2;
            case 2:
                View view3 = View.inflate(context, R.layout.fragment01_item03, null);
                ViewHolder3 viewHolder3 = new ViewHolder3(view3);
                return viewHolder3;
            case 3:
                View view4 = View.inflate(context, R.layout.fragment01_item04, null);
                ViewHolder4 viewHolder4 = new ViewHolder4(view4);
                return viewHolder4;
            case 4:
                View view5 = View.inflate(context, R.layout.fragment01_item05, null);
                ViewHolder5 viewHolder5 = new ViewHolder5(view5);
                return viewHolder5;
            case 5:
                View view6 = View.inflate(context, R.layout.fragment01_item06, null);
                ViewHolder6 viewHolder6 = new ViewHolder6(view6);
                return viewHolder6;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        switch (type){
            case 0:
                List<String> bannerList = new ArrayList<>();
                for (int i = 0; i < data.getAd1().size(); i++) {
                    bannerList.add(data.getAd1().get(i).getImage());
                }
                ((ViewHolder1)holder).banner.setImageLoader(new BannerImageLoader());
                ((ViewHolder1)holder).banner.setImages(bannerList);
                ((ViewHolder1)holder).banner.setDelayTime(3000);
                ((ViewHolder1)holder).banner.isAutoPlay(true);
                ((ViewHolder1)holder).banner.start();
                break;
            case 1:
                ViewHolder2 viewHolder2 = new ViewHolder2(holder.itemView);
                GridView_adapter adapter = new GridView_adapter(context,data.getAd5());
                viewHolder2.gridview.setAdapter(adapter);
                break;
            case 2:
                ViewHolder3 viewHolder3 = new ViewHolder3(holder.itemView);
                Picasso.with(context).load(data.getSubjects().get(1).getImage()).into(viewHolder3.iv);
                break;
            case 3:
                ViewHolder4 viewHolder4 = new ViewHolder4(holder.itemView);
                Picasso.with(context).load(data.getSubjects().get(position).getImage()).into(viewHolder4.iv_remen);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
                viewHolder4.scroll_recycler.setLayoutManager(linearLayoutManager);
                List<Bean01.DataBean.SubjectsBean.GoodsListBeanX> goodsList = data.getSubjects().get(position).getGoodsList();
                Scroll_adapter scroll_adapter = new Scroll_adapter(context, goodsList);
                viewHolder4.scroll_recycler.setAdapter(scroll_adapter);
                break;
            case 4:
                break;
            case 5:
                ViewHolder6 viewHolder6 = new ViewHolder6(holder.itemView);
                viewHolder6.cai_recyclerview.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
                Pinterest_adapter pinterest_adapter = new Pinterest_adapter(context,data.getDefaultGoodsList());
                viewHolder6.cai_recyclerview.setAdapter(pinterest_adapter);
                pinterest_adapter.setOnItemClickListener(new Pinterest_adapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        Toast.makeText(context,"点击了"+position,Toast.LENGTH_SHORT).show();
                    }
                });
                break;
        }

    }

    @Override
    public int getItemCount() {
        return 6;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0){
            return 0;
        }else if (position == 1){
            return 1;
        }else if (position == 2){
            return 2;
        }else if (position == 3){
            return 3;
        }else if (position == 4){
            return 4;
        }else{
            return 5;
        }
    }

    class ViewHolder1 extends RecyclerView.ViewHolder{

        private final Banner banner;

        public ViewHolder1(View itemView) {
            super(itemView);

            banner = itemView.findViewById(R.id.banner);
        }
    }

    class ViewHolder2 extends RecyclerView.ViewHolder{

        private final GridView gridview;

        public ViewHolder2(View itemView) {
            super(itemView);

            gridview = itemView.findViewById(R.id.gridview);

        }
    }

    class ViewHolder3 extends RecyclerView.ViewHolder{

        private final ImageView iv;

        public ViewHolder3(View itemView) {
            super(itemView);

            iv = itemView.findViewById(R.id.iv);

        }
    }

    class ViewHolder4 extends RecyclerView.ViewHolder{

        private final ImageView iv_remen;
        private final RecyclerView scroll_recycler;

        public ViewHolder4(View itemView) {
            super(itemView);

            iv_remen = itemView.findViewById(R.id.iv_remen);
            scroll_recycler = itemView.findViewById(R.id.scroll_recycler);

        }
    }

    class ViewHolder5 extends RecyclerView.ViewHolder{

        public ViewHolder5(View itemView) {
            super(itemView);
        }
    }

    class ViewHolder6 extends RecyclerView.ViewHolder{

        private final RecyclerView cai_recyclerview;

        public ViewHolder6(View itemView) {
            super(itemView);

            cai_recyclerview = itemView.findViewById(R.id.cai_recyclerview);

        }
    }

}
