package com.example.xiaohan_lh.meishiapp.bean;

/**
 * Created by xiaohan-lh on 16/3/13.
 */
public class CommentEntity {

    /**
     * id : 294744653
     * content : 哈哈哈
     * media_id : 488777796
     * created_at : 1457875088
     * liked : false
     * liked_count : 0
     * user : {"id":53556529,"screen_name":"-麦兜先生cc","country":2630000,"province":2630600,"city":2630609,"avatar":"http://mvavatar2.meitudata.com/560a9220af5b81058.jpg","gender":"m","birthday":"1997-08-22","age":18,"constellation":"Leo","verified":false,"followers_count":13,"friends_count":35,"reposts_count":24,"videos_count":1,"real_videos_count":1,"photos_count":0,"locked_videos_count":0,"real_locked_videos_count":0,"locked_photos_count":0,"be_liked_count":20,"url":"http://www.meipai.com/user/53556529","created_at":1407736435,"has_password":false,"status":"1","is_funy_core_user":false,"funy_core_user_created_at":0,"last_publish_time":0}
     */

    private String content;
    /**
     * id : 53556529
     * screen_name : -麦兜先生cc
     * country : 2630000
     * province : 2630600
     * city : 2630609
     * avatar : http://mvavatar2.meitudata.com/560a9220af5b81058.jpg
     * gender : m
     * birthday : 1997-08-22
     * age : 18
     * constellation : Leo
     * verified : false
     * followers_count : 13
     * friends_count : 35
     * reposts_count : 24
     * videos_count : 1
     * real_videos_count : 1
     * photos_count : 0
     * locked_videos_count : 0
     * real_locked_videos_count : 0
     * locked_photos_count : 0
     * be_liked_count : 20
     * url : http://www.meipai.com/user/53556529
     * created_at : 1407736435
     * has_password : false
     * status : 1
     * is_funy_core_user : false
     * funy_core_user_created_at : 0
     * last_publish_time : 0
     */

    private UserEntity user;

    public void setContent(String content) {
        this.content = content;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public UserEntity getUser() {
        return user;
    }

    public static class UserEntity {
        private String screen_name;
        private String avatar;

        public void setScreen_name(String screen_name) {
            this.screen_name = screen_name;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getScreen_name() {
            return screen_name;
        }

        public String getAvatar() {
            return avatar;
        }
    }
}
