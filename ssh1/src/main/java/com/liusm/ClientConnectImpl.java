package com.liusm;

import honoor.utils.ConfigUtil;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.lana.action.FirstAction;
import com.lana.domain.TabRecord;
import com.lana.service.TabRecordService;
import com.lana.utils.NoticeUtils;

/**
 * Created by liusmchs on 2017/2/1 0001.
 */
@Component
public class ClientConnectImpl implements ClientConnect, RequestAware {
	@Resource
	TabRecordService tabRecordService;
	private String info;
	private String[] infoAll;
	Map<String, Object> arg0;
	Logger logger=Logger.getLogger(ClientConnectImpl.class); 
	@Override
	public void callback(String info) {
		this.info = info;
		logger.info(info);	
		if (tabRecordService.selectByRecordSN(info.split(",")[0].split("=")[1]) == null) {

			tabRecordService.insertByRecord(parseInfo(info));

		}
		
		//tabRecordService.updateByRecordSN(parseInfo(info));
		NoticeUtils.notice = 1;
		
	}

	public String getInfo() {
		return info;
	}

	public String[] getInfoAll() {
		return infoAll;
	}

	public TabRecord parseInfo(String info) {
		infoAll = info.split(",");
		TabRecord tab = new TabRecord();
		ConfigUtil.SN=infoAll[0].split("=")[1];
		tab.setSN(infoAll[0].split("=")[1]);
		tab.setName(infoAll[0].split("=")[1]);
		tab.setVersion(infoAll[1].split("=")[1]);
		tab.setMAC(infoAll[2].split("=")[1]);

		tab.setType(new Integer(infoAll[3].split("=")[1]));
		tab.setDevWorkMode(infoAll[4].split("=")[1]);
		tab.setDoorCount(new Integer(infoAll[5].split("=")[1]));
		tab.setReaderCount(infoAll[6].split("=")[1]);
		tab.setAuxInCount(new Integer(infoAll[7].split("=")[1]));
		tab.setAuxOutCount(new Integer(infoAll[8].split("=")[1]));
		tab.setServerIP(infoAll[9].split("=")[1]);
		tab.setOnline("ÔÚÏß");
		// tab.set
		return tab;
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.arg0 = arg0;
	}

	public TabRecordService getTabRecordService() {
		return tabRecordService;
	}

	public void setTabRecordService(TabRecordService tabRecordService) {
		this.tabRecordService = tabRecordService;
	}

}
