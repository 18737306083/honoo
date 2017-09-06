package com.lana.service;

import java.util.List;

import com.lana.domain.Parameter;
import com.lana.domain.ReadRecord;
import com.lana.domain.RealTime;
import com.lana.domain.TabRecord;

/** 
 * @author 作者 卢保  E-mail: 1914045211@qq.com
 * @version 创建时间：2017年7月25日 上午9:09:46 
 * 类说明 
 */
public interface TabRecordService {
public void insertByRecord(TabRecord tabRecord);

public List<TabRecord> selectByRecord();
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

/*刷卡显示*/
List<RealTime> selectLED();
void updateLED(RealTime realTime);
void deleteLED();
}
