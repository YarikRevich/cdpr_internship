package com.gamestore.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.CascadeType;
import javax.persistence.Column;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "games", uniqueConstraints={@UniqueConstraint(columnNames={"name"})})
public class Game implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "genres_id")
    private List<Genre> genres;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "available_quantity", nullable = false)
    private int availableQuantity;

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

    public List<Genre> getGenres() {
        return this.genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAvailableQuantity() {
        return this.availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }
}
