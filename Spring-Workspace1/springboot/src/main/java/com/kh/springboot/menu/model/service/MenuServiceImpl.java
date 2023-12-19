package com.kh.springboot.menu.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.springboot.menu.model.dao.MenuDao;
import com.kh.springboot.menu.model.vo.Menu;

@Service
public class MenuServiceImpl implements MenuService{

	@Autowired
	private MenuDao mDao;

	@Override
	public List<Menu> selectMenuList() {
		return mDao.selectMenuList();
	}

	@Override
	public List<Menu> selectMenuListByTypeAndTaste(Map<String, Object> paramMap) {
		return mDao.selectMenuListByTypeAndTaste(paramMap);
	}

	@Override
	public int insertMenu(Menu menu) {
		return mDao.insertMenu(menu);
	}

	@Override
	public Menu selectOneMenu(String id) {
		return mDao.selectOneMenu(id);
	}

	@Override
	public int updateMenu(Menu menu) {
		return mDao.updateMenu(menu);
	}

	@Override
	public int deleteMenu(int id) {
		return mDao.deleteMenu(id);
	}
	
	
}
