package com.mysiteforme.admin;

import com.alibaba.fastjson.JSONObject;
import com.mysiteforme.admin.dao.EmpCompanyDetailDao;
import com.mysiteforme.admin.dao.MenuDao;
import com.mysiteforme.admin.entity.emp.EmpCompanyDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MysiteformeApplicationTests {

	private static final Logger LOGGER = LoggerFactory.getLogger(MysiteformeApplicationTests.class);

	@Autowired
	private MenuDao menuDao;
	@Autowired
	private EmpCompanyDetailDao dao;
//	@Test
//	public void contextLoads() {
//		List<Menu> list = menuDao.getMenus(null);
//		LOGGER.info(JSONObject.toJSONString(list));
//	}

	@Test
	public void selectById() {
		List<EmpCompanyDetail>  list = dao.selectById();
		LOGGER.info(JSONObject.toJSONString(list));
	}

}
