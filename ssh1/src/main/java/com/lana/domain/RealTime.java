package com.lana.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="led_record")
public class RealTime {
	

	
@Id
  private Integer	RecordIndex;
@Temporal(TemporalType.TIMESTAMP)
private Date DateTime;
private String Pin;
private String Name;
private String SN;
private String Department;
private String CardID;
private String InputType;
private String InputAddr;
private String OutputType;
private String OutputAddr;
private String EventType;
private String Direction;
private String CardNum;
private String Play;
public Date getDateTime() {
	return DateTime;
}
public void setDateTime(Date dateTime) {
	DateTime = dateTime;
}
public String getPin() {
	return Pin;
}
public void setPin(String pin) {
	Pin = pin;
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
public String getInputType() {
	return InputType;
}
public void setInputType(String inputType) {
	InputType = inputType;
}
public String getInputAddr() {
	return InputAddr;
}
public void setInputAddr(String inputAddr) {
	InputAddr = inputAddr;
}
public String getOutputType() {
	return OutputType;
}
public void setOutputType(String outputType) {
	OutputType = outputType;
}
public String getOutputAddr() {
	return OutputAddr;
}
public void setOutputAddr(String outputAddr) {
	OutputAddr = outputAddr;
}
public String getEventType() {
	return EventType;
}
public void setEventType(String eventType) {
	EventType = eventType;
}
public String getDirection() {
	return Direction;
}
public void setDirection(String direction) {
	Direction = direction;
}
public String getCardNum() {
	return CardNum;
}
public void setCardNum(String cardNum) {
	CardNum = cardNum;
}
public Integer getRecordIndex() {
	return RecordIndex;
}
public void setRecordIndex(Integer recordIndex) {
	RecordIndex = recordIndex;
}
public String getSN() {
	return SN;
}
public void setSN(String sN) {
	SN = sN;
}
public String getPlay() {
	return Play;
}
public void setPlay(String play) {
	Play = play;
}


			
	
}
