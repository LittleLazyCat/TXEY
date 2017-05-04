/*
 * COPYRIGHT. ShenZhen GreatVision Network Technology Co., Ltd. 2015.
 * ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system, or transmitted,
 * on any form or by any means, electronic, mechanical, photocopying, recording, 
 * or otherwise, without the prior written permission of ShenZhen GreatVision Network Technology Co., Ltd.
 *
 * Amendment History:
 * 
 * Date                   By              Description
 * -------------------    -----------     -------------------------------------------
 * May 6, 2015    YangShengJun         Create the class
*/

package com.gvtv.manage.base.system.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gvtv.manage.base.dao.BaseDao;
import com.gvtv.manage.base.system.entity.Button;
import com.gvtv.manage.base.system.entity.Menu;

/**
 * @FileName LoginService.java
 * @Description: 
 *
 * @Date May 6, 2015 
 * @author YangShengJun
 * @version 1.0
 * 
 */
@Transactional(readOnly=true)
@Service("loginService")
public class LoginService {
	
	@Resource(name = "BaseDao")
	private BaseDao dao;
	

	public List<String> getRightsRolesId(Integer userId) throws Exception {
		return  dao.findForList("RoleMapper.findRolesIdByUserId", userId);
	}
	
	public List<Menu> getRightsParentMenus(Integer userId) throws Exception {
		return  dao.findForList("MenuMapper.findParentMenusByUserId", userId);
	}
	
	public List<Menu> getRightsSubMenus(Map<?, ?> parames) throws Exception {
		return  dao.findForList("MenuMapper.findMenusByUserIdAndParent", parames);
	}
	
	public List<Button> getRightsButtons(Integer userId) throws Exception {
		return  dao.findForList("ButtonMapper.findButtonsByUserId", userId);
	}
}
