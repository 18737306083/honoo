<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/ssh1/js/jquery-1.8.3.min.js"></script>
<style type="text/css">


.left{
float:left;
right: 10px;
}
#body{
position: relative;
left: 30%;
padding-left: 100px;
margin-top: 200px;
 }
#top{
position: relative;
left: 10%;


}
.caidan{
width: 200px;
float:left;
background-color: #CCE8CF;
height: 600px;
}
td,tr{ border:1px solid red;text-align: center;}

</style>
</head>
<body>
<div class="caidan">
<jsp:include page="../../caidan.jsp" ></jsp:include>
</div>



<!-- 主体-->

<form action="/ssh1/lock_timezone" method="post" id="readForm" >
<div id="top"><input type="submit" value="下发"/></div>
<!-- <div id="body"> -->
<!-- <div>
门号: <input type="text" name="DoorID"><br/>
星期:<select name="Weekday">
<option value="1">星期一</option>
<option value="2">星期二</option>
<option value="3">星期三</option>
<option value="4">星期四</option>
<option value="5">星期五</option>
<option value="6">星期六</option>
<option value="7">星期日</option>
</select><br/>
开始: <input type="text" placeholder="10:20" name="TimeStart"><br/>
结束: <input type="text" placeholder="12:20" name="TimeEnd"><br/>
行为: <select name="DoorOption">
<option value="0">用户权限决定</option>
<option value="2">常开</option>
<option value="1">常闭</option>
<option value="3">正常时间段</option>

</select>
</div> -->
<!-- </div> -->
</form>
<table>
<tbody>
<tr><td></td><td>星期一</td><td>星期二</td><td>星期三</td><td>星期四</td><td>星期五</td><td>星期六</td><td>星期日</td></tr>
<tr><td>门1</td>
<td><div>
门号: <input type="text" name="DoorID"><br/>
星期:<select name="Weekday">
<option value="1">星期一</option>
<option value="2">星期二</option>
<option value="3">星期三</option>
<option value="4">星期四</option>
<option value="5">星期五</option>
<option value="6">星期六</option>
<option value="7">星期日</option>
</select><br/>
开始: <input type="text" placeholder="10:20" name="TimeStart"><br/>
结束: <input type="text" placeholder="12:20" name="TimeEnd"><br/>
行为: <select name="DoorOption">
<option value="0">用户权限决定</option>
<option value="2">常开</option>
<option value="1">常闭</option>
<option value="3">正常时间段</option>

</select>
</div></td><td><div>
门号: <input type="text" name="DoorID"><br/>
星期:<select name="Weekday">
<option value="1">星期一</option>
<option value="2">星期二</option>
<option value="3">星期三</option>
<option value="4">星期四</option>
<option value="5">星期五</option>
<option value="6">星期六</option>
<option value="7">星期日</option>
</select><br/>
开始: <input type="text" placeholder="10:20" name="TimeStart"><br/>
结束: <input type="text" placeholder="12:20" name="TimeEnd"><br/>
行为: <select name="DoorOption">
<option value="0">用户权限决定</option>
<option value="2">常开</option>
<option value="1">常闭</option>
<option value="3">正常时间段</option>

</select>
</div></td><td><div>
门号: <input type="text" name="DoorID"><br/>
星期:<select name="Weekday">
<option value="1">星期一</option>
<option value="2">星期二</option>
<option value="3">星期三</option>
<option value="4">星期四</option>
<option value="5">星期五</option>
<option value="6">星期六</option>
<option value="7">星期日</option>
</select><br/>
开始: <input type="text" placeholder="10:20" name="TimeStart"><br/>
结束: <input type="text" placeholder="12:20" name="TimeEnd"><br/>
行为: <select name="DoorOption">
<option value="0">用户权限决定</option>
<option value="2">常开</option>
<option value="1">常闭</option>
<option value="3">正常时间段</option>

</select>
</div></td><td><div>
门号: <input type="text" name="DoorID"><br/>
星期:<select name="Weekday">
<option value="1">星期一</option>
<option value="2">星期二</option>
<option value="3">星期三</option>
<option value="4">星期四</option>
<option value="5">星期五</option>
<option value="6">星期六</option>
<option value="7">星期日</option>
</select><br/>
开始: <input type="text" placeholder="10:20" name="TimeStart"><br/>
结束: <input type="text" placeholder="12:20" name="TimeEnd"><br/>
行为: <select name="DoorOption">
<option value="0">用户权限决定</option>
<option value="2">常开</option>
<option value="1">常闭</option>
<option value="3">正常时间段</option>

</select>
</div></td><td><div>
门号: <input type="text" name="DoorID"><br/>
星期:<select name="Weekday">
<option value="1">星期一</option>
<option value="2">星期二</option>
<option value="3">星期三</option>
<option value="4">星期四</option>
<option value="5">星期五</option>
<option value="6">星期六</option>
<option value="7">星期日</option>
</select><br/>
开始: <input type="text" placeholder="10:20" name="TimeStart"><br/>
结束: <input type="text" placeholder="12:20" name="TimeEnd"><br/>
行为: <select name="DoorOption">
<option value="0">用户权限决定</option>
<option value="2">常开</option>
<option value="1">常闭</option>
<option value="3">正常时间段</option>

</select>
</div></td><td><div>
门号: <input type="text" name="DoorID"><br/>
星期:<select name="Weekday">
<option value="1">星期一</option>
<option value="2">星期二</option>
<option value="3">星期三</option>
<option value="4">星期四</option>
<option value="5">星期五</option>
<option value="6">星期六</option>
<option value="7">星期日</option>
</select><br/>
开始: <input type="text" placeholder="10:20" name="TimeStart"><br/>
结束: <input type="text" placeholder="12:20" name="TimeEnd"><br/>
行为: <select name="DoorOption">
<option value="0">用户权限决定</option>
<option value="2">常开</option>
<option value="1">常闭</option>
<option value="3">正常时间段</option>

</select>
</div></td><td><div>
门号: <input type="text" name="DoorID"><br/>
星期:<select name="Weekday">
<option value="1">星期一</option>
<option value="2">星期二</option>
<option value="3">星期三</option>
<option value="4">星期四</option>
<option value="5">星期五</option>
<option value="6">星期六</option>
<option value="7">星期日</option>
</select><br/>
开始: <input type="text" placeholder="10:20" name="TimeStart"><br/>
结束: <input type="text" placeholder="12:20" name="TimeEnd"><br/>
行为: <select name="DoorOption">
<option value="0">用户权限决定</option>
<option value="2">常开</option>
<option value="1">常闭</option>
<option value="3">正常时间段</option>

</select>
</div></td></tr>
<tr><td>门1</td>
<td><div>
门号: <input type="text" name="DoorID"><br/>
星期:<select name="Weekday">
<option value="1">星期一</option>
<option value="2">星期二</option>
<option value="3">星期三</option>
<option value="4">星期四</option>
<option value="5">星期五</option>
<option value="6">星期六</option>
<option value="7">星期日</option>
</select><br/>
开始: <input type="text" placeholder="10:20" name="TimeStart"><br/>
结束: <input type="text" placeholder="12:20" name="TimeEnd"><br/>
行为: <select name="DoorOption">
<option value="0">用户权限决定</option>
<option value="2">常开</option>
<option value="1">常闭</option>
<option value="3">正常时间段</option>

</select>
</div></td><td><div>
门号: <input type="text" name="DoorID"><br/>
星期:<select name="Weekday">
<option value="1">星期一</option>
<option value="2">星期二</option>
<option value="3">星期三</option>
<option value="4">星期四</option>
<option value="5">星期五</option>
<option value="6">星期六</option>
<option value="7">星期日</option>
</select><br/>
开始: <input type="text" placeholder="10:20" name="TimeStart"><br/>
结束: <input type="text" placeholder="12:20" name="TimeEnd"><br/>
行为: <select name="DoorOption">
<option value="0">用户权限决定</option>
<option value="2">常开</option>
<option value="1">常闭</option>
<option value="3">正常时间段</option>

</select>
</div></td><td><div>
门号: <input type="text" name="DoorID"><br/>
星期:<select name="Weekday">
<option value="1">星期一</option>
<option value="2">星期二</option>
<option value="3">星期三</option>
<option value="4">星期四</option>
<option value="5">星期五</option>
<option value="6">星期六</option>
<option value="7">星期日</option>
</select><br/>
开始: <input type="text" placeholder="10:20" name="TimeStart"><br/>
结束: <input type="text" placeholder="12:20" name="TimeEnd"><br/>
行为: <select name="DoorOption">
<option value="0">用户权限决定</option>
<option value="2">常开</option>
<option value="1">常闭</option>
<option value="3">正常时间段</option>

</select>
</div></td><td><div>
门号: <input type="text" name="DoorID"><br/>
星期:<select name="Weekday">
<option value="1">星期一</option>
<option value="2">星期二</option>
<option value="3">星期三</option>
<option value="4">星期四</option>
<option value="5">星期五</option>
<option value="6">星期六</option>
<option value="7">星期日</option>
</select><br/>
开始: <input type="text" placeholder="10:20" name="TimeStart"><br/>
结束: <input type="text" placeholder="12:20" name="TimeEnd"><br/>
行为: <select name="DoorOption">
<option value="0">用户权限决定</option>
<option value="2">常开</option>
<option value="1">常闭</option>
<option value="3">正常时间段</option>

</select>
</div></td><td><div>
门号: <input type="text" name="DoorID"><br/>
星期:<select name="Weekday">
<option value="1">星期一</option>
<option value="2">星期二</option>
<option value="3">星期三</option>
<option value="4">星期四</option>
<option value="5">星期五</option>
<option value="6">星期六</option>
<option value="7">星期日</option>
</select><br/>
开始: <input type="text" placeholder="10:20" name="TimeStart"><br/>
结束: <input type="text" placeholder="12:20" name="TimeEnd"><br/>
行为: <select name="DoorOption">
<option value="0">用户权限决定</option>
<option value="2">常开</option>
<option value="1">常闭</option>
<option value="3">正常时间段</option>

</select>
</div></td><td><div>
门号: <input type="text" name="DoorID"><br/>
星期:<select name="Weekday">
<option value="1">星期一</option>
<option value="2">星期二</option>
<option value="3">星期三</option>
<option value="4">星期四</option>
<option value="5">星期五</option>
<option value="6">星期六</option>
<option value="7">星期日</option>
</select><br/>
开始: <input type="text" placeholder="10:20" name="TimeStart"><br/>
结束: <input type="text" placeholder="12:20" name="TimeEnd"><br/>
行为: <select name="DoorOption">
<option value="0">用户权限决定</option>
<option value="2">常开</option>
<option value="1">常闭</option>
<option value="3">正常时间段</option>

</select>
</div></td><td><div>
门号: <input type="text" name="DoorID"><br/>
星期:<select name="Weekday">
<option value="1">星期一</option>
<option value="2">星期二</option>
<option value="3">星期三</option>
<option value="4">星期四</option>
<option value="5">星期五</option>
<option value="6">星期六</option>
<option value="7">星期日</option>
</select><br/>
开始: <input type="text" placeholder="10:20" name="TimeStart"><br/>
结束: <input type="text" placeholder="12:20" name="TimeEnd"><br/>
行为: <select name="DoorOption">
<option value="0">用户权限决定</option>
<option value="2">常开</option>
<option value="1">常闭</option>
<option value="3">正常时间段</option>

</select>
</div></td></tr><hr/><tr><td>门1</td>
<td><div>
门号: <input type="text" name="DoorID"><br/>
星期:<select name="Weekday">
<option value="1">星期一</option>
<option value="2">星期二</option>
<option value="3">星期三</option>
<option value="4">星期四</option>
<option value="5">星期五</option>
<option value="6">星期六</option>
<option value="7">星期日</option>
</select><br/>
开始: <input type="text" placeholder="10:20" name="TimeStart"><br/>
结束: <input type="text" placeholder="12:20" name="TimeEnd"><br/>
行为: <select name="DoorOption">
<option value="0">用户权限决定</option>
<option value="2">常开</option>
<option value="1">常闭</option>
<option value="3">正常时间段</option>

</select>
</div></td><td><div>
门号: <input type="text" name="DoorID"><br/>
星期:<select name="Weekday">
<option value="1">星期一</option>
<option value="2">星期二</option>
<option value="3">星期三</option>
<option value="4">星期四</option>
<option value="5">星期五</option>
<option value="6">星期六</option>
<option value="7">星期日</option>
</select><br/>
开始: <input type="text" placeholder="10:20" name="TimeStart"><br/>
结束: <input type="text" placeholder="12:20" name="TimeEnd"><br/>
行为: <select name="DoorOption">
<option value="0">用户权限决定</option>
<option value="2">常开</option>
<option value="1">常闭</option>
<option value="3">正常时间段</option>

</select>
</div></td><td><div>
门号: <input type="text" name="DoorID"><br/>
星期:<select name="Weekday">
<option value="1">星期一</option>
<option value="2">星期二</option>
<option value="3">星期三</option>
<option value="4">星期四</option>
<option value="5">星期五</option>
<option value="6">星期六</option>
<option value="7">星期日</option>
</select><br/>
开始: <input type="text" placeholder="10:20" name="TimeStart"><br/>
结束: <input type="text" placeholder="12:20" name="TimeEnd"><br/>
行为: <select name="DoorOption">
<option value="0">用户权限决定</option>
<option value="2">常开</option>
<option value="1">常闭</option>
<option value="3">正常时间段</option>

</select>
</div></td><td><div>
门号: <input type="text" name="DoorID"><br/>
星期:<select name="Weekday">
<option value="1">星期一</option>
<option value="2">星期二</option>
<option value="3">星期三</option>
<option value="4">星期四</option>
<option value="5">星期五</option>
<option value="6">星期六</option>
<option value="7">星期日</option>
</select><br/>
开始: <input type="text" placeholder="10:20" name="TimeStart"><br/>
结束: <input type="text" placeholder="12:20" name="TimeEnd"><br/>
行为: <select name="DoorOption">
<option value="0">用户权限决定</option>
<option value="2">常开</option>
<option value="1">常闭</option>
<option value="3">正常时间段</option>

</select>
</div></td><td><div>
门号: <input type="text" name="DoorID"><br/>
星期:<select name="Weekday">
<option value="1">星期一</option>
<option value="2">星期二</option>
<option value="3">星期三</option>
<option value="4">星期四</option>
<option value="5">星期五</option>
<option value="6">星期六</option>
<option value="7">星期日</option>
</select><br/>
开始: <input type="text" placeholder="10:20" name="TimeStart"><br/>
结束: <input type="text" placeholder="12:20" name="TimeEnd"><br/>
行为: <select name="DoorOption">
<option value="0">用户权限决定</option>
<option value="2">常开</option>
<option value="1">常闭</option>
<option value="3">正常时间段</option>

</select>
</div></td><td><div>
门号: <input type="text" name="DoorID"><br/>
星期:<select name="Weekday">
<option value="1">星期一</option>
<option value="2">星期二</option>
<option value="3">星期三</option>
<option value="4">星期四</option>
<option value="5">星期五</option>
<option value="6">星期六</option>
<option value="7">星期日</option>
</select><br/>
开始: <input type="text" placeholder="10:20" name="TimeStart"><br/>
结束: <input type="text" placeholder="12:20" name="TimeEnd"><br/>
行为: <select name="DoorOption">
<option value="0">用户权限决定</option>
<option value="2">常开</option>
<option value="1">常闭</option>
<option value="3">正常时间段</option>

</select>
</div></td><td><div>
门号: <input type="text" name="DoorID"><br/>
星期:<select name="Weekday">
<option value="1">星期一</option>
<option value="2">星期二</option>
<option value="3">星期三</option>
<option value="4">星期四</option>
<option value="5">星期五</option>
<option value="6">星期六</option>
<option value="7">星期日</option>
</select><br/>
开始: <input type="text" placeholder="10:20" name="TimeStart"><br/>
结束: <input type="text" placeholder="12:20" name="TimeEnd"><br/>
行为: <select name="DoorOption">
<option value="0">用户权限决定</option>
<option value="2">常开</option>
<option value="1">常闭</option>
<option value="3">正常时间段</option>

</select>
</div></td></tr>
<hr/>
<tr><td>门1</td>
<td><div>
门号: <input type="text" name="DoorID"><br/>
星期:<select name="Weekday">
<option value="1">星期一</option>
<option value="2">星期二</option>
<option value="3">星期三</option>
<option value="4">星期四</option>
<option value="5">星期五</option>
<option value="6">星期六</option>
<option value="7">星期日</option>
</select><br/>
开始: <input type="text" placeholder="10:20" name="TimeStart"><br/>
结束: <input type="text" placeholder="12:20" name="TimeEnd"><br/>
行为: <select name="DoorOption">
<option value="0">用户权限决定</option>
<option value="2">常开</option>
<option value="1">常闭</option>
<option value="3">正常时间段</option>

</select>
</div></td><td><div>
门号: <input type="text" name="DoorID"><br/>
星期:<select name="Weekday">
<option value="1">星期一</option>
<option value="2">星期二</option>
<option value="3">星期三</option>
<option value="4">星期四</option>
<option value="5">星期五</option>
<option value="6">星期六</option>
<option value="7">星期日</option>
</select><br/>
开始: <input type="text" placeholder="10:20" name="TimeStart"><br/>
结束: <input type="text" placeholder="12:20" name="TimeEnd"><br/>
行为: <select name="DoorOption">
<option value="0">用户权限决定</option>
<option value="2">常开</option>
<option value="1">常闭</option>
<option value="3">正常时间段</option>

</select>
</div></td><td><div>
门号: <input type="text" name="DoorID"><br/>
星期:<select name="Weekday">
<option value="1">星期一</option>
<option value="2">星期二</option>
<option value="3">星期三</option>
<option value="4">星期四</option>
<option value="5">星期五</option>
<option value="6">星期六</option>
<option value="7">星期日</option>
</select><br/>
开始: <input type="text" placeholder="10:20" name="TimeStart"><br/>
结束: <input type="text" placeholder="12:20" name="TimeEnd"><br/>
行为: <select name="DoorOption">
<option value="0">用户权限决定</option>
<option value="2">常开</option>
<option value="1">常闭</option>
<option value="3">正常时间段</option>

</select>
</div></td><td><div>
门号: <input type="text" name="DoorID"><br/>
星期:<select name="Weekday">
<option value="1">星期一</option>
<option value="2">星期二</option>
<option value="3">星期三</option>
<option value="4">星期四</option>
<option value="5">星期五</option>
<option value="6">星期六</option>
<option value="7">星期日</option>
</select><br/>
开始: <input type="text" placeholder="10:20" name="TimeStart"><br/>
结束: <input type="text" placeholder="12:20" name="TimeEnd"><br/>
行为: <select name="DoorOption">
<option value="0">用户权限决定</option>
<option value="2">常开</option>
<option value="1">常闭</option>
<option value="3">正常时间段</option>

</select>
</div></td><td><div>
门号: <input type="text" name="DoorID"><br/>
星期:<select name="Weekday">
<option value="1">星期一</option>
<option value="2">星期二</option>
<option value="3">星期三</option>
<option value="4">星期四</option>
<option value="5">星期五</option>
<option value="6">星期六</option>
<option value="7">星期日</option>
</select><br/>
开始: <input type="text" placeholder="10:20" name="TimeStart"><br/>
结束: <input type="text" placeholder="12:20" name="TimeEnd"><br/>
行为: <select name="DoorOption">
<option value="0">用户权限决定</option>
<option value="2">常开</option>
<option value="1">常闭</option>
<option value="3">正常时间段</option>

</select>
</div></td><td><div>
门号: <input type="text" name="DoorID"><br/>
星期:<select name="Weekday">
<option value="1">星期一</option>
<option value="2">星期二</option>
<option value="3">星期三</option>
<option value="4">星期四</option>
<option value="5">星期五</option>
<option value="6">星期六</option>
<option value="7">星期日</option>
</select><br/>
开始: <input type="text" placeholder="10:20" name="TimeStart"><br/>
结束: <input type="text" placeholder="12:20" name="TimeEnd"><br/>
行为: <select name="DoorOption">
<option value="0">用户权限决定</option>
<option value="2">常开</option>
<option value="1">常闭</option>
<option value="3">正常时间段</option>

</select>
</div></td><td><div>
门号: <input type="text" name="DoorID"><br/>
星期:<select name="Weekday">
<option value="1">星期一</option>
<option value="2">星期二</option>
<option value="3">星期三</option>
<option value="4">星期四</option>
<option value="5">星期五</option>
<option value="6">星期六</option>
<option value="7">星期日</option>
</select><br/>
开始: <input type="text" placeholder="10:20" name="TimeStart"><br/>
结束: <input type="text" placeholder="12:20" name="TimeEnd"><br/>
行为: <select name="DoorOption">
<option value="0">用户权限决定</option>
<option value="2">常开</option>
<option value="1">常闭</option>
<option value="3">正常时间段</option>

</select>
</div><hr/></td></tr>
</tbody>


</table>
<script type="text/javascript">
/* 查看用户信息 */

/* $(".lookUser").click(function(){

	$("#readForm").attr("action","/ssh1/read_readUser");

	$("#readForm").submit();
	
});
 */

/* $(".lookperssion").click(function(){

	$("#readForm").attr("action","/ssh1/perssion_getPersion");
	$("#readForm").submit();
	 
	
});
$(function(){
	$(".lookup").hide();
});
$(".readBtn").click(function(){

	
$(".lookup").toggle(); 
});

 */
/* 发送 */
 /* $(".sendBtn").click(function(){
	
$("#readForm").attr("action","/ssh1/send.jsp");

$("#readForm").submit();
});  */
 /*读取测试  */
/*  $(".readBtn").click(function(){
	
$("#readForm").attr("action","/ssh1/read.jsp");

$("#readForm").submit();
}); */
/*  $(".perssionBtn").click(function(){
	
	$("#readForm").attr("action","/ssh1/permission.jsp");

	$("#readForm").submit();
	});
 */
/*  $(".timeBtn").click(function(){
		
	$("#readForm").attr("action","/ssh1/lock_getTime");

	$("#readForm").submit();
	});

 $(".otherBtn").click(function(){
		
	$("#readForm").attr("action","/ssh1/lock_doorLock");

	$("#readForm").submit();
	});
$(".lookrecord").click(function(){

	$("#readForm").attr("action","/ssh1/read_leave");

	$("#readForm").submit();
	
});
 */

</script>
<script type="text/javascript" src="/ssh1/js/caidan.js"></script>

</body>
</html>