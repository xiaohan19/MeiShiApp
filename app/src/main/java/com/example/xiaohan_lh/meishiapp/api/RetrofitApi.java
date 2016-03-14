package com.example.xiaohan_lh.meishiapp.api;

import com.example.xiaohan_lh.meishiapp.bean.CategotyEntity;
import com.example.xiaohan_lh.meishiapp.bean.CommentEntity;
import com.example.xiaohan_lh.meishiapp.bean.VideoListEntity;
import com.example.xiaohan_lh.meishiapp.utils.AppConstants;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.QueryMap;

/**
 * Created by xiaohan-lh on 16/3/10.
 */
public interface RetrofitApi {
    @GET(AppConstants.RequestPath.CATEGOTY)
    Call<List<CategotyEntity>> getCategotyEngtity();
    @POST(AppConstants.RequestPath.VIDEO_LIST)
    Call<List<VideoListEntity>> getVideoListEntity(@QueryMap Map<String,String> map);
    @POST(AppConstants.RequestPath.COMMENTS)
    Call<List<CommentEntity>> getCommentEntity(@QueryMap Map<String,String> map);
}
