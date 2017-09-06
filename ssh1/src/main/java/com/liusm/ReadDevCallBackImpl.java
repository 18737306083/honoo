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
    	   System.out.println("����");
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
    	    		System.out.println("����datetime");
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
 //   System.out.println(per.getDoorID()+"��ID"+per.getCardID());

   // infoList.add(per);
   //  }
    	 return per;
     }
    
    
    //base64�ַ���ת����ͼƬ  
    public static boolean GenerateImage(String imgStr)  
    {   //���ֽ������ַ�������Base64���벢����ͼƬ  
        if (imgStr == null) //ͼ������Ϊ��  
            return false;  
        BASE64Decoder decoder = new BASE64Decoder();  
        try   
        {  
            //Base64����  
            byte[] b = decoder.decodeBuffer(imgStr);  
            for(int i=0;i<b.length;++i)  
            {  
                if(b[i]<0)  
                {//�����쳣����  
                    b[i]+=256;  
                }  
            }  
            //����jpegͼƬ  
            String imgFilePath = "D:\\360CloudUI\\tupian\\new.jpg";//�����ɵ�ͼƬ  
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
   /* �����¼�����*/
    public String parseEventType(String type){
    	String type1=type;
    	if(type.equals("0")){
    		type1="����ˢ������";
    	}
    	else if(type.equals("1")){
    		type1="Զ�̿���";
		}
else if(type.equals("2")){
	type1="�࿨����";	
		}
else if(type.equals("3")){
	type1="���뿪��";
}
else if(type.equals("4")){
	type1="�׿�����";
}
else if(type.equals("5")){
	type1="���Ű�Ť����";
}
else if(type.equals("6")){
	type1="�Զ���1���";
}
else if(type.equals("7")){
	type1="�Զ���2���";
}
else if(type.equals("8")){
	type1="�Զ���3���";
}
else if(type.equals("9")){
	type1="�Զ���4���";
}   	
else if(type.equals("10")){
	type1="�࿨ˢ��";
}    	
else if(type.equals("11")){
	type1="������";
}   	
else if(type.equals("12")){
	type1="Զ�̹���";
} 
else if(type.equals("13")){
	type1="����������";
} 
else if(type.equals("14")){
	type1="����������";
} 
else if(type.equals("15")){
	type1="���Զ�̳�������";
} 	
else if(type.equals("16")){
	type1="���������¼�";
} 
else if(type.equals("17")){
	type1="�ȴ�������֤";
}    	
	
switch (type) {
case "1001":
	type1="��δע��";
	break;
case "1002":
	type1="����Ȩ����Ϣ";
	break;
case "1003":
	type1="��Ƭʹ�ô�������";
	break;
case "1004":
	type1="�Ƿ��û�";
	break;
case "1005":
	type1="������Ч����";
	break;
case "1006":
	type1="���ѹ�ʧ";
	break;
case "1007":
	type1="�Ƿ�ʱ��";
	break;
case "1008":
	type1="������Ч";
	break;
case "1009":
	type1="�࿨��Ч";
	break;
	case "1010":
		type1="δˢ�׿�";
		break;	
	case "1011":
		type1="���ڳ���ʱ��";
		break;
	case "1012":
		type1="���ڳ���ʱ��";
		break;
	case "1013":
		type1="���Ż�������������";
		break;
	case "1014":
		type1="�ű���������";
		break;
	case "1015":
		type1="�ű���������";
		break;
	case "1016":
		type1="ʶ�������";
		break;
			
	case "1017":
		type1="��ά��ʧЧ";
		break;
			
	case "1018":
		type1="���������Ѵ�����";
		break;
	case "2001":
		type1="в�ȿ��ű���";
		break;
	case "2002":
		type1="�Ŵű�����ʼ";
		break;
	case "2003":
		type1="�Ŵű�������";
		break;
	case "2004":
		type1="���������߱���";
		break;
	case "2005":
		type1="��������������";
		break;
	case "2006":
		type1="��ǿ��������ʼ";
		break;
	case "2007":
		type1="��ǿ����������";
		break;
	case "2008":
		type1="���������𱨾�";
		break;
	case "2009":
		type1="�������е�ϵ籨��";
		break;
	case "2010":
		type1="��Ǳ�ر���";
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
