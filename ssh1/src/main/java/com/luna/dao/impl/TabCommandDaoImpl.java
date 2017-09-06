package com.luna.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.lana.dao.TabCommandDao;
import com.lana.dao.TabUserPermInfoDao;
import com.lana.domain.TabCommand;
import com.lana.domain.TabUserPermInfo;
import com.lana.utils.DbUtils;

/** 
 * @author 作者 卢保  E-mail: 1914045211@qq.com
 * @version 创建时间：2017年8月2日 上午10:46:40 
 * 类说明 
 */
@Repository
public class TabCommandDaoImpl implements TabCommandDao{
	@Resource
	DbUtils dbutils;

	@Override
	public TabCommand getTime() {
		// TODO Auto-generated method stub
		String hql="from TabCommand";
		
		return (TabCommand) dbutils.getSession().createQuery(hql).uniqueResult();
	}

	@Override
	public void setTime(TabCommand tab) {
		// TODO Auto-generated method stub
		dbutils.getSession().save(tab);
	}
	

}
