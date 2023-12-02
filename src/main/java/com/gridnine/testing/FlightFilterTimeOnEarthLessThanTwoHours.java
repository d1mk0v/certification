package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class FlightFilterTimeOnEarthLessThanTwoHours implements FlightFilter {

    @Override
    public List<Flight> filter(List<Flight> flights) {
        System.out.println("Filter flight with more than two hours ground time");
        return flights
                .stream()
                .filter(flight -> checkTimeOnEarth(flight.getSegments()))
                .toList();
    }

    private boolean checkTimeOnEarth(List<Segment> segments) {
        if (segments.size() == 1) {
            return true;
        }
        int allTimeOnEarth = 0;
        for (int i = 1; i < segments.size(); i++) {
            allTimeOnEarth += timeOnEarth(segments.get(i - 1).getArrivalDate(), segments.get(i).getDepartureDate());
        }
        int hoursOnEarth = 2;

        return allTimeOnEarth <= hoursOnEarth;
    }

    private int timeOnEarth(LocalDateTime arr, LocalDateTime dep) {
        return (int) ChronoUnit.HOURS.between(arr, dep);
    }
}
