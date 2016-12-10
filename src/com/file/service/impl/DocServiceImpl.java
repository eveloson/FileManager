package com.file.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.file.mapper.DocMapper;
import com.file.service.DocService;
import com.file.vo.Page;
import com.file.vo.Doc;
@Service("docService")
public class DocServiceImpl implements DocService {
	
	@Resource
	private DocMapper docMapper;

	@Override
	public boolean addDocByDoc(Doc doc) {
		// TODO Auto-generated method stub
		return docMapper.addDocByDoc(doc);
	}

	@Override
	public int getDocNumByUserId(int user_id) {
		// TODO Auto-generated method stub
		return docMapper.getDocNumByUserId(user_id);
	}

	@Override
	public List<Doc> getDocsByPageAndUserId(Page page, int user_id) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", page);
		map.put("user_id", user_id);
		return docMapper.getDocsByPageAndUserId(map);
	}

	@Override
	public Doc getDocById(int doc_id) {
		// TODO Auto-generated method stub
		return docMapper.getDocById(doc_id);
	}
	
	
}
