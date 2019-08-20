package com.alexmarkelenkov.oldBastards.util;

import com.alexmarkelenkov.oldBastards.model.Member;
import com.alexmarkelenkov.oldBastards.model.MembersGroup;
import com.alexmarkelenkov.oldBastards.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PopulateMembers implements ApplicationRunner {

	@Autowired
	private MemberRepository memberRepository;

	public static long populateCount;
	public static List<Member> populateMembers;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		MembersGroup group1 = new MembersGroup("Group1", new ArrayList<Member>());
		MembersGroup group2 = new MembersGroup("Group2", new ArrayList<Member>());
		memberRepository.save(new Member("Vasya", 15, group1));
		memberRepository.save(new Member("Gosha", 55, group1) );
		memberRepository.save(new Member("Kokosha", 79, group2));
		memberRepository.save(new Member("Slava", 30, group2));
		populateCount = memberRepository.count();
		memberRepository.findAll().forEach(member -> populateMembers.add(member));
	}
}
