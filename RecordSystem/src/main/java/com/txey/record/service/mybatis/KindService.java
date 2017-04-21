package com.txey.record.service.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.txey.record.dao.mybatis.KindMybatisTemplateDao;
import com.txey.record.model.Kind;

@Transactional
@Service
public class KindService {
	@Autowired
	private KindMybatisTemplateDao kindMybatisTemplateDao;

	public List<Kind> getKind() {
		return kindMybatisTemplateDao.getKind();
	}
}
