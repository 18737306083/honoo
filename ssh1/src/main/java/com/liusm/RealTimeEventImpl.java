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
						
							/*ˢ����ʾ*/
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
			if(realtime.getEventType().equals("����ˢ������")) {
				
				
			 if(state==0){
				    logger.info("����ˢ������");
				    logger.info("led1���ӳɹ�");
							
					sock1.sendTextAndSound("", "", 1);//��������
					sock1.sendTextAndSound("[t002]"+real.get(j).getName(),"17",0 );//��������ʾ�ı�
					//sock1.sendTextAndSound("[t003]"+simple.format(real.get(j).getDateTime()),"18" ,0);//��������ʾʱ��
			             }
					/*ip2*/
					if(getLedstart2()==0){
						int state2=sock2.connect(getLedip2(), getLedport2());	
						ConfigUtil.status=0;
						if(state2==0){
			        		logger.info(state2+"led2���ӳɹ�");
			   	       sock2.sendTextAndSound("", "", 1);//+real.get(j).getDateTime().toLocaleString()
		        	   sock2.sendTextAndSound("[t002]"+real.get(j).getName(),"17",0 );//real.get(j).getName()
					  // sock2.sendTextAndSound("[t003]"+simple.format(real.get(j).getDateTime()),"18" ,0);
					   sock2.disconnect();
					}			 
					}		}
					else if(realtime.getEventType().equals("��δע��")){
						if(state==0){
							logger.info(state+"���ӳɹ�");
						    logger.info("��δע��");							
						    sock1.sendTextAndSound("", "", 2);//+real.get(j).getDateTime().toLocaleString()
							sock1.sendTextAndSound("[t002]"+"��δע��","17",0);//real.get(j).getName()
						 //   sock1.sendTextAndSound("[t003]"+simple.format(real.get(j).getDateTime()),"18" ,0);
						}
								/*ip2*/
							if(getLedstart2()==0){
								int state2=sock2.connect(getLedip2(), getLedport2());	
								ConfigUtil.status=0;
								if(state2==0){
					        		logger.info(state2+"���ӳɹ�");
					        	sock2.sendTextAndSound("", "", 2);//+real.get(j).getDateTime().toLocaleString()
					        	sock2.sendTextAndSound("[t002]"+"��δע��","17",0 );//real.get(j).getName()
							//	sock2.sendTextAndSound("[t003]"+simple.format(real.get(j).getDateTime()),"18" ,0);
								sock2.disconnect();
					        	}
								}
								
								
							}
                             else if(realtime.getEventType().equals("����Ȩ����Ϣ")){
                            	 if(state==0){
                    			 logger.info(state+"���ӳɹ�");
                            	 logger.info("����Ȩ����Ϣ");          
                            	 sock1.sendTextAndSound("", "", 3);//���������ѹ���
                            	 sock1.sendTextAndSound("[t002]"+"����Ȩ��","17",0 );//��������ʾ�ı�
								// sock1.sendTextAndSound("[t003]"+simple.format(real.get(j).getDateTime()),"18" ,0);//��������ʾʱ��
                            	 }
									/*ip2*/
								if(getLedstart2()==0){	
								int state2=sock2.connect(getLedip2(), getLedport2());	
								ConfigUtil.status=0;
								if(state2==0){
						        		logger.info(state2+"���ӳɹ�");
						        	sock2.sendTextAndSound("", "", 3);//
						        	sock2.sendTextAndSound("[t002]"+"����Ȩ��","17",0 );//real.get(j).getName()
								//	sock2.sendTextAndSound("[t003]"+simple.format(real.get(j).getDateTime()),"18" ,0);
									sock2.disconnect();
						        	}
						        	
						        	}
							} 
							
							
							realtime.setPlay("0");
							record.updateLED(realtime);/*�޸�״̬Ϊ�Ѿ���ʾ0Ϊ�Ѿ���ʾ1Ϊδ��ʾ*/
						
				try {
					 if(state==0){
					
					sock1.disconnect();
					ConfigUtil.status=1;
					 }
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.err.println("����ʧ��!");
				}
				
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.err.println("����ʧ��!");
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
