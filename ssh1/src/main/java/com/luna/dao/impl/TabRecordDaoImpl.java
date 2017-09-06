package com.luna.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lana.dao.TabRecordDao;
import com.lana.domain.Parameter;
import com.lana.domain.ReadRecord;
import com.lana.domain.RealTime;
import com.lana.domain.TabRecord;
import com.lana.utils.DbUtils;

/** 
 * @author 作者 卢保  E-mail: 1914045211@qq.com
 * @version 创建时间：2017年7月25日 上午8:35:24 
 * 类说明 
 */
@Repository
public class TabRecordDaoImpl implements TabRecordDao{
	@Resource
	DbUtils dbutils;
	//插入数据
	@Override
	public void insertByTabRecord(TabRecord tabrecord) {
		// TODO Auto-generated method stub
	
		dbutils.getSession().saveOrUpdate(tabrecord);
		
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<TabRecord> selectByTabRecord() {
		// TODO Auto-generated method stub
		List<TabRecord> tabRecords ; 
		String hql=" from TabRecord";
		tabRecords=dbutils.getSession().createQuery(hql).list();
		
		return tabRecords;
		
	}
	@Override
	public void delectByRecord(TabRecord tabRecord) {
		// TODO Auto-generated method stub
		dbutils.getSession().delete(tabRecord);
	}
	@Override
	public TabRecord selectByRecordSN(String sn) {
		// TODO Auto-generated method stub
		String hql="from TabRecord where SN = :S";
		TabRecord	tabRecord=(TabRecord) dbutils.getSession().createQuery(hql).setString("S", sn).uniqueResult();
		return tabRecord;
	}
	@Override
	public void deleteByRecordSN(TabRecord tabRecord) {
		// TODO Auto-generated method stub
	/*	String hql="update TabRecord tab set ";
		Query queryupdate=dbutils.getSession().createQuery(hql);
		int ret=queryupdate.executeUpdate();*/
		dbutils.getSession().delete(tabRecord);
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<ReadRecord> selectByReadRecord() {
		// TODO Auto-generated method stub
		List<ReadRecord> readRecords; 
		String hql="from ReadRecord record order by record.RecordIndex desc";
		readRecords=dbutils.getSession().createQuery(hql).list();
		
		return readRecords;
	}
	@Override
	public void insertByReadRecord(ReadRecord readRecord) {
		// TODO Auto-generated method stub
		dbutils.getSession().saveOrUpdate(readRecord);
	}
	@Override
	public Parameter readParameter() {
		// TODO Auto-generated method stub
		String hql="from Parameter ";
		return (Parameter) dbutils.getSession().createQuery(hql).uniqueResult();
	}
	@Override
	public void writeParamter(Parameter para) {
		// TODO Auto-generated method stub
		dbutils.getSession().saveOrUpdate(para);
	}
	@Override
	public void deleteDecordByAll() {
		// TODO Auto-generated method stub
		String hql="delete from ReadRecord ";
		dbutils.getSession().createQuery(hql).executeUpdate();
		
		
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<RealTime> selectByRealTime() {
		// TODO Auto-generated method stub
		List<RealTime> realtime; 
		String hql="from RealTime real order by real.RecordIndex desc";
		realtime=dbutils.getSession().createQuery(hql).list();
		
		return realtime;
	}
	@Override
	public void insertByRealTime(RealTime realtime) {
		// TODO Auto-generated method stub
		
		dbutils.getSession().save(realtime);
	
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<RealTime> selectLED() {
		// TODO Auto-generated method stub
		List<RealTime> realtime; 
	
		String hql="from RealTime real where real.Play = '1'";
		realtime=dbutils.getSession().createQuery(hql).list();
		
		
		
		
		return realtime;
	}
	@Override
	public void updateLED(RealTime realTime) {
		// TODO Auto-generated method stub
		
		dbutils.getSession().update(realTime);
		
	}
	@Override
	public void deleteLED() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		
				String hql="delete from RealTime ";
				dbutils.getSession().createQuery(hql).executeUpdate();
		
	}
 

		 
}
