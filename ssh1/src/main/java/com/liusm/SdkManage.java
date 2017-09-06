package com.liusm;
/** 
 * @author 作者 卢保  E-mail: 1914045211@qq.com
 * @version 创建时间：2017年7月23日 下午4:08:34 
 * 类说明 
 */
public interface SdkManage {
	//启动sdk服务
int	SEC_PUSH_StartServer(String ipaddr, String config);
//向设备写数据
int SEC_PUSH_WriteTableData(String snList, int cmd, String data, int len);
//对设备的读数据操作
int SEC_PUSH_ReadTableData(String snList, int cmd, String data, int len);
//SDK事件回调
boolean SEC_PUSH_SetServiceCallBack(ClientConnect  cc, ClientDisconnect cd, RealTimeEvent rte, WriteDevCallBack wdc, ReadDevCallBack rdc);
//设备事件
DeviceEvent SEC_PUSH_PollEvent();
}
