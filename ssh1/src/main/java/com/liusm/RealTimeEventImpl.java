package com.liusm;

import honoor.utils.ConfigUtil;
import honoor.utils.Sock1Utils;
import honoor.utils.Sock2Utils;





import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;




import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.Resource;














import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;














import com.lana.domain.RealTime;
import com.lana.service.TabRecordService;

/**
 * Created by liusmchs on 2017/2/1 0001.
 * 
 */
@Component
public class RealTimeEventImpl implements RealTimeEvent {
	private String sn=ConfigUtil.SN;
	private String info;
	private	String ledip1;
	private String	ledip2;
	private int ledport1;
	private int ledport2;
	private int ledstart2;	
	Logger logger=Logger.getLogger(RealTimeEventImpl.class); 		
	@Resource
	private TabRecordService record;

	@Override
	public void callback(String sn, String data) {
		this.sn = sn;
		this.info = info;
		int j;
		
		logger.info(new Date() + " realtime event, sn:" + sn
				+ ", info: " + data);
		if (data != null && !data.equals("") && !data.equals("null")) {
			
			JSONObject json = new JSONObject(data);
			JSONArray array = json.names();
			
			if (array.getString(0).equals("TabRecord")) {

				
				JSONArray jsonTab = json.getJSONArray("TabRecord");

				if (jsonTab != null) {
					if (jsonTab.length() > 0) {
					//	record.deleteDecordByAll();
						for (int i = 0; i < jsonTab.length(); i++) {

							JSONObject obRecord = jsonTab.getJSONObject(i);
							record.insertByRealTime(parseJsonRecord(obRecord));
						
							/*刷卡显示*/
			List<RealTime>	real=record.selectLED();	
			
			if(real!=null){
				
				for (j = 0; j < real.size(); j++) {
					
					
					try {
					RealTime realtime=real.get(j);
					
					Sock1Utils sock1=new Sock1Utils();
					Sock2Utils sock2=new Sock2Utils();
			/*ip1*/
					
				int state=sock1.connect(getLedip1(), getLedport1());
				ConfigUtil.status=0;
				SimpleDateFormat simple=new SimpleDateFormat("hh-mm-ss");
			if(realtime.getEventType().equals("正常刷卡开门")) {
				
				
			 if(state==0){
				    logger.info("正常刷卡开门");
				    logger.info("led1连接成功");
							
					sock1.sendTextAndSound("", "", 1);//播报声音
					sock1.sendTextAndSound("[t002]"+real.get(j).getName(),"17",0 );//第三行显示文本
					//sock1.sendTextAndSound("[t003]"+simple.format(real.get(j).getDateTime()),"18" ,0);//第四行显示时间
			             }
					/*ip2*/
					if(getLedstart2()==0){
						int state2=sock2.connect(getLedip2(), getLedport2());	
						ConfigUtil.status=0;
						if(state2==0){
			        		logger.info(state2+"led2连接成功");
			   	       sock2.sendTextAndSound("", "", 1);//+real.get(j).getDateTime().toLocaleString()
		        	   sock2.sendTextAndSound("[t002]"+real.get(j).getName(),"17",0 );//real.get(j).getName()
					  // sock2.sendTextAndSound("[t003]"+simple.format(real.get(j).getDateTime()),"18" ,0);
					   sock2.disconnect();
					}			 
					}		}
					else if(realtime.getEventType().equals("卡未注册")){
						if(state==0){
							logger.info(state+"连接成功");
						    logger.info("卡未注册");							
						    sock1.sendTextAndSound("", "", 2);//+real.get(j).getDateTime().toLocaleString()
							sock1.sendTextAndSound("[t002]"+"卡未注册","17",0);//real.get(j).getName()
						 //   sock1.sendTextAndSound("[t003]"+simple.format(real.get(j).getDateTime()),"18" ,0);
						}
								/*ip2*/
							if(getLedstart2()==0){
								int state2=sock2.connect(getLedip2(), getLedport2());	
								ConfigUtil.status=0;
								if(state2==0){
					        		logger.info(state2+"连接成功");
					        	sock2.sendTextAndSound("", "", 2);//+real.get(j).getDateTime().toLocaleString()
					        	sock2.sendTextAndSound("[t002]"+"卡未注册","17",0 );//real.get(j).getName()
							//	sock2.sendTextAndSound("[t003]"+simple.format(real.get(j).getDateTime()),"18" ,0);
								sock2.disconnect();
					        	}
								}
								
								
							}
                             else if(realtime.getEventType().equals("卡无权限信息")){
                            	 if(state==0){
                    			 logger.info(state+"连接成功");
                            	 logger.info("卡无权限信息");          
                            	 sock1.sendTextAndSound("", "", 3);//播报卡卡已过期
                            	 sock1.sendTextAndSound("[t002]"+"卡无权限","17",0 );//第三行显示文本
								// sock1.sendTextAndSound("[t003]"+simple.format(real.get(j).getDateTime()),"18" ,0);//第四行显示时间
                            	 }
									/*ip2*/
								if(getLedstart2()==0){	
								int state2=sock2.connect(getLedip2(), getLedport2());	
								ConfigUtil.status=0;
								if(state2==0){
						        		logger.info(state2+"连接成功");
						        	sock2.sendTextAndSound("", "", 3);//
						        	sock2.sendTextAndSound("[t002]"+"卡无权限","17",0 );//real.get(j).getName()
								//	sock2.sendTextAndSound("[t003]"+simple.format(real.get(j).getDateTime()),"18" ,0);
									sock2.disconnect();
						        	}
						        	
						        	}
							} 
							
							
							realtime.setPlay("0");
							record.updateLED(realtime);/*修改状态为已经显示0为已经显示1为未显示*/
						
				try {
					 if(state==0){
					
					sock1.disconnect();
					ConfigUtil.status=1;
					 }
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.err.println("连接失败!");
				}
				
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.err.println("连接失败!");
				}
				
								
								
								
								
					
				}
				
				
				
				
			}
							
							
							
						}

					}
				}
			}

		}

	}
    public RealTime parseJsonRecord(JSONObject obRecord){
    	SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	
    	RealTime tab = new RealTime();
    	
    	tab.setRecordIndex(obRecord.getInt("RecordIndex"));
    	
    	
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
    	tab.setInputType(String.valueOf(obRecord.getInt("InputType")));
    	tab.setInputAddr(String.valueOf(obRecord.getInt("InputAddr")));
    	tab.setOutputType(String.valueOf(obRecord.getInt("OutputType")));
    	tab.setOutputAddr(String.valueOf(obRecord.getInt("OutputAddr")));
    	tab.setEventType(parseEventType(String.valueOf(obRecord.getInt("EventType"))));
    	tab.setDirection(String.valueOf(obRecord.getInt("Direction")));
    	tab.setCardNum(String.valueOf(obRecord.getInt("CardNum")));
    	tab.setSN(sn);
    	tab.setPlay("1");
    	return tab;
    }
    
    public String parseJSON(String info){
    	
    	
    	
    	return "";
    	
    }
	public String getSn() {
		return sn;
	}
	public String getInfo() {
		return info;
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
	public TabRecordService getRecord() {
		return record;
	}
	public void setRecord(TabRecordService record) {
		this.record = record;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getLedip1() {
		return ledip1;
	}
	@Value("#{prop.ledip1}")
	public void setLedip1(String ledip1) {
		this.ledip1 = ledip1;
	}
	public String getLedip2() {
		return ledip2;
	}
	@Value("#{prop.ledip2}")
	public void setLedip2(String ledip2) {
		this.ledip2 = ledip2;
	}
	public int getLedport1() {
		return ledport1;
	}
	@Value("#{prop.ledport1}") 
	public void setLedport1(int ledport1) {
		this.ledport1 = ledport1;
	}
	public int getLedport2() {
		return ledport2;
	}
	@Value("#{prop.ledport2}") 
	public void setLedport2(int ledport2) {
		this.ledport2 = ledport2;
	}
	public int getLedstart2() {
		return ledstart2;
	}
	@Value("#{prop.ledstart2}") 
	public void setLedstart2(int ledstart2) {
		this.ledstart2 = ledstart2;
	}


}
