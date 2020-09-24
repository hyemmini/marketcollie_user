package kr.co.collie.user.main.service;

import java.util.List;

import kr.co.collie.user.main.dao.MainDAO;
import kr.co.collie.user.main.domain.CategoryDomain;

public class MainService {
	
	/**
	 * ī�װ� ��ȸ
	 * @return
	 */
	public List<CategoryDomain> getCategories() {
		List<CategoryDomain> list = null;
		MainDAO mDAO = MainDAO.getInstance();
		list = mDAO.selectCategoryList();
		return list;
	}
	
	
}
