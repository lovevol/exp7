<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix ="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
</head>
<body>
<s:i18n name="messageResource">
	<s:form action = "login" method = "post">
	<s:textfield name = "name" key="nameLabel"/>
	<s:password name = "password" key="passwordLabel"/>
	<s:submit key="loginLabel"></s:submit>
	</s:form>
</s:i18n>
<a href="register.jsp"><s:text name="registerLabel"/></a>
</body>
</html>