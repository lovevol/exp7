package action;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

import model.User;

public class Register extends ActionSupport{
	private String name;
	private String password;
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
	public String execute() throws Exception{
		User user = new User();
		if(user.addUser(name, password)!=0)//存入用户信息
			return SUCCESS;
		else
			return ERROR;
	}

}
