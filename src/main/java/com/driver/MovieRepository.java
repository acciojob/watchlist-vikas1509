package com.driver;

//@Repository
//public class MovieRepository {
//    private HashMap<String, Movie> movieMap;
//    private HashMap<String, Director> directorMap;
//    private HashMap<String, List<String>> directorMovieMapping;
//
//    public MovieRepository(){
//        this.movieMap = new HashMap<String, Movie>();
//        this.directorMap = new HashMap<String, Director>();
//        this.directorMovieMapping = new HashMap<String, List<String>>();
//    }
//
//
//    public String  (Movie movie){
//        String movieName= movie.getName();
//        movieMap.put(movieName,movie);
//        return  "movie add Successfully";
//    }
//
//    public String  addDirector(Director directore){
//        String dname=directore.getName();
//
//        directorMap.put(dname,directore);
//
//        return "Added directore Name";
//    }
//
//    public void addMovieDirectorePair(String movieName,String directoreName){
//
//        if(movieMap.containsKey(movieName) && directorMap.containsKey(directoreName)) {
//            List<String> currentMovie = new ArrayList<>();
//
//            if (directorMovieMapping.containsKey(directoreName)) {
//
//                currentMovie.add(movieName);
//                directorMovieMapping.put(directoreName, currentMovie);
//            }
//        }
//    }
//    public Movie findMovie(String movieName){
//        return movieMap.get(movieName);
//    }
//
//    public Director findDirector(String directorName){
//
//        return directorMap.get(directorName);
//    }
//
//    public  List<String> findMoviesfromDirector(String directore){
//        List<String> movielist = new ArrayList<>();
//        if(directorMovieMapping.containsKey(directore)){
//
//            movielist= directorMovieMapping.get(directore);
//
//
//        }
//        return movielist;
//    }
//
//    public  List<String> findAllMovie(){
//
//        return new ArrayList<>(movieMap.keySet());
//    }
//
//    public void deleteDirectorkimovie(String director){
//        List<String> movies = new ArrayList<>();
//
//        if(directorMovieMapping.containsKey(director)){
//            movies=directorMovieMapping.get(director);
//        }
//        for(String x:movies){
//            if(movieMap.containsKey(x)){
//                movieMap.remove(x);
//            }
//        }
//
//        directorMovieMapping.remove(director);
//
//if(directorMap.containsKey(director)){
//    directorMap.remove(director);
//}
//
//    }
//    public void  DeleteMovieofallDirectore(){
//        List<String> movieset = new ArrayList<>();
//
//     for(String Director :directorMovieMapping.keySet()){
//         for (String movie:directorMovieMapping.get(Director)){
//             movieset.add(movie);
//         }
//
//     }
//     for(String movie: movieset){
//         if(movieMap.containsKey(movie)){
//             movieMap.remove(movie);
//         }
//     }
//
//    }
//
//
//
//
//
//
//
//
//}

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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

    public void addMovie(Movie movie){
        movieMap.put(movie.getName(), movie);
    }

    public void addDirector(Director director){
        directorMap.put(director.getName(), director);
    }

    public void addMovieDirectorPair(String movie, String director){
        if(movieMap.containsKey(movie) && directorMap.containsKey(director)){
            movieMap.put(movie, movieMap.get(movie));
            directorMap.put(director, directorMap.get(director));
            List<String> currentMovies = new ArrayList<String>();
            if(directorMovieMapping.containsKey(director)) currentMovies = directorMovieMapping.get(director);
            currentMovies.add(movie);
            directorMovieMapping.put(director, currentMovies);
        }
    }

    public Movie findMovie(String movie){
        return movieMap.get(movie);
    }

    public Director findDirector(String director){
        return directorMap.get(director);
    }

    public List<String> findMoviesfromDirector(String director){
        List<String> moviesList = new ArrayList<String>();
        if(directorMovieMapping.containsKey(director)) moviesList = directorMovieMapping.get(director);
        return moviesList;
    }

    public List<String> findAllMovie(){
        return new ArrayList<>(movieMap.keySet());
    }

    public void deleteDirector(String director){
        List<String> movies = new ArrayList<String>();
        if(directorMovieMapping.containsKey(director)){
            movies = directorMovieMapping.get(director);
            for(String movie: movies){
                if(movieMap.containsKey(movie)){
                    movieMap.remove(movie);
                }
            }

            directorMovieMapping.remove(director);
        }

        if(directorMap.containsKey(director)){
            directorMap.remove(director);
        }
    }

    public void deleteAllDirector(){
        HashSet<String> moviesSet = new HashSet<String>();

        //directorMap = new HashMap<>();

        for(String director: directorMovieMapping.keySet()){
            for(String movie: directorMovieMapping.get(director)){
                moviesSet.add(movie);
            }
        }

        for(String movie: moviesSet){
            if(movieMap.containsKey(movie)){
                movieMap.remove(movie);
            }
        }
    }
}
