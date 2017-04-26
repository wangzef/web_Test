package com.bbs.dao;

import java.util.List;

import com.bbs.entity.Posts;

public interface Postsdao {
         public List<Posts> showpostsbyt_iddao(int t_id);  //根据类型编号显示帖子
         public List<Posts> showallpostsdao();            //显示所有帖子
         public List<Posts> showpostsbyp_iddao(int p_id);   //根据帖子编号显示所有帖子
         public boolean updatep_ntimedao(String p_ntime,int p_id);   //修改帖子最新更新时间
         public List<Posts> showpostbyt_iddao(int t_id);  //根据类型编号显示该类型的帖子
         public boolean addpostsdao(Posts posts);  //发帖
         public boolean deletepostsbyp_iddao(int p_id);  //根据帖子编号删除帖子
         public boolean updatep_statedao(int p_state,int p_id); //修改帖子状态
         public boolean updatep_titlebyp_iddao(String p_title,int p_id);    //根据帖子编号修改帖子标题
}
