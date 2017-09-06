package com.lana.action;

import honoor.utils.ConfigUtil;
import honoor.utils.Listerner;
import honoor.utils.Sock1Utils;
import honoor.utils.Sock2Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.lana.domain.TabRecord;
import com.lana.service.TabRecordService;
import com.lana.utils.NoticeUtils;
import com.liusm.ClientConnectImpl;
import com.liusm.ClientDisconnectImpl;
import com.liusm.EventImpl;
import com.liusm.ReadDevCallBackImpl;
import com.liusm.RealTimeEventImpl;
import com.liusm.SdkManageImpl;
import com.liusm.SdkManageImpl2;
import com.liusm.WriteDevCallBackImpl;
import com.liusm.SdkManageImpl.ServiceCallBack;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/*启动控制器
 * 配置ip和端口
 * 
 * 
 * 
 * */
@Controller
@Scope("prototype")
public class FirstAction extends ActionSupport implements ServletRequestAware {
	
	
	

	public String submitData()  {
		String path;
		String path2;
		String hostAddress;
		InetAddress address;
	
		 Sock1Utils sock1=new Sock1Utils();
			Sock2Utils sock2=new Sock2Utils();
			SimpleDateFormat simple=new SimpleDateFormat("HH:mm");
		File file=new File("");
		String sep = File.separator;

		String str=file.getAbsolutePath();
		
		 try {
			address = InetAddress.getLocalHost();
			 hostAddress = address.getHostAddress();
			 if(getControllstart()==0){
					
					setKip1(getControllip());
					setKport1(getControllport1());
				}
				else {
					setKip1(hostAddress);
					setKport1(getControllport1());
				}
	//	String	path1=str.split("bin")[0]+"webapps\\led_sdk\\ServiceConfig.cf";
			 path="D:"+sep+"Honoo_new"+sep+"tools"+sep+"Demo_2.2.4"+sep+"Demo_x64"+sep+"ServiceConfig.cf";
			// path=	"D:"+sep+"Honoo_new"+sep+"honooled"+sep+"webapps"+sep+"led_sdk"+sep+"ServiceConfig.cf";
			path2=str+"\\webapps\\led_sdk\\ServiceConfig.cf";
			 logger.info("开始连接SDK");	
			 System.out.println(str);
			 
			 if(str.endsWith("bin")){//str.split("bin")[0]+"webapps\\led_sdk\\ServiceConfig.cf"
			//logger.info("本地启动"+getKip1()+":" +getKport1()+str.split("bin")[0]+"webapps\\led_sdk\\ServiceConfig.cf");	
				 sdkManageImpl2.SEC_PUSH_StartServer(getKip1()+":" +getKport1(),path);
					sdkManageImpl2.SEC_PUSH_SetServiceCallBack(cc, cd, rte, wdc, rdc);
					ConfigUtil.sdk=2;
			 }else{
				 logger.info("服务启动"+getKip1()+getKport1());	
				 //str+"\\webapps\\led_sdk\\ServiceConfig.cf"
				sdkManageImpl.SEC_PUSH_StartServer(getKip1()+":" +getKport1(),path);
				sdkManageImpl.SEC_PUSH_SetServiceCallBack(cc, cd, rte, wdc, rdc);
				ConfigUtil.sdk=0;
			 }	
		} catch (UnknownHostException e) {
			
			System.out.println("连接错误!");
		}
		
		 
		 /*LED每分钟显示时间*/
		 Timer timer=new Timer();
		  	 
		 timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				if(ConfigUtil.status==1){
				System.out.println("正常显示时间");
				
//第一次连接				
				
				 int sock1Satus=sock1.connect(getLedip1(), getLedport1());
				 int sock2Satus = 1;
				if(getLedstart2()==0){
					sock2Satus=sock2.connect(getLedip2(), getLedport2());	
				}
				if(sock1Satus==0){
			sock1.sendTextAndSound("[t000]"+simple.format(new Date()),"18",0 );//real.get(j).getName()
				}
			if(getLedstart2()==0){
				if(sock2Satus==0){
		sock2.sendTextAndSound("[t000]"+simple.format(new Date()),"18",0 );//real.get(j).getName()
				}
			}
try {
	if(sock1Satus==0){
	sock1.disconnect();
	
	}
	if(getLedstart2()==0){
		if(sock2Satus==0){
	sock2.disconnect();
		}
	}
} catch (IOException e) {
	// TODO Auto-generated catch block
	System.out.println("发送时间错误,重新发送");
	
//第二次重新连接	
	if(ConfigUtil.status==1){
		
		 int sock21Satus=sock1.connect(getLedip1(), getLedport1());
		 int sock22Satus = 1;
		if(getLedstart2()==0){
			sock22Satus=sock2.connect(getLedip2(), getLedport2());	
		}
		if(sock21Satus==0){
	sock1.sendTextAndSound("[t000]"+simple.format(new Date()),"18",0 );//real.get(j).getName()
		}
	if(getLedstart2()==0){
		if(sock22Satus==0){
sock2.sendTextAndSound("[t000]"+simple.format(new Date()),"18",0 );//real.get(j).getName()
		}
	}
try {
	if(sock21Satus==0){
sock1.disconnect();
	}
if(getLedstart2()==0){
	if(sock22Satus==0){
sock2.disconnect();
	}
}
} catch (IOException e1) {
// TODO Auto-generated catch block
System.out.println("发送时间错误,重新发送");
}
		

}
				
}		
			}
				else{
					/*如何正在显示其他等待2s*/
				timer.schedule(new TimerTask() {
					
						@Override
						public void run() {
							// TODO Auto-generated method stub
							System.out.println("冲突显示时间");
//时间冲突延迟2s连接
							int sock31Satus = sock1.connect(getLedip1(),
									getLedport1());
							int sock32Satus = 1;
							if (getLedstart2() == 0) {

								sock2.connect(getLedip2(), getLedport2());

							}
							if (sock31Satus == 0) {
								sock1.sendTextAndSound(
										"[t000]" + simple.format(new Date()),
										"18", 0);// real.get(j).getName()
							}
							if (getLedstart2() == 0) {
								if (sock32Satus == 0) {
									sock2.sendTextAndSound(
											"[t000]"
													+ simple.format(new Date()),
											"18", 0);// real.get(j).getName()
								}
							}
							try {
								if (sock31Satus == 0) {
									sock1.disconnect();
								}
								if (getLedstart2() == 0) {
									if (sock32Satus == 0) {
										sock2.disconnect();
									}
								}
							} catch (IOException e) {
								// TODO Auto-generated catch block
								System.out.println("发送时间错误,重新发送");
//第2次重新连接
								int sock41Satus = sock1.connect(getLedip1(),
										getLedport1());
								int sock42Satus = 1;
								if (getLedstart2() == 0) {
									sock42Satus=sock2.connect(getLedip2(), getLedport2());
								}
								if (sock41Satus == 0) {
									sock1.sendTextAndSound(
											"[t000]"
													+ simple.format(new Date()),
											"18", 0);// real.get(j).getName()

								}
								if (getLedstart2() == 0) {
									if (sock42Satus == 0) {
										sock2.sendTextAndSound("[t000]"
												+ simple.format(new Date()),
												"18", 0);// real.get(j).getName()
									}
								}
								try {
									if (sock41Satus == 0) {
										sock1.disconnect();
									}
									if (getLedstart2() == 0) {
										if (sock42Satus == 0) {
											sock2.disconnect();
										}
									}
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									System.out.println("发送失败");

								}
							}
						}
				}, 2000);
				
				
			}
				
			}
			
		}, 0, 60*1000);	
		return "index";
	
	}

	// 开启服务
	@SuppressWarnings("unused")
	public String startSdkService() throws UnknownHostException {
	  request.setAttribute("switchs", sdkManageImpl.getResult());
	   request.setAttribute("ipAddres", getIp());
	  if( ConfigUtil.sdk==2){
		  SdkManageImpl2.ServiceCallBack.INSTANCE.SEC_PUSH_SetServiceCallBack(cc, cd, rte, wdc, rdc);
	  }else{
		  
		  
		  SdkManageImpl.ServiceCallBack.INSTANCE.SEC_PUSH_SetServiceCallBack(cc, cd, rte, wdc, rdc);
 
		  
	  }
	   
	   return "index";
	}

	
	public String pushData() {
		// if (NoticeUtils.notice == 1) {
		data1 = tabRecordService.selectByRecord();
		NoticeUtils.notice = 0;
		ActionContext.getContext().getValueStack().push(data1);
		return "pushdata";
	}
	
	
	
	public String readData() {
		String time;
		JSONObject json;
		String data;
		 if( ConfigUtil.sdk==2){
			 SdkManageImpl2.ServiceCallBack.INSTANCE.SEC_PUSH_ReadTableData(SN1, 1,
						"{\"TabCommand\":[{\"DateTime\":\"\"}]}", 32); 
		 }else{
			 SdkManageImpl.ServiceCallBack.INSTANCE.SEC_PUSH_ReadTableData(SN1, 1,
						"{\"TabCommand\":[{\"DateTime\":\"\"}]}", 32);
			 
		 }
		
		data = rdc.getdata();
	    json = new JSONObject(data);
		JSONArray array = json.getJSONArray("TabCommand");
		time = array.getJSONObject(0).getString("DateTime");
		System.out.println(time);
		ActionContext.getContext().getValueStack().push(time);
		return "read";

	}

	public String getTime() {

		return "time";
	}

	public String deleteLEDRecord(){
		System.out.println("delete");
		tabRecordService.deleteLED();
		ActionContext.getContext().getValueStack().push("成功");
		return "read";
	}
	
	


public String selecte(){
	
	ActionContext.getContext().getValueStack().push("success");
	return "read";
}

private	String ledip1;
private String	ledip2;
private int ledport1;
private int ledport2;
private int ledstart2;	
private String controllip;
private int controllstart;
private String  controllport1;
HttpServletRequest request;
@Resource
SdkManageImpl sdkManageImpl;
@Resource
SdkManageImpl2 sdkManageImpl2;
@Resource
ClientConnectImpl cc;
@Resource
ClientDisconnectImpl cd;
@Resource
RealTimeEventImpl rte;
@Resource
WriteDevCallBackImpl wdc;
@Resource
ReadDevCallBackImpl rdc;
@Resource
TabRecordService tabRecordService;
@Resource
RealTimeEventImpl rti=null;
Logger logger=Logger.getLogger(FirstAction.class); 
@Resource
EventImpl evet=null;
List<TabRecord> data1;
private String ip="";
private String svPort="";
private String SN="";
private String SN1=ConfigUtil.SN;

/*ip配置*/
/*ip1为本机ip*/

private String kport1;
private String kip1;


	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		request = arg0;
	}

	public TabRecordService getTabRecordService() {
		return tabRecordService;
	}

	public void setTabRecordService(TabRecordService tabRecordService) {
		this.tabRecordService = tabRecordService;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public SdkManageImpl getSdkManageImpl() {
		return sdkManageImpl;
	}

	public void setSdkManageImpl(SdkManageImpl sdkManageImpl) {
		this.sdkManageImpl = sdkManageImpl;
	}

	public ClientConnectImpl getCc() {
		return cc;
	}

	public void setCc(ClientConnectImpl cc) {
		this.cc = cc;
	}

	public ClientDisconnectImpl getCd() {
		return cd;
	}

	public void setCd(ClientDisconnectImpl cd) {
		this.cd = cd;
	}

	public RealTimeEventImpl getRte() {
		return rte;
	}

	public void setRte(RealTimeEventImpl rte) {
		this.rte = rte;
	}

	public WriteDevCallBackImpl getWdc() {
		return wdc;
	}

	public void setWdc(WriteDevCallBackImpl wdc) {
		this.wdc = wdc;
	}

	public ReadDevCallBackImpl getRdc() {
		return rdc;
	}

	public void setRdc(ReadDevCallBackImpl rdc) {
		this.rdc = rdc;
	}

	public List<TabRecord> getData() {
		return data1;
	}

	public void setData(List<TabRecord> data) {
		this.data1 = data;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getSvPort() {
		return svPort;
	}

	public void setSvPort(String svPort) {
		this.svPort = svPort;
	}

	public EventImpl getEvet() {
		return evet;
	}

	public void setEvet(EventImpl evet) {
		this.evet = evet;
	}

	public String getSN() {
		return SN;
	}
	   
	public void setSN(String sN) {
		SN = sN;
	}

	
	
	public String getKport1() {
		return kport1;
	}
	
	public void setKport1(String kport1) {
		this.kport1 = kport1;
	}
	public SdkManageImpl2 getSdkManageImpl2() {
		return sdkManageImpl2;
	}
	public void setSdkManageImpl2(SdkManageImpl2 sdkManageImpl2) {
		this.sdkManageImpl2 = sdkManageImpl2;
	}

	public String getKip1() {
		return kip1;
	}

	public void setKip1(String kip1) {
		this.kip1 = kip1;
	}

	public String getControllip() {
		return controllip;
	}
	@Value("#{prop.controllip}")
	public void setControllip(String controllip) {
		this.controllip = controllip;
	}

	public int getControllstart() {
		return controllstart;
	}
	@Value("#{prop.controllstart}")
	public void setControllstart(int controllstart) {
		this.controllstart = controllstart;
	}

	public String getControllport1() {
		return controllport1;
	}
	@Value("#{prop.controllport1}")
	public void setControllport1(String controllport1) {
		this.controllport1 = controllport1;
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
