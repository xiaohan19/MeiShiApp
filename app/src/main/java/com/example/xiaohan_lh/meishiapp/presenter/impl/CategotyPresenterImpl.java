package com.example.xiaohan_lh.meishiapp.presenter.impl;

import com.example.xiaohan_lh.meishiapp.bean.CategotyEntity;
import com.example.xiaohan_lh.meishiapp.bean.CommentEntity;
import com.example.xiaohan_lh.meishiapp.bean.VideoListEntity;
import com.example.xiaohan_lh.meishiapp.model.impl.CategotyModelImpl;
import com.example.xiaohan_lh.meishiapp.presenter.CategotyPresenter;
import com.example.xiaohan_lh.meishiapp.view.BaseMyView;
import com.example.xiaohan_lh.meishiapp.view.CategotyView;
import com.example.xiaohan_lh.meishiapp.view.CommentView;
import com.example.xiaohan_lh.meishiapp.view.VideoListView;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by xiaohan-lh on 16/3/10.
 */
public class CategotyPresenterImpl implements CategotyPresenter {
    private Map<String,String> map;
    private CategotyModelImpl categotyModel;
    private BaseMyView view;

    public CategotyPresenterImpl(BaseMyView view, Map<String ,String> map) {
        categotyModel = new CategotyModelImpl();
        this.view = view;
        this.map = map;
    }

    @Override
    public void categoty() {
        categotyModel.categoty(new Callback<List<CategotyEntity>>() {
            @Override
            public void onResponse(Call<List<CategotyEntity>> call, Response<List<CategotyEntity>> response) {
                List<CategotyEntity> categotyEntities = response.body();
                ((CategotyView) view).categotySueccess(categotyEntities);
            }

            @Override
            public void onFailure(Call<List<CategotyEntity>> call, Throwable t) {
                view.fail(t);
            }
        });
    }

    @Override
    public void videoList() {
        Callback<List<VideoListEntity>> callback = new Callback<List<VideoListEntity>>() {
            @Override
            public void onResponse(Call<List<VideoListEntity>> call, Response<List<VideoListEntity>> response) {
                List<VideoListEntity> videoListEntities = response.body();
                ((VideoListView) view).videoListSueccess(videoListEntities);
            }

            @Override
            public void onFailure(Call<List<VideoListEntity>> call, Throwable t) {
                view.fail(t);
            }
        };
        categotyModel.videoList(callback,map);
    }

    @Override
    public void comment() {
        Callback<List<CommentEntity>> callback = new Callback<List<CommentEntity>>() {
            @Override
            public void onResponse(Call<List<CommentEntity>> call, Response<List<CommentEntity>> response) {
                List<CommentEntity> commentEntities = response.body();
                ((CommentView) view).commentSueccess(commentEntities);
            }

            @Override
            public void onFailure(Call<List<CommentEntity>> call, Throwable t) {
                t.printStackTrace();
                view.fail(t);
            }
        };
        categotyModel.comment(callback,map);
    }
}
