package com.lana.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/** 
 * @author 作者 卢保  E-mail: 1914045211@qq.com
 * @version 创建时间：2017年8月1日 上午11:54:11 
 * 类说明 
 */
@Entity
@Table(name="led_userperminfo")
public class TabUserPermInfo {
	@Id
	@Column(nullable=false)
private String Pin;
private String SN;
private String Name;
private String Department;
private String CardID;
private String Passwd;
private String  UserState;
private String ValidTimes;
private String ValidPeriodStart;
private String  ValidPeriodEnd;
private String OpenDoorTime;
private String PermID;
public String getPin() {
	return Pin;
}
public void setPin(String pin) {
	Pin = pin;
}
public String getSN() {
	return SN;
}
public void setSN(String sN) {
	SN = sN;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getDepartment() {
	return Department;
}
public void setDepartment(String department) {
	Department = department;
}
public String getCardID() {
	return CardID;
}
public void setCardID(String cardID) {
	CardID = cardID;
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
public String getOpenDoorTime() {
	return OpenDoorTime;
}
public void setOpenDoorTime(String openDoorTime) {
	OpenDoorTime = openDoorTime;
}
public String getPermID() {
	return PermID;
}
public void setPermID(String permID) {
	PermID = permID;
}


}
