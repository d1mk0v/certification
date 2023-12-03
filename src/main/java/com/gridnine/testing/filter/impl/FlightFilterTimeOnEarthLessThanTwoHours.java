package com.gridnine.testing.filter.impl;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import com.gridnine.testing.filter.inter.FlightFilter;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

public class FlightFilterTimeOnEarthLessThanTwoHours implements FlightFilter {

    @Override
    public List<Flight> filter(List<Flight> flights) {
        System.out.println("Filter flight with more than two hours ground time");
        return flights
                .stream()
                .filter(flight -> checkTimeOnEarth(flight.getSegments()))
                .collect(Collectors.toList());
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
