package com.alexmarkelenkov.oldBastards.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "member")
public class Member implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private  String name;
    @Column(name = "age")
    private  Integer age;

    public Member(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    protected Member(){

    }


    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
