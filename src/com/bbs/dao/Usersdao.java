package com.bbs.dao;

import java.util.List;

import com.bbs.entity.Users;

public interface Usersdao {
       public boolean Logindao(Users users,int u_limit);   //��¼��֤
       public boolean Regdao(Users users);  			  //�û�ע��
       public boolean selectSamedao(String u_name);  	 //��ѯ�����Ƿ���ͬ
       public Users selectnamebyu_iddao(int u_id);  	//�����û�ID��ѯ�û�
       public Users selectusersbyu_namedao(String u_name);  //�����û�����ѯ�û�����ϸ��Ϣ
       public List<Users> showallusersdao();    	//��ʾ�����û���Ϣ
       public boolean updateu_statebyu_iddao(int u_id,int u_state);   //�����û�ID�޸��û�״̬
       public boolean updatemsgby_namedao(String name,String pwd,
    		   String sex,String major,String year,String photo,String u_name );//�����û����޸��û���Ϣ
}
