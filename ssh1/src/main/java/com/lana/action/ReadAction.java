package com.lana.action;

import honoor.utils.ConfigUtil;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.lana.domain.ReadRecord;
import com.lana.domain.RealTime;
import com.lana.domain.TabCommand;
import com.lana.domain.TabRecord;
import com.lana.domain.TabUserPermInfo;
import com.lana.service.TabCommandService;
import com.lana.service.TabRecordService;
import com.lana.service.TabUserPermInfoService;
import com.lana.service.impl.TabCommandServiceImpl;
import com.liusm.ClientConnectImpl;
import com.liusm.ClientDisconnectImpl;
import com.liusm.ReadDevCallBackImpl;
import com.liusm.RealTimeEventImpl;
import com.liusm.SdkManageImpl;
import com.liusm.SdkManageImpl.ServiceCallBack;
import com.liusm.WriteDevCallBackImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author 作者 卢保 E-mail: 1914045211@qq.com
 * @version 创建时间：2017年7月27日 上午9:28:29 类说明
 * 
 * 读数据
 */
@Controller
@Scope("prototype")
public class ReadAction extends ActionSupport {
	
	
	public String readSystemVersion() {
		JSONObject json;
		JSONArray array;
		String version="";
		System.out.println("readversion");
				int res = ServiceCallBack.INSTANCE
				.SEC_PUSH_ReadTableData(SN1, 1,
						"{\"TabCommand\":[{\"AppVersion\":\"\"}]}", 32);

		return "readVersion";
	}

	
	
	/* 远程开门 */
	public String openDoor() { 
		ServiceCallBack.INSTANCE.SEC_PUSH_WriteTableData(SN1, 1,
				"{\"TabCommand\":[" + getDoorSatus() + "]}", 550);
		System.out.println("123\"");
		System.out.println(getDoorSatus());
		System.out.println("{\"TabCommand\":[" + getDoorSatus() + "]}");
		return "send";
	}

	
	public String getDoorSatus() {
		String data = "";
		for (int i = 0; i < openDoor.length; i++) {

			if (getTransfor().equals("DoorControl")) {
				data += "{\"DoorControl\":\"" + getOpenDoor()[i] + ","
						+ getDataDoor()[Integer.parseInt(getOpenDoor()[i]) - 1]
						+ "\"},";
			} else {
				data += "{\"AuxoutControl\":\"" + getOpenDoor()[i] + ","
						+ getDataDoor()[Integer.parseInt(getOpenDoor()[i]) - 1]
						+ "\"},";
			}

		}
		data = data.substring(0, data.length() - 1);

		return data;
	}

	
	
	/* 强制开门 */
	public String norOpen() {
		ServiceCallBack.INSTANCE.SEC_PUSH_WriteTableData(SN1, 1,
				"{\"TabCommand\":[" + getDoorData("1") + "]}", 550);

		return "send";

	}

	
	/* 强制常关 */
	public String closedDoor() {
		ServiceCallBack.INSTANCE.SEC_PUSH_WriteTableData(SN1, 1,
				"{\"TabCommand\":[" + getDoorData("0") + "]}", 550);
		return "send";

	}

	
	/* 解除强制 */

	public String unforceDoor() {
		ServiceCallBack.INSTANCE.SEC_PUSH_WriteTableData(SN1, 1,
				"{\"TabCommand\":[" + getDoorData("2") + "]}", 550);
		return "send";

	}

	
	public String getDoorData(String command) {
		String data = "";
		for (int i = 0; i < openDoor.length; i++) {
			data += "{\"ForceControl\":\"" + getOpenDoor()[i] + "," + command
					+ "\"},";
		}
		data = data.substring(0, data.length() - 1);

		return data;

	}

	
	// 采集离线数据
	public String leave() {
	//	System.out.println("readleave");
				int res = ServiceCallBack.INSTANCE.SEC_PUSH_ReadTableData(
						SN1, 1,
				"{\"TabRecord\":[{\"Condition\":\"\"}]}", 400);
		//		System.out.println("leave..");
		readRecord = record.selectByReadRecord();
		return "readrecord";
	}

	
	/* 查看离线数据 */
	public String readLeave() {
		int res = ServiceCallBack.INSTANCE.SEC_PUSH_ReadTableData(
				SN1, 1,
				"{\"TabRecord\":[{\"Condition\":\"Upload=0\"}]}", 400);
		readRecord = record.selectByReadRecord();
		return "readrecord";
	}

	
	/* 查看月数据 */
	public String readMonth() {
//		System.out.println(getDatatime());
		int res = ServiceCallBack.INSTANCE.SEC_PUSH_ReadTableData(
				SN1, 1,
				"{\"TabRecord\":[{\"Condition\":\"DateTime like '"
						+ getDatatime() + "%'\"}]}", 400);
		readRecord = record.selectByReadRecord();
		return "readrecord";
	}

	// 设置当前时间
	public String setCurrentTime() {
		ServiceCallBack.INSTANCE.SEC_PUSH_WriteTableData(SN1, 1,
				"{\"TabCommand\":[{\"DateTime\":\"2017-12-10  06:12:15\"}]}",
				40);
	//	System.out.println("123");
		return "currentTime";
	}

	// 添加用户

	public String addUser() {
		return "addUser";
	}

	public String getTabData() {
		int res = ServiceCallBack.INSTANCE.SEC_PUSH_ReadTableData(
				SN1, 1, "{\"" + getTab()
						+ "\":[{\"Condition\":\"\"}]}}", 40);
		leave = dev.getLeave();
	//	System.out.println(leave.get(1));
		ActionContext.getContext().getValueStack().push(leave);
		return "tabdata";

	}

	
	/* 读取用户信息 */
	public String readTime() {
		int res = SdkManageImpl.ServiceCallBack.INSTANCE
				.SEC_PUSH_ReadTableData(SN1, 1,
						"{\"DateTime\":\"\"}]}", 400);
		com = command.getTime();
		return "readtime";
	}

	
	
	public String readUser() {
		if (Pin != "" && CardID != ""&&!Pin.equals("")&&!CardID.equals("")) {
			System.out.println("1");
			int res = ServiceCallBack.INSTANCE.SEC_PUSH_ReadTableData(
					SN1, 1,
					"{\"TabUserPermInfo\":[{\"Condition\":\"Pin=" + getPin()
							+ "and CardID=" + getCardID() + "\"}]}}", 600);
			infoList = perminfo.selectUser();
		}

		if (Pin != "" && CardID == "") {
			System.out.println("2");
			int res = ServiceCallBack.INSTANCE.SEC_PUSH_ReadTableData(
					SN1, 1,
					"{\"TabUserPermInfo\":[{\"Condition\":\"Pin=" + getPin()
							+ "\"}]}}", 600);
			infoList = perminfo.selectUser();
		}
		if (Pin == "" && CardID == "" || Pin == "" && CardID != "") {
			System.out.println("3");
			int res = ServiceCallBack.INSTANCE.SEC_PUSH_ReadTableData(
					SN1, 1,
					"{\"TabUserPermInfo\":[{\"Condition\":\"\"}]}}", 600);
			infoList = perminfo.selectUser();
			// parseJSon();
		}

		return "readUser";
	}

	
	public List<TabUserPermInfo> parseJSon() {
		infoList = new ArrayList<TabUserPermInfo>();
		TabUserPermInfo info = new TabUserPermInfo();

		if (dev.getdata() != null && dev.getdata() != "") {
		//	System.out.println(dev.getData() + "dev");
			// System.out.println(dev.getdata()+"llllll");
			JSONObject json = new JSONObject(dev.getdata());
			JSONArray array = json.getJSONArray("TabUserPermInfo");
			ob = array.getJSONObject(0);
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
			info.setSN(dev.getSn());
			infoList.add(info);
		}
		return infoList;
	}
	
	
	
/*读取实时信息*/
	public String readReal(){
			realTime=record.selectByRealTime();
				return "real";
	}

	
	/* json */
	public String readRealJson() {
		realTime = record.selectByRealTime();
		ActionContext.getContext().getValueStack().push(realTime);

		return "readVersion";
	}
	
	
	
	public String deleteUser() {
		System.out.println("delect");
		int res = ServiceCallBack.INSTANCE.SEC_PUSH_ReadTableData(
				SN1, 1,
				"{\"TabUserPermInfo\":[{\"Del\":\"all\"}]}}", 600);
		// parseJSon();
		perminfo.deleteUserInfoAll();
		return "deleteUser";
	}
	
	
	
	
	@Resource
	TabCommandService command;
	@Resource
	TabRecordService record;
	@Resource
	TabUserPermInfoService perminfo;
	@Resource
	SdkManageImpl sdkManageImpl;
	TabCommand com;
	String[] openDoor;
	String[] dataDoor;
	private String transfor;
	List<String> leave;
	public String Pin="";
	public String CardID="";
	@Resource
	ReadDevCallBackImpl dev;
	String tab="";
	JSONObject ob;
	List<TabUserPermInfo> infoList;
	List<ReadRecord> readRecord;
	private String datatime="";
	private 	List<RealTime> realTime;
	private String SN1=ConfigUtil.SN;
	public String[] getOpenDoor() {
		return openDoor;
	}

	public void setOpenDoor(String[] openDoor) {
		this.openDoor = openDoor;
	}

	public String[] getDataDoor() {
		return dataDoor;
	}

	public void setDataDoor(String[] dataDoor) {
		this.dataDoor = dataDoor;
	}

	public List<String> getLeave() {
		return leave;
	}

	public void setLeave(List<String> leave) {
		this.leave = leave;
	}

	public String getTab() {
		return tab;
	}

	public void setTab(String tab) {
		this.tab = tab;
	}

	public JSONObject getOb() {
		return ob;
	}

	public void setOb(JSONObject ob) {
		this.ob = ob;
	}

	public String getPin() {
		return Pin;
	}

	public void setPin(String pin) {
		Pin = pin;
	}

	public String getCardID() {
		return CardID;
	}

	public void setCardID(String cardID) {
		CardID = cardID;
	}

	public List<TabUserPermInfo> getInfoList() {
		return infoList;
	}

	public void setInfoList(List<TabUserPermInfo> infoList) {
		this.infoList = infoList;
	}

	public TabCommandService getCommand() {
		return command;
	}

	public void setCommand(TabCommandService command) {
		this.command = command;
	}

	public TabUserPermInfoService getPerminfo() {
		return perminfo;
	}

	public void setPerminfo(TabUserPermInfoService perminfo) {
		this.perminfo = perminfo;
	}

	public SdkManageImpl getSdkManageImpl() {
		return sdkManageImpl;
	}

	public void setSdkManageImpl(SdkManageImpl sdkManageImpl) {
		this.sdkManageImpl = sdkManageImpl;
	}

	public TabCommand getCom() {
		return com;
	}

	public void setCom(TabCommand com) {
		this.com = com;
	}

	public ReadDevCallBackImpl getDev() {
		return dev;
	}

	public void setDev(ReadDevCallBackImpl dev) {
		this.dev = dev;
	}

	public TabRecordService getRecord() {
		return record;
	}

	public void setRecord(TabRecordService record) {
		this.record = record;
	}

	public List<ReadRecord> getReadRecord() {
		return readRecord;
	}

	public void setReadRecord(List<ReadRecord> readRecord) {
		this.readRecord = readRecord;
	}

	public String getDatatime() {
		return datatime;
	}

	public void setDatatime(String datatime) {
		this.datatime = datatime;
	}

	public String getTransfor() {
		return transfor;
	}

	public void setTransfor(String transfor) {
		this.transfor = transfor;
	}

	public List<RealTime> getRealTime() {
		return realTime;
	}

	public void setRealTime(List<RealTime> realTime) {
		this.realTime = realTime;
	}

}
