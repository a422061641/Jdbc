<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="./Hello.css">
<title>Insert title here</title>
</head>
<body>
	<%
	ArrayList<String> name = (ArrayList) request.getAttribute("names");
	ArrayList<String> value= (ArrayList) request.getAttribute("values");
	Iterator it1 = name.iterator();
	Iterator it2 = value.iterator();
	int length=name.size();
	int length2=value.size();%>
	<table class="gridtable">
	<tr>
	<%
	int i=0;
	while(it1.hasNext()){
	%>
		<td>
		<%
		out.write(name.get(i));
		%>
		</td>
		<%
		i++;
		it1.next();
	}
	%>
	</tr>
	<%
	for (int n=0;n<length2/length;n++){
	%>
		<tr>
		<%
			for(int n2=0;n2<length;n2++){
		%>
			<td>
			<%
			out.write(value.get(n*length+n2));
			%>
			</td>
			<%
			}
			%>
		<tr>
	<%}%>
	</table>
</body>
</html>
