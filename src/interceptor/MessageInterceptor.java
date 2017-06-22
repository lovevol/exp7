package interceptor;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import action.AddLy;
import model.Ly;

public class MessageInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		AddLy add = (AddLy) arg0.getAction(); //获取action
		String title = add.getLy().getTitle();//获取要添加的留言的标题
		Ly ly = new Ly();
		if (ly.findLyByTitle(title)) {//检查标题是否存在
			return "errorTitle";//跳转到出错界面
		}
		return arg0.invoke();//继续执行
	}

}
