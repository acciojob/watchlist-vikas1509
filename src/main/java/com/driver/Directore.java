package com.driver;

//Director.java Class - String name, int numberOfMovies, double imdbRating, no-args constructor, all-args constructor and getters-setters
public class Directore {
    private  String Dname ;
    private int numberOfMovies;
    private double imdbRating;

    public Directore (String Dname , int numberOfMovies,int imdbRating){
        this.Dname=Dname;
        this. numberOfMovies=numberOfMovies;
        this.imdbRating=imdbRating;
    }
    public Directore(){

    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getDName() {
        return Dname;
    }

    public void setDName(String name) {
        this.Dname = Dname;
    }

    public int getNumberOfMovies() {
        return numberOfMovies;
    }

    public void setNumberOfMovies(int numberOfMovies) {
        this.numberOfMovies = numberOfMovies;
    }

}
