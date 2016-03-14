package com.example.xiaohan_lh.meishiapp.adapter;


import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xiaohan_lh.meishiapp.R;
import com.example.xiaohan_lh.meishiapp.bean.VideoListEntity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xiaohan-lh on 16/3/11.
 */
public class CategotyRecyclerAdapter extends RecyclerView.Adapter<CategotyRecyclerAdapter.CategotyViewHolder> {
    private List<VideoListEntity> list;
    private Context context;
    private View view;
    private OnitemChilckListener onitemChilckListener;

    public CategotyRecyclerAdapter(List<VideoListEntity> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public CategotyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.video_list_item, null);
        return new CategotyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CategotyViewHolder holder, final int position) {
        VideoListEntity videoListEntity = list.get(position);
        String path = videoListEntity.getRecommend_cover_pic();
        Uri uri = Uri.parse(path);
        holder.videoImg.setImageURI(uri);
        holder.nameTxt.setText(videoListEntity.getRecommend_caption());
        if (videoListEntity.getMedia()!=null) {
            holder.iconImg.setImageURI(Uri.parse(videoListEntity.getMedia().getUser().getAvatar()));
            holder.numTxt.setText(videoListEntity.getMedia().getLikes_count()+"");
        }
        if(onitemChilckListener!=null){
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onitemChilckListener.OnitemChilck(v,list,position);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setOnitemChilckListener(OnitemChilckListener onitemChilckListener){
        this.onitemChilckListener = onitemChilckListener;
    }
    public interface OnitemChilckListener{
        public void OnitemChilck(View view,List<VideoListEntity> datas,int position);
    }

    public class CategotyViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.video_img)
        SimpleDraweeView videoImg;
        @Bind(R.id.icon_img)
        SimpleDraweeView iconImg;
        @Bind(R.id.name_txt)
        TextView nameTxt;
        @Bind(R.id.num_txt)
        TextView numTxt;

        public CategotyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
