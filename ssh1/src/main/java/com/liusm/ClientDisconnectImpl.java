package com.liusm;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.lana.domain.TabRecord;
import com.lana.service.TabRecordService;
import com.lana.utils.NoticeUtils;
import com.opensymphony.xwork2.ActionContext;

/**
 * Created by liusmchs on 2017/2/1 0001.
 */
@Component
public class ClientDisconnectImpl implements ClientDisconnect {
	private String info;
	@Resource
	TabRecordService tabRecordService ;
	private String[] infoAll;
	Map<String, Object>  arg0;
    @Override
    public void callback(String info) {
    	this.info=info;
        System.out.println(new Date()+" info: "+info);
       
        
        if(info !=null && !info.equals("null")&&!info.equals("") ){
        tabRecordService.deleteByRecordSN(parseInfo(info));
        NoticeUtils.notice=1;
        }
    }
	public String getInfo() {
		return info;
	}
	
public TabRecord parseInfo(String info){
	
	 
 

 TabRecord tab=new TabRecord();
 tab.setSN(info);

return tab;
}
}
