package com.file.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.file.mapper.DocMapper;
import com.file.service.DocService;
import com.file.utils.DateFormatUtil;
import com.file.vo.Page;
import com.file.vo.Doc;
import com.file.vo.DocExample;
import com.file.vo.DocExample.Criteria;
@Service("docService")
public class DocServiceImpl implements DocService {
	
	@Resource
	private DocMapper docMapper;

	@Override
	public int addDocByDoc(Doc doc) {
		// TODO Auto-generated method stub
		return docMapper.insertSelective(doc);
	}

	@Override
	public long getDocNumByUserId(int user_id) {
		// TODO Auto-generated method stub
		DocExample example = new DocExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(user_id);
		criteria.andDocDtimeIsNull();
		return docMapper.countByExample(example);
	}

	@Override
	public List<Doc> getDocsByPageAndUserId(Page page, int user_id) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", page);
		map.put("user_id", user_id);
		DocExample example = new DocExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(user_id);
		criteria.andDocDtimeIsNull();
		return docMapper.selectByExample(example);
	}

	@Override
	public Doc getDocById(int doc_id) {
		return docMapper.selectByPrimaryKey(doc_id);
	}

	@Override
	public int delDocByUserIdAndDocId(int userId, int docId) {
		// TODO Auto-generated method stub
		Doc doc = docMapper.selectByPrimaryKey(docId);
		int res = 0;
		if(doc.getUserId() == userId) {
			res = docMapper.updateByPrimaryKeySelective(new Doc(docId,null, null,DateFormatUtil.getTimeString(), null, null, null));
		}
		return res;
	}
	
	
}
