package com.lana.dao;

import java.util.List;

import com.lana.domain.TabPermission;
import com.lana.domain.TabUserPermInfo;

/** 
 * @author ���� ¬��  E-mail: 1914045211@qq.com
 * @version ����ʱ�䣺2017��8��2�� ����9:01:53 
 * ��˵�� 
 */
public interface TabUserPermInfoDao {
 void insertTabUser(TabUserPermInfo info);
 List<TabUserPermInfo>  selectUser();
 void deleteUserInfoAll();
 /*Ȩ��*/
 void insertTabPersion(TabPermission persion);
 List<TabPermission>  selectPersion();
 
}
