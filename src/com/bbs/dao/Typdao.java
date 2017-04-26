package com.bbs.dao;

import java.util.List;

import com.bbs.entity.Typ;

public interface Typdao {
        public List<Typ> showalltypedao();      //显示所有类型
        public List<Typ> showtypebyt_iddao(int t_id);  //根据类型编号显示类型
        
}
