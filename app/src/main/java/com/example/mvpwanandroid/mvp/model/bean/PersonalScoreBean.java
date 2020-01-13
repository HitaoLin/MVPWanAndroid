package com.example.mvpwanandroid.mvp.model.bean;

import com.cxz.baselibs.bean.BaseBean;

/**
 * <pre>
 *     author:LHT
 *     date:2019.12.16
 *     desc:个人积分 Bean
 * </pre>
 */
public class PersonalScoreBean extends BaseBean<PersonalScoreBean.DataBean> {

    /**
     * data : {"coinCount":1995,"level":20,"rank":107,"userId":23071,"username":"l**haitao"}
     */

    public static class DataBean {
        /**
         * coinCount : 1995
         * level : 20
         * rank : 107
         * userId : 23071
         * username : l**haitao
         */

        private int coinCount;
        private int level;
        private int rank;
        private int userId;
        private String username;

        public int getCoinCount() {
            return coinCount;
        }

        public void setCoinCount(int coinCount) {
            this.coinCount = coinCount;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
