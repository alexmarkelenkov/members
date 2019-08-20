package com.alexmarkelenkov.oldBastards.service;


import com.alexmarkelenkov.oldBastards.model.Member;
import com.alexmarkelenkov.oldBastards.model.MembersGroup;
import com.alexmarkelenkov.oldBastards.repository.MemberRepository;
import com.alexmarkelenkov.oldBastards.repository.MembersGroupRepository;
import com.alexmarkelenkov.oldBastards.util.Finder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private MembersGroupRepository membersGroupRepository;
    @Autowired
    private Finder.OldMemberGroupsFinder oldMemberGroupsFinder;

    @Override
    public List<Member> findAllMembers() {
        List<Member> allMembers = new ArrayList<>();
        memberRepository.findAll().forEach(allMembers::add);
        return allMembers;
    }

    @Override
    public Optional<Member> getMemberById(Long id) {
        return memberRepository.findById(id);
    }

    @Override
    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public List<MembersGroup> findAllMemberGroups() {
        return membersGroupRepository.findAll();
    }

    @Override
    public Optional<MembersGroup> getMembersGroupById(Long id) {
        return membersGroupRepository.findById(id);
    }


//    public List<Member> findAllMembersUnder(Integer age){
//       return memberRepository.findAllMembersUnder(age).collect(Collectors.toList());
//    }
//
//    public List<Member> findAllMembersOlderThan(Integer age){
//        return memberRepository.findAllMembersOlderThan(age).collect(Collectors.toList());
//    }

    public Set<MembersGroup> findGroupsWithMembersOlderThan(Integer age){
        return oldMemberGroupsFinder.findGroupsWithMembersOlderThan(age);
    }

    public Set<MembersGroup> findGroupsWithMembersUnder(Integer age){
        return oldMemberGroupsFinder.findGroupsWithMembersUnder(age);
    }
}
