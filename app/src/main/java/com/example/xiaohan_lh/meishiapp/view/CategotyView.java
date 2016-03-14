package com.example.xiaohan_lh.meishiapp.view;

import com.example.xiaohan_lh.meishiapp.bean.CategotyEntity;
import com.example.xiaohan_lh.meishiapp.bean.VideoListEntity;

import java.util.List;

/**
 * Created by xiaohan-lh on 16/3/10.
 */
public interface CategotyView extends BaseMyView {
    public void categotySueccess(List<CategotyEntity> categotyEntities);
}
