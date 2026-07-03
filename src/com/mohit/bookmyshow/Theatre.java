package com.mohit.bookmyshow;

import com.sun.source.tree.BreakTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Theatre {
    String id;
    String name;

    List<Screen>  screenList = new ArrayList<>();
    public void addShow(Show show, Screen screen){
        System.out.println(this.id + " " + show.id);
        for(Screen s : screenList){
            if(s.id.equals(screen.id)){
                s.showList.add(show);
            }
        }
    }

    public void addScreen(Screen screen){
        screenList.add(screen);
    }

    List<Show> getShow() {
        List<Show> shows = new ArrayList<>();
        for (Screen screen : screenList) {
            for(Show show : screen.showList) {
                shows.add(show);

            }
        }
    return shows;

    }

}


class TheatreController {
    List<Theatre> theatreList = new ArrayList<>();
    Map<City,List<Theatre>> theatreMap = new HashMap<City,List<Theatre>>();

    public void addTheatre(Theatre theatre, City city){
        List<Theatre> theatreList = theatreMap.getOrDefault(city,new ArrayList<>());
        theatreList.add(theatre);
        theatreMap.put(city,theatreList);
        this.theatreList.add(theatre);
    }

    public List<Theatre> getTheatreList() {
        return theatreList;
    }

    public  List<Show> getTheatreShows(City city) {
        List<Show> theatreList = new ArrayList<Show>();
        for(Map.Entry<City,List<Theatre>> entry : theatreMap.entrySet()){
            if(entry.getKey().equals(city)){
                for(Theatre theatre : entry.getValue()) {
                    System.out.println(theatre.id);
                    List<Show> shows = theatre.getShow();
                    for(Show show : shows) {
                        theatreList.add(show);
                    }
                }
            }
        }
        return theatreList;
    }

}
