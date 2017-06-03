<%@page import="java.sql.*"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="./reset.css">
<link rel="stylesheet" type="text/css" href="./main.css">
<script type="text/javascript">
	var xmlhttp;
	function show(){//显示结果的流程控制
		var input_sql=document.getElementById("input_sql");
		var url="commit?input_sql="+escape(input_sql.value);
		xmlhttp=new CreatXMLHttp();
		xmlhttp.onreadystatechange=function()
		  {
			  if (xmlhttp.readyState==4 && xmlhttp.status==200)//状态改变调用回调方法
			    {
					var result =xmlhttp.responseText;
					var json=eval("("+result+")");//关键的函数。解析json
					setContents(json);
					
			    }//交互成功，获得文本格式数据?responseText不是方法，是 XMLHttpRequest 对象的 responseText 或 responseXML 属性。
			  }
		xmlhttp.open("get",url,true);//异步发送数据
		xmlhttp.send();

	}
	function CreatXMLHttp(){//创建XmlHttp对象
		var xmlhttp;
		if (window.XMLHttpRequest){//for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp=new XMLHttpRequest();
		}
		else//for IE6, IE5
			{
			xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
			}
		return xmlhttp;
	}
	function setContents(contents){//动态显示数据,这是模版的先参考，再改
		//获得数据的长度，确定生成行树，既多少组<tr></tr>
		clearContents();
		var size=contents.length;
		var length =size-1;
		var xsize=contents[0];//第一个元素是列数
		var tabNode=document.createElement("table");
		for (var i=0;i<length/xsize;i++){
			var trNode=tabNode.insertRow();
			for(var n=1;n<=xsize;n++){
				var nextNode=contents[i*xsize+n];
				var tdNode=trNode.insertCell();
				tdNode.innerHTML=nextNode;
			}
		}
		document.getElementById('content_table_body').appendChild(tabNode);
	//	tabNode.setAttribute('border', '1');
	}
	function clearContents(){
		var contentTableBody=document.getElementById("content_table_body");
		var size=contentTableBody.childNodes.length;
		var something=contentTableBody.childNodes[1];
		contentTableBody.innerHTML=null;
//		alert(something);
//		for (var i=size-1;i>=0;i--){
//			contentTableBody.removeChild(contentTableBody.childNods[i]);
//		}
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>web of showing Sql</title>
</head>
<body>
	<div class=toparea>
		<p>Please input your sql</p>
	</div>
	<div class="inputare">
			<input type="text" name="input_sql" id="input_sql" /> 
			<input type="button" value="Explain" id="search_btn" onclick="show()" />
	</div>
	<div id="showare">
		<table id="content_table" bgcolor="#FFFAFA" border="0" cellspacing="0"
			cellpadding="0">
			<tbody id="content_table_body">
				<!-- 显示数据的地方 -->
			</tbody>
		</table>
	</div>
</body>
</html>