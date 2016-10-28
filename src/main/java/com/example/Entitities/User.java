package com.example.Entitities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * Created by john.tumminelli on 10/24/16.
 */

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    public int id;

    @Column(nullable = false, unique = true)
    public String name;

    @JsonIgnore
    @Column(nullable = false)
    public String password;

//    @JsonIgnore
//    @OneToMany(mappedBy = "user")
//    List<Hurricane> hurricanes;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

//    public List<Hurricane> getHurricanes() {
//        return hurricanes;
//    }
//
//    public void setHurricanes(List<Hurricane> hurricanes) {
//        this.hurricanes = hurricanes;
    //}
}
