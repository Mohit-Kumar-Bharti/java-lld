package com.mohit.bookmyshow;

import java.util.List;

public class Main {
    static void main() {
        City city = new City();
        city.id = "1";
        city.name = "Delhi";


        Movie movie = new Movie();
        movie.id = "2";
        movie.name = "dhurandhar";

        Theatre theatre = new Theatre();
        theatre.id = "3";

        TheatreController controller = new TheatreController();
        controller.addTheatre(theatre,city);


        List<Theatre> theatreList = controller.getTheatreList();
        Show show = new Show();
        show.id = "4";
        show.movie = movie;

        Screen screen = new Screen();
        screen.id = "5";


        for(Theatre th : theatreList) {
            if(th.id.equals(theatre.id)) {
                th.addScreen(screen);
            }
        }


        for(Theatre th : theatreList) {
            if(th.id.equals(theatre.id)) {
                System.out.println("adding show" + " " +  th.id);
                th.addShow(show,screen);
            }
        }

        System.out.println(controller.getTheatreShows(city).size());

        for(Show shows : controller.getTheatreShows(city)) {
            System.out.println(show.movie.name);
            System.out.println("here...");
        }

    }
}
