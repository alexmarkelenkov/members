package com.alexmarkelenkov.oldBastards.repository;

import com.alexmarkelenkov.oldBastards.model.Member;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.stream.Stream;


public interface MemberRepository extends CrudRepository<Member, Long> {
//    @Query(value = "select m from member where m.age > ?1", nativeQuery = true)
//    Stream<Member> findAllMembersOlderThan(Integer age);

//    @Query(value = "select * from member where age < ?1", nativeQuery = true)
//    Stream<Member> findAllMembersUnder(Integer age);
}
