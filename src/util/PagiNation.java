package util;

public class PagiNation {
	
	private boolean prev = true;
	private boolean next = true;
	
	private int page;
	private int length;
	
	private int pageStart;
	private int pageLast;
	
	public PagiNation(int page, int length) {
		this.page = page;
		this.length = length;
		
		int maxPage = (int) Math.ceil(length / 6.0);
		
		pageStart = (int) Math.floor((page - 1)/ 10) * 10 + 1;
		pageLast = pageStart + 9 > maxPage ? maxPage : pageStart + 9;
		
		if(pageLast <= 10) {
			prev = false;
		}
		
		if(maxPage - pageStart <= 9) {
			next = false;
		}
	}
	

	public int getPageStart() {
		return pageStart;
	}

	public int getPageLast() {
		return pageLast;
	}


	public int getPage() {
		return page;
	}

	public int getLength() {
		return length;
	}


	public boolean isPrev() {
		return prev;
	}
	public boolean isNext() {
		return next;
	}
}

