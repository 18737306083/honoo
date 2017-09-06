<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>

<style type="text/css">
.top{
margin-top: 10px;
border-bottom-width: 10px;
}
.center{
margin-top: 15px;

}

tr,td{
margin-top: 10px;
padding-top: 10px;
text-align: center;
}

td{
 overflow:hidden;
 white-space:nowrap;
width: 100px;
padding: 10px;
 }

.bottom{
margin-top: 10px;


}
.left{
float:left;

}
#table
{
margin-top:60px;
border:1px solid #0C0C0C;
height:300px;
overflow-x:scroll;
}
.read1{
margin-top:20px;
border:1px solid #0C0C0C;
height:200px;
overflow-x:scroll;
}
.read2{
border:1px solid #0C0C0C;
height:150px;
overflow-x:scroll;
}
table td{word-break: keep-all;}
.caidan{
width: 200px;
float:left;
background-color: #CCE8CF;
height: 600px;
}
</style>
</head>
<body>
<%-- <div>
<div class="left" style="width: 200px;height: 700px;background-color: #CCE8CF; " >
<div style="margin-top: 80px;">
<button  style="width: 100%;height: 40px;" class="sendBtn">发送测试</button>

</div>
<div>
<button style="width: 100%;height: 40px;" class="readBtn">读取测试</button>

</div>
<div class="lookup"  style="text-align: center;" >

<button style="width: 50%;height: 20px;margin: 5px;background-color:#94DAEB;" class="lookUser" >查看用户信息</button>
<button style="width: 50%;height: 20px;margin: 5px;background-color:#94DAEB; " class="lookperssion" >查看权限信息</button>
<button style="width: 50%;height: 20px;margin: 5px;background-color:#94DAEB; " class="lookrecord" >读取记录</button>
</div>
<div class="lookup>
<button style="width: 100%;height: 40px;">查看用户信息</button>
<button style="width: 100%;height: 40px;">查看权限信息</button>
</div>

<div>
<button  style="width: 100%;height: 40px;" class="perssionBtn">实时刷卡信息</button>

</div>
<div>
<button  style="width: 100%;height: 40px;" class="timeBtn">门时间段</button>

</div>
<div>
<button  style="width: 100%;height: 40px;" class="otherBtn">其他配置</button>

</div>
</div>

</div> --%>
<div class="caidan">
<jsp:include page="caidan.jsp" ></jsp:include>
</div>
<%-- <form action="first_startSdkService" method="post" id="form">
	<div >
	<table class="top">
		<tbody>
		
				<tr>
					<td>
					<span>配置文件</span></td>
					<td><input type="file" style="text-align: center;"></td>
					<td></td>
				</tr>
				<tr>
					<td><span>服务地址</span></td>
					<td><select name="ip">
	 
							<option>${requestScope.ipAddres}</option>
							 
					</select></td>
				</tr>
	           <tr><td>服务端口  </td><td><input type="text" name="svPort" value="8068" ></td> </tr>
	           <tr><td><input type="radio" name="range"><input type="radio" name="range"><input type="radio" name="range"></td></tr>
		</tbody>
	</table>
	<table class="center">
	<tbody>
	<tr><td><input type="checkbox" name="check"><span>远程调试</span></td><td><select><option>TCP</option><option>UDP</option> </select></td></tr>
	
	<tr><td>调试地址</td><td><input type="text"></td></tr>
	<tr> <td>调试端口</td><td><input type="text" value="12345"></td></tr>
	
	
	</tbody>
	
	</table>
	<table class="bottom">
	<tbody>
	<tr><td><input type="checkbox" checked="checked">选择调试</td></tr>
	<tr><td><input type="file" name="file"></td></tr>
	<tr><td>
	 <c:if test="${requestScope.switchs>=1}">
	<input type="button" value="打开" class="open" disabled="disabled">
	<input type="button" value="关闭" class="close"></td> </tr>
	</c:if>
	 
	<c:if test="${requestScope.switchs<1}">
	
	<input type="button" value="打开" class="open" >
	<input type="button" value="关闭" class="close" disabled="disabled">   </td> </tr>
	</c:if>
	
	<input type="checkbox" value="1" class="select" name="select">
	
	</tbody>
	</table>
	</div>
	</form>
 --%>
 

<div>
<div>
<button id="addUser">添加用户</button><button id="addperssion">添加权限</button><button id="led">清空LED记录</button><button id="test">测试</button>

</div>
<div class="read1">
<form id="readForm" action="">
<table class="readTable1" style="width: 900px;" style="white-space:nowrap">
<tr><td>选择</td><td>SN</td><td>状态</td><td>IP地址</td><td>版本</td><td>MAC</td><td>设备类型</td><td>工作模式</td><td>门数</td><td>读头数</td><td>辅助输入</td><td>辅助输入</td></tr>
</table>
</form>
</div>
<!-- <input type="button" value="全选"><input type="button" value="反选"><input type="button" value="重启设备"> -->

</div>
 <div id="table">
<table id="timedata">
<tr><td>SN</td><td>卡号</td><td>卡数量</td><td>时间</d><td>部门</td><td>方向</td> <td>输入地址</td><td>输入类型</td> <td>名字</td><td>输出地址</td> <td>输出类型</td><td>PIN</td><td>记录号</td><td>事件类型</td>   </tr>


</table>

</div>
<script type="text/javascript">
/* 查看用户信息 */



$(".open").click(function(){

 $("#form").submit();

	




	
	});
 
var fn = function(){
$.ajax({
url:"/ssh1/first_pushData",
dataType:"json",
type:"post",
success:function(data1){
	console.log(data1);

   
	// alert(data1.data[0].SN+data1.data[0].serverIP+data1.data[0].MAC+data1.data[0].type+data1.data[0].auxInCount+data1.data[0].serverIP+data1.data[0].isDoubleDirection+data1.data[0].auxOutCount);
   var str="";
	for(i=0;i<data1.length;i++){
		
 str=str+"<tr><td><input type='checkbox' value='"+data1[i].SN+"' class='equip' name='equip'></td><td>"+data1[i].SN+"</td><td>在线</td><td>"+data1[i].serverIP+"</td><td>"+data1[i].version+"</td><td>"+data1[i].MAC+"</td><td>"+data1[i].type+"</td><td>"+data1[i].devWorkMode+"</td><td>"+data1[i].doorCount+"</td><td>"+data1[i].readerCount+"</td><td>"+data1[i].auxInCount+"</td><td>"+data1[i].auxOutCount+"</td></tr>"
 
 
	
} 
$(".readTable1").empty();

$(".readTable1").append("<tr><td>选择</td><td>SN</td><td>状态</td><td>IP地址</td><td>版本</td><td>MAC</td><td>设备类型</td><td>工作模式</td><td>门数</td><td>读头数</td><td>辅助输入</td><td>辅助输入</td></tr>");
$(".readTable1").append(str);  

/* } */

}

	
});





    
}

// setInterval(fn,5000); 
setTimeout(fn, 5000);



var time1 = function()  {
	$.ajax({
	url:"/ssh1/read_readRealJson",
	dataType:"json",
	type:"post",
	success:function(data1){
		console.log(data1);
	   var str="";
		for(i=0;i<data1.length;i++){
			
	// str=str+"<tr><td><input type='checkbox' value='"+data1[i].SN+"' class='equip' name='equip'></td><td>"+data1[i].SN+"</td><td>在线</td><td>"+data1[i].serverIP+"</td><td>"+data1[i].version+"</td><td>"+data1[i].MAC+"</td><td>"+data1[i].type+"</td><td>"+data1[i].devWorkMode+"</td><td>"+data1[i].doorCount+"</td><td>"+data1[i].readerCount+"</td><td>"+data1[i].auxInCount+"</td><td>"+data1[i].auxOutCount+"</td></tr>"
	 
		str=str+"<tr> <td> "+data1[i].SN +"</td><td>"+data1[i].cardID+"</td><td>"+data1[i].cardNum+"</td><td>"+data1[i].dateTime+"</td> <td>"+data1[i].department +"</td>"
			 +" <td>"+data1[i].direction+"</td><td>"+data1[i].inputAddr+" </td> <td>"+data1[i].inputType+" </td><td>"+data1[i].name+"</td> "
			  +"<td>"+data1[i].outputAddr+" </td><td>"+data1[i].outputType +"</td><td>"+data1[i].pin+" </td><td>"+data1[i].recordIndex +"</td> "
			  +"<td>"+data1[i].eventType+" </td> </tr>";
		
	} 
	$("#timedata").empty();

	$("#timedata").append("<tr><td>SN</td><td>卡号</td><td>卡数量</td><td>时间</d><td>部门</td><td>方向</td> <td>输入地址</td><td>输入类型</td> <td>名字</td><td>输出地址</td> <td>输出类型</td><td>PIN</td><td>记录号</td><td>事件类型</td>   </tr>");
	$("#timedata").append(str);  

	/* } */

	}

		
	});





	    
	}

setInterval(time1,3000); 
	//setTimeout(time1, 2000);
$("#led").click(function() {
	
	
	
	$.ajax({
	url:"/ssh1/first_deleteLEDRecord",
	type:"post",
	dataType:"json",
	success:function(data){

	
	alert(data);	
	}	
	});
		


		
	});
$("#test").click(function() {
	
	
	
	$.ajax({
	url:"/ssh1/first_test12",
	type:"post",
	dataType:"json",
	success:function(data){

	
	alert(data);	
	}	
	});
		


		
	});

</script>
<script type="text/javascript" src="/ssh1/js/caidan.js"></script>
</body>

</html>