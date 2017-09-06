<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/ssh1/js/jquery-1.8.3.min.js"></script>

<style type="text/css">

body{
font-size: 23px;
font-family: SimSun;

}


.left{
float:left;
right: 10px;
}
#body{
position: relative;
left: 30%;
padding-left: 100px;
margin-top: 20px;
 }
#top{
position: relative;
left: 2%;


}
.caidan{
width: 200px;
float:left;
background-color: #CCE8CF;
height: 600px;
}
tr,td{
margin-top: 10px;
padding-top: 10px;

}

td{
text-align:center;
 overflow:hidden;
 white-space:nowrap;
width: 100px;
padding: 10px;
 }

#table{
margin-top:20px;
border:1px solid #0C0C0C;
height:300px;
overflow-x:scroll;
}

</style>
</head>
<body>


<div class="caidan">
<jsp:include page="../../caidan.jsp" ></jsp:include>
</div>
<form action="/ssh1/lock_lockDoor" method="post" id="readForm"">
<div id="top">
<input type="submit" value="互锁">
</div>
<div id="body">

  <table>
  <tr><td></td><td>门1</td> <td>门2</td><td>门3</td> <td>门4</td> </tr>
  <tr><td>门1</td><td><input type="checkbox" disabled="disabled"></td> <td><input type="checkbox" name="door1" value="2" ></td><td><input type="checkbox" name="door1" value="3" ></td> <td><input type="checkbox" name="door1" value="4" ></td> </tr>
  <tr><td>门2</td><td><input type="checkbox" name="door2" value="1" ></td> <td><input type="checkbox" disabled="disabled"></td><td><input type="checkbox" name="door2" value="3" ></td> <td><input type="checkbox" name="door2" value="4" ></td> </tr>
  <tr><td>门3</td><td><input type="checkbox" name="door3" value="1"></td><td><input type="checkbox" name="door3" value="2" ></td> <td><input type="checkbox" disabled="disabled"></td><td><input type="checkbox" name="door3"  value="4" ></td>  </tr>
  <tr><td>门4</td><td><input type="checkbox" name="door4" value="1" ></<td><td><input type="checkbox" name="door4" value="2" ></td> <td><input type="checkbox" name="door4" value="3" ></td><td><input type="checkbox" disabled="disabled"></td> </tr>
  </table>
</div>




</form>
 <div id="table">
<table id="timedata">
<tr><td>SN</td><td>卡号</td><td>卡数量</td><td>时间</d><td>部门</td><td>方向</td> <td>输入地址</td><td>输入类型</td> <td>名字</td><td>输出地址</td> <td>输出类型</td><td>PIN</td><td>记录号</td><td>事件类型</td>   </tr>


</table>
</div>
<script type="text/javascript">
/* 查看用户信息 */



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