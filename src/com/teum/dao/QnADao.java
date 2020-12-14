package com.teum.dao;

import java.util.List;

import com.teum.dao.entity.QnAView;
import com.teum.entity.QnA;

public interface QnADao {
	
	int insert(QnA qna);
	int update(QnA qna);
	int delete(int id);
	
	QnA get(int id);
	List<QnA> getList();
	
	List<QnAView> getViewList();
	List<QnAView> getViewList(int startIndex, int endIndex);
	List<QnAView> getViewList(int startIndex, int endIndex,String category);
	
}
