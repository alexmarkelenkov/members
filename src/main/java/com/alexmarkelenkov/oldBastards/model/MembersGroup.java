package com.alexmarkelenkov.oldBastards.model;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "memberGroup")
public class MembersGroup {
    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String groupName;
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "group")
    @OneToMany(cascade={CascadeType.REMOVE, CascadeType.ALL}, fetch=FetchType.EAGER, mappedBy="group", orphanRemoval=true)
    private List<Member> members;

    public MembersGroup(String groupName, List<Member> members) {
        this.groupName = groupName;
        this.members = members;
    }
    protected MembersGroup(){

    }

    public String getGroupName() {
        return groupName;
    }
    public List<Member> getMembers() {
        return members;
    }


}
