package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "genres")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @OneToMany(mappedBy="genre")
    private List< Movie > movies = new ArrayList< >();

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
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description=description;
    }
    public List<Movie> getMovies(){return this.movies;}
    public void setMovies(List<Movie> movies){this.movies=movies;}


    public Genre(Long id, String name, String description){
        this.id=id;
        this.name=name;
        this.description=description;
    }

    public Genre(String name, String description){
        this.name=name;
        this.description=description;
    }

    public Genre(){
        this.name="";
        this.description="";
    }
}
