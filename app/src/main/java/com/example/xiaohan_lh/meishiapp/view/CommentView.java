package com.example.xiaohan_lh.meishiapp.view;

import com.example.xiaohan_lh.meishiapp.bean.CommentEntity;

import java.util.List;

/**
 * Created by xiaohan-lh on 16/3/13.
 */
public interface CommentView extends BaseMyView {
    public void commentSueccess(List<CommentEntity> commentEntities);
}
