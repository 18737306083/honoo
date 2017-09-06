<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>

<title>登录</title>
<style type="text/css">
#login{
text-align: center;
margin-top: 300px;
margin-left: 40%;
}

body{
font-size: 23px;
font-family: SimSun;
background-color: #CCE8CF;
}

</style>
</head>
<body>

<form action="/ssh1/first_submitData">
<div id="login">
<table s>
<tr><td>用户名:</td><td><input type="text" name="name" ></td></tr>
<tr><td>密码:</td><td><input type="text" name="name" ></td></tr>
<tr><td></td></tr>
<tr><td colspan="2" style="text-align: center;"><input type="submit" value="登录"></td></tr>

</table>

</div>
</form>
<script type="text/javascript">

$(function(){
	$("form").submit();	
});



</script>
</body>
</html>