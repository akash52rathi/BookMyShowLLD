package com.example.demo;

import com.example.demo.City;
import com.example.demo.Movie;
import com.example.demo.Show;
import com.example.demo.Theatre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TheatreController {


    Map<City, List<Theatre>> cityVsTheatre;
    List<Theatre> allTheatre;

    TheatreController() {
        cityVsTheatre = new HashMap<>();
        allTheatre = new ArrayList<>();
    }

    void addTheatre(Theatre theatre, City city) {

        allTheatre.add(theatre);

        List<Theatre> theatres = cityVsTheatre.getOrDefault(city, new ArrayList<>());
        theatres.add(theatre);
        cityVsTheatre.put(city, theatres);
    }

    List<Theatre> getAllTheatreBYMovieandCity(Movie movie,City city)
    {
        List<Theatre>theatreLists = cityVsTheatre.get(city);
        List<Theatre>returnList= new ArrayList<>();

        System.out.println(theatreLists);



        System.out.println(theatreLists);

        for(Theatre theatre:theatreLists)
        {
            List<Show> givenMovieShows = new ArrayList<>();
            List<Show> shows = theatre.getShowList();
            int flag=0;
            for(Show show: shows)
            {
                if(show.getMovie().getMovieId()==movie.getMovieId())
                {
                    flag=1;
                    break;
                }
            }
            if(flag==1)
            {
                returnList.add(theatre);
            }
        }

        return returnList;

    }

    Map<Theatre, List<Show>> getAllShow(Movie movie, City city,Integer theatreId) {

        //get all the theater of this city

        Map<Theatre, List<Show>> theatreVsShows = new HashMap<>();

        List<Theatre> theatres = cityVsTheatre.get(city);
        Theatre Usertheatre = new Theatre();
        for(Theatre th:theatres)
        {
            if(th.getTheatreId()==theatreId)
            {
                Usertheatre = th;
                break;
            }
        }


        //filter the theatres which run this movie



            List<Show> givenMovieShows = new ArrayList<>();
            List<Show> shows = Usertheatre.getShowList();

            for(Show show : shows) {
                if(show.getMovie().getMovieId() == movie.getMovieId()) {
                    givenMovieShows.add(show);
                }
            }
            if(!givenMovieShows.isEmpty()) {
                theatreVsShows.put(Usertheatre, givenMovieShows);
            }


        return theatreVsShows;
    }

    public Theatre getTheatreById(Integer theatreId) {
        for(Theatre theatre: allTheatre) {
            if(theatre.getTheatreId() == theatreId)
            {
                return theatre;
            }

        }
        return null;
    }
}
