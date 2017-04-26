package com.bbs.service;

import java.util.List;

import com.bbs.entity.Posts;

public interface Postsservice {
    public List<Posts> showpostsbyt_idservice(int t_id);  //根据类型编号显示帖子
    public List<Posts> showallpostsservice();            //显示所有帖子
    public List<Posts> showpostsbyp_idservice(int p_id);   //根据帖子编号显示所有帖子
    public boolean updatep_ntimeservice(String p_ntime,int p_id);   //修改帖子最新更新时间
    public List<Posts> showpostbyt_idservice(int t_id);  //根据类型编号显示该类型的帖子
    public boolean addpostsdao(Posts posts);  //发帖
    public boolean deletepostsbyp_idservice(int p_id);  //根据帖子编号删除帖子
    public boolean updatep_stateservice(int p_state,int p_id); //修改帖子状态
    public boolean updatep_titlebyp_idservice(String p_title,int p_id);    //根据帖子编号修改帖子标题
}
