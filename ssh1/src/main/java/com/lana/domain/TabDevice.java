package com.lana.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/** 
 * @author 作者 卢保  E-mail: 1914045211@qq.com
 * @version 创建时间：2017年7月25日 上午11:49:29 
 * 类说明 
 */
@Entity
@Table(name="led_device")
public class TabDevice {
	@Id
	@GeneratedValue
	@Column(nullable=false)
private Integer id;
	//设备名
private String Name;
private String SN;

private String Firmware;
//本机ip
private String IPAdress;

private String MAC;
private String ReaderCount;
private int DoorCount;
private int AuxInCount;
private int AuxOutCount;

private int Type;
private int IsDoubleDirection;
//远程ip
private String ServerIP;
private int ServerPort;

private String NetMask;

private String Gate;

private int AreaId;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
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
public String getFirmware() {
	return Firmware;
}
public void setFirmware(String firmware) {
	Firmware = firmware;
}
public String getIPAdress() {
	return IPAdress;
}
public void setIPAdress(String iPAdress) {
	IPAdress = iPAdress;
}
public String getMAC() {
	return MAC;
}
public void setMAC(String mAC) {
	MAC = mAC;
}
public String getReaderCount() {
	return ReaderCount;
}
public void setReaderCount(String readerCount) {
	ReaderCount = readerCount;
}
public int getDoorCount() {
	return DoorCount;
}
public void setDoorCount(int doorCount) {
	DoorCount = doorCount;
}
public int getAuxInCount() {
	return AuxInCount;
}
public void setAuxInCount(int auxInCount) {
	AuxInCount = auxInCount;
}
public int getAuxOutCount() {
	return AuxOutCount;
}
public void setAuxOutCount(int auxOutCount) {
	AuxOutCount = auxOutCount;
}
public int getType() {
	return Type;
}
public void setType(int type) {
	Type = type;
}
public int getIsDoubleDirection() {
	return IsDoubleDirection;
}
public void setIsDoubleDirection(int isDoubleDirection) {
	IsDoubleDirection = isDoubleDirection;
}
public String getServerIP() {
	return ServerIP;
}
public void setServerIP(String serverIP) {
	ServerIP = serverIP;
}
public int getServerPort() {
	return ServerPort;
}
public void setServerPort(int serverPort) {
	ServerPort = serverPort;
}
public String getNetMask() {
	return NetMask;
}
public void setNetMask(String netMask) {
	NetMask = netMask;
}
public String getGate() {
	return Gate;
}
public void setGate(String gate) {
	Gate = gate;
}
public int getAreaId() {
	return AreaId;
}
public void setAreaId(int areaId) {
	AreaId = areaId;
}








}
