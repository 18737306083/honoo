<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>联动</title>
</head>
<body>

<form action="">
序号:<input type="text" name="Index">
输入类型:<select name="InputType">
<option value="0">门</option>
<option value="1">读头</option>
<option value="2">辅助输入 </option>
<option value="3">USB</option>

</select>
输入地址:	<input type="text" name="InputAddr">
触发事件: <select name="TriggerEvent">
<option value="0">正常刷卡开门</option>
<option value="1">远程开门</option>
<option value="2">多卡开门</option>
<option value="1001">卡未注册</option>
<option value="1002">卡无权限信息</option>
<option value="1003">卡片使用次数已完</option>
</select>

输出类型:<select name="OutputType">
<option value="1">门锁</option>
<option value="2">辅助输出</option>
<option value="3">蜂鸣器输出</option>


</select>
输出地址:<input type="text" name="OutputAddr" value="1">
输出时间: <input type="text" name="ExportTime" value="4">
生成记录:<input type="radio" name="GenRecord" value="o" hecked="checked">不生成<input type="radio" name="GenRecord" value="1">生成


</form>
<button>联动</button>
</body>
</html>