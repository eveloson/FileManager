package com.file.mapper;

import java.util.List;
import java.util.Map;

import com.file.annotation.DocAnnotation;
import com.file.vo.Doc;

@DocAnnotation
public interface DocMapper {
	boolean addDocByDoc(Doc doc);
	
	boolean delDocByUserIdAndDocId(int user_id,int doc_id);
	
	int getDocNumByUserId(int user_id);
		
	List<Doc> getDocsByPageAndUserId(Map<String, Object> map);

	Doc getDocById(int doc_id);
	
}
