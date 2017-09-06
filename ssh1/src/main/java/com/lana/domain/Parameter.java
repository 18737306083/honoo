package com.lana.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/** 
 * @author ���� ¬��  E-mail: 1914045211@qq.com
 * @version ����ʱ�䣺2017��8��3�� ����1:49:40 
 * ��˵�� 
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
