<%@page import="java.util.Iterator"%>
<%@page import="model.Ly"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="dbtools.MysqlCon"%>
<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
</head>
<body>
你的用户权限：
<%
	User user = (User)session.getAttribute("user");
	ArrayList<Ly> list = new ArrayList<>();
	String sql = null;
	if(user.getJur().equals("h")){
		out.print("高<br>");
		out.print("<h3>查看所有留言</h3>");
		out.print("<hr>");
		sql = "select * from ly";	
	}else{
		out.print("低<br>");
		out.print("<h3>查看自己的留言</h3>");
		out.print("<hr>");
		sql = "select * from ly where userid = "+"'"+user.getId()+"'";	
	}
	MysqlCon mysqlCon = new MysqlCon();
	Connection connection = mysqlCon.getConnection();
	PreparedStatement pStatement = connection.prepareStatement(sql);
	ResultSet rs = pStatement.executeQuery();
	while(rs.next()){
		Ly ly = new Ly();
		ly.setIdly(rs.getInt(1));
		ly.setUserid(rs.getInt(2));
		ly.setAddtime(rs.getDate(3));
		ly.setTitle(rs.getString(4));
		ly.setContent(rs.getString(5));
		list.add(ly);
	}
	rs.close();
	
%>
<table border="1">
<thead>
	<td>用户名</td><td>时间</td><td>标题</td><td>内容</td>
</thead>

<%	Iterator iterator = list.iterator();
	while(iterator.hasNext()){
		Ly theLy = (Ly)iterator.next();
		rs = pStatement.executeQuery("select name from userinfo where id = "+theLy.getUserid());
		String userName = null;
		while(rs.next()){
			userName = rs.getString(1);	
		}
		%>
		<tr>
			<td width="80px"><%=userName %></td>
			<td width="100px"><%=theLy.getAddtime() %></td>
			<td width="150px"><%=theLy.getTitle() %></td>
			<td width="600px"><%=theLy.getContent() %></td>
		</tr>
		<%
	}
	pStatement.close();
	connection.close();
%>
</table>
<br>
<a href="addLy.jsp">添加留言</a>
</body>
</html>