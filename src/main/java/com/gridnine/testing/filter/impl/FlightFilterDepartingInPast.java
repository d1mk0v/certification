package com.gridnine.testing.filter.impl;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import com.gridnine.testing.filter.inter.FlightFilter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class FlightFilterDepartingInPast implements FlightFilter {
        @Override
        public List<Flight> filter(List<Flight> flights) {
            System.out.println("Filter departing in the past");
            return flights
                    .stream()
                    .filter(flight -> checkDepartInThePast(flight.getSegments()))
                    .collect(Collectors.toList());
        }

        private boolean checkDepartInThePast(List<Segment> segments) {
            return segments
                    .stream()
                    .allMatch(segment -> segment.getDepartureDate().isAfter(LocalDateTime.now()));
        }
}
