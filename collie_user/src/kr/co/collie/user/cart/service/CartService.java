package kr.co.collie.user.cart.service;

import java.util.List;

import kr.co.collie.user.cart.dao.CartDAO;
import kr.co.collie.user.cart.domain.CartGoodsDomain;
import kr.co.collie.user.cart.vo.CartVO;

public class CartService {
	
	/**
	 * ��ٱ��Ͽ� ��ǰ�� �߰��ϴ� ��
	 * @param cVO
	 * @return
	 */
	public boolean addCart(CartVO cVO) {
		boolean addFlag = false;
		
		CartDAO cDAO = CartDAO.getInstance();
		addFlag = cDAO.insertCart(cVO)==1;
		
		return addFlag;
	}//addCart
	
	public List<CartGoodsDomain> getMyCart(int memberNum){
		List<CartGoodsDomain> list=null;
		
		CartDAO cDAO=CartDAO.getInstance();
		list=cDAO.selectCartGoods(memberNum);
		
		return list;
	}//getMyCart
	
}//class
