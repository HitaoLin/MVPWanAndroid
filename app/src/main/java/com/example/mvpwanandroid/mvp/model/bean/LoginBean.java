package com.example.mvpwanandroid.mvp.model.bean;


import com.cxz.baselibs.bean.BaseBean;

import java.util.List;

public class LoginBean extends BaseBean<LoginBean.DataBean> {

    /**
     * data : {"admin":false,"chapterTops":[],"collectIds":[7730,8547,8699,8700,8982,8976,8855,9111,9663,3188,3189,3025,8020,10164],"email":"","icon":"","id":23071,"nickname":"linhaitao","password":"","publicName":"linhaitao","token":"","type":0,"username":"linhaitao"}
     */

    public static class DataBean {
        /**
         * admin : false
         * chapterTops : []
         * collectIds : [7730,8547,8699,8700,8982,8976,8855,9111,9663,3188,3189,3025,8020,10164]
         * email :
         * icon :
         * id : 23071
         * nickname : linhaitao
         * password :
         * publicName : linhaitao
         * token :
         * type : 0
         * username : linhaitao
         */

        private boolean admin;
        private String email;
        private String icon;
        private String id;
        private String nickname;
        private String password;
        private String publicName;
        private String token;
        private int type;
        private String username;
        private List<?> chapterTops;
        private List<Integer> collectIds;

        public boolean isAdmin() {
            return admin;
        }

        public void setAdmin(boolean admin) {
            this.admin = admin;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getPublicName() {
            return publicName;
        }

        public void setPublicName(String publicName) {
            this.publicName = publicName;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public List<?> getChapterTops() {
            return chapterTops;
        }

        public void setChapterTops(List<?> chapterTops) {
            this.chapterTops = chapterTops;
        }

        public List<Integer> getCollectIds() {
            return collectIds;
        }

        public void setCollectIds(List<Integer> collectIds) {
            this.collectIds = collectIds;
        }
    }
}
