package com.lana.dao;

import java.util.List;

import com.lana.domain.Parameter;
import com.lana.domain.ReadRecord;
import com.lana.domain.RealTime;
import com.lana.domain.TabRecord;

/** 
 * @author ���� ¬��  E-mail: 1914045211@qq.com
 * @version ����ʱ�䣺2017��7��25�� ����8:55:56 
 * ��˵�� 
 */
public interface TabRecordDao {
	public void insertByTabRecord(TabRecord tabrecord);
	public List<TabRecord> selectByTabRecord();
	public void delectByRecord(TabRecord tabRecord);
	public TabRecord selectByRecordSN(String sn);
	public void deleteByRecordSN(TabRecord tabRecord);
	public List<ReadRecord> selectByReadRecord();
	public void insertByReadRecord(ReadRecord readRecord);
 Parameter readParameter();
 void writeParamter(Parameter para);
 
 
 void deleteDecordByAll();
 
 public List<RealTime> selectByRealTime();
 public void insertByRealTime(RealTime realtime);
 
 /*ˢ����ʾ*/
 List<RealTime> selectLED();
 void updateLED(RealTime realTime);
 void deleteLED();
 
}
