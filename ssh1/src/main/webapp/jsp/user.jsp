<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
<style type="text/css">
td{

text-align: center;

}


</style>
</head>

<body>
<div>
<form action="#" style="margin-top: 10px;margin-right: 50px;">
<table>
<tr>
<td>编号</td><td><input type="text"  name="Pin" required="required"/></td>
<label></label>
</tr>

<tr>
<td>姓名</td><td><input type="text"  name="Name" /></td>

</tr>
<tr>
<td>权限</td><td><select name="PermID" id="perssionSelect" required="required"> 
<option>---</option>

</select></td>

</tr>
<tr>
<td>部门</td><td><input type="text"  name="Department" /></td>

</tr>
<tr>
<td>卡号</td><td><input type="text"  name="CardID"  required="required"/></td>

</tr>
<tr>
<td>密码</td><td><input type="text"  name="Passwd"/></td>

</tr>
<tr>
<td>有效次数</td><td><input type="text"  name="ValidTimes" /></td>

</tr>
<tr>
<td>开始日期</td><td><input type="text"  name="ValidPeriodStart" /></td>

</tr>
<tr>
<td>结束日期</td><td><input type="text"  name="ValidPeriodEnd" /><input hidden="hidden" type="text" value="" name="SN" ></td>

</tr>
<tr>
<td>用户状态<input type="radio" name="UserState" value="0" checked="checked"> 正常</td><td><input type="radio" name="UserState" value="1">禁用</td>

</tr>
<tr>
<td></td><td><input type="button" class="addUser1" value="添加用户"></td>

</tr>
<tr>
<td></td><td></td>

</tr>


<!-- <label>刷卡号<input type="text"name="CardID1" id="cardid1" /></label><br/>
<label>卡号<input type="text" name="CardID" id="cardid"/></label><br/>
<label>门禁权限ID<input type="text" name="PermID" id="permid1"/></label>
 -->
 
<!--  <div></div> -->


</table>

</form>


</div>
<script type="text/javascript">
$(".addUser1").click(function(){

	var x=$("form").serializeArray();
/* $.each(x, function(i, field){
		alert(field.name + ":" + field.value + " "+field)
		//$("#results").append();
	}); */
	$.ajax({
		url:"/ssh1/perssion_addUser",
		data:x,
		type:"post",
		dataType:"json",
		success:function(data){
			 if(data=="ok"){
			        alert("添加成功");}
			/*  $.each(data, function(index, value) {
			  
			    }); */
			console.log(data);
	/* var data1=$("#content").val(); */
		//	$("#perssionSelect").val(data);
		}	
		});
		
});

$(function(){
	
//	alert();


$("#sn").val($("input[name='equip']:checked",  window.opener.document).val());
	console.log( );
	var perssionSelect= $("#perssionSelect").val();
	 var datas={"perssion":perssionSelect};
	$.ajax({
	url:"/ssh1/perssion_getAllPersion",
	data:datas,
	type:"post",
	dataType:"json",
	success:function(data){
		 $.each(data, function(index, value) {
		     //   alert(index + ': ' + value.permID);
		        $("#perssionSelect").append("<option>"+value.permID+"</option>");


		        
		    });
		console.log(data);
/* var data1=$("#content").val(); */
	//	$("#perssionSelect").val(data);
	}	
	});
	 
	});



</script>
</body>
</html>