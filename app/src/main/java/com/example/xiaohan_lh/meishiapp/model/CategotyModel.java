package com.example.xiaohan_lh.meishiapp.model;

import com.example.xiaohan_lh.meishiapp.bean.CategotyEntity;
import com.example.xiaohan_lh.meishiapp.bean.CommentEntity;
import com.example.xiaohan_lh.meishiapp.bean.VideoListEntity;

import java.util.List;
import java.util.Map;

import retrofit2.Callback;

/**
 * Created by xiaohan-lh on 16/3/10.
 */
public interface CategotyModel {
    public void categoty(Callback<List<CategotyEntity>> callback) ;
    public void videoList(Callback<List<VideoListEntity>> callback, Map<String,String> map);
    public void comment(Callback<List<CommentEntity>> callback,Map<String,String> map);
}
