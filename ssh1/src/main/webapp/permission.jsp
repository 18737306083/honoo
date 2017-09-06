<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<style type="text/css">
body{
font-size: 23px;
font-family: SimSun;

}

.left1{
float:left;

}

.read{
border:1px solid #0C0C0C;
height:150px;
overflow-x:scroll;
}
td{text-align: center;}

</style>

</head>
<body>


<!--内容  -->
<div >
<div>
<button id="addUser">添加用户</button><button id="addperssion">添加权限</button>

</div>

 <div class="read" >
<table style="width: 900px;">
<tr><td>选中</td>  <td>SN</td><td>流水号</td><td>时间</td><td>编号</td><td>姓名</td><td>部门</td><td>卡号</td><td>输入</td><td>输入地址</td><td>输出</td><td>输出地址</td><td>方向</td><td>卡数量</td><td>事件</td></tr>

  <c:forEach var="y"  items="${readRecord}">
   Item <c:out value="${y.eventType}"/><p>
</c:forEach>
   
 
</table>

</div> 





</div>
<script type="text/javascript">


</script>
</body>
</html>