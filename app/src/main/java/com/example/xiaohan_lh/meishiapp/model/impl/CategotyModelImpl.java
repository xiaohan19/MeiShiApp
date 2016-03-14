package com.example.xiaohan_lh.meishiapp.model.impl;

import com.example.xiaohan_lh.meishiapp.api.RetrofitApi;
import com.example.xiaohan_lh.meishiapp.bean.CategotyEntity;
import com.example.xiaohan_lh.meishiapp.bean.CommentEntity;
import com.example.xiaohan_lh.meishiapp.bean.VideoListEntity;
import com.example.xiaohan_lh.meishiapp.model.CategotyModel;
import com.example.xiaohan_lh.meishiapp.utils.AppConstants;

import java.util.List;
import java.util.Map;

import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by xiaohan-lh on 16/3/10.
 */
public class CategotyModelImpl implements CategotyModel {
    private final RetrofitApi retrofitApi;

    public CategotyModelImpl() {
        retrofitApi = new Retrofit.Builder()
                .baseUrl(AppConstants.RequestPath.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RetrofitApi.class);
    }

    @Override
    public void categoty(Callback<List<CategotyEntity>> callback) {
        retrofitApi.getCategotyEngtity().enqueue(callback);
    }

    @Override
    public void videoList(Callback<List<VideoListEntity>> callback, Map<String,String> map) {
        retrofitApi.getVideoListEntity(map).enqueue(callback);
    }

    @Override
    public void comment(Callback<List<CommentEntity>> callback, Map<String, String> map) {
        retrofitApi.getCommentEntity(map).enqueue(callback);
    }
}
