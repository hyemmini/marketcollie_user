package kr.co.collie.user.pagination;

public class PaginationDomain {
	private int currentPage = 1;
	
	private int totalCnt; //�� �Խù� ��
	private int pageScale = 3; //�� �������� 5�� ����� ��ȸ
	
	private int totalPage; // �� ������ ��
	
	private int startNum; //�� ������ �Խù� ���� ��ȣ
	private int endNum; //�� ������ �Խù� �� ��ȣ
	private int pageRange = 3; //��ȸ�� ������ ���� ����
	
	private int startPage; //���� ������ ��ȣ
	private int endPage; //�� ������ ��ȣ
	private int prePage; //"����"�� ������ �� ���� ������
	private int nextPage; //"����"�� ������ �� ���� ������
	
	/**
	 * ������ ������ �� �Խù� ���� �Է°����� �޾ƿ� �����Ѵ�.
	 * @param totalCnt
	 */
	public PaginationDomain(int totalCnt) {
		this.totalCnt = totalCnt;
		totalPage = (int)Math.ceil((double)totalCnt/pageScale);
		startNum = (currentPage-1)*pageScale+1;
		endNum=startNum+pageScale-1;
		
		if(endNum > totalCnt){
			endNum = totalCnt;
		}
		
		startPage=((currentPage-1)/pageRange)*pageRange+1;
		endPage=startPage+pageRange-1;
		if(totalPage < endPage) {
			endPage = totalPage;
		}
		prePage = currentPage - 1;
		nextPage = currentPage + 1;
	}
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
		if( currentPage > pageRange ) {
			prePage=((currentPage-1)/pageRange)*pageRange;
		} else {
			prePage = currentPage - 1;
		}
		if( totalPage>endPage ){ //"����" ��ư Ȱ��ȭ�ϴ� ����
			nextPage=prePage+pageRange+1;
		} else {
			nextPage = currentPage + 1;
		}
		
		int startNum=(currentPage-1)*pageScale+1; //�� ������ �Խù� ���۹�ȣ
		int endNum=startNum+pageScale-1; //�� ������ �Խù� ����ȣ
		if(endNum>totalCnt){
			endNum=totalCnt;
		}//end if
	}
	/**
	 * 
	 * �� �������� ������ �Խù��� ������ �����Ѵ�.
	 * @param pageScale ������ �Խù��� ����
	 */
	public void setPageScale(int pageScale) {
		this.pageScale = pageScale;
	}
	
	/**
	 * �� ������ ��ȣ�� �����Ѵ�.
	 * ��ü ������ ������ �� ������ ���� �� ū ��� ��ü ������ ���� �����Ѵ�.
	 * 
	 * @param endPage
	 */
	public void setEndPage(int endPage) {
		if(totalPage < endPage) {
			this.endPage = totalPage; 
		} else {
			this.endPage = endPage;
			nextPage=prePage+pageRange+1;
		}
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getTotalCnt() {
		return totalCnt;
	}

	public int getPageScale() {
		return pageScale;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getStartNum() {
		return startNum;
	}

	public int getEndNum() {
		return endNum;
	}

	public int getPageRange() {
		return pageRange;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public int getPrePage() {
		return prePage;
	}

	public int getNextPage() {
		return nextPage;
	}
}
