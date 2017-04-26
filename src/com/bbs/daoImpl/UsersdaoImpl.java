package com.bbs.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bbs.dao.Usersdao;
import com.bbs.entity.*;

public class UsersdaoImpl implements Usersdao{
    /**
     * 登录验证
     */
	@Override
	public boolean Logindao(Users users,int u_limits) {
		   boolean flag=false;
		   Connection conn=DBManager.getConnection();
		   PreparedStatement stat=null;
		   ResultSet rs=null;
		   String sql="select * from Users where u_name=? and u_pwd=? and u_limits=?";
		   try {
			stat=conn.prepareStatement(sql);
			stat.setString(1,users.getU_name());
			stat.setString(2,users.getU_pwd());
			stat.setInt(3, u_limits);
			rs=stat.executeQuery();
			if(rs.next()){
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBManager.closeAll(conn, stat, rs);
		}
			return flag;
	}
	/**
	 * 用户注册
	 */
	@Override
	public boolean Regdao(Users users) {
		String sql="insert into Users values(?,?,?,?,?,?,?,?,?)";
		Object[]objs={users.getU_name(),users.getU_pwd(),users.getU_sex(),users.getU_photo(),
				users.getU_year(),users.getU_major(),users.getU_state(),users.getU_regtime(),users.getU_limits()};
		return DBManager.executeUpdate(sql, objs);
	}
	/**
	 * 用户名查重
	 */
	@Override
	public boolean selectSamedao(String u_name) {
		 boolean flag=false;
		   Connection conn=DBManager.getConnection();
		   PreparedStatement stat=null;
		   ResultSet rs=null;
		   String sql="select count(*) from Users where u_name=?";
		   try {
			stat=conn.prepareStatement(sql);
			stat.setString(1,u_name);
			rs=stat.executeQuery();
			if(rs.next()){
				if(rs.getInt(1)>0){
					flag=true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBManager.closeAll(conn, stat, rs);
		}
			return flag;
	}
	/**
	 * 根据用户编号查询用户详细信息
	 */
	@Override
	public Users selectnamebyu_iddao(int u_id) {
		   Users u=new Users();
		   Connection conn=DBManager.getConnection();
		   PreparedStatement stat=null;
		   ResultSet rs=null;
		   String sql="select * from Users where u_id=?";
		   try {
			stat=conn.prepareStatement(sql);
			stat.setInt(1,u_id);
			rs=stat.executeQuery();
			if(rs.next()){
				u.setU_id(rs.getInt("u_id"));
				u.setU_name(rs.getString("u_name"));
				u.setU_pwd(rs.getString("u_pwd"));
				u.setU_sex(rs.getString("u_sex"));
				u.setU_photo(rs.getString("u_photo"));
				u.setU_year(rs.getString("u_year"));
				u.setU_major(rs.getString("u_major"));
				u.setU_state(rs.getInt("u_state"));
				u.setU_regtime(rs.getString("u_regtime"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBManager.closeAll(conn, stat, rs);
		}
			return u;
	}
	/**
	 * 根据用户名查询用户所有信息
	 */
	@Override
	public Users selectusersbyu_namedao(String u_name) {
		   Users u=new Users();
		   Connection conn=DBManager.getConnection();
		   PreparedStatement stat=null;
		   ResultSet rs=null;
		   String sql="select * from Users where u_name=?";
		   try {
			stat=conn.prepareStatement(sql);
			stat.setString(1, u_name);
			rs=stat.executeQuery();
			if(rs.next()){
				u.setU_id(rs.getInt("u_id"));
				u.setU_name(rs.getString("u_name"));
				u.setU_pwd(rs.getString("u_pwd"));
				u.setU_sex(rs.getString("u_sex"));
				u.setU_photo(rs.getString("u_photo"));
				u.setU_year(rs.getString("u_year"));
				u.setU_major(rs.getString("u_major"));
				u.setU_state(rs.getInt("u_state"));
				u.setU_regtime(rs.getString("u_regtime"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBManager.closeAll(conn, stat, rs);
		}
			return u;
	}
	@Override
	public List<Users> showallusersdao() {
		List<Users>list=new ArrayList<Users>();
		 Connection conn=DBManager.getConnection();
		   PreparedStatement stat=null;
		   ResultSet rs=null;
		   String sql="select * from Users ";
		   try {
			stat=conn.prepareStatement(sql);
			rs=stat.executeQuery();
			while(rs.next()){
				Users u=new Users();
				u.setU_id(rs.getInt("u_id"));
				u.setU_name(rs.getString("u_name"));
				u.setU_pwd(rs.getString("u_pwd"));
				u.setU_sex(rs.getString("u_sex"));
				u.setU_photo(rs.getString("u_photo"));
				u.setU_year(rs.getString("u_year"));
				u.setU_major(rs.getString("u_major"));
				u.setU_state(rs.getInt("u_state"));
				u.setU_regtime(rs.getString("u_regtime"));
				u.setU_limits(rs.getInt("u_limits"));
				list.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBManager.closeAll(conn, stat, rs);
		}
		return list;
	}
	/**
	 * 根据用户ID修改用户状态
	 */
	@Override
	public boolean updateu_statebyu_iddao(int u_id, int u_state) {
		String sql="update users set u_state=? where u_id=?";
		Object objs[]={u_state,u_id};
		return DBManager.executeUpdate(sql, objs);
	}
	@Override
	public boolean updatemsgby_namedao(String name, String pwd, String sex,
			String major, String year, String photo, String u_name) {
		String sql="update users set u_name=?,u_pwd=?,u_sex=?,u_major=?,u_year=?,u_photo=? where u_name=?";
		Object[] objs={name,pwd,sex,major,year,photo,u_name};
		return DBManager.executeUpdate(sql, objs);
	}

}
