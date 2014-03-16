
package com.taotaoti.member.dao;

import java.util.List;

import com.taotaoti.common.generic.dao.BaseDao;
import com.taotaoti.member.bo.Member;

public interface MemberDao extends BaseDao<Integer, Member> {

	public List<Member> findAll();
	public void modifyEmail(Integer memberId, String email);
	public void modifyPassword(Integer memberId, String password);
	public Member createMember(Member member);

    public List<Member> findByMemberId(Integer memberId, int page, int pageSize);
    public List<Member> findMembers(int page, int pageSize);
    public Member findMemberByEmailAndPassword(String email,String password);
    public Member findMemberByEmail(String email);
	
	public int countByMemberId(Integer memberId);
	public int counts();
}