package com.liusm;

import org.springframework.stereotype.Component;

/** 
 * @author 作者 卢保  E-mail: 1914045211@qq.com
 * @version 创建时间：2017年7月26日 下午3:26:26 
 * 类说明 
 */
@Component
public class EventImpl implements RealTimeEvent {

	@Override
	public void callback(String sn, String info) {
		// TODO Auto-generated method stub
		
		System.out.println(info);
	}

}
