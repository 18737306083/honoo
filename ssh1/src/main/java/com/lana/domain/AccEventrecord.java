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
@Table(name = "led_eventrecord")
public class AccEventrecord {
	@Id
	@GeneratedValue
	@Column(nullable = false)
	private Integer id;

	private Integer recordindex;
	@Temporal(TemporalType.DATE)
	private Date eventdatetime;

	private String pin;

	private String cardno;

	private Integer inputtype;

	private Integer inputaddress;

	private Integer outputtype;

	private Integer outputaddress;

	private Integer direction;

	private Integer cardcount;

	private Integer eventtype;

	private Integer deviceid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRecordindex() {
		return recordindex;
	}

	public void setRecordindex(Integer recordindex) {
		this.recordindex = recordindex;
	}

	public Date getEventdatetime() {
		return eventdatetime;
	}

	public void setEventdatetime(Date eventdatetime) {
		this.eventdatetime = eventdatetime;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin == null ? null : pin.trim();
	}

	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno == null ? null : cardno.trim();
	}

	public Integer getInputtype() {
		return inputtype;
	}

	public void setInputtype(Integer inputtype) {
		this.inputtype = inputtype;
	}

	public Integer getInputaddress() {
		return inputaddress;
	}

	public void setInputaddress(Integer inputaddress) {
		this.inputaddress = inputaddress;
	}

	public Integer getOutputtype() {
		return outputtype;
	}

	public void setOutputtype(Integer outputtype) {
		this.outputtype = outputtype;
	}

	public Integer getOutputaddress() {
		return outputaddress;
	}

	public void setOutputaddress(Integer outputaddress) {
		this.outputaddress = outputaddress;
	}

	public Integer getDirection() {
		return direction;
	}

	public void setDirection(Integer direction) {
		this.direction = direction;
	}

	public Integer getCardcount() {
		return cardcount;
	}

	public void setCardcount(Integer cardcount) {
		this.cardcount = cardcount;
	}

	public Integer getEventtype() {
		return eventtype;
	}

	public void setEventtype(Integer eventtype) {
		this.eventtype = eventtype;
	}

	public Integer getDeviceid() {
		return deviceid;
	}

	public void setDeviceid(Integer deviceid) {
		this.deviceid = deviceid;
	}
}