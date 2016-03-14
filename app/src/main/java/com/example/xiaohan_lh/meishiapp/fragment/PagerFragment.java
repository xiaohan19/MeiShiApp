package com.example.xiaohan_lh.meishiapp.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ShareCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xiaohan_lh.meishiapp.R;
import com.example.xiaohan_lh.meishiapp.adapter.CategotyRecyclerAdapter;
import com.example.xiaohan_lh.meishiapp.bean.VideoListEntity;
import com.example.xiaohan_lh.meishiapp.presenter.impl.CategotyPresenterImpl;
import com.example.xiaohan_lh.meishiapp.ui.BaseVideoActivity;
import com.example.xiaohan_lh.meishiapp.view.VideoListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class PagerFragment extends Fragment implements VideoListView {


    private RecyclerView recyclerView;
    private CategotyRecyclerAdapter categotyRecyclerAdapter;
    private List<VideoListEntity> list;

    public static PagerFragment newInstance(String id) {
        Bundle args = new Bundle();
        args.putString("id", id);
        PagerFragment fragment = new PagerFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pager, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_categoty);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        list = new ArrayList<>();
        categotyRecyclerAdapter = new CategotyRecyclerAdapter(list,getContext());
        categotyRecyclerAdapter.setOnitemChilckListener(new CategotyRecyclerAdapter.OnitemChilckListener(){
            @Override
            public void OnitemChilck(View view, List<VideoListEntity> datas,int position) {
                Intent intent = new Intent(getContext(), BaseVideoActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("data", list.get(position));
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(categotyRecyclerAdapter);
        String id = getArguments().getString("id");
        Map<String, String> map = new HashMap<>();
        map.put("id", id);
        CategotyPresenterImpl categotyPresenter = new CategotyPresenterImpl(this, map);
        categotyPresenter.videoList();
        return view;
    }

    @Override
    public void videoListSueccess(List<VideoListEntity> videoListEntities) {
        list.addAll(videoListEntities);
        categotyRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void fail(Throwable t) {
        t.printStackTrace();
        Toast.makeText(getContext(),"网络错误",Toast.LENGTH_SHORT).show();
    }
}
