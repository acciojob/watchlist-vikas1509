package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public void addMovie(Movie movie){

         movieRepository.addMovie(movie);
    }

    public void  addDirector(Director directore){
        movieRepository.addDirector(directore);
    }
    public void addMovieDirectorPair(String movieName , String DirectoreName){

        movieRepository.addMovieDirectorePair(movieName,DirectoreName);
    }
    public void createMovieDirectorPair(String movie, String  director){
        movieRepository.addMovieDirectorePair(movie,director);
    }
    public Movie findMovie(String movieName){
       Movie movie= movieRepository.findMovie(movieName);
       return movie;
    }
    public Director findDirector(String directorName){
     return  movieRepository.findDirector(directorName);
    }
    public List<String> findMoviesFromDirector(String movieName){
List<String> movies = movieRepository.findMoviesfromDirector(movieName);
return movies;
    }
    public List<String > findAllMovies(){
        List<String> allMovie = new ArrayList<>();
       allMovie= movieRepository.findAllMovie();
        return allMovie;
    }
public void deleteDirector(String directorName){
        movieRepository.deleteDirectorkimovie(directorName);
}
public void deleteAllDirectors(){
        movieRepository.DeleteMovieofallDirectore();
}
}
