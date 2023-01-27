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
    public void creatMovieDirectorPair(String movieName , String DirectoreName){

        movieRepository.addMovieDirectorePair(movieName,DirectoreName);
    }
    public Movie findMovie(String movieName){
       Movie movie= movieRepository.findMovie(movieName);
       return movie;
    }
    public Director findDirector(String directorName){
     return  movieRepository.findDirector(directorName);
    }
    public void findMovieFromDirector(String movieName){

movieRepository.findMoviesfromDirector(movieName);
    }
    public List<String > findAllMovie(){
        List<String> allMovie = new ArrayList<>();
       allMovie= movieRepository.findAllMovie();
        return allMovie;
    }
public void DeleteDirectorkiMovie(String directorName){
        movieRepository.deleteDirectorkimovie(directorName);
}
public void deleteAllDirector(){
        movieRepository.DeleteMovieofallDirectore();
}
}
