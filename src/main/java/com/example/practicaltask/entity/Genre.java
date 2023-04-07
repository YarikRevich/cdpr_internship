package com.example.practicaltask.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

import java.io.Serializable;

@Entity
@Table(name = "genres")
public class Genre implements Serializable{
    @Id
    @GeneratedValue
    private long id;

    private String name;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setCart(String name) {
        this.name = name;
    }
}
