<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
background-color: #CCE8CF;
}



</style>

</head>
<body>
<button class="readTime">读取时间</button><button class="readVersion">读取版本号</button>
<select style="width: 100px;" name="where"><option value=" " ><option value="Upload=0" >Upload=0</option>
<option value="DateTime like 2015-9%">DateTime like '2015-9%'</option>
<option value="DateTime like 2015-9-06%">DateTime like '2015-9-06%'</option>

</select>
<button class="offLineRecord">采集离线记录</button><button class="offLineID">采集离线身份证</button>
<button class="setLocalTime">设置当前时间</button><button class="selection">采集表数据</button>
<select name="tab" id="tab"><option value="TabUserPermInfo">TabUserPermInfo</option> <option value="TabPermission">TabPermission</option> </select>

<div>
<textarea rows="30" cols="70" style="margin-top: 10px;padding: 5px;" id="content"></textarea></div>
<script type="text/javascript">




$(".readTime").click(function(){
$.ajax({
url:"/ssh1/first_readData",
type:"post",
dataType:"json",
success:function(data){

console.log(data);
	$("#content").val(data);
}	
});
	


	
});
$(".readVersion").click(function(){
	
	$.ajax({
	url:"/ssh1/read_readSystemVersion",
	type:"post",
	dataType:"json",
	success:function(data){

	console.log(data);
		$("#content").val(data);
	}	
	});
		


		
	});

$(".offLineRecord").click(function(){
	
	$.ajax({
	url:"/ssh1/read_leave",
	type:"post",
	dataType:"json",
	success:function(data){

	console.log(data);
		$("#content").val(data);
	}	
	});
		


		
	});

$(".setLocalTime").click(function(){

	
	alert("123");
	$.ajax({
	url:"/ssh1/read_setCurrentTime ",
	type:"post",
	dataType:"json",
	success:function(data){

	console.log(data);
		$("#content").val(data);
	}	
	});
		


		
	});

$(".selection").click(function(){
	 var tab= $("#tab").val();
	 alert(tab);
	 var datas={"tab":tab};
	$.ajax({
	url:"/ssh1/read_getTabData",
	data:datas,
	type:"post",
	dataType:"json",
	success:function(data){

	console.log(data);
var data1=$("#content").val();
		$("#content").val(data1+data);
	}	
	});
		


		
	});
</script>
</body>
</html>