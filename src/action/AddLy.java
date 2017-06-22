package action;

import java.sql.Date;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import model.Ly;
import model.User;

public class AddLy extends ActionSupport{
	private Ly ly;
	private ActionContext context;
	private Map session;
	public Ly getLy() {
		return ly;
	}

	public void setLy(Ly ly) {
		this.ly = ly;
	}
	public String execute() throws Exception{
		context = ActionContext.getContext();
		session = (Map) context.getSession();
		User user = (User) session.get("user");
		ly.setUserid(user.getId());
		ly.setAddtime(new Date(System.currentTimeMillis()));
		Ly myLy = new Ly();
		if(myLy.AddLy(ly)!=0){
			return SUCCESS;
		}
		else 
			return ERROR;
	}

}
