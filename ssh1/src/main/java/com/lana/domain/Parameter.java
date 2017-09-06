package com.lana.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/** 
 * @author 作者 卢保  E-mail: 1914045211@qq.com
 * @version 创建时间：2017年8月3日 下午1:49:40 
 * 类说明 
 */
@Entity
@Table(name="led_parameter")
public class Parameter {
	
	@Id
	@Column(nullable=false)
	private Integer id;
private String name;
private String value;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getValue() {
	return value;
}
public void setValue(String value) {
	this.value = value;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}

}
