package com.gridnine.testing.filter.impl;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import com.gridnine.testing.filter.inter.FlightFilter;

import java.util.List;
import java.util.stream.Collectors;

public class FlightFilterDepartingBeforeArrives implements FlightFilter {

    @Override
    public List<Flight> filter(List<Flight> flights) {
        System.out.println("Filter departs before it arrives");
        return flights
                .stream()
                .filter(flight -> checkDepartureDateInSegment(flight.getSegments()))
                .collect(Collectors.toList());
    }

    private boolean checkDepartureDateInSegment(List<Segment> segments){
        return segments
                .stream()
                .allMatch(segment -> segment.getArrivalDate().isAfter(segment.getDepartureDate()));
    }
}
