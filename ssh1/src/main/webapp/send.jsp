<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>远程开门</title>
<script type="text/javascript" src="/ssh1/js/jquery-1.8.3.min.js"></script>

<style type="text/css">
body{
font-size: 23px;
font-family: SimSun;

}

.readForm{
position:relative;
left: 25%;
top:20%;
width: 50%;
margin-top: 100px;

}

.dataDoor{
padding-left: 10px;
margin:20px 40px 10px 10px;


}
.left{

float: left;
right: 50px;
}
tr,td{
text-align:center;
margin-top: 10px;
padding-top: 10px;

}

td{
 overflow:hidden;
 white-space:nowrap;
width: 100px;
padding: 10px;
 }

#table{
margin-top:20px;
border:1px solid #0C0C0C;
height:400px;
overflow-x:scroll;
}
.top1{

/* width: px;
height: 42px; */
margin-top: 10px;



}
input{
margin-left: 1px;
padding-left: 1px
}
.caidan{
width: 200px;
float:left;
background-color: #CCE8CF;
height: 600px;
}
.top{
position:relative;
left: 2%;
}
</style>
</head>
<body>

 <div class="caidan">
<jsp:include page="caidan.jsp" ></jsp:include>
</div>
<!--开门  -->

<div>
<div class="top">
<button class="top1 select">全选</button><input type="submit" value="开门" class="top1" form="readForm"><button class="top1 usuallyopen" >常开</button><button class="top1 closed">常闭</button><button class="top1 unforce">解除</button><button class="top1">联动</button>
</div>
<form action="/ssh1/read_openDoor"  id="readForm">

<input type="radio" name="transfor" value="DoorControl" checked="checked">远程开门 <input type="radio" name="transfor" value="AuxoutControl">远程开门输出<br/>
<input type="checkbox" name="openDoor" value="1">1门<input type="text" name="dataDoor" value="5" class="dataDoor">
<input type="checkbox" name="openDoor" value="2">2门<input type="text" name="dataDoor" value="5" class="dataDoor">
<input type="checkbox" name="openDoor" value="3">3门<input type="text" name="dataDoor" value="5" class="dataDoor">
<input type="checkbox" name="openDoor" value="4">4门<input type="text" name="dataDoor" value="5" class="dataDoor">




</form>
</div>
 <div id="table">
<table id="timedata">
<tr><td>SN</td><td>卡号</td><td>卡数量</td><td>时间</d><td>部门</td><td>方向</td> <td>输入地址</td><td>输入类型</td> <td>名字</td><td>输出地址</td> <td>输出类型</td><td>PIN</td><td>记录号</td><td>事件类型</td>   </tr>


</table>
</div>
<script type="text/javascript">
$(".select").click(function(){
	$("input[name='openDoor']").attr("checked",true) 
});


$(function(){

	// 全选
	$(".select").bind("click", function () {
	    $("[name = copenDoor]:checkbox").attr("checked", true);
	});
	
});
/* 常开 */
$(".usuallyopen").click(function(){

	$("#readForm").attr("action","/ssh1/read_norOpen");
	$("#readForm").submit();
	 
	
}); 
/* 长关 */
$(".closed").click(function(){

	$("#readForm").attr("action","/ssh1/read_closedDoor");
	$("#readForm").submit();
	 
	
}); 
/*  解除*/

$(".unforce").click(function(){

	$("#readForm").attr("action","/ssh1/read_unforceDoor");
	$("#readForm").submit();
	 
	
}); 

var time1 = function()  {
	$.ajax({
	url:"/ssh1/read_readRealJson",
	dataType:"json",
	type:"post",
	success:function(data1){
		console.log(data1);
	   var str="";
		for(i=0;i<data1.length;i++){
			
	// str=str+"<tr><td><input type='checkbox' value='"+data1[i].SN+"' class='equip'' name='equip'></td><td>"+data1[i].SN+"</td><td>在线</td><td>"+data1[i].serverIP+"</td><td>"+data1[i].version+"</td><td>"+data1[i].MAC+"</td><td>"+data1[i].type+"</td><td>"+data1[i].devWorkMode+"</td><td>"+data1[i].doorCount+"</td><td>"+data1[i].readerCount+"</td><td>"+data1[i].auxInCount+"</td><td>"+data1[i].auxOutCount+"</td></tr>"
	 
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

</script>
<script type="text/javascript" src="/ssh1/js/caidan.js"></script>
</body>
</html>