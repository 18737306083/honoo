package com.lana.dao;

import java.util.List;

import com.lana.domain.TabPermission;
import com.lana.domain.TabUserPermInfo;

/** 
 * @author 作者 卢保  E-mail: 1914045211@qq.com
 * @version 创建时间：2017年8月2日 上午9:01:53 
 * 类说明 
 */
public interface TabUserPermInfoDao {
 void insertTabUser(TabUserPermInfo info);
 List<TabUserPermInfo>  selectUser();
 void deleteUserInfoAll();
 /*权限*/
 void insertTabPersion(TabPermission persion);
 List<TabPermission>  selectPersion();
 
}
