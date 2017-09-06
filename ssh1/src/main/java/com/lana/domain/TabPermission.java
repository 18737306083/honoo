package com.lana.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/** 
 * @author 作者 卢保  E-mail: 1914045211@qq.com
 * @version 创建时间：2017年8月1日 下午2:58:10 
 * 类说明 
 */
@Entity
@Table(name="led_permission")
public class TabPermission {
	@Id
	@Column(nullable=false)
	private String PermID;
	private String	CardID;
	private String	ReaderID;
	private String DoorID;
	private String VerifyMode;
	private String WeekID;
	private String	HolidayID;
	private String	GroupID;
	private String	SameGroup;
	private String	GroupMethod;;
	private String	RemoteConfirm;
	private String	VerifyPasswd;
	
	public String getVerifyPasswd() {
		return VerifyPasswd;
	}
	public void setVerifyPasswd(String verifyPasswd) {
		VerifyPasswd = verifyPasswd;
	}
	public String getPermID() {
		return PermID;
	}
	public void setPermID(String permID) {
		PermID = permID;
	}
	public String getCardID() {
		return CardID;
	}
	public void setCardID(String cardID) {
		CardID = cardID;
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
	
	
}
