package com.example.demo.service.implementation;

import com.example.demo.entity.Genre;
import com.example.demo.repository.GenreRepository;
import com.example.demo.service.GenreService;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class GenreServiceImplementation implements GenreService{

    private GenreRepository genreRepository;

    public GenreServiceImplementation(GenreRepository genreRepository){
        this.genreRepository=genreRepository;
    }

    @Override
    public Genre createGenre(Genre genre){
        return genreRepository.save(genre);
    }

    @Override
    public Genre getGenreById(Long genreId) {
        Optional<Genre> optionalGenre = genreRepository.findById(genreId);
        return optionalGenre.get();
    }

    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @Override
    public Genre updateGenre(Genre genre) {
        Genre existingGenre = genreRepository.findById(genre.getId()).get();
        existingGenre.setName(genre.getName());
        existingGenre.setDescription(genre.getDescription());
        Genre updatedGenre = genreRepository.save(existingGenre);
        return updatedGenre;
    }

    @Override
    public void deleteGenre(Long genreId) {
        genreRepository.deleteById(genreId);
    }
}