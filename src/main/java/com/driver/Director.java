package com.driver;

//Director.java Class - String name, int numberOfMovies, double imdbRating, no-args constructor, all-args constructor and getters-setters
public class Director {
    private  String name ;
    private int numberOfMovies;
    private double imdbRating;

    public Director(String name , int numberOfMovies, int imdbRating){
        this.name=name;
        this. numberOfMovies=numberOfMovies;
        this.imdbRating=imdbRating;
    }
    public Director(){

    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getDName() {
        return name;
    }

    public void setDName(String name) {
        this.name = name;
    }

    public int getNumberOfMovies() {
        return numberOfMovies;
    }

    public void setNumberOfMovies(int numberOfMovies) {
        this.numberOfMovies = numberOfMovies;
    }

}
