package com.bbs.service;

import java.util.List;

import com.bbs.entity.Typ;

public interface Typservice {
	public List<Typ> showalltypeservice();      //��ʾ��������
	public List<Typ> showtypebyt_idservice(int t_id);  //�������ͱ����ʾ����
}
