package ru.mirea.shparaga.lesson9.domain.usecases;

import ru.mirea.shparaga.lesson9.domain.models.Movie;
import ru.mirea.shparaga.lesson9.domain.repository.MovieRepository;

public class SaveMovieToFavoriteUseCase {
    private final MovieRepository movieRepository;
    public SaveMovieToFavoriteUseCase(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    public boolean execute(Movie movie){
        return movieRepository.saveMovie(movie);
    }
}