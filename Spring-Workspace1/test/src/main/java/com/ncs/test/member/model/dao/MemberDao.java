package com.ncs.test.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ncs.test.member.model.vo.Member;

@Repository
public class MemberDao {

	@Autowired
	private SqlSessionTemplate session;
	
	public Member selectOne(Member m) {
		return session.selectOne("memberMapper.loginMember", m);
	}

}
