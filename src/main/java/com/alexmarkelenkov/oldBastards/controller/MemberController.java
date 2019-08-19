package com.alexmarkelenkov.oldBastards.controller;

import com.alexmarkelenkov.oldBastards.model.Member;
import com.alexmarkelenkov.oldBastards.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/all")
    public Iterable<Member> findAll(){
        memberRepository.save(new Member("Vasya", 15));
        return memberRepository.findAll();
    }
}
