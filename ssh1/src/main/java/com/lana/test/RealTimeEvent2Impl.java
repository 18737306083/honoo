package com.lana.test;

import java.util.Date;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import com.liusm.RealTimeEvent;


/** 
 * @author ���� ¬��  E-mail: 1914045211@qq.com
 * @version ����ʱ�䣺2017��8��25�� ����9:37:34 
 * ��˵�� 
 */
public class RealTimeEvent2Impl implements RealTimeEvent {
	Logger logger=Logger.getLogger(RealTimeEvent2Impl.class); 		

	@Override
	public void callback(String sn, String data) {
		// TODO Auto-generated method stub

		logger.info(new Date() + " realtime event, sn:" + sn
				+ ", info: " + data);
		if (data != null && !data.equals("") && !data.equals("null")) {
			
			JSONObject json = new JSONObject(data);
			JSONArray array = json.names();
			
			if (array.getString(0).equals("TabRecord")) {
			}
			
		
		
		
		
		}
		
	}

}
