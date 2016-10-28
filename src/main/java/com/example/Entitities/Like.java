package com.example.Entitities;

import javax.persistence.*;

/**
 * Created by john.tumminelli on 10/28/16.
 */
@Entity
@Table(name = "likes")
public class Like {
    @Id
    @GeneratedValue
    public int id;

    @ManyToOne
    public User user;

    @ManyToOne
    public Hurricane hurricane;

    public Like() {
    }

    public Like(User user, Hurricane hurricane) {
        this.user = user;
        this.hurricane = hurricane;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Hurricane getHurricane() {
        return hurricane;
    }

    public void setHurricane(Hurricane hurricane) {
        this.hurricane = hurricane;
    }
}
