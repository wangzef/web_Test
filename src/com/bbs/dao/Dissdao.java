package com.bbs.dao;

import java.util.List;

import com.bbs.entity.Diss;

public interface Dissdao {
         public List<Diss> showdissbyp_iddao(int p_id);   //�������ӱ�Ų�ѯ����
         public boolean adddissdao(Diss d);    //����һ������
         public boolean admadddissdao(Diss d);   //����Ա����һ������
}
