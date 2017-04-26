package com.bbs.entity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {
	private static final String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String  url="jdbc:sqlserver://localhost:1433;databaseName=BBS";
	private static final String user="sa";
	private static final String pwd="123qwer";
	/**
	 * ��ȡ���ݿ����Ӷ���
	 * @return
	 */
	public static Connection getConnection(){
		Connection conn=null;
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, pwd);
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * �����ݵ���ɾ��
	 * @param sql
	 * @param objs
	 * @return
	 */
	public static boolean executeUpdate(String sql,Object[] objs){
		boolean flag=false;
		Connection conn=getConnection();
		PreparedStatement pst=null;
		try {
			pst=conn.prepareStatement(sql);
			for(int i=0;i<objs.length;i++){
				pst.setObject(i+1, objs[i]);
			}
			int num=pst.executeUpdate();
			if(num>0){
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAll(conn, pst, null);
		}
		
		return flag;
	}
	/**
	 * �ر����ݿ����Ӷ���
	 * @param conn
	 * @param stat
	 * @param rs
	 */
	public static void closeAll(Connection conn,Statement stat,ResultSet rs){
		try {
			if(rs!=null){
				rs.close();
			}
			if(stat!=null){
				stat.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
