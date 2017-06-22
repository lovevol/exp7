package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import dbtools.MysqlCon;

public class User {
	private int id;
	private String name;
	private String password;
	private String jur;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean validate(String userName, String userPassword){//登陆验证
		MysqlCon mysqlCon = new MysqlCon();//数据库相关操作
		Connection connection = null;
		connection = mysqlCon.getConnection();
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
			try {
				pStatement = connection.prepareStatement("select * from userinfo where name = ? and password = ?");
				pStatement.setString(1, userName);
				pStatement.setString(2, userPassword);
				resultSet = pStatement.executeQuery();
				while(resultSet.next()){//返回用户id
					return true;
				}
				resultSet.close();
				pStatement.close();
				connection.close();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
				//e.printStackTrace();
				return false;
			}
		return false;
	}
	public int addUser(String userName,String userPassword) {//添加用户
		int result = 0;
		MysqlCon mysqlCon = new MysqlCon();
		Random random = new Random(12);
		String jur = "h";
		if(random.nextInt(15)%2==0)
			jur = "l";
		try {
			Statement statement = mysqlCon.getConnection().createStatement();
			result = statement.executeUpdate("insert into userinfo(name,password,jur) values("+"'"+userName+"',"+"'"+userPassword+"',"+"'"+jur+"')");
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return result;
	}
	public String getJur() {
		return jur;
	}
	public void setJur(String jur) {
		this.jur = jur;
	}

}
