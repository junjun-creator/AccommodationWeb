package com.teum.service;

import java.util.List;

import com.teum.entity.QnA;

public interface QnAServiceI {
	
	List<QnA> getList(int id, String search, int category);
	
	int deletAll(int[] ids);
	
	int delete(int id);
	
	int insert(QnA qna);
	
	int update(int id);
	
	
}
