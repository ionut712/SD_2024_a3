package com.example.demo.service.implementation;

import com.example.demo.entity.Movie;
import com.example.demo.repository.MovieRepository;
import com.example.demo.service.MovieService;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MovieServiceImplementation implements MovieService{

    private MovieRepository movieRepository;

    public MovieServiceImplementation(MovieRepository movieRepository){
        this.movieRepository=movieRepository;
    }

    @Override
    public Movie createMovie(Movie movie){
        return movieRepository.save(movie);
    }

    @Override
    public Movie getMovieById(Long movieId) {
        Optional<Movie> optionalMovie = movieRepository.findById(movieId);
        return optionalMovie.get();
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie updateMovie(Movie movie) {
        Movie existingMovie = movieRepository.findById(movie.getId()).get();
        existingMovie.setName(movie.getName());
        existingMovie.setRating(movie.getRating());
        existingMovie.setDuration_minutes(movie.getDuration_minutes());
        Movie updatedMovie = movieRepository.save(existingMovie);
        return updatedMovie;
    }

    @Override
    public void deleteMovie(Long movieId) {
        movieRepository.deleteById(movieId);
    }
}
