<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/ssh1/js/jquery-1.8.3.min.js"></script>
<style type="text/css">

td{
text-align: center;


}

</style>
</head>
<body>
<div>
<form action="#" method="post" style="margin-top: 20px;">
<fieldset>
<legend>权限</legend>
<table>
<tr>
<td><label>权限号</label></td>
<td>
<input type="text" name="PermID" id="permid2"/>
</td>
</tr>
<tr>
<td><label>读头ID</label></td>
<td>
<input type="text" name="ReaderID" id="doorid" disabled="disabled"/><br/>
</td>
</tr>
<tr>
<td><label>门号</label></td>
<td>
<input type="text" name="DoorID" id="doorid"/><br/>
</td>
</tr>
<tr>
<td><label>验证模式</label></td>
<td>
<select name="VerifyMode">
<option value="0">普通组(不受首卡/双卡限制)</option>
<option value="1">双卡组(不受首卡/双卡限制)</option>
<option value="2">首卡(不受普通卡/双卡组限制)</option>
<option value="3">受首卡限制(不受普通/双卡限制)</option>
<option value="4">五星级卡(主卡)</option>
<option value="5">四星级卡(副卡)</option>
<option value="6">三星级卡(副卡)</option>
<option value="7">自定义验证方式</option>
</select><br/>
</td>
</tr>
<tr>
<td>验证方式</td>
<td>
<input type="radio" name="VerifyPasswd" value="0">不校验密码(默认)<input type="radio" name="VerifyPasswd" value="1">卡加密码<input type="radio" name="VerifyPasswd" value="2" checked="checked">卡或密码<br/>
</td>
</tr>
<tr>
<td><label>周号</label></td>
<td>
<input type="text" name="WeekID" id="doorid"/><br/>
</td>
</tr>
<tr>
<td><label>节假日号</label></td>
<td>
<input type="text" name="HolidayID" id="doorid"/><br/>
</td>
</tr>
<tr>
<td><label>组方法</label></td>
<td>
<input type="text" name="GroupMethod" id="doorid"/><br/>
</td>
</tr>
<tr>
<td>同样的组</td>
<td>
<input type="radio" name="SameGroup" value="1" checked="checked">同组<input type="radio" name="SameGroup" value="0"> 不同组<br/>
</td>
</tr>
<tr>
<td><label>组号</label></td>
<td>
<input type="text" name="GroupID" id="doorid"/><br/>
</td>
</tr>
<tr>
<td><label>远程ID</label></td>
<td>
<input type="text" name="RemoteConfirm" id="doorid"/><br/>
</td>
</tr>
<tr><td><input type="button" class="addUser1" value="提交" ></td></tr>


</table>
</fieldset>

</form>



</div>
<script type="text/javascript">


	$(".addUser1").click(function(){

		var x=$("form").serializeArray();
	
		$.ajax({
			url:"/ssh1/perssion_addPersion",
			data:x,
			type:"post",
			dataType:"json",
			success:function(data){
				 if(data=="ok"){
				        alert("添加成功");}
			
				console.log(data);
		
			}	
			});
			
	});

</script>
</body>
</html>