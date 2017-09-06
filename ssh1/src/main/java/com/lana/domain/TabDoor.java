package com.lana.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/** 
 * @author ���� ¬��  E-mail: 1914045211@qq.com
 * @version ����ʱ�䣺2017��7��25�� ����11:03:42 
 * ��˵�� 
 */
@Entity
@Table(name="led_door")
public class TabDoor {
	@Id
	@GeneratedValue
	@Column(nullable=false)
private Integer id;
	@Column(nullable=false)
private int DoorNo;
private String Name;
private int DeviceId;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public int getDoorNo() {
	return DoorNo;
}
public void setDoorNo(int doorNo) {
	DoorNo = doorNo;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public int getDeviceId() {
	return DeviceId;
}
public void setDeviceId(int deviceId) {
	DeviceId = deviceId;
}

	
	
}
