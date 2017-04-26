package com.bbs.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bbs.dao.Dissdao;
import com.bbs.entity.DBManager;
import com.bbs.entity.Diss;


public class DissdaoImpl implements Dissdao {
    /**
     * 根据帖子编号查询评论
     */
	@Override
	public List<Diss> showdissbyp_iddao(int p_id) {
		List<Diss> list=new ArrayList<Diss>();
		   Connection conn=DBManager.getConnection();
		   PreparedStatement stat=null;                    
		   ResultSet rs=null;
		   String sql="select * from diss where p_id=? order by d_time asc ";
		   try {
			stat=conn.prepareStatement(sql);
			stat.setInt(1, p_id);
			rs=stat.executeQuery();
			while(rs.next()){
				Diss d=new Diss();
				d.setD_id(rs.getInt("d_id"));
				d.setD_content(rs.getString("d_content"));
				d.setD_time(rs.getString("d_time"));
				d.setU_id(rs.getInt("u_id"));
				list.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBManager.closeAll(conn, stat, rs);
		}
		return list;
	}
	/**
	 * 插入一条评论
	 */
	@Override
	public boolean adddissdao(Diss d) {
		String sql="insert into diss values(?,?,?,?)";
		Object [] objs={d.getD_content(),d.getD_time(),d.getU_id(),d.getP_id()};
		return DBManager.executeUpdate(sql, objs);
	}
	/**
	 * 管理员插入一条评论
	 */
	@Override
	public boolean admadddissdao(Diss d) {
		String sql="insert into diss (d_content,d_time,p_id) values(?,?,?)";
		Object [] objs={d.getD_content(),d.getD_time(),d.getP_id()};
		return DBManager.executeUpdate(sql, objs);
	}

}
