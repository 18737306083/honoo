package com.liusm;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by liusmchs on 2017/2/1 0001.
 */
@Component
public class WriteDevCallBackImpl implements WriteDevCallBack {
	private String sn;
	private int cmd;
	private String data;
	private int len;

	@Override
	public void callback(String sn, int cmd, String data, int len) {
		this.sn = sn;
		this.cmd = cmd;
		this.data = data;
		this.len = len;
		System.out.println("data" + data);
		// System.out.printf("writeDevCallBack info, sn: %s, cmd: %d, data: %s, len: %s \n",sn,
		// cmd, data, len);
	}
	public String getSn() {
		return sn;
	}
	public int getCmd() {
		return cmd;
	}
	public String getData() {
		return data;
	}
	public int getLen() {
		return len;
	}
    
}
