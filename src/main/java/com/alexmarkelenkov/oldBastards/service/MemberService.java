package com.alexmarkelenkov.oldBastards.service;

import com.alexmarkelenkov.oldBastards.model.Member;
import com.alexmarkelenkov.oldBastards.model.MembersGroup;


import java.util.List;
import java.util.Optional;


public interface MemberService {
    List<Member> findAllMembers();
    Optional<Member> getMemberById(Long id);
    Member saveMember(Member member);

    List<MembersGroup> findAllMemberGroups();
    Optional<MembersGroup> getMembersGroupById(Long id);
}
