package com.example.xiaohan_lh.meishiapp.view;

import com.example.xiaohan_lh.meishiapp.bean.VideoListEntity;

import java.util.List;

/**
 * Created by xiaohan-lh on 16/3/11.
 */
public interface VideoListView extends BaseMyView{
    public void videoListSueccess(List<VideoListEntity> videoListEntities);
}
