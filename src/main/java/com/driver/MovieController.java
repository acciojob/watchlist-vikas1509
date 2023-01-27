package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

@Autowired
    MovieService movieService;
    private org.springframework.http.ResponseEntity<Director> ResponseEntity;

    @PostMapping("/add_Movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){

    movieService.addMovie(movie);
    return new ResponseEntity<>("Movie Added Succesfully",HttpStatus.CREATED);
}
@PostMapping("/add_director")
    public ResponseEntity<String> addDirector(@RequestBody Director directore){
    movieService.addDirector(directore);

    return new ResponseEntity<>("Director Added Successfully",HttpStatus.CREATED);
}
    @PostMapping("/add_movie_by_Director_Pair")
    public ResponseEntity<String> addMvoieByDirectorPair(@RequestBody String movie , String director){
    movieService.creatMovieDirectorPair(movie,director);

    return new ResponseEntity<>("pair added successfully",HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> addMoviebyName(@PathVariable String name){

    Movie movie= movieService.findMovie(name);

    return new ResponseEntity<>(movie,HttpStatus.CREATED);
}

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name){
        Director director = movieService.findDirector(name);
        return new ResponseEntity<>(director, HttpStatus.CREATED);
    }
   @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> findMovie(@PathVariable String name){
       Movie movie= movieService.findMovie(name);
       return new ResponseEntity<>(movie, HttpStatus.CREATED);

   }
   @GetMapping("/get-all-movies")
    public ResponseEntity<List<String >> getAllMovieName(){
        List<String> allmoviename ;//= new ArrayList<>();
      allmoviename=  movieService.findAllMovie();

       return new ResponseEntity<>(allmoviename, HttpStatus.CREATED);

   }
   @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorName(@RequestParam String director){
        movieService.DeleteDirectorkiMovie(director);
        return new ResponseEntity<>("Removed Successfully",HttpStatus.CREATED);
   }

   @DeleteMapping("delete-all-directors")
    public ResponseEntity<String> deleteAll(){
        movieService.deleteAllDirector();
        return new ResponseEntity<>("Deleted all",HttpStatus.CREATED);
   }



}