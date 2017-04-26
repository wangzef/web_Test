package com.bbs.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bbs.dao.Typdao;
import com.bbs.entity.DBManager;
import com.bbs.entity.Typ;

public class TypdaoImpl implements Typdao {

	@Override
	public List<Typ> showalltypedao() {
		List<Typ> list=new ArrayList<Typ>();
		   Connection conn=DBManager.getConnection();
		   PreparedStatement stat=null;                    
		   ResultSet rs=null;
		   String sql="select * from Typ ";
		   try {
			stat=conn.prepareStatement(sql);
			rs=stat.executeQuery();
			while(rs.next()){
				Typ t=new Typ();
				t.setT_id(rs.getInt("t_id"));
				t.setT_type(rs.getString("t_type"));
				list.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBManager.closeAll(conn, stat, rs);
		}
		return list;
	}
	/**
	 * 根据类型编号显示类型
	 */
	@Override
	public List<Typ> showtypebyt_iddao(int t_id) {
		   List<Typ> list=new ArrayList<Typ>();
		   Connection conn=DBManager.getConnection();
		   PreparedStatement stat=null;                    
		   ResultSet rs=null;
		   String sql="select * from Typ where t_id=?";
		   try {
			stat=conn.prepareStatement(sql);
			stat.setInt(1, t_id);
			rs=stat.executeQuery();
			while(rs.next()){
				Typ t=new Typ();
				t.setT_id(rs.getInt("t_id"));
				t.setT_type(rs.getString("t_type"));
				list.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBManager.closeAll(conn, stat, rs);
		}
		return list;
	}

}
