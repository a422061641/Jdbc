<%@page import="java.sql.*"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="./reset.css">
<link rel="stylesheet" type="text/css"
	href="./Hello.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>web of showing Sql</title>
</head>
<body>
	<div class=top_area>
		<p>Please input yuor sql</p>
	</div>
	<div class="logoBar">
		<div class=search_box>	
			<form class="input" method="post" action="commit">
					<input type="text" name="input_sql" class="search_text"></input>
				<input type="submit"name="commit" value="Commit" class="search_btn"></input>
		</div>
	</div>
</body>
</html>