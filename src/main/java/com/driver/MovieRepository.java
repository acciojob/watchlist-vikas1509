package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {
    private HashMap<String, Movie> movieMap;
    private HashMap<String, Director> directorMap;
    private HashMap<String, List<String>> directorMovieMapping;

    public MovieRepository(){
        this.movieMap = new HashMap<String, Movie>();
        this.directorMap = new HashMap<String, Director>();
        this.directorMovieMapping = new HashMap<String, List<String>>();
    }


    public String addMovie(Movie movie){
        String movieName= movie.getName();
        movieMap.put(movieName,movie);
        return  "movie add Successfully";
    }

    public String  addDirector(Director directore){
        String dname=directore.getName();

        directorMap.put(dname,directore);

        return "Added directore Name";
    }

    public void addMovieDirectorePair(String movieName,String directoreName){

        if(movieMap.containsKey(movieName) && directorMap.containsKey(directoreName)) {
            List<String> currentMovie = new ArrayList<>();

            if (directorMovieMapping.containsKey(directoreName)) {

                currentMovie.add(movieName);
                directorMovieMapping.put(directoreName, currentMovie);
            }
        }
    }
    public Movie findMovie(String movieName){
        return movieMap.get(movieName);
    }

    public Director findDirector(String directorName){

        return directorMap.get(directorName);
    }

    public  List<String> findMoviesfromDirector(String directore){
        List<String> movielist = new ArrayList<>();
        if(directorMovieMapping.containsKey(directore)){

            movielist= directorMovieMapping.get(directore);


        }
        return movielist;
    }

    public  List<String> findAllMovie(){

        return new ArrayList<>(movieMap.keySet());
    }

    public void deleteDirectorkimovie(String director){
        List<String> movies = new ArrayList<>();

        if(directorMovieMapping.containsKey(director)){
            movies=directorMovieMapping.get(director);
        }
        for(String x:movies){
            if(movieMap.containsKey(x)){
                movieMap.remove(x);
            }
        }

        directorMovieMapping.remove(director);

if(directorMap.containsKey(director)){
    directorMap.remove(director);
}

    }
    public void  DeleteMovieofallDirectore(){
        List<String> movieset = new ArrayList<>();

     for(String Director :directorMovieMapping.keySet()){
         for (String movie:directorMovieMapping.get(Director)){
             movieset.add(movie);
         }

     }
     for(String movie: movieset){
         if(movieMap.containsKey(movie)){
             movieMap.remove(movie);
         }
     }

    }








}
