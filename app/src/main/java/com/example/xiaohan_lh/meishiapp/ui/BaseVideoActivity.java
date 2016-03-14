package com.example.xiaohan_lh.meishiapp.ui;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xiaohan_lh.meishiapp.R;
import com.example.xiaohan_lh.meishiapp.adapter.CommentRecyclerAdapter;
import com.example.xiaohan_lh.meishiapp.bean.CommentEntity;
import com.example.xiaohan_lh.meishiapp.bean.VideoListEntity;
import com.example.xiaohan_lh.meishiapp.presenter.impl.CategotyPresenterImpl;
import com.example.xiaohan_lh.meishiapp.utils.AppConstants;
import com.example.xiaohan_lh.meishiapp.view.CommentView;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.VideoView;

public class BaseVideoActivity extends AppCompatActivity implements CommentView {


    @Bind(R.id.userIcon)
    SimpleDraweeView userIcon;
    @Bind(R.id.userName)
    TextView userName;
    @Bind(R.id.img_visibility)
    ImageView imgVisibility;
    @Bind(R.id.visibility_txt)
    TextView visibilityTxt;
    @Bind(R.id.videoVitamio)
    VideoView videoVitamio;
    @Bind(R.id.explain_txt)
    TextView explainTxt;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbarLayout;
    @Bind(R.id.app_bar)
    AppBarLayout appBar;
    @Bind(R.id.commentRecycler)
    RecyclerView commentRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Vitamio.isInitialized(this);
        setContentView(R.layout.activity_base_video);
        ButterKnife.bind(this);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        init();
    }

    private void init() {
        Bundle bundle = getIntent().getExtras();
        VideoListEntity data = (VideoListEntity) bundle.getSerializable("data");
        if (data.getMedia() != null) {
            Toast.makeText(this, data.getMedia().getVideo(), Toast.LENGTH_SHORT).show();
            videoVitamio.setVideoURI(Uri.parse(data.getMedia().getVideo()));
            // videoVitamio.setMediaController(new MediaController(videoVitamio.getContext()));
            videoVitamio.setVideoLayout(AppBarLayout.LayoutParams.MATCH_PARENT, 1);
            videoVitamio.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    mediaPlayer.setPlaybackSpeed(1.0f);
                }
            });
            videoVitamio.start();
            dataLoad(data.getMedia());
        }

    }

    private void dataLoad(VideoListEntity.MediaEntity media) {
        userIcon.setImageURI(Uri.parse(media.getUser().getAvatar()));
        userName.setText(media.getUser().getScreen_name());
        visibilityTxt.setText(media.getUser().getBe_liked_count() + "");
        explainTxt.setText(media.getCaption());
        Map<String, String> map = new HashMap<>();
        int id = media.getId();
        map.put(AppConstants.ParamKey.ID_KEY, id + "");
        new CategotyPresenterImpl(this, map).comment();

    }

    @Override
    public void commentSueccess(List<CommentEntity> commentEntities) {
        CommentRecyclerAdapter commentRecyclerAdapter = new CommentRecyclerAdapter(commentEntities, this);
        commentRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL,false));
        commentRecycler.setAdapter(commentRecyclerAdapter);
//        CommentListAdapter commentListAdapter = new CommentListAdapter(commentEntities, BaseVideoActivity.this);
//        commentList.setAdapter(commentListAdapter);
    }

    @Override
    public void fail(Throwable t) {
        Toast.makeText(this, "网络错误", Toast.LENGTH_SHORT).show();
    }
}
