package com.alexmarkelenkov.oldBastards.model;

import java.util.List;
import javax.persistence.*;

//@Entity
//@Table(name = "memberGroup")
public class MembersGroup {

    //@Id
    private final String groupName;
    private final List<Member> members;


    public String getGroupName() {
        return groupName;
    }

    public List<Member> getMembers() {
        return members;
    }

    public MembersGroup(String groupName, List<Member> members) {
        this.groupName = groupName;
        this.members = members;
    }
}
