package action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.regexp.internal.recompile;

import dbtools.MysqlCon;
import model.User;

public class Login extends ActionSupport{
	private String name;
	private String password;
	private ActionContext context;
	private Map session;
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
	public void validate(){//������֤
	       if(name==null||name.equals("")){
	           addFieldError("name","��������");
	       }
	       if(password==null||password.equals("")){
	           addFieldError("password","�������");
	       }
	   }
	public String execute() throws Exception{//ִ��
		User user = new User();
		if(user.validate(name, password)){//��Ϣ�ȶԳɹ�
			MysqlCon mysqlCon = new MysqlCon();//���ݿ���ز���
			Connection connection = null;
			connection = mysqlCon.getConnection();
			PreparedStatement pStatement = null;
			ResultSet resultSet = null;
				try {
					pStatement = connection.prepareStatement("select * from userinfo where name = ? and password = ?");
					pStatement.setString(1, name);
					pStatement.setString(2, password);
					resultSet = pStatement.executeQuery();
					while(resultSet.next()){
						user.setId(resultSet.getInt(1));
						user.setName(name);
						user.setPassword(password);
						user.setJur(resultSet.getString(4));
					}
					resultSet.close();
					pStatement.close();
					connection.close();
				} catch (SQLException e) {
				// TODO Auto-generated catch block
					//e.printStackTrace();
				}
			context = ActionContext.getContext();
			session = (Map) context.getSession();
			session.put("user",user);//���û���Ϣ����Ự
			return SUCCESS;
		}
		return ERROR;
	}
}
