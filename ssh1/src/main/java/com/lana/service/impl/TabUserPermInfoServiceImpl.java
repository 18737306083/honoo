package com.lana.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.lana.dao.TabUserPermInfoDao;
import com.lana.domain.TabPermission;
import com.lana.domain.TabUserPermInfo;
import com.lana.service.TabRecordService;
import com.lana.service.TabUserPermInfoService;
import com.luna.dao.impl.TabUserPermInfoDaoImpl;

/**
 * @author ���� ¬�� E-mail: 1914045211@qq.com
 * @version ����ʱ�䣺2017��8��2�� ����9:06:18 ��˵��
 */
@Service
@Transactional
public class TabUserPermInfoServiceImpl implements TabUserPermInfoService {
	@Resource
	TabUserPermInfoDaoImpl info1;

	@Override
	public void insertTabUser(TabUserPermInfo info) {
		// TODO Auto-generated method stub
		info1.insertTabUser(info);
	}

	@Override
	public List<TabUserPermInfo> selectUser() {
		// TODO Auto-generated method stub

		return info1.selectUser();
	}

	@Override
	public void deleteUserInfoAll() {
		// TODO Auto-generated method stub
		info1.deleteUserInfoAll();
	}

	@Override
	public void insertTabPersion(TabPermission persion) {
		// TODO Auto-generated method stub
		info1.insertTabPersion(persion);
	}

	@Override
	public List<TabPermission> selectPersion() {
		// TODO Auto-generated method stub
		return info1.selectPersion();
	}

}
