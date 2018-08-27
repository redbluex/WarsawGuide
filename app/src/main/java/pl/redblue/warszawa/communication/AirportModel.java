package pl.redblue.warszawa.communication;

import java.util.ArrayList;
import java.util.List;

public class AirportModel {
    public List<Airport> giveAirport(){
        List<Airport> list = new ArrayList<>();
        list.add(new Airport("Chopin Airport","Żwirki i Wigury 1, 00-001 Warszawa", "The airport is located on Ochota, one of Warsaw's districts. \n" +
                "Public buses run next to the airport", "ZTM, TAXI", "Public bus: - 3 zł, Taxi: 20-50 zł"));
        list.add(new Airport("Modlin Airport", "Generała Wiktora Thommée 1a, 05-102 Nowy Dwór Mazowiecki", "The airport is located 35 km from center of Warsaw.", "Modlin Bus, Taxi, Train", "Modlin Bus: 23-25 zł, Train 20-30 zł, Taxi: 100-150zł"));
        return list;
    }
}
