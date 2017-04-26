package com.bbs.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bbs.dao.Postsdao;
import com.bbs.entity.DBManager;
import com.bbs.entity.Posts;


public class PostsdaoImpl implements Postsdao {
    /**
     * 根据类型编号查询帖子
     */
	@Override
	public List<Posts> showpostsbyt_iddao(int t_id) {
		   List<Posts> list=new ArrayList<Posts>();
		   Connection conn=DBManager.getConnection();
		   PreparedStatement stat=null;                    
		   ResultSet rs=null;
		   String sql="select * from posts where t_id=? ";
		   try {
			stat=conn.prepareStatement(sql);
			stat.setInt(1, t_id);
			rs=stat.executeQuery();
			while(rs.next()){
				Posts p=new Posts();
				p.setP_id(rs.getInt("p_id"));
				p.setP_title(rs.getString("p_title"));
				p.setP_content(rs.getString("p_content"));
				p.setP_state(rs.getInt("p_state"));
				p.setP_time(rs.getString("p_time"));
				p.setP_ntime(rs.getString("p_ntime"));
				p.setU_id(rs.getInt("u_id"));
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBManager.closeAll(conn, stat, rs);
		}
		return list;
		
	}
	/**
	 * 查询所有帖子
	 */
	@Override
	public List<Posts> showallpostsdao() {
		 List<Posts> list=new ArrayList<Posts>();
		   Connection conn=DBManager.getConnection();
		   PreparedStatement stat=null;                    
		   ResultSet rs=null;
		   String sql="select * from posts where p_state in(1,3) order by p_state desc, p_ntime desc ";
		   try {
			stat=conn.prepareStatement(sql);
			rs=stat.executeQuery();
			while(rs.next()){
				Posts p=new Posts();
				p.setP_id(rs.getInt("p_id"));
				p.setP_title(rs.getString("p_title"));
				p.setP_content(rs.getString("p_content"));
				p.setP_state(rs.getInt("p_state"));
				p.setP_time(rs.getString("p_time"));
				p.setP_ntime(rs.getString("p_ntime"));
				p.setU_id(rs.getInt("u_id"));
				p.setT_id(rs.getInt("t_id"));
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBManager.closeAll(conn, stat, rs);
		}
		return list;
	}
	/**
	 * 根据帖子编号查询帖子信息
	 */
	@Override
	public List<Posts> showpostsbyp_iddao(int p_id) {
		   List<Posts> list=new ArrayList<Posts>();
		   Connection conn=DBManager.getConnection();
		   PreparedStatement stat=null;                    
		   ResultSet rs=null;
		   String sql="select * from posts where p_id=? ";
		   try {
			stat=conn.prepareStatement(sql);
			stat.setInt(1, p_id);
			rs=stat.executeQuery();
			while(rs.next()){
				Posts p=new Posts();
				p.setP_id(rs.getInt("p_id"));
				p.setP_title(rs.getString("p_title"));
				p.setP_content(rs.getString("p_content"));
				p.setP_state(rs.getInt("p_state"));
				p.setP_time(rs.getString("p_time"));
				p.setP_ntime(rs.getString("p_ntime"));
				p.setU_id(rs.getInt("u_id"));
				p.setT_id(rs.getInt("t_id"));
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBManager.closeAll(conn, stat, rs);
		}
		return list;
	}
	/**
	 * 修改帖子的最新动态时间
	 */
	@Override
	public boolean updatep_ntimedao(String p_ntime,int p_id) {
		String sql="update Posts set p_ntime=? where p_id=?";
		Object [] objs={p_ntime,p_id};
		return DBManager.executeUpdate(sql, objs);
	}
	/**
	 * 根据类型编号查询该类型的帖子标题
	 */
	@Override
	public List<Posts> showpostbyt_iddao(int t_id) {
		List<Posts> list=new ArrayList<Posts>();
		Connection conn=DBManager.getConnection();
		   PreparedStatement stat=null;                    
		   ResultSet rs=null;
		   String sql="select * from posts where t_id=? ";
		   try {
			stat=conn.prepareStatement(sql);
			stat.setInt(1, t_id);
			rs=stat.executeQuery();
			while(rs.next()){
				Posts p=new Posts();
				p.setP_id(rs.getInt("p_id"));
				p.setP_title(rs.getString("p_title"));
				p.setP_content(rs.getString("p_content"));
				p.setP_state(rs.getInt("p_state"));
				p.setP_time(rs.getString("p_time"));
				p.setP_ntime(rs.getString("p_ntime"));
				p.setU_id(rs.getInt("u_id"));
				p.setT_id(rs.getInt("t_id"));
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBManager.closeAll(conn, stat, rs);
		}
		return list;
	}
	/**
	 * 发表帖子
	 */
	@Override
	public boolean addpostsdao(Posts posts) {
		String sql="insert into Posts values (?,?,?,?,?,?,?)";
		Object [] objs={posts.getP_title(),posts.getP_content(),posts.getP_state(),
				posts.getP_time(),posts.getP_ntime(),posts.getT_id(),posts.getU_id()};
		return DBManager.executeUpdate(sql, objs);
	}
	/**
	 * 根据帖子编号删除帖子
	 */
	@Override
	public boolean deletepostsbyp_iddao(int p_id) {
		String sql="delete * from posts where p_id=?";
		Object [] objs={p_id};
		return DBManager.executeUpdate(sql, objs);
	}
	/**
	 * 修改帖子状态
	 */
	@Override
	public boolean updatep_statedao(int p_state,int p_id) {
		String sql="update posts set p_state=? where p_id=?";
		Object [] objs={p_state,p_id};
		return DBManager.executeUpdate(sql, objs);
	}
	/**
	 * 根据帖子编号修改帖子标题
	 */
	@Override
	public boolean updatep_titlebyp_iddao(String p_title,int p_id) {
		String sql="update posts set p_title=? where p_id=?";
		Object [] objs={p_title,p_id};
		return DBManager.executeUpdate(sql, objs);
	}
}
