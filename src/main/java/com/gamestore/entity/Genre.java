package com.gamestore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;

import java.io.Serializable;

@Entity
@Table(name = "genres", uniqueConstraints={@UniqueConstraint(columnNames={"name"})})
public class Genre implements Serializable{
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "name", nullable = false)
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

    public void setName(String name) {
        this.name = name;
    }
}
