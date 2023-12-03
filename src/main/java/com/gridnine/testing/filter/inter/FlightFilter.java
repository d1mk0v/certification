package com.gridnine.testing.filter.inter;

import com.gridnine.testing.model.Flight;

import java.util.List;

public interface FlightFilter {
    List<Flight> filter(List<Flight> flights);

}
