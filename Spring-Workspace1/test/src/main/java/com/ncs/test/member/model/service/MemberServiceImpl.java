package com.ncs.test.member.model.service;

import org.springframework.stereotype.Service;

import com.ncs.test.member.model.dao.MemberDao;
import com.ncs.test.member.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService{

	private MemberDao mDao;

	@Override
	public Member selectOne(Member m) {
		return mDao.selectOne(m);
	}

}
