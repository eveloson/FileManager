package com.file.vo;

import java.io.Serializable;

public class Page implements Serializable{
	int total_rows ;  
	int current_page ; 
	int page_size ; 
	int total_page ;
	int start_row ; 
	public Page(int total_rows, int current_page, int page_size) {
		super();
		this.total_rows = total_rows;
		this.page_size = page_size;
		
		this.total_page = 
				this.total_rows % this.page_size == 0 ? 
						this.total_rows / this.page_size : 
							this.total_rows / this.page_size + 1 ;
		if (this.total_page == 0) {
			this.current_page = 0;
			this.start_row = 0;
		} else {
			if (current_page > this.total_page) {
				this.current_page = this.total_page;
			} else if (current_page <= 0) {
				this.current_page = 1;
			}  else {
				this.current_page = current_page;
			}
			this.start_row = (this.current_page - 1) * this.page_size ; 
		}

		
		
		System.out.println(this.toString());
	}

	
	public int getTotal_rows() {
		return total_rows;
	}


	public int getCurrent_page() {
		return current_page;
	}


	public int getPage_size() {
		return page_size;
	}


	public int getTotal_page() {
		return total_page;
	}


	public int getStart_row() {
		return start_row;
	}


	@Override
	public String toString() {
		return "Page [total_rows=" + total_rows + ", current_page="
				+ current_page + ", page_size=" + page_size + ", total_page="
				+ total_page + ", start_row=" + start_row + "]";
	}
	
}
