package com.mvc.hell.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.hell.dto.MemberDetails;

@Repository
public class MemberAuthDaoImpl implements MemberAuthDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public MemberDetails login(String username) {
		
		MemberDetails dto = null;
		
		try {
			dto = sqlSessionTemplate.selectOne(namespace+"login",username);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("LOGIN ERROR");
		}
		return dto;
	}

}
