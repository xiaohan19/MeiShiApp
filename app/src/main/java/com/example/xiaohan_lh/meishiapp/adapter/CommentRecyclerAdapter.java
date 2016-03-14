package com.example.xiaohan_lh.meishiapp.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xiaohan_lh.meishiapp.R;
import com.example.xiaohan_lh.meishiapp.bean.CommentEntity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xiaohan-lh on 16/3/13.
 */
public class CommentRecyclerAdapter extends RecyclerView.Adapter<CommentRecyclerAdapter.ViewHolder> {
    private List<CommentEntity> commentEntities;
    private Context context;

    public CommentRecyclerAdapter(List<CommentEntity> commentEntities, Context context) {
        this.commentEntities = commentEntities;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.comment_list_item, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CommentEntity commentEntity = commentEntities.get(position);
        holder.userIconComment.setImageURI(Uri.parse(commentEntity.getUser().getAvatar()));
        holder.userNameComment.setText(commentEntity.getUser().getScreen_name());
        holder.commentTxt.setText(commentEntity.getContent());
    }

    @Override
    public int getItemCount() {
        return commentEntities.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {


        @Bind(R.id.userIcon_comment)
        SimpleDraweeView userIconComment;
        @Bind(R.id.userName_comment)
        TextView userNameComment;
        @Bind(R.id.comment_txt)
        TextView commentTxt;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
