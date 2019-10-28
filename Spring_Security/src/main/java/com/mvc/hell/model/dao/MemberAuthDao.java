package com.mvc.hell.model.dao;

import com.mvc.hell.dto.MemberDetails;

public interface MemberAuthDao {

	public String namespace="member.";
	
	public MemberDetails login(String username);
	
}
