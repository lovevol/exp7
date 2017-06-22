package interceptor;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import action.AddLy;
import model.Ly;

public class MessageInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		AddLy add = (AddLy) arg0.getAction(); //��ȡaction
		String title = add.getLy().getTitle();//��ȡҪ��ӵ����Եı���
		Ly ly = new Ly();
		if (ly.findLyByTitle(title)) {//�������Ƿ����
			return "errorTitle";//��ת���������
		}
		return arg0.invoke();//����ִ��
	}

}
