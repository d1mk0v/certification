package com.gridnine.testing;

import com.gridnine.testing.Flight;
import com.gridnine.testing.FlightFilter;

import java.util.ArrayList;
import java.util.List;

public class FlightFilterFabric {
    private final List<FlightFilter> filters;

    public FlightFilterFabric(List<FlightFilter> filters) {
        this.filters = filters;
    }

    public List<Flight> doFilter(List<Flight> flights) {
        List<Flight> filterList = new ArrayList<>(flights);

        for(FlightFilter filter : filters){
            filterList = filter.filter(filterList);
        }

        return filterList;
    }

}
