package com.lana.action;

import honoor.utils.ConfigUtil;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.lana.domain.Parameter;
import com.lana.service.TabRecordService;
import com.liusm.SdkManageImpl;
import com.liusm.SdkManageImpl.ServiceCallBack;
import com.liusm.SdkManageImpl2;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author 作者 卢保 E-mail: 1914045211@qq.com
 * @version 创建时间：2017年8月3日 上午9:12:35 类说明
 */

@Controller
@Scope("prototype")
public class OtherAction extends ActionSupport {
	
	public String doorLock() {

		return "lock";
	}

	public String lockDoor() {

		System.out.println("" + door1 + door2 + door3 + door4);

		ServiceCallBack.INSTANCE.SEC_PUSH_WriteTableData(SN1, 1,
				"{\"TabDoorMutualLock\":[" + getData() + "]}", 900);

		System.out.println(getData());

		return "lock";
	}

	public String getData() {
		String data = "";
		if (door1 != null) {
			if (door1.length > 0) {
				System.out.println("123");
				data = data + judge(door1);

			}
		}
		if (door2 != null) {
			if (door2.length > 0) {
				data = data + judge(door2);

			}
		}
		if (door3 != null) {
			if (door3.length > 0) {
				data = data + judge(door3);

			}
		}
		if (door4 != null) {
			if (door4.length > 0) {
				data = data + judge(door4);

			}
		}
		data = data.substring(0, data.length() - 1);

		return data;
	}

	public String judge(String[] door) {
		String doorst1 = "\"Door1\":\"0\",";
		String doorst2 = "\"Door2\":\"0\",";
		String doorst3 = "\"Door3\":\"0\",";
		String doorst4 = "\"Door4\":\"0\"";
		String data = "";
		for (int i = 0; i < door.length; i++) {
			String d = door[i];
			if (d.equals("1")) {
				doorst1 = "\"Door2\":\"1\",";

			}

			if (d.equals("2")) {
				doorst2 = "\"Door2\":\"1\",";

			}
			if (d.equals("3")) {
				doorst3 = "\"Door3\":\"1\",";

			}
			if (d.equals("4")) {
				doorst4 = "\"Door4\":\"1\"";

			}

		}
		data = "{" + doorst1 + doorst2 + doorst3 + doorst4 + "},";
		return data;
		// data = data.substring(0, data.length() - 1);

	}

	/* 门时间段 */
	public String getTime() {

		return "time";
	}

	public String timezone() {

		ServiceCallBack.INSTANCE.SEC_PUSH_WriteTableData(SN1, 1,
				"{\"TabDoorTimezoneCfg\":[{\"DoorID\":\"" + getDoorID()
						+ "\",\"Weekday\":\"" + getWeekday()
						+ "\",\"TimeStart\":\"" + getTimeStart()
						+ "\",\"TimeEnd\":\"" + getTimeEnd()
						+ "\",\"DoorOption\":\"" + getDoorOption() + "\"}]}",
				900);

		return "time";
	}

	/* 读取输出参数 */

	public String readOutPutParameter() {
		System.out.println(getParameter() + "00");

		ServiceCallBack.INSTANCE.SEC_PUSH_ReadTableData(SN1, 1,
				"{\"TabDevParameters\":[{\"" + getParameter() + "\":\"\"}]}",
				500);

		pa = record.readParameter();
		System.out.println(pa.getName() + "55");
		ActionContext.getContext().getValueStack().push(pa);
		return "readpara";
	}

	/* 写入参数 */

	public String writeOutPutParameter() {

		ServiceCallBack.INSTANCE.SEC_PUSH_WriteTableData(SN1, 1,
				"{\"TabDevParameters\":[{\"" + getParameter() + "\":\""
						+ getValue() + "\"}]}", 900);
		ActionContext.getContext().getValueStack().push("Ok");
		return "readpara";

	}

	/* 删除记录 */
	public String deleteRecord() {
		ServiceCallBack.INSTANCE.SEC_PUSH_WriteTableData(SN1, 1,
				"{\"TabRecord\":[{\"Del\":\"all\"}]}", 900);

		record.deleteDecordByAll();

		return "delete";
	}
	
	public String redIndentity(){

		SdkManageImpl2.ServiceCallBack.INSTANCE.SEC_PUSH_ReadTableData(SN1, 1,
				"{\" IdentityCard\":[{\"Condition\":\"\"}]}", 900);
		//{" IdentityCard ":[{"Condition":""}]}
		
		return "";
	}
	
	String[] door1;
	String[] door2;
	String[] door3;
	String[] door4;
	private Parameter pa;
	private String parameter="";
	private String DoorID="";
	private String Weekday="";
	private String SN1=ConfigUtil.SN;
	private String TimeStart="";
	private String TimeEnd="";
	private String DoorOption="";
	private String value="";
	@Resource
	TabRecordService record;
	@Resource
	SdkManageImpl sdkManageImpl;

	public String[] getDoor1() {
		return door1;
	}

	public void setDoor1(String[] door1) {
		this.door1 = door1;
	}

	public String[] getDoor2() {
		return door2;
	}

	public void setDoor2(String[] door2) {
		this.door2 = door2;
	}

	public String[] getDoor3() {
		return door3;
	}

	public void setDoor3(String[] door3) {
		this.door3 = door3;
	}

	public String[] getDoor4() {
		return door4;
	}

	public void setDoor4(String[] door4) {
		this.door4 = door4;
	}

	public SdkManageImpl getSdkManageImpl() {
		return sdkManageImpl;
	}

	public void setSdkManageImpl(SdkManageImpl sdkManageImpl) {
		this.sdkManageImpl = sdkManageImpl;
	}

	public String getDoorID() {
		return DoorID;
	}

	public void setDoorID(String doorID) {
		DoorID = doorID;
	}

	public String getWeekday() {
		return Weekday;
	}

	public void setWeekday(String weekday) {
		Weekday = weekday;
	}

	public String getTimeStart() {
		return TimeStart;
	}

	public void setTimeStart(String timeStart) {
		TimeStart = timeStart;
	}

	public String getTimeEnd() {
		return TimeEnd;
	}

	public void setTimeEnd(String timeEnd) {
		TimeEnd = timeEnd;
	}

	public String getDoorOption() {
		return DoorOption;
	}

	public void setDoorOption(String doorOption) {
		DoorOption = doorOption;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public TabRecordService getRecord() {
		return record;
	}

	public void setRecord(TabRecordService record) {
		this.record = record;
	}

	public Parameter getPa() {
		return pa;
	}

	public void setPa(Parameter pa) {
		this.pa = pa;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
