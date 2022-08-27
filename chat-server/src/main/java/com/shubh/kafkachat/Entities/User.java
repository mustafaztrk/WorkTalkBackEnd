package com.shubh.kafkachat.Entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data //getter setter
@Entity
//@Table(name="users")
@AllArgsConstructor //ctor
@NoArgsConstructor
public class User {

    /**/
    @Id//id alanını belirtme
   @GeneratedValue(strategy = GenerationType.IDENTITY)//id au artıcak
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="lastName")
    private String lastName;

    @Column(name="email")
    @Email
    @NotBlank
    @NotNull
    private String email;



    @Column(name="password")
    @NotBlank
    @NotNull
    private String password;
   // private List<User> friends;



}
