package com.example.demo.controller;

import com.example.demo.entity.Genre;
import com.example.demo.service.GenreService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/genres")

public class GenreController {

    private GenreService genreService;

    public GenreController(GenreService genreService){
        this.genreService=genreService;
    }

    @PostMapping("/create")
    public ResponseEntity<Genre> createGenre(@RequestBody Genre genre){
        Genre savedGenre = genreService.createGenre(genre);
        return new ResponseEntity<>(savedGenre, HttpStatus.CREATED);
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<Genre> getGenreById(@PathVariable("id") Long genreId){
        Genre genre = genreService.getGenreById(genreId);
        return new ResponseEntity<>(genre, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Genre>> getAllGenres(){
        List<Genre> genres = genreService.getAllGenres();
        return new ResponseEntity<>(genres, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Genre> updateGenre(@PathVariable("id") Long genreId, @RequestBody Genre genre){
        genre.setId(genreId);
        Genre updatedGenre = genreService.updateGenre(genre);
        return new ResponseEntity<>(updatedGenre, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteGenre(@PathVariable("id") Long genreId){
        genreService.deleteGenre(genreId);
        return new ResponseEntity<>("deleted genre", HttpStatus.OK);
    }
}