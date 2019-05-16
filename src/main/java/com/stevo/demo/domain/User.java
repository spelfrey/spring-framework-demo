package com.stevo.demo.domain;

import javax.persistence.*;

@Entity
@Table(name="usr")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 250)
    private String email;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private String password;
}
