package pl.redblue.warszawa.communication;

import java.util.ArrayList;
import java.util.List;

import pl.redblue.warszawa.R;

public class TicketModel {

    public List<SingleTicket> giveTickets(){
        List<SingleTicket> list = new ArrayList<>();
        list.add(new SingleTicket("20 minute ticket / zone 1+2", "20 minute ticket entitles to an unlimited number of journeys for a period not exceeding 20 minutes from its validation.", R.drawable.dwudziestonorm, "3.40 zł" ));
        list.add(new SingleTicket("Reduced fare 20 minute ticket / zone 1+2", "20 minute ticket entitles to an unlimited number of journeys for a period not exceeding 20 minutes from its validation. ", R.drawable.dwudziesto, "1.70 zł" ));
        list.add(new SingleTicket("Single transfer ticket / zone 1", "Single fare transfer ticket entitles to an unlimited number of journeys for a period not exceeding 75 minutes from its validation or entitling to a single journey to a stop or station which is the last on the route.", R.drawable.normalnynorm, "4.40 zł"));
        list.add(new SingleTicket("Reduced fare single transfer ticket / zone 1", "Single fare transfer ticket entitles to an unlimited number of journeys for a period not exceeding 75 minutes from its validation or entitling to a single journey to a stop or station which is the last on the route.", R.drawable.normulg, "2.20 zł"));
        list.add(new SingleTicket("Reduced fare single transfer ticket / zone 1+2", "Single fare transfer ticket entitles to an unlimited number of journeys for a period not exceeding 90 minutes from its validation or entitling to a single journey to a stop or station which is the last on the route.", R.drawable.dziewiecnorm, "7.00 zł"));
        list.add(new SingleTicket("Reduced fare single transfer ticket / zone 1+2", "Single fare transfer ticket entitles to an unlimited number of journeys for a period not exceeding 90 minutes from its validation or entitling to a single journey to a stop or station which is the last on the route.", R.drawable.dziewieculg, "3.50 zł"));
        list.add(new SingleTicket("Reduced fare single transfer ticket up to 10 person / zone 1", "Single fare transfer group ticket entitles a group up to 10 people to an unlimited number of journeys for a period not exceeding 75 minutes from its validation or entitling to a single journey to a stop or station which is the last on the route.", R.drawable.grupowynorm, "22.00 zł"));
        list.add(new SingleTicket("One day ticket / zone 1", "One-day ticket entitles to unlimited number of journeys for 24 hours from its validation.", R.drawable.dobowynorm, "15.00 zł"));
        list.add(new SingleTicket("Reduced fare one day ticket / zone 1","One-day ticket entitles to unlimited number of journeys for 24 hours from its validation.", R.drawable.dobowyulg, "7.50 zł"));
        list.add(new SingleTicket("One day ticket / zone 1+2","One-day ticket entitles to unlimited number of journeys for 24 hours from its validation.", R.drawable.domowynormdwie, "26.00 zł"));
        list.add(new SingleTicket("Reduced fare one day ticket / zone 1+2","One-day ticket entitles to unlimited number of journeys for 24 hours from its validation.", R.drawable.domowyulgdwie, "13.00 zł"));
        list.add(new SingleTicket("Three day ticket / zone 1","3-day ticket entitles to unlimited number of journeys for 72 hours from its validation.", R.drawable.trzydninorm, "36.00 zł"));
        list.add(new SingleTicket("Reduced fare three day ticket / zone 1","3-day ticket entitles to unlimited number of journeys for 72 hours from its validation.", R.drawable.trzydniulg, "18.00 zł"));
        list.add(new SingleTicket("Reduced fare three day ticket / zone 1+2","3-day ticket entitles to unlimited number of journeys for 72 hours from its validation.", R.drawable.trzydninormdwie, "57.00 zł"));
        list.add(new SingleTicket("Reduced fare three day ticket / zone 1+2","3-day ticket entitles to unlimited number of journeys for 72 hours from its validation.", R.drawable.trzydniulgdwie, "28.50 zł"));
        list.add(new SingleTicket("Weekend ticket / zone 1+2","Weekend ticket entitles to unlimited number of journeys from 7:00 PM on Friday till 8:00 AM on Monday.", R.drawable.wekendn, "24.00 zł"));
        list.add(new SingleTicket("Reduced fare weekend ticket / zone 1+2","Weekend ticket entitles to unlimited number of journeys from 7:00 PM on Friday till 8:00 AM on Monday.", R.drawable.wekendu, "12.00 zł"));
        list.add(new SingleTicket("Group weekend ticket / zone 1+2", "Group weekend ticket entitles a group of up to 5 people to unlimited number of journeys from 7:00 PM on Friday till 8:00 AM on Monday", R.drawable.grup, "40.00 zł"));
        return list;
    }

    public List<Airport> giveAirport(){
        List<Airport> list = new ArrayList<>();
        list.add(new Airport("Chopin Airport","Żwirki i Wigury 1, 00-001 Warszawa", "The airport is located on Ochota, one of Warsaw's districts. \n" +
                "Public buses run next to the airport", "ZTM, TAXI", "Public bus: - 3 zł, Taxi: 20-50 zł"));
        list.add(new Airport("Modlin Airport", "Generała Wiktora Thommée 1a, 05-102 Nowy Dwór Mazowiecki", "The airport is located 35 km from center of Warsaw.", "Modlin Bus, Taxi, Train", "Modlin Bus: 23-25 zł, Train 20-30 zł, Taxi: 100-150zł"));
        return list;
    }
}
