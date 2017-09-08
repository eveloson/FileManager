package com.file.service;

import java.util.List;
import java.util.Map;

import com.file.vo.Page;
import com.file.vo.Doc;

public interface DocService {
	boolean addDocByDoc(Doc doc);
	int getDocNumByUserId(int user_id);
		
	List<Doc> getDocsByPageAndUserId(Page page,int user_id);

	Doc getDocById(int doc_id);
}
