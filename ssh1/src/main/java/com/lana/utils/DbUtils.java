package com.lana.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author ���� ¬�� E-mail: 1914045211@qq.com
 * @version ����ʱ�䣺2017��7��25�� ����8:52:17 ��˵��
 */
@Repository
public class DbUtils {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {

		return sessionFactory.getCurrentSession();

	};

}
