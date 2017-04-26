package com.bbs.dao;

import java.util.List;

import com.bbs.entity.Diss;

public interface Dissdao {
         public List<Diss> showdissbyp_iddao(int p_id);   //根据帖子编号查询评论
         public boolean adddissdao(Diss d);    //插入一条评论
         public boolean admadddissdao(Diss d);   //管理员插入一条评论
}
