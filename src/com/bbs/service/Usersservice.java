package com.bbs.service;

import java.util.List;

import com.bbs.entity.Users;

public interface Usersservice {
	 public boolean Loginservice(Users users,int u_limits);   //��¼��֤
     public boolean Regservice(Users users);    //�û�ע��
     public boolean selectSameservice(String u_name);   //��ѯ�����Ƿ���ͬ
     public Users selectnamebyu_idservice(int u_id);  //�����û�ID��ѯ�û�
     public Users selectusersbyu_nameservice(String u_name);  //�����û�����ѯ�û�����ϸ��Ϣ
     public List<Users> showallusersservice();    //��ʾ�����û���Ϣ
     public boolean updateu_statebyu_idservice(int u_id,int u_state);   //�����û�ID�޸��û�״̬
     public boolean updatemsgby_nameservice(String name,String pwd,
  		   String sex,String major,String year,String photo,String u_name );//�����û����޸��û���Ϣ
}
