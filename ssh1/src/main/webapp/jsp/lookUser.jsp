<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="s" uri="/struts-tags" %>  --%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>  
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/ssh1/js/jquery-1.8.3.min.js"></script>
<title>Insert title here</title>
<style type="text/css">

.left{
float:left;

}
tr,td{
 
padding-top: 10px;

}

td{
 overflow:hidden;
 white-space:nowrap;
width: 100px;
padding: 10px;
 }
.top{

padding-top:3px;
padding-left: 20px;
position:relative;
left:1%;
}
table td{word-break: keep-all;}


#table{
width:80%;
border:1px solid #0C0C0C;
height:200px;
overflow-x:scroll;
padding-top: 9px;
position:relative;
left:3%;
margin-top: 10%;
}
.caidan{
width: 200px;
float:left;
background-color: #CCE8CF;
height: 600px;
}
</style>
</head>
<body>


 <div class="caidan">
<jsp:include page="../caidan.jsp" ></jsp:include>
</div>
<!--  主体-->
<div>
<div class="top">
<form id="readForm" action="/ssh1/read_readUser" method="post">
<input type="button" value="读取时间" class="readTime"><input type="submit" value="查看"><input type="button" value="删除所有" class="delete"><br/>
<div style="margin-top: 10px;"></div>
用户名: <input type="text" name="Pin"> 卡号<input type="text" name="CardID">

</form>
</div>
<div>

<table id="table">
<tr><td>SN</td><td>用户名</td><td>姓名</d><td>部门</td><td>卡号</td> <td>密码</td><td>用户状态</td> <td>有效次数</td><td>有效开始时间</td> <td>有效结束时间</td><td>开门时间</d><td>权限ID</td>   </tr>

<c:forEach var="i" items="${infoList}" >
  

<tr><td>${i.SN}</td><td>${i.pin}</td>
  <td> ${i.name}  </td><td>${i.department}</td>
 <td>${i.cardID}</td><td>${i.passwd}</td>
<%--  <td>${infoList[0].userState}   </td> --%>

<s:if test="${i.userState=='0'}"><td>正常</td></s:if>
<td>${i.validTimes}</td>
 <td>${i.validPeriodStart}</td><td>${i.validPeriodEnd}</td>
 <td>${i.openDoorTime}</td><td>${i.permID}</td> 

 </tr>

</c:forEach>
</table>
 
</div>
</div>
 <script type="text/javascript">

 $(".delete").click(function(){
		
		$("#readForm").attr("action","/ssh1/read_deleteUser");

		$("#readForm").submit();
		});
/*  读取时间*/
 $(".readTime").click(function(){
		window.open("/ssh1/read_readTime", "_blank", "toolbar=yes, directories=no, status=no, menubar=yes, scrollbars=yes, left=400px,top=100px,resizable=no, copyhistory=yes, width=400, height=400", false);
		
	/* 	$("#readForm").attr("action","/ssh1/read_deleteUser");

		$("#readForm").submit(); */
		});


	
</script>
<script type="text/javascript" src="/ssh1/js/caidan.js"></script>


</body>
</html>