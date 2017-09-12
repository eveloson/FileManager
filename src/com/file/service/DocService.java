package com.file.service;

import java.util.List;
import java.util.Map;

import com.file.vo.Page;
import com.file.vo.Doc;

public interface DocService {
	int addDocByDoc(Doc doc);
	long getDocNumByUserId(int user_id);
	int delDocByUserIdAndDocId(int userId,int docId);	
	List<Doc> getDocsByPageAndUserId(Page page,int user_id);
	Doc getDocById(int doc_id);
}
