package com.gridnine.testing.filter.impl;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import com.gridnine.testing.filter.inter.FlightFilter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс, реализующий фильтр для перелетов, где дата вылета происходит до даты прилета в каждом сегменте.
 */
public class FlightFilterDepartingBeforeArrives implements FlightFilter {

    /**
     * Фильтрует список перелетов на основе того, происходит ли вылет до прилета в каждом сегменте.
     * @param flights список перелетов для фильтрации
     * @return отфильтрованный список перелетов
     */
    @Override
    public List<Flight> filter(List<Flight> flights) {
        System.out.println("Filter departs before it arrives");
        return flights
                .stream()
                .filter(flight -> checkDepartureDateInSegment(flight.getSegments()))
                .collect(Collectors.toList());
    }

    /**
     * Проверяет, происходит ли вылет до прилета во всех сегментах перелета.
     * @param segments список сегментов
     * @return true, если вылет происходит до прилета в каждом сегменте, иначе false
     */
    private boolean checkDepartureDateInSegment(List<Segment> segments){
        return segments
                .stream()
                .allMatch(segment -> segment
                        .getArrivalDate()
                        .isAfter(segment.getDepartureDate()));
    }
}
