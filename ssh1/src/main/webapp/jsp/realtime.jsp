<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
<script type="text/javascript" src="/ssh1/js/jquery-1.8.3.min.js"></script>
<style type="text/css">

.left{
float:left;

}
tr,td{
 text-align:center;
padding-top: 10px;

}

td{
 overflow:hidden;
 white-space:nowrap;
width: 100px;
padding: 10px;
 }
.top{

padding-top:20px;
padding-left: 20px;
position:relative;
left:3%;
}


td{
 overflow:hidden;
 white-space:nowrap;
width: 100px;
padding: 10px;
 }

#table{

width:80%;
border:1px solid #0C0C0C;
height:500px;
overflow-x:scroll;
padding-top:9px;
position:relative;
left:3%;
margin-top: 10%;
}
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
</div>
<div class="lookup>
<button style="width: 100%;height: 40px;">查看用户信息</button>
<button style="width: 100%;height: 40px;">查看权限信息</button>
</div>

<div>
<button  style="width: 100%;height: 40px;" class="perssionBtn">权限下发测试</button>

</div>
<div>
<button  style="width: 100%;height: 40px;" class="timeBtn">门时间段</button>

</div>
<div>
<button  style="width: 100%;height: 40px;" class="otherBtn">其他配置</button>

</div>
</div>

</div>

<div> --%>
<div class="caidan">
<jsp:include page="../caidan.jsp" ></jsp:include>
</div>
<form action="#" id="readForm" method="post">
<button class="leave">查看离线记录</button>  
<button class="refresh">刷新</button>
</form>
</div>

<%-- 
<c:forEach items="${readRecord}" var="item">
            <tr><td>${item.recordIndex}</td></tr>
        </c:forEach> --%>
<%-- ${readRecord[0].recordIndex } --%>
<div id="table">
<table >
<tr><td>SN</td><td>卡号</td><td>卡数量</td><td>时间</d><td>部门</td><td>方向</td> <td>输入地址</td><td>输入类型</td> <td>名字</td><td>输出地址</td> <td>输出类型</td><td>PIN</td><td>记录号</td><td>事件类型</td>   </tr>
<%-- <tr>
  <td> sn  </td><td>${readRecord[0].cardID}</td>
 <td>${readRecord[0].cardNum}</td><td>${readRecord[0].dateTime}</td>
 <td>${infoList[0].userState}   </td>

<s:if test="${infoList[0].userState=='0'}"><td>正常</td></s:if>
<td>${readRecord[0].department }</td>
 <td>${readRecord[0].direction }</td><td>${readRecord[0].inputAddr }</td>
 <td>${readRecord[0].inputType }</td><td>${readRecord[0].name}</td> 
 <td>${readRecord[0].outputAddr }</td><td>${readRecord[0].outputType }</td>
 <td>${readRecord[0].pin }</td><td>${readRecord[0].recordIndex }</td> 
 <td>${readRecord[0].eventType }</td>
 

 </tr> --%>
<c:forEach var="i" items="${realTime}" >
  
   <tr>
  <td> ${i.SN} </td><td>${i.cardID}</td>
 <td>${i.cardNum}</td><td>${i.dateTime}</td>
<%--  <td>${infoList[0].userState}   </td> --%>

<%-- <s:if test="${infoList[0].userState=='0'}"><td>正常</td></s:if> --%>
<td>${i.department }</td>
 <td>${i.direction }</td><td>${i.inputAddr }</td>
 <td>${i.inputType }</td><td>${i.name}</td> 
 <td>${i.outputAddr }</td><td>${i.outputType }</td>
 <td>${i.pin }</td><td>${i.recordIndex }</td> 
 <td>${i.eventType }</td>
 

 </tr>
</c:forEach>
 

</table>
</div>
 <script type="text/javascript">

$(".refresh").click(function(){
	
	$("#readForm").attr("action","/ssh1/read_readReal");

	$("#readForm").submit();
	});


$(".leave").click(function(){
	$("#readForm").attr("action","/ssh1/read_readLeave");

	$("#readForm").submit();
});

$(".month").click(function(){
	$("#readForm").attr("action","/ssh1/read_readMonth");

	$("#readForm").submit();
});
$(".day").click(function(){
	$("#readForm").attr("action","/ssh1/read_readMonth");

	$("#readForm").submit();
});
$(".parameter").click(function(){
	window.open("/ssh1/jsp/json1.jsp", "_blank", "toolbar=yes, location=no,directories=no, status=no, menubar=yes, scrollbars=yes, left=400px,top=100px,resizable=no, copyhistory=yes, width=400, height=400", false);
	//window.showModalDialog("/ssh1/jsp/parameter.jsp", "_blank", "toolbar=yes, location=no,directories=no, status=no, menubar=yes, scrollbars=yes, left=400px,top=100px,resizable=no, copyhistory=yes, width=400, height=400", false);
	

});

</script>
<script type="text/javascript" src="/ssh1/js/caidan.js"></script>

</body>
</html>