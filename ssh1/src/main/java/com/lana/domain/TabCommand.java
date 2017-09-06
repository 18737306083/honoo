package com.lana.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/** 
 * @author 作者 卢保  E-mail: 1914045211@qq.com
 * @version 创建时间：2017年8月2日 上午10:30:34 
 * 类说明 
 */
@Entity
@Table(name="led_command")
public class TabCommand {
	@Id
	@GeneratedValue
	@Column(nullable=false)
private Integer id;
	@Temporal(TemporalType.TIMESTAMP)
private Date time;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	
}
