package com.gridnine.testing.filter.impl;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import com.gridnine.testing.filter.inter.FlightFilter;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс, реализующий фильтр для перелетов, где общее время на земле не превышает двух часов.
 */
public class FlightFilterTimeOnEarthLessThanTwoHours implements FlightFilter {

    /**
     * Фильтрует список перелетов на основе общего времени на земле, не превышающего два часа.
     * @param flights список перелетов для фильтрации
     * @return отфильтрованный список перелетов
     */
    @Override
    public List<Flight> filter(List<Flight> flights) {
        System.out.println("Filter flight with more than two hours ground time");
        return flights
                .stream()
                .filter(flight -> checkTimeOnEarth(flight.getSegments()))
                .collect(Collectors.toList());
    }

    /**
     * Проверяет, не превышает ли общее время на земле для каждого перелета два часа.
     * @param segments список сегментов
     * @return true, если общее время на земле не превышает два часа, иначе false
     */
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

    /**
     * Вычисляет время на земле между прилетом и вылетом для двух дат.
     * @param arr дата и время прилета
     * @param dep дата и время вылета
     * @return время на земле в часах
     */
    private int timeOnEarth(LocalDateTime arr, LocalDateTime dep) {
        return (int) ChronoUnit.HOURS.between(arr, dep);
    }
}
