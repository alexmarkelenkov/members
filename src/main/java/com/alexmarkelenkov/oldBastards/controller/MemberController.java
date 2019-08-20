package com.alexmarkelenkov.oldBastards.controller;

import com.alexmarkelenkov.oldBastards.model.Member;
import com.alexmarkelenkov.oldBastards.model.MembersGroup;
import com.alexmarkelenkov.oldBastards.repository.MemberRepository;
import com.alexmarkelenkov.oldBastards.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class MemberController {

    @Autowired
    MemberService memberService;

    @GetMapping("/members")
    public List<Member> findAllMembers(){
        return memberService.findAllMembers();
    }

    @GetMapping("/member")
    public Member getMemberById(Long id){
        return memberService.getMemberById(id).orElseThrow(() -> new DataRetrievalFailureException("No Member with id " + id.toString()));
    }

    @GetMapping("/groups")
    public List<MembersGroup> findAllMemberGroups(){
        return memberService.findAllMemberGroups();
    }

//    @GetMapping("/under/{age}")
//    public List<Member> findAllMembersUnder(){
//    }
}
