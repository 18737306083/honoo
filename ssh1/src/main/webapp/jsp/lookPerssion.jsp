<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/ssh1/js/jquery-1.8.3.min.js"></script>
<style type="text/css">

.left{
float:left;

}
tr,td{
margin-top: 10px;
padding-top: 10px;

}

td{
 overflow:hidden;
 white-space:nowrap;
width: 100px;
padding: 10px;
 }
.top{

padding-top:20px;
padding-left: 20px;
position:relative;
left:3%;
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
<!-- 主体 -->

<div>
<form action="/ssh1/perssion_getPersion" id="readForm" method="post">
<div class="top">
<input type="submit" value="查看权限"><input type="button" value="查看子权限">
</div>
</form>
<div id="table">
<table>
<tr><td>SN</td><td>权限ID</td><td>卡ID</td><td>头ID</td><td>门id</<td>验证方式</td> <td>周方式</td><td>假期方式</td> <td>组号</td><td>同组</td> <td>组方法</td><td>远程确认</td>   </tr>








<c:forEach var="i" items="${perssioninfo }">



<tr><td> <%-- ${infoList[0].N} --%> </td><td>${i.permID}</td>
  <td> ${i.cardID}  </td><td>${i.readerID}</td>
 <td>${i.doorID}</td><td>${i.verifyMode}</td>
 <td>${i.weekID}</td><td>${i.holidayID}</td>
 <td>${i.groupID}</td><td>${i.sameGroup}</td>
 <td>${i.groupMethod}</td><td>${i.remoteConfirm}</td> 

 </tr>
 </c:forEach>

</table>
</div>
</div>
 <script type="text/javascript">
/* 查看用户信息 */

 
</script>
<script type="text/javascript" src="/ssh1/js/caidan.js"></script>



</body>
</html>