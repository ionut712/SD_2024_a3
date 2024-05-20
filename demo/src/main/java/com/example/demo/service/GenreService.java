package com.example.demo.service;

import com.example.demo.entity.Genre;

import java.util.List;

public interface GenreService {
    Genre createGenre(Genre genre);

    Genre getGenreById(Long genreId);

    List<Genre> getAllGenres();

    Genre updateGenre(Genre genre);

    void deleteGenre(Long genreId);
}
