package com.bbs.service;

import java.util.List;

import com.bbs.entity.Users;

public interface Usersservice {
	 public boolean Loginservice(Users users,int u_limits);   //登录验证
     public boolean Regservice(Users users);    //用户注册
     public boolean selectSameservice(String u_name);   //查询名字是否相同
     public Users selectnamebyu_idservice(int u_id);  //根据用户ID查询用户
     public Users selectusersbyu_nameservice(String u_name);  //根据用户名查询用户的详细信息
     public List<Users> showallusersservice();    //显示所有用户信息
     public boolean updateu_statebyu_idservice(int u_id,int u_state);   //根据用户ID修改用户状态
     public boolean updatemsgby_nameservice(String name,String pwd,
  		   String sex,String major,String year,String photo,String u_name );//根据用户名修改用户信息
}
