package com.example.demo;

import com.example.demo.Enum.SeatCategory;
import com.example.demo.Enum.SeatStatus;

import java.util.*;

public class BookMyShow {

    MovieController movieController;
    TheatreController theatreController;

    BookMyShow()
    {
        movieController = new MovieController();
        theatreController = new TheatreController();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        BookMyShow bookMyShow = new BookMyShow();
        bookMyShow.initialize();

        System.out.println("Select City");
        System.out.println(bookMyShow.movieController.getCities());
        String userCity = scanner.nextLine();
        System.out.println("select movie");
        System.out.println(bookMyShow.movieController.getMoviesListByCity(bookMyShow.movieController.getCitiesBYName(userCity)));
        String userMovie = scanner.nextLine();
        System.out.println("Select Theatre Id");
        System.out.println(bookMyShow.theatreController.getAllTheatreBYMovieandCity(bookMyShow.movieController.getMovieByName(userMovie),bookMyShow.movieController.getCitiesBYName(userCity)));
        Integer theatreId = scanner.nextInt();

        Theatre UserTheatre = bookMyShow.theatreController.getTheatreById(theatreId);
        System.out.println("Select Show");
        Map<Theatre,List<Show>> mapLsitShow = bookMyShow.theatreController.getAllShow(bookMyShow.movieController.getMovieByName(userMovie),
                bookMyShow.movieController.getCitiesBYName(userCity),
                theatreId
                );
        //List<Show>AvailableShows = new ArrayList<>();


        for(Map.Entry<Theatre,List<Show>>mp:mapLsitShow.entrySet())
        {
            System.out.println(mp.getKey().getAddress() );
            System.out.println(mp.getValue());

        }

        System.out.println("Select ShowId");
        Integer showId=scanner.nextInt();
        System.out.println(UserTheatre.getShowById(showId));
        System.out.println("Select Seat for Booking");
        Show UserShow = UserTheatre.getShowById(showId);
        System.out.println(UserShow.getSeatStatus());
        int UserSeat= scanner.nextInt();
        bookMyShow.createBooking(UserTheatre,UserShow,UserSeat);

        System.out.println("All Availabe Seats ");

        System.out.println(UserShow.getSeatStatus());

        System.out.println();


//        System.out.println(mapLsitShow.get());









//        System.out.println("Movie by city list");
//        System.out.println(bookMyShow.movieController.MoviesListByCity);
//        System.out.println("All moviue list");
//        System.out.println(bookMyShow.movieController.getAllMovies());




    }
    private void initialize()
    {
        createMoviesCities();
        createTheatre();

    }

    private void createBooking(Theatre userTheatre, Show UserShow,int UserSeat)
    {
        if(UserShow.getSeatStatus().get(UserSeat).equals(SeatStatus.AVAILABLE))
        {
            UserShow.setSeatStatus(UserSeat,SeatStatus.BOOKED);
            Booking booking = new Booking(UserShow,new Payment(UUID.randomUUID()));
            System.out.println("Seat Booked");

        }
        else
        {
            System.out.println("Seat Can't Be Booked");
        }

    }

    private void createMoviesCities()
    {
        Movie Avenger = new Movie("Avenger",1,126);
        Movie RRR = new Movie("RRR",2,128);

        City jaipur = new City("Jaipur");
        City delhi = new City("Delhi");

        movieController.addCity(jaipur);
        movieController.addCity(delhi);
        movieController.addMovie(Avenger,jaipur);
        movieController.addMovie(Avenger,delhi);
        movieController.addMovie(RRR,jaipur);
        movieController.addMovie(RRR,delhi);

    }

    private void createTheatre()
    {
        Movie Avenger = movieController.getMovieByName("Avenger");
        Movie RRR = movieController.getMovieByName("RRR");
        Theatre OSK = new Theatre();
        OSK.setAddress("LLK Road");
        City city = movieController.getCitiesBYName("Jaipur");
        OSK.setCity(city);
        OSK.setTheatreId(111);
        OSK.setScreenList(createScreen());
        List<Show> showLists = new ArrayList<>();
        Map<Integer, SeatStatus>bookedSheets1 = new HashMap<>();
        for(int i=0;i<100;i++)
        {
            bookedSheets1.put(i,SeatStatus.AVAILABLE);
        }
        Show morningShowOsk = new Show(3,Avenger,OSK.getScreenList().get(0),9,bookedSheets1);
        Show eveninggShowOsk = new Show(4,RRR,OSK.getScreenList().get(0),6,bookedSheets1);
        showLists.add(morningShowOsk);
        showLists.add(eveninggShowOsk);
        OSK.setShowList(showLists);
        theatreController.addTheatre(OSK,city);


        Theatre PVR = new Theatre();
        PVR.setAddress("MK Road");
        City city2 = movieController.getCitiesBYName("Delhi");
        PVR.setCity(city2);
        PVR.setTheatreId(111);
        PVR.setScreenList(createScreen());
        List<Show> showLists2 = new ArrayList<>();
        Map<Integer, SeatStatus>bookedSheets2 = new HashMap<>();
        for(int i=0;i<100;i++)
        {
            bookedSheets2.put(i,SeatStatus.AVAILABLE);
        }
        Show morningShowpvr = new Show(3,Avenger,PVR.getScreenList().get(0),9,bookedSheets2);
        Show eveninggShowpvr = new Show(4,RRR,PVR.getScreenList().get(0),6,bookedSheets2);
        showLists2.add(morningShowpvr);
        showLists2.add(eveninggShowpvr);
        PVR.setShowList(showLists2);
        theatreController.addTheatre(PVR,city2);


    }

    private List<Screen> createScreen()
    {
        List<Screen> screenList = new ArrayList<>();
        Screen screen1 = new Screen();
        screen1.setScreenId(1);
        screen1.setListSeat(createSeats());
        screenList.add(screen1);
        return screenList;

    }

    private List<Seat> createSeats()
    {
        List<Seat> seats = new ArrayList<>();

        //1 to 40 : SILVER
        for (int i = 0; i < 40; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.SILVER);
            seats.add(seat);
        }

        //41 to 70 : SILVER
        for (int i = 40; i < 70; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.GOLD);
            seats.add(seat);
        }

        //1 to 40 : SILVER
        for (int i = 70; i < 100; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.PLATINUM);
            seats.add(seat);
        }

        return seats;



    }

}
