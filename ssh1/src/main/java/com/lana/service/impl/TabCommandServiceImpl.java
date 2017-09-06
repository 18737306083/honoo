package com.lana.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.lana.dao.TabCommandDao;
import com.lana.domain.TabCommand;
import com.lana.service.TabCommandService;
import com.luna.dao.impl.TabCommandDaoImpl;

/**
 * @author 作者 卢保 E-mail: 1914045211@qq.com
 * @version 创建时间：2017年8月2日 上午10:45:19 类说明
 */
@Transactional
@Service
public class TabCommandServiceImpl implements TabCommandService {
	@Resource
	TabCommandDao command;

	@Override
	public TabCommand getTime() {
		// TODO Auto-generated method stub
		return command.getTime();
	}

	@Override
	public void setTime(TabCommand tab) {
		// TODO Auto-generated method stub
		command.setTime(tab);
	}

}
