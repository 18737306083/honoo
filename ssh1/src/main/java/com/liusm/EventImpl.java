package com.liusm;

import org.springframework.stereotype.Component;

/** 
 * @author ���� ¬��  E-mail: 1914045211@qq.com
 * @version ����ʱ�䣺2017��7��26�� ����3:26:26 
 * ��˵�� 
 */
@Component
public class EventImpl implements RealTimeEvent {

	@Override
	public void callback(String sn, String info) {
		// TODO Auto-generated method stub
		
		System.out.println(info);
	}

}
