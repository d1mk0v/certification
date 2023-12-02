package com.gridnine.testing;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Flight> flightList = FlightBuilder.createFlights();
        flightList.forEach(System.out::println);
        System.out.println();

        FlightFilter filter1 = new FlightFilterDepartingBeforeArrives();
        filter1.filter(flightList).forEach(System.out::println);
        System.out.println();

        FlightFilter filter2 = (FlightFilter) new FlightFilterDepartingInPast();
        filter2.filter(flightList).forEach(System.out::println);
        System.out.println();

        FlightFilter filter3 = new FlightFilterTimeOnEarthLessThanTwoHours();
        filter3.filter(flightList).forEach(System.out::println);
        System.out.println();

        FlightFilterFabric filterFabric = new FlightFilterFabric(Arrays.asList(
                filter1,
                filter2,
                filter3
        ));

        filterFabric.doFilter(flightList).forEach(System.out::println);
    }
}