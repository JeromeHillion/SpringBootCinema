/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.laerce.cinema.model;

import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;

/**
 *
 * @author Gideon
 */

/**
 * Entité pour les Genres des films
 */
@Entity
@Table(name = "genres")
public class Genre {
    /**
     * L'identifiant unique dans la base
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * Le nom du genre
     */
    @Basic
    @Column(name = "name", nullable = false, length = 30)
    private String name;

    /**
     * L'ensemble des films associés au genre
     */
    @ManyToMany(mappedBy = "genres")
    private Set<Film> films;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Genre genre = (Genre) o;

        if (id != genre.id) return false;
        if (name != null ? !name.equals(genre.name) : genre.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}