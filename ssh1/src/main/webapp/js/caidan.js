
$(function(){
	$(".lookdoor").hide();
	
	$(".lookup").hide();
	$(".lookdevice").hide();
});


$(".readBtn").click(function(){

	
$(".lookup").toggle(); 
});


$(".devicemanager").click(function(){

	$("#readForm").attr("action","/ssh1/first_startSdkService");

	$("#readForm").submit();
	
});

$(".lookUser").click(function(){

	$("#readForm").attr("action","/ssh1/read_readUser");

	$("#readForm").submit();
	
});


$(".lookperssion").click(function(){

	$("#readForm").attr("action","/ssh1/perssion_getPersion");
	$("#readForm").submit();
	 
	
});


$("#addUser").click(function(){

	window.open("/ssh1/jsp/user.jsp", "_blank", "toolbar=yes, directories=no, status=no, menubar=yes, scrollbars=yes, left=400px,top=100px,resizable=no, copyhistory=yes, width=400, height=400", false);

		
	});

	$("#addperssion").click(function(){

		window.open("/ssh1/jsp/addPerssion.jsp", "_blank", "toolbar=yes,directories=no, status=no, menubar=yes, scrollbars=yes, left=400px,top=100px,resizable=no, copyhistory=yes, width=400, height=400", false);

			
		});

	

	 $(".kaimen").click(function(){
		
	$("#readForm").attr("action","/ssh1/send.jsp");

	$("#readForm").submit();
	});

 $(".sendBtn").click(function(){
	 $(".lookdevice").toggle(); 
/*$("#readForm").attr("action","/ssh1/send.jsp");

$("#readForm").submit();*/
}); 
 /*读取测试  */
/*  $(".readBtn").click(function(){
	
$("#readForm").attr("action","/ssh1/read.jsp");

$("#readForm").submit();
}); */
 $(".perssionBtn").click(function(){
	 $(".lookdoor").toggle(); 
	/*$("#readForm").attr("action","/ssh1/read_readReal");

	$("#readForm").submit();*/
	});

 $(".timeBtn").click(function(){
		
	$("#readForm").attr("action","/ssh1/lock_getTime");

	$("#readForm").submit();
	});

 $(".otherBtn").click(function(){
		
	$("#readForm").attr("action","/ssh1/lock_doorLock");

	$("#readForm").submit();
	});
 
 
$(".lookrecord").click(function(){

	$("#readForm").attr("action","/ssh1/read_leave");

	$("#readForm").submit();
	
});
