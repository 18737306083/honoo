package com.luna.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.lana.dao.TabUserPermInfoDao;
import com.lana.domain.TabPermission;
import com.lana.domain.TabUserPermInfo;
import com.lana.utils.DbUtils;

/** 
 * @author ���� ¬��  E-mail: 1914045211@qq.com
 * @version ����ʱ�䣺2017��8��2�� ����9:07:42 
 * ��˵�� 
 */
@Repository
public class TabUserPermInfoDaoImpl implements TabUserPermInfoDao{
	@Resource
	DbUtils dbutils;
	@Override
	public void insertTabUser(TabUserPermInfo info) {
		// TODO Auto-generated method stub
		dbutils.getSession().saveOrUpdate(info);
	}

	@Override
	public List<TabUserPermInfo> selectUser() {
		// TODO Auto-generated method stub
		String hql="from TabUserPermInfo";
	List<TabUserPermInfo> tab=dbutils.getSession().createQuery(hql).list();
		
		return tab;
	}

	@Override
	public void deleteUserInfoAll() {
		// TODO Auto-generated method stub
		String hql="delete from TabUserPermInfo";
		dbutils.getSession().createQuery(hql).executeUpdate();
	}

	@Override
	public void insertTabPersion(TabPermission persion) {
		// TODO Auto-generated method stub
		dbutils.getSession().saveOrUpdate(persion);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TabPermission> selectPersion() {
		// TODO Auto-generated method stub
		String hql="from TabPermission";
		return dbutils.getSession().createQuery(hql).list();
	}

	

}
