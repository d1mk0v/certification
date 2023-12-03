package com.gridnine.testing.filter.impl;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import com.gridnine.testing.filter.inter.FlightFilter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс, реализующий фильтр для перелетов, где вылет происходит в прошлом.
 */
public class FlightFilterDepartingInPast implements FlightFilter {

    /**
     * Фильтрует список перелетов на основе того, происходит ли вылет в прошлом.
     * @param flights список перелетов для фильтрации
     * @return отфильтрованный список перелетов
     */
    @Override
    public List<Flight> filter(List<Flight> flights) {
        System.out.println("Filter departing in the past");
        return flights
                .stream()
                .filter(flight -> checkDepartInThePast(flight.getSegments()))
                .collect(Collectors.toList());
    }

    /**
     * Проверяет, происходит ли вылет в прошлом в каждом сегменте перелета.
     * @param segments список сегментов
     * @return true, если вылет происходит в прошлом в каждом сегменте, иначе false
     */
    private boolean checkDepartInThePast(List<Segment> segments) {
        return segments
                .stream()
                .allMatch(segment -> segment
                        .getDepartureDate()
                        .isAfter(LocalDateTime.now()));
    }
}
