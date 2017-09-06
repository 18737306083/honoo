package com.lana.action;

import honoor.utils.ConfigUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.Resource;

import org.apache.struts2.json.JSONUtil;
import org.apache.struts2.json.annotations.JSON;
import org.apache.tomcat.jni.Time;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.lana.domain.TabPermission;
import com.lana.domain.TabUserPermInfo;
import com.lana.service.TabUserPermInfoService;
import com.liusm.ReadDevCallBackImpl;
import com.liusm.SdkManageImpl;
import com.liusm.SdkManageImpl2;
import com.liusm.SdkManageImpl.ServiceCallBack;
import com.liusm.WriteDevCallBackImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/** 
 * @author 作者 卢保  E-mail: 1914045211@qq.com
 * @version 创建时间：2017年7月28日 上午10:54:37 
 * 类说明 
 * 权限相关
 */
@Controller
@Scope("prototype")
public class PersionAction extends ActionSupport{

	
	/**
	 * 
	 * 
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
public String addUser()   {
	//System.out.println("adduser");
//System.out.println(getPin()+getPermID()+getCardID());
	String str="{\"TabUserPermInfo\":[{\"UserState\":0,"
			+ "\"ValidPeriodEnd\":\"2017-08-12 10:10:10\",\"PermID\":15,"
			+ "\"Pin\":\"3695369291\",\"ValidTimes\":0,"
			+ "\"ValidPeriodStart\":\"2017-08-11 10:10:10\","
			+ "\"CardID\":\"3695369291\",\"Name\":\"蒋政龙\"}]}";
	 if( ConfigUtil.sdk==2){
		
			 
	 SdkManageImpl2.ServiceCallBack.INSTANCE
           .SEC_PUSH_WriteTableData(
					ConfigUtil.SN,
					1,"{\"TabUserPermInfo\":[{\"UserState\":0,"
							+ "\"ValidPeriodEnd\":\"2017-08-12 10:10:10\",\"PermID\":15,"
							+ "\"Pin\":\"3695369291\",\"ValidTimes\":0,"
							+ "\"ValidPeriodStart\":\"2017-08-11 10:10:10\","
							+ "\"CardID\":\"3695369291\",\"Name\":\"蒋政龙\"}]}"

					,440);}else {
						SdkManageImpl.ServiceCallBack.INSTANCE
						           .SEC_PUSH_WriteTableData(
											ConfigUtil.SN,
											1,"{\"TabUserPermInfo\":[{\"UserState\":0,"
													+ "\"ValidPeriodEnd\":\"2017-08-12 10:10:10\",\"PermID\":15,"
													+ "\"Pin\":\"3695369291\",\"ValidTimes\":0,"
													+ "\"ValidPeriodStart\":\"2017-08-11 10:10:10\","
													+ "\"CardID\":\"3695369291\",\"Name\":\"蒋政龙\"}]}"

											,440);
						
					}
		 
		 
	 
	ActionContext.getContext().getValueStack().push("ok");

	return "getAllpersion";
                             }
/*//"{\"TabUserPermInfo\":[{\"Pin\":\""+getPin()+"\",\"CardID\":\""+getCardID()+"\",\"Name\":\""+getName()+"\",\"Department\":\""
+getDepartment()+"\",\"Passwd\":\""+getPasswd()+"\",\"UserState\":\""+getUserState()+"\",\"ValidTimes\":\""
+getValidTimes()+"\",\"ValidPeriodStart\":\""+getValidPeriodStart()+"\",\"ValidPeriodEnd\":\""+getValidPeriodEnd()+"\",\"PermID\":\""
+getPermID()+"\"}]}"*/

	 public String addPersion(){
		 int res = ServiceCallBack.INSTANCE
					.SEC_PUSH_WriteTableData(
							SN1,
							1,
							"{\"TabPermission\":[{\"PermID\":\""+getPermID()+"\",\"DoorID\":\""+getDoorID()+"\",\"VerifyPasswd\":\""+getVerifyPasswd()
							+"\",\"VerifyMode\":\""+getVerifyMode()+"\",\"WeekID\":\""+getWeekID()
							+"\",\"HolidayID\":\""+getHolidayID()+"\",\"GroupID\":\""+getGroupID()+"\",\"SameGroup\":\""+getSameGroup()+"\",\"GroupMethod\":\""+getGroupMethod()+"\"}]}",500);
			
		 		 ActionContext.getContext().getValueStack().push("ok");
			return "getAllpersion";
	 }
	 
	 
	 
	public String getAllPersion() {
		ServiceCallBack.INSTANCE.SEC_PUSH_ReadTableData(SN1, 1,
				"{\"TabPermission\":[{\"Condition\":\"\"}]}", 100);
		perssioninfo = persion.selectPersion();
		ActionContext.getContext().getValueStack().push(perssioninfo);
		return "getAllpersion";
	}
	
	
	 
 public String getPersion(){
	 ServiceCallBack.INSTANCE.SEC_PUSH_ReadTableData(SN1, 1, "{\"TabPermission\":[{\"Condition\":\"\"}]}", 100);
				 perssioninfo=persion.selectPersion();
		 return "lookpersion";
	 }
 
 
 
 
 @Resource
	WriteDevCallBackImpl write;
	@Resource
	SdkManageImpl sdkManageImpl;
	@Resource
	ReadDevCallBackImpl  read;
	/*添加用户*/
	@Resource
	TabUserPermInfoService persion;
	private String Pin="";
	private String Name="";
	private String Card="";
	private String PermID="";
	private String permid2="";
	private String doorid="";
	private String	SN="";
	private String SN1=ConfigUtil.SN;
	private String Department="";
	
	private String Passwd="";
	private String	UserState="";
	private String ValidTimes="";
	private String ValidPeriodStart="";
	private String ValidPeriodEnd="";
	List<TabPermission> perssioninfo;
	/*添加权限*/
	List<TabPermission> infoList;
	private String	VerifyPasswd="";
	private String CardID="";
	private String 	ReaderID="";
	private String 	DoorID="";
	private String 	VerifyMode="";
	private String 	WeekID="";
	private String 	HolidayID="";
	private String 	GroupID="";
	private String SameGroup="";
	private String GroupMethod="";
	private String 	RemoteConfirm="";
	public String getPin() {
		return Pin;
	}
	public void setPin(String pin) {
		Pin = pin;
	}
	public String getCard() {
		return Card;
	}
	public void setCard(String card) {
		Card = card;
	}
	public String getPermID() {
		return PermID;
	}
	public void setPermID(String permID) {
		PermID = permID;
	}
	public String getPermid2() {
		return permid2;
	}
	public void setPermid2(String permid2) {
		this.permid2 = permid2;
	}
	public String getDoorid() {
		return doorid;
	}
	public void setDoorid(String doorid) {
		this.doorid = doorid;
	}
	public String getVerifyPasswd() {
		return VerifyPasswd;
	}
	public void setVerifyPasswd(String verifyPasswd) {
		VerifyPasswd = verifyPasswd;
	}
	public String getCardID() {
		return CardID;
	}
	public void setCardID(String cardID) {
		CardID = cardID;
	}
	
	public List<TabPermission> getPerssioninfo() {
		return perssioninfo;
	}
	public void setPerssioninfo(List<TabPermission> perssioninfo) {
		this.perssioninfo = perssioninfo;
	}
	public void setPersion(TabUserPermInfoService persion) {
		this.persion = persion;
	}
	public String getReaderID() {
		return ReaderID;
	}
	public void setReaderID(String readerID) {
		ReaderID = readerID;
	}
	public String getDoorID() {
		return DoorID;
	}
	public void setDoorID(String doorID) {
		DoorID = doorID;
	}
	public String getVerifyMode() {
		return VerifyMode;
	}
	public void setVerifyMode(String verifyMode) {
		VerifyMode = verifyMode;
	}
	public String getWeekID() {
		return WeekID;
	}
	public void setWeekID(String weekID) {
		WeekID = weekID;
	}
	public String getHolidayID() {
		return HolidayID;
	}
	public void setHolidayID(String holidayID) {
		HolidayID = holidayID;
	}
	public String getGroupID() {
		return GroupID;
	}
	public void setGroupID(String groupID) {
		GroupID = groupID;
	}
	public String getSameGroup() {
		return SameGroup;
	}
	public void setSameGroup(String sameGroup) {
		SameGroup = sameGroup;
	}
	public String getGroupMethod() {
		return GroupMethod;
	}
	public void setGroupMethod(String groupMethod) {
		GroupMethod = groupMethod;
	}
	public String getRemoteConfirm() {
		return RemoteConfirm;
	}
	public void setRemoteConfirm(String remoteConfirm) {
		RemoteConfirm = remoteConfirm;
	}
	public SdkManageImpl getSdkManageImpl() {
		return sdkManageImpl;
	}
	public void setSdkManageImpl(SdkManageImpl sdkManageImpl) {
		this.sdkManageImpl = sdkManageImpl;
	}
	public ReadDevCallBackImpl getRead() {
		return read;
	}
	public void setRead(ReadDevCallBackImpl read) {
		this.read = read;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getSN() {
		return SN;
	}
	public void setSN(String sN) {
		SN = sN;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	public String getPasswd() {
		return Passwd;
	}
	public void setPasswd(String passwd) {
		Passwd = passwd;
	}
	public String getUserState() {
		return UserState;
	}
	public void setUserState(String userState) {
		UserState = userState;
	}
	public String getValidTimes() {
		return ValidTimes;
	}
	public void setValidTimes(String validTimes) {
		ValidTimes = validTimes;
	}
	public String getValidPeriodStart() {
		return ValidPeriodStart;
	}
	public void setValidPeriodStart(String validPeriodStart) {
		ValidPeriodStart = validPeriodStart;
	}
	public String getValidPeriodEnd() {
		return ValidPeriodEnd;
	}
	public void setValidPeriodEnd(String validPeriodEnd) {
		ValidPeriodEnd = validPeriodEnd;
	}
	public List<TabPermission> getInfoList() {
		return infoList;
	}
	public void setInfoList(List<TabPermission> infoList) {
		this.infoList = infoList;
	}
	public WriteDevCallBackImpl getWrite() {
		return write;
	}
	public void setWrite(WriteDevCallBackImpl write) {
		this.write = write;
	}



}
