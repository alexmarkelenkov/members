package com.alexmarkelenkov.oldBastards.util;

import com.alexmarkelenkov.oldBastards.model.Member;
import com.alexmarkelenkov.oldBastards.model.MembersGroup;
import com.alexmarkelenkov.oldBastards.repository.MembersGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.Set;
import java.util.stream.Collectors;


@Component
public class Finder {

    public interface OldMemberGroupsFinder{
        Set<MembersGroup> findGroupsWithMembersOlderThan(Integer age);
        Set<MembersGroup> findGroupsWithMembersUnder(Integer age);
    }

    @Component
    public  class OldMemberGroupsFinderImpl implements OldMemberGroupsFinder{

        @Autowired
        MembersGroupRepository membersGroupRepository;

        @Override
        public Set<MembersGroup> findGroupsWithMembersOlderThan(Integer age) {
            return membersGroupRepository.findAll().stream().filter(membersGroup ->
                    membersGroup.getMembers().stream().anyMatch(member -> member.getAge() > age)
            ).collect(Collectors.toSet());
        }

        @Override
        public  Set<MembersGroup> findGroupsWithMembersUnder(Integer age) {
            return membersGroupRepository.findAll().stream().filter(membersGroup ->
                    membersGroup.getMembers().stream().anyMatch(member -> member.getAge() < age)
            ).collect(Collectors.toSet());
        }


    }

}
