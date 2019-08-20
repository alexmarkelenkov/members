package com.alexmarkelenkov.oldBastards;

import com.alexmarkelenkov.oldBastards.model.Member;
import com.alexmarkelenkov.oldBastards.model.MembersGroup;
import com.alexmarkelenkov.oldBastards.repository.MemberRepository;
import com.alexmarkelenkov.oldBastards.util.PopulateMembers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OldBastardsApplicationTests {

	@Autowired
	MemberRepository memberRepository;

	@Test
	public void contextLoads() {
		assertNotNull(PopulateMembers.populateCount);
		assertNotNull(PopulateMembers.populateMembers);
		assertEquals(memberRepository.count(),PopulateMembers.populateCount );
	}

	@Test
	public void aurowiredRepoIsNotNull(){
		assertNotNull(memberRepository);
	}

//	@Test
//	public void populatedSuccessfully(){
//
//	}

	@Test
	public void saveTest(){
		MembersGroup group0 = new MembersGroup("Group0", new ArrayList<Member>());
		Member member = new Member("Petya", 20, group0);

		//assertNull(member.getId());
		memberRepository.save(member);
		assertNotNull(member.getId());

		Member fetchedMember = memberRepository.findById(member.getId()).orElse(null);
		assertNotNull(fetchedMember);
		assertEquals(member.getId(), fetchedMember.getId());
		assertEquals(member.getName(), fetchedMember.getName());
		assertEquals(member.getAge(), fetchedMember.getAge());
	}

}
