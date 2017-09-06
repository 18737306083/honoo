package com.liusm;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import sun.misc.BASE64Decoder;

import com.lana.domain.Parameter;
import com.lana.domain.ReadRecord;
import com.lana.domain.TabCommand;
import com.lana.domain.TabPermission;
import com.lana.domain.TabRecord;
import com.lana.domain.TabUserPermInfo;
import com.lana.service.TabCommandService;
import com.lana.service.TabRecordService;
import com.lana.service.TabUserPermInfoService;
import com.lana.service.impl.TabCommandServiceImpl;
import com.opensymphony.xwork2.inject.ContainerBuilder.Command;

/**
 * Created by liusmchs on 2017/2/1 0001.
 */
@Component
public class ReadDevCallBackImpl implements ReadDevCallBack {
	@Resource
	private TabRecordService record;
	@Resource
	private TabCommandService command;
	@Resource
	private TabUserPermInfoService user;
	private String sn;
	private	int cmd;
	private String data;
	private int len;
	 JSONObject ob;
	    List<TabUserPermInfo> infoList;
    @Override
    public void callback(String sn, int cmd, String data, int len) {
    	this.sn=sn;
    	this.cmd=cmd;
    	this.data=data;
    	this.len=len;
        System.out.printf("callback sn: %s, cmd: %d, data: %s, len: %s \n",sn, cmd, data, len);
       if(data!=null &&!data.equals("")&&!data.equals("null")){
    	   System.out.println("进入");
    	   JSONObject json=new JSONObject(data);
    	JSONArray array=json.names();
    	System.out.println(array.getString(0)+"callback");
    	    if(array.getString(0).equals("TabUserPermInfo")){
    	    	System.out.println(array.getString(0)+"callback");
    	    	 JSONObject json2=new JSONObject(data);
    	     	
    	    		JSONArray array2=json.getJSONArray("TabUserPermInfo");
    	    	 //ob=;
    	    		
    	    		if(array2.length()>0){
    	    			for (int i = 0; i < array2.length(); i++) {
    	    				user.insertTabUser(parseJSon(array2.getJSONObject(i)));
						
    	    			}
    	    			
    	    			
    	    		}
    	    		
    	    	
    	    	
    	    }
    	    else if(array.getString(0).equals("TabCommand")){
    	    	System.out.println("Tabcommand");
    	    JSONArray 	jsonTab= json.getJSONArray("Tabcommand");
    	    	if(jsonTab.getJSONObject(0).names().getString(0).equals("DateTime")){
    	    		System.out.println("进入datetime");
    	    	String date=jsonTab.getJSONObject(0).getString("DateTime");
    	    	SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
    	    	
    	    	TabCommand tab=new TabCommand();
    	    	try {
					tab.setTime(simple.parse(date));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    	    		command.setTime(tab);
    	    	
    	    		
    	    	}
    	    	
    	    	
    	    }
    	    else if(array.getString(0).equals("TabRecord")){
    	    	
    	    	System.out.println("TabRecord");
        	    JSONArray 	jsonTab= json.getJSONArray("TabRecord");
        	    
        	    if(jsonTab!=null){
    	    	if(jsonTab.length()>0){
    	    		record.deleteDecordByAll();
    	    		for (int i = 0; i < jsonTab.length(); i++) {
						
    	    			
    	        	    JSONObject obRecord=jsonTab.getJSONObject(i);
    	        	     
    	        	    
    	        	  record.insertByReadRecord(parseJsonRecord( obRecord));
    	    			
					}
    	    	
        	    
    	    	}
        	    }
    	    }
    	    
    	    else if(array.getString(0).equals("TabDevParameters")){
    	    	
    	    	   JSONArray 	jsonTab= json.getJSONArray("TabDevParameters");
    	    JSONObject ob=	jsonTab.getJSONObject(0);
    	  JSONArray ar= ob.names();
    	  Parameter pa=new Parameter();
    	  pa.setId(1);
    	  pa.setName(ar.getString(0));
    	  pa.setValue(ob.getString(ar.getString(0)));
    	  System.out.println(ar.getString(0)+"paramterter");
    	  record.writeParamter(pa);
    	    }
    	    else if(array.getString(0).equals("TabPermission")){
    	    	
 	    	   JSONArray 	perssion= json.getJSONArray("TabPermission");
 	 //   JSONObject per=	perssion.getJSONObject(0);
 	   
	    if(perssion!=null){
    	if(perssion.length()>0){
    		//record.deleteDecordByAll();
    		for (int i = 0; i < perssion.length(); i++) {
				
    			
        	    JSONObject obPersion=perssion.getJSONObject(i);
        	     
        	    user.insertTabPersion(parsePerssion(obPersion));
        	  //record.insertByReadRecord(parseJsonRecord( obRecord));
    			
			}
    	
	    
    	}
	    }
 	    } 
    	    else if(array.getString(0).equals("IdentityCard")) {
    	    	
    	    	  JSONArray 	perssion= json.getJSONArray("IdentityCard");
    	    	
    	    	
    	    }
       }
        
    }
    public TabPermission parsePerssion(JSONObject ob){
    	//infoList =new ArrayList<TabPermission>();
    	 TabUserPermInfo info=new TabUserPermInfo();
    	    
    	//	if(read.getdata()!= null){
    		
    		

    		//System.out.println(dev.getdata()+"llllll");
    			// JSONObject json=new JSONObject(read.getdata());
    			//	JSONArray array= json.getJSONArray("TabPermission");
    			//	JSONObject ob=array.getJSONObject(0);
    				
    	TabPermission per=new TabPermission();
    	per.setPermID(ob.getString("PermID"));
    	per.setReaderID(ob.getString("ReaderID"));
    	per.setDoorID(ob.getString("DoorID"));
    	per.setVerifyMode(ob.getString("VerifyMode"));
    	per.setVerifyPasswd(ob.getString("VerifyPasswd"));
    	per.setWeekID(ob.getString("WeekID"));
    	per.setHolidayID(ob.getString("HolidayID"));
    	per.setGroupID(ob.getString("GroupID"));
    	per.setSameGroup(ob.getString("SameGroup"));
    	per.setGroupMethod(ob.getString("GroupMethod"));
    	per.setRemoteConfirm(ob.getString("RemoteConfirm"));
    	System.out.println(per.getPermID());
 //   System.out.println(per.getDoorID()+"卡ID"+per.getCardID());

   // infoList.add(per);
   //  }
    	 return per;
     }
    
    
    //base64字符串转化成图片  
    public static boolean GenerateImage(String imgStr)  
    {   //对字节数组字符串进行Base64解码并生成图片  
        if (imgStr == null) //图像数据为空  
            return false;  
        BASE64Decoder decoder = new BASE64Decoder();  
        try   
        {  
            //Base64解码  
            byte[] b = decoder.decodeBuffer(imgStr);  
            for(int i=0;i<b.length;++i)  
            {  
                if(b[i]<0)  
                {//调整异常数据  
                    b[i]+=256;  
                }  
            }  
            //生成jpeg图片  
            String imgFilePath = "D:\\360CloudUI\\tupian\\new.jpg";//新生成的图片  
            OutputStream out = new FileOutputStream(imgFilePath);      
            out.write(b);  
            out.flush();  
            out.close();  
            return true;  
        }   
        catch (Exception e)   
        {  
            return false;  
        }  
    }  
    
    
    public ReadRecord parseJsonRecord(JSONObject obRecord){
    	SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	
    	ReadRecord tab = new ReadRecord();
    	tab.setRecordIndex(obRecord.getInt("RecordIndex"));
    	
    //	System.out.println(tab.getRecordIndex()+"index");
    	try {
			tab.setDateTime(simple.parse(obRecord.getString("DateTime")));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	tab.setPin(obRecord.getString("Pin"));
    	tab.setName(obRecord.getString("Name"));
    	tab.setDepartment(obRecord.getString("Department"));
    	tab.setCardID(obRecord.getString("CardID"));
    	tab.setInputType(obRecord.getString("InputType"));
    	tab.setInputAddr(obRecord.getString("InputAddr"));
    	tab.setOutputType(obRecord.getString("OutputType"));
    	tab.setOutputAddr(obRecord.getString("OutputAddr"));
    	tab.setEventType(parseEventType(obRecord.getString("EventType")));
    	tab.setDirection(obRecord.getString("Direction"));
    	tab.setCardNum(obRecord.getString("CardNum"));
    	tab.setSN(sn);
    	return tab;
    }
   /* 解析事件类型*/
    public String parseEventType(String type){
    	String type1=type;
    	if(type.equals("0")){
    		type1="正常刷卡开门";
    	}
    	else if(type.equals("1")){
    		type1="远程开门";
		}
else if(type.equals("2")){
	type1="多卡开门";	
		}
else if(type.equals("3")){
	type1="密码开门";
}
else if(type.equals("4")){
	type1="首卡开门";
}
else if(type.equals("5")){
	type1="开门按扭开门";
}
else if(type.equals("6")){
	type1="自定义1输出";
}
else if(type.equals("7")){
	type1="自定义2输出";
}
else if(type.equals("8")){
	type1="自定义3输出";
}
else if(type.equals("9")){
	type1="自定义4输出";
}   	
else if(type.equals("10")){
	type1="多卡刷卡";
}    	
else if(type.equals("11")){
	type1="请求开门";
}   	
else if(type.equals("12")){
	type1="远程关门";
} 
else if(type.equals("13")){
	type1="紧急常开门";
} 
else if(type.equals("14")){
	type1="紧急常闭门";
} 
else if(type.equals("15")){
	type1="解除远程常开常闭";
} 	
else if(type.equals("16")){
	type1="触发联动事件";
} 
else if(type.equals("17")){
	type1="等待密码验证";
}    	
	
switch (type) {
case "1001":
	type1="卡未注册";
	break;
case "1002":
	type1="卡无权限信息";
	break;
case "1003":
	type1="卡片使用次数已完";
	break;
case "1004":
	type1="非法用户";
	break;
case "1005":
	type1="不在有效期内";
	break;
case "1006":
	type1="卡已挂失";
	break;
case "1007":
	type1="非法时段";
	break;
case "1008":
	type1="密码无效";
	break;
case "1009":
	type1="多卡无效";
	break;
	case "1010":
		type1="未刷首卡";
		break;	
	case "1011":
		type1="门在常闭时段";
		break;
	case "1012":
		type1="门在常开时段";
		break;
	case "1013":
		type1="多门互锁条件不成立";
		break;
	case "1014":
		type1="门被紧急常闭";
		break;
	case "1015":
		type1="门被紧急常开";
		break;
	case "1016":
		type1="识别码错误";
		break;
			
	case "1017":
		type1="二维码失效";
		break;
			
	case "1018":
		type1="门内人数已达上限";
		break;
	case "2001":
		type1="胁迫开门报警";
		break;
	case "2002":
		type1="门磁报警开始";
		break;
	case "2003":
		type1="门磁报警结束";
		break;
	case "2004":
		type1="读卡器离线报警";
		break;
	case "2005":
		type1="读卡器正常插入";
		break;
	case "2006":
		type1="门强开报警开始";
		break;
	case "2007":
		type1="门强开报警结束";
		break;
	case "2008":
		type1="控制器防拆报警";
		break;
	case "2009":
		type1="控制器市电断电报警";
		break;
	case "2010":
		type1="防潜回报警";
		break;
default:
	break;
}  	
    	
    	return type1;
    }
    public TabUserPermInfo parseJSon(JSONObject ob){
    	//infoList =new ArrayList<TabUserPermInfo>();
    	 TabUserPermInfo info=new TabUserPermInfo();
    	    
    	//	if(dev.getdata()!= null&&dev.getdata()!="" ){
    		
    	//	System.out.println(dev.getData()+"dev");

    		//System.out.println(dev.getdata()+"llllll");
  	  
    info.setPin(ob.getString("Pin"));
    info.setName(ob.getString("Name"));
    info.setDepartment(ob.getString("Department"));
    info.setCardID(ob.getString("CardID"));
    info.setPasswd(ob.getString("Passwd"));
    info.setUserState(ob.getString("UserState"));
    info.setValidTimes(ob.getString("ValidTimes"));
    info.setValidPeriodStart(ob.getString("ValidPeriodStart"));
    info.setValidPeriodEnd(ob.getString("ValidPeriodEnd"));
    info.setOpenDoorTime(ob.getString("OpenDoorTime"));
    info.setPermID(ob.getString("PermID"));
    info.setSN(sn);
   // infoList.add(info);
     
    	 return info;
     }



    public String getSN(){
    	
    	
    	return sn;
    }
    
    public String getdata(){
    	
    	 System.out.printf("getdata sn: %s, data: %s\n",sn,data);
    	 return data;	
    	
    }
    
    public List< String> getLeave(){
    	List< String> leave=new ArrayList<>();
    	leave.add(sn);
     	leave.add(data);
    	return leave;
    }
	public String getSn() {
		return sn;
	}
	public int getCmd() {
		return cmd;
	}
	public String getData() {
		return data;
	}
	public int getLen() {
		return len;
	}
	public TabCommandService getCommand() {
		return command;
	}
	public void setCommand(TabCommandService command) {
		this.command = command;
	}
	
    
}
