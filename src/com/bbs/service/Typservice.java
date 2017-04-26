package com.bbs.service;

import java.util.List;

import com.bbs.entity.Typ;

public interface Typservice {
	public List<Typ> showalltypeservice();      //显示所有类型
	public List<Typ> showtypebyt_idservice(int t_id);  //根据类型编号显示类型
}
