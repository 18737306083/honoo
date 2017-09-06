<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/ssh1/js/jquery-1.8.3.min.js"></script>

</head>
<body>
   <form action="" method="post">
参数:  <select name="parameter" id="para">

<option value="DeviceType">DeviceType</option>
<option value="DevWorkMode">DevWorkMode</option>
<option value="DoorCount">DoorCount</option>
<option value="ReaderCount">ReaderCount</option>
<option value="AuxInCount">AuxInCount</option>
<option value="AuxOutCount">AuxOutCount</option>
<option value="MaxRecordCount">MaxRecordCount</option>
<option value="DHCPEnable">DHCPEnable</option>
<option value="CurrentIP">CurrentIP</option>
<option value="StaticIP"> StaticIP</option>
<option value="Gateway">Gateway</option>
<option value="Netmask">Netmask</option>
<option value="LocalPort">LocalPort</option>
<option value="ServerIP1">ServerIP1</option>
<option value="ServerPort1">ServerPort1</option>
<option value="DNS1Enable">DNS1Enable</option>
<option value="Domain1">Domain1</option>
<option value="DNS1Server">DNS1Server</option>
<option value="DNS2Server">DNS2Server</option>
<option value="ReconnectInterval">ReconnectInterval</option>
<option value="HeartbeatInterval">HeartbeatInterval</option>
<option value="Serial1Configure">Serial1Configure</option>
<option value="Serial2Configure">Serial2Configure</option>
<option value="D1DefenseEnable">D1DefenseEnable</option>
<option value="D1SuperPWD">D1SuperPWD</option>
<option value="D1DriveTime">D1DriveTime</option>
<option value="D1OpenPWD1">D1OpenPWD1</option>
<option value="D1LockType">D1LockType</option>
<option value="AuxIn1ValidState">AuxIn1ValidState</option>
</select><br/>
输出值: <input type="text"  readonly id="output">
<button id="btn">输出</button>

</form>


<script type="text/javascript">
$("#btn").click(function()   {
 
var para=$("#para").val();
	var datas={"parameter":para};
	$.ajax({
	url:"/ssh1/lock_readOutPutParameter",
	type:"post",
	 data:datas, 
	
	dataType:"json",
	error:function(xhr,status,error){
alert(status);
		},
	success:function(data){
		
alert("11");
	console.log(data);
		
	}	
	});
		


		
	});




</script>
</body>
</html>