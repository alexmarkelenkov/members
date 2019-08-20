package com.alexmarkelenkov.oldBastards.model;

import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "member")
public class Member implements Serializable {
    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private  String name;
    @Column(name = "age")
    private  Integer age;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "group_id")
    @NotNull
    @ManyToOne(optional=false)
    private MembersGroup group;


    public Member(String name, Integer age, MembersGroup group) {
        this.name = name;
        this.age = age;
        this.group = group;
    }
    protected Member(){
    }


    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Integer getAge() {
        return age;
    }
}
