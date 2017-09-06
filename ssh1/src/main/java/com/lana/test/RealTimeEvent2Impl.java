package com.lana.test;

import java.util.Date;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import com.liusm.RealTimeEvent;


/** 
 * @author 作者 卢保  E-mail: 1914045211@qq.com
 * @version 创建时间：2017年8月25日 上午9:37:34 
 * 类说明 
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
