package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController {
    Map<City, List<Movie>>MoviesListByCity;
    List<Movie>AllMovies;
    List<City>Cities;

    public List<City> getCities() {
        return Cities;
    }

    MovieController()
    {
        MoviesListByCity = new HashMap<>();
        AllMovies = new ArrayList<>();
        Cities = new ArrayList<>();

    }

    public List<Movie> getMoviesListByCity(City city) {
        return MoviesListByCity.get(city);
    }

    public City getCitiesBYName(String city) {
        for(City ct:Cities)
            if(ct.getName().equals(city))return ct;
        return null;
    }

    public void addCity(City city) {

        if(city!=null)
        Cities.add(city);
    }

    public List<Movie> getAllMovies() {
        return AllMovies;
    }


    public Movie getMovieByName(String name)
    {
     for(Movie movie:AllMovies)
         if(movie.getMoviename().equals(name)){return movie;}
     return null;
    }

    public void addMovie(Movie movie,City city)
    {
        int flag=0;
        for(Movie mv : AllMovies)
        {
            if(mv.getMovieId()==movie.getMovieId())
            {
                flag=1;
                break;
            }
        }
        if(flag==0)
        AllMovies.add(movie);
        List<Movie>movieTempList=MoviesListByCity.getOrDefault(city,new ArrayList<>());

        movieTempList.add(movie);
        MoviesListByCity.put(city,movieTempList);

    }

}
