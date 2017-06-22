<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix ="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加留言</title>
</head>
<body>
<s:form action="addLy" method="post">
	<s:textfield name="ly.title" label="标题"/>
	<s:textarea name="ly.content" label="内容"/>
	<s:submit value="提交"/>
	<s:reset value="重置"/>
</s:form>
</body>
</html>