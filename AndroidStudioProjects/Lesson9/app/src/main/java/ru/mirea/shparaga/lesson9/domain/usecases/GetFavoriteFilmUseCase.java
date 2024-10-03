package ru.mirea.shparaga.lesson9.domain.usecases;

import ru.mirea.shparaga.lesson9.domain.models.Movie;
import ru.mirea.shparaga.lesson9.domain.repository.MovieRepository;

public class GetFavoriteFilmUseCase {
    private final MovieRepository movieRepository;
    public GetFavoriteFilmUseCase(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    public Movie execute(){
        return movieRepository.getMovie();
    }
}
