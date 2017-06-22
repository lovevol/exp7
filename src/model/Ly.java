package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbtools.MysqlCon;

public class Ly {
	private int idly;
	private int userid;
	private Date addtime;
	private String title;
	private String content;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getIdly() {
		return idly;
	}
	public void setIdly(int idly) {
		this.idly = idly;
	}
	public int AddLy(Ly ly) {
		MysqlCon mysqlCon = new MysqlCon();//数据库相关操作
		Connection connection = null;
		connection = mysqlCon.getConnection();
		PreparedStatement pStatement = null;
		int result = 0;
			try {
				pStatement = connection.prepareStatement("insert into ly(userid,addtime,title,content) values(?,?,?,?)");
				pStatement.setInt(1, ly.getUserid());
				pStatement.setDate(2, ly.getAddtime());
				pStatement.setString(3, ly.getTitle());
				pStatement.setString(4, ly.getContent());
				result = pStatement.executeUpdate();
				pStatement.close();
				connection.close();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			return result;
	}
	public boolean findLyByTitle(String title) {
		MysqlCon mysqlCon = new MysqlCon();//数据库相关操作
		Connection connection = null;
		connection = mysqlCon.getConnection();
		PreparedStatement pStatement = null;
		ResultSet result = null;
			try {
				pStatement = connection.prepareStatement("select idly from ly where title = ?");
				pStatement.setString(1, title);
				result = pStatement.executeQuery();
				while(result.next()){
					return true;
				}
				pStatement.close();
				connection.close();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
				//e.printStackTrace();
			} 
		return false;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
}
