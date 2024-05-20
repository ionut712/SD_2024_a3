package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.LazyCollection;

import java.util.Set;

//import java.util.ArrayList;
//import java.util.List;

@Entity
@Table(name = "users1")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @Size(min = 2, message = "First Name should have at least 2 characters")
    @Pattern(regexp = "^[a-zA-Z0-9]*$") //only alphanumeric characters
    private String firstname;
    @Column(nullable = false)
    @Size(min = 2, message = "First Name should have at least 2 characters")
    @Pattern(regexp = "^[a-zA-Z0-9]*$") //only alphanumeric characters
    private String lastname;
    @Column(nullable = false)
    @Email
    private String email;
    @Column
    private String password;
    @Column
    private String username;

    @ManyToMany
    private Set<Role> roles;

    //@OneToMany(mappedBy="genre")
    //private List< Movie > movies = new ArrayList< >();

    public Long getId(){
        return this.id;
    }
    public void setId(Long id){this.id=id;}
    public String getFirstName(){
        return this.firstname;
    }
    public void setFirstName(String firstname){
        this.firstname=firstname;
    }
    public String getLastName(){
        return this.lastname;
    }
    public void setLastName(String lastname){
        this.lastname=lastname;
    }
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getPassword(){return this.password;}
    public void setPassword(String password){this.password=password;}
    public Set<Role> getRoles() {return roles;}
    public void setRoles(Set<Role> roles) {this.roles = roles;}
    public String getUsername(){return this.username;}
    public void setUsername(String username){this.username=username;}

    /*
    public List<Movie> getMovies(){return this.movies;}
    public void setMovies(List<Movie> movies){this.movies=movies;}
    */

    public User(Long id, String firstname, String lastname, String email, String password, String username){
        this.id=id;
        this.firstname=firstname;
        this.lastname=lastname;
        this.email=email;
        this.password=password;
        this.username=username;
    }

    public User(String firstname, String lastname, String email, String password, String username){
        this.firstname=firstname;
        this.lastname=lastname;
        this.email=email;
        this.password=password;
        this.username=username;
    }

    public User(){
        this.firstname="";
        this.lastname="";
        this.email="";
        this.password="";
        this.username="";
    }
}

