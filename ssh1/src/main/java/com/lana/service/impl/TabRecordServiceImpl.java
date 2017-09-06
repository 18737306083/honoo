package com.lana.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.lana.dao.TabRecordDao;
import com.lana.domain.Parameter;
import com.lana.domain.ReadRecord;
import com.lana.domain.RealTime;
import com.lana.domain.TabRecord;
import com.lana.service.TabRecordService;

/**
 * @author 作者 卢保 E-mail: 1914045211@qq.com
 * @version 创建时间：2017年7月25日 上午9:13:26 类说明
 */
@Service
@Transactional
public class TabRecordServiceImpl implements TabRecordService {
	@Resource
	TabRecordDao tabRecordDao;

	@Override
	public void insertByRecord(TabRecord tabRecord) {
		// TODO Auto-generated method stub
		System.out.println("service");
		tabRecordDao.insertByTabRecord(tabRecord);
	}

	@Override
	public List<TabRecord> selectByRecord() {
		// TODO Auto-generated method stub
		return tabRecordDao.selectByTabRecord();
	}

	@Override
	public void delectByRecord(TabRecord tabRecord) {
		// TODO Auto-generated method stub
		tabRecordDao.delectByRecord(tabRecord);

	}

	@Override
	public TabRecord selectByRecordSN(String sn) {
		// TODO Auto-generated method stub

		return tabRecordDao.selectByRecordSN(sn);
	}

	@Override
	public void deleteByRecordSN(TabRecord tabRecord) {
		// TODO Auto-generated method stub
		tabRecordDao.deleteByRecordSN(tabRecord);
	}

	@Override
	public List<ReadRecord> selectByReadRecord() {
		// TODO Auto-generated method stub
		return tabRecordDao.selectByReadRecord();
	}

	@Override
	public void insertByReadRecord(ReadRecord readRecord) {
		// TODO Auto-generated method stub
		tabRecordDao.insertByReadRecord(readRecord);
	}

	@Override
	public Parameter readParameter() {
		// TODO Auto-generated method stub
		return tabRecordDao.readParameter();
	}

	@Override
	public void writeParamter(Parameter para) {
		// TODO Auto-generated method stub
		tabRecordDao.writeParamter(para);
	}

	@Override
	public void deleteDecordByAll() {
		// TODO Auto-generated method stub
		tabRecordDao.deleteDecordByAll();
	}

	@Override
	public List<RealTime> selectByRealTime() {
		// TODO Auto-generated method stub
		return tabRecordDao.selectByRealTime();
	}

	@Override
	public void insertByRealTime(RealTime realtime) {
		// TODO Auto-generated method stub
		tabRecordDao.insertByRealTime(realtime);
	}

	@Override
	public List<RealTime> selectLED() {
		// TODO Auto-generated method stub
		
		return tabRecordDao.selectLED();
	}

	@Override
	public void updateLED(RealTime realTime) {
		// TODO Auto-generated method stub
		tabRecordDao.updateLED(realTime);
	}

	@Override
	public void deleteLED() {
		// TODO Auto-generated method stub
		tabRecordDao.deleteLED();
	}

}
