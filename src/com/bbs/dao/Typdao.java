package com.bbs.dao;

import java.util.List;

import com.bbs.entity.Typ;

public interface Typdao {
        public List<Typ> showalltypedao();      //��ʾ��������
        public List<Typ> showtypebyt_iddao(int t_id);  //�������ͱ����ʾ����
        
}
