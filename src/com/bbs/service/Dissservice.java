package com.bbs.service;

import java.util.List;

import com.bbs.entity.Diss;

public interface Dissservice {
	public List<Diss> showdissbyp_idservice(int p_id);   //�������ӱ�Ų�ѯ����
	public boolean adddissservice(Diss d);    //����һ������
	 public boolean admadddissservice(Diss d);   //����Ա����һ������
}
