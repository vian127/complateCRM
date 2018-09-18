package com.pop136.customerservice.vo.common;

import java.io.Serializable;

public class Page implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final int DEFAULT_PAGE_SIZE = 10;
	private static final int MAX_PAGE_SIZE = 1000 ;

	private int page = 0;//第几页

	private int size = DEFAULT_PAGE_SIZE;


	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		if( page <= 1 ){
			page = 0;
		}
//		setSize(size, page);
		this.page = page;
	}

	public void convertPage(Page page) {

//		if(page.getPage() > 1) this.page = (page.getPage() - 1) * page.getSize();
		if(page.getPage() > 1) this.page = page.getPage() - 1;
//		this.size = page.getSize() + this.page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		if( size < 1 ) size = 1 ;
		if( size > MAX_PAGE_SIZE ) size = MAX_PAGE_SIZE ;
		this.size = size;
//		setSize(size, page);
	}

}
