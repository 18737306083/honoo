package com.liusm;

import java.io.File;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.lana.action.FirstAction;
import com.liusm.SdkManageImpl2.ServiceCallBack;
import com.sun.jna.Library;
import com.sun.jna.Native;


@Component
public class SdkManageImpl implements SdkManage {

	private int result = 0;
	  
	public interface ServiceCallBack extends Library {
		String sep = File.separator;

		File file=new File("");
		String str=file.getAbsolutePath();
		
		//ServiceCallBack INSTANCE = (ServiceCallBack) Native.loadLibrary("D:\\Honoo_new\\honoo_led\\webapps\\led_sdk\\dcpushSDK", ServiceCallBack.class);
	//String	path=str+"\\webapps\\led_sdk\\dcpushSDK.dll";
		//String path="D:"+sep+"Honoo_new"+sep+"honooled"+sep+"webapps"+sep+"led_sdk"+sep+"dcpushSDK.dll";
	String	 path="D:"+sep+"Honoo_new"+sep+"tools"+sep+"Demo_2.2.4"+sep+"Demo_x64"+sep+"dcpushSDK.dll";

//	ServiceCallBack INSTANCE = (ServiceCallBack) Native.loadLibrary(path2, ServiceCallBack.class);

		ServiceCallBack INSTANCE = (ServiceCallBack) Native.loadLibrary(path, ServiceCallBack.class);
/*		ServiceCallBack INSTANCE = (ServiceCallBack) Native.loadLibrary(str.split("bin")[0]+"webapps\\led_sdk\\dcpushSDK", ServiceCallBack.class);
*/
		boolean SEC_PUSH_SetServiceCallBack(ClientConnect cc,
				ClientDisconnect cd, RealTimeEvent rte, WriteDevCallBack wdc,
				ReadDevCallBack rdc);

		int SEC_PUSH_StartServer(String ipaddr, String config);

		int SdkManageImpl(String snList, int cmd, String data, int len);

		int SEC_PUSH_ReadTableData(String snList, int cmd, String data, int len);

		int SEC_PUSH_WriteTableData(String snList, int cmd, String data, int len);

		DeviceEvent SEC_PUSH_PollEvent();
	}

	@Override
	public int SEC_PUSH_StartServer(String ipaddr, String config) {
		// TODO Auto-generated method stub
		result = ServiceCallBack.INSTANCE.SEC_PUSH_StartServer(ipaddr, config);

		return result;

	}

	@Override
	public int SEC_PUSH_WriteTableData(String snList, int cmd, String data,
			int len) {
		// TODO Auto-generated method stub
		int res = SdkManageImpl.ServiceCallBack.INSTANCE
				.SEC_PUSH_WriteTableData(snList, cmd, data, len);
		System.out.println("write cmd result " + res);

		return res;
	}

	@Override
	public int SEC_PUSH_ReadTableData(String snList, int cmd, String data,
			int len) {
		// TODO Auto-generated method stub
		System.out.println(data);
		int res = SdkManageImpl.ServiceCallBack.INSTANCE
				.SEC_PUSH_ReadTableData(snList, cmd, data, len);
		// System.out.println("read data result "+res);
		return res;
	}

	@Override
	public boolean SEC_PUSH_SetServiceCallBack(ClientConnect cc,
			ClientDisconnect cd, RealTimeEvent rte, WriteDevCallBack wdc,
			ReadDevCallBack rdc) {
		// TODO Auto-generated method stub

		boolean res = ServiceCallBack.INSTANCE.SEC_PUSH_SetServiceCallBack(cc,
				cd, rte, wdc, rdc);

		return res;

	}

	@Override
	public DeviceEvent SEC_PUSH_PollEvent() {
		// TODO Auto-generated method stub

		while (true) {
			try {
				DeviceEvent rs = (DeviceEvent) ServiceCallBack.INSTANCE
						.SEC_PUSH_PollEvent();
				if (rs != null) {
					System.out.println(rs);
				}
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public int getResult() {
		return result;
	}

}
