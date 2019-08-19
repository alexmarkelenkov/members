package com.alexmarkelenkov.oldBastards.repository;

import com.alexmarkelenkov.oldBastards.model.Member;
import org.springframework.data.repository.CrudRepository;


public interface MemberRepository extends CrudRepository<Member, Long> {

}
