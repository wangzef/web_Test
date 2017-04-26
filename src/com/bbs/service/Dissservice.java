package com.bbs.service;

import java.util.List;

import com.bbs.entity.Diss;

public interface Dissservice {
	public List<Diss> showdissbyp_idservice(int p_id);   //根据帖子编号查询评论
	public boolean adddissservice(Diss d);    //插入一条评论
	 public boolean admadddissservice(Diss d);   //管理员插入一条评论
}
