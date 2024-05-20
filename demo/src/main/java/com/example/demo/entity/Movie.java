package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private double rating;
    @Column(nullable = false)
    private int duration_minutes;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id")
    @JsonBackReference
    private Genre genre;


    public Long getId(){
        return this.id;
    }
    public void setId(Long id){this.id=id;}
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }
    public double getRating(){
        return this.rating;
    }
    public void setRating(double rating){
        this.rating=rating;
    }
    public int getDuration_minutes(){
        return this.duration_minutes;
    }
    public void setDuration_minutes(int duration_minutes){
        this.duration_minutes=duration_minutes;
    }
    public Genre getGenre(){return this.genre;}
    public void setGenre(Genre genre){this.genre=genre;}


    public Movie(Long id, String name, double rating, int duration_minutes, Genre genre){
        this.id=id;
        this.name=name;
        this.rating=rating;
        this.duration_minutes=duration_minutes;
        this.genre=genre;
    }

    public Movie(Long id, String name, double rating, int duration_minutes, Long genre_id){
        this.id=id;
        this.name=name;
        this.rating=rating;
        this.duration_minutes=duration_minutes;
        this.genre.setId(genre_id);
    }

    public Movie(String name, double rating, int duration_minutes, Genre genre){
        this.name=name;
        this.rating=rating;
        this.duration_minutes=duration_minutes;
        this.genre=genre;
    }

    public Movie(){
        this.name="";
        this.rating=0;
        this.duration_minutes=0;
    }
}
