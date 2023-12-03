package com.gridnine.testing.filter.impl;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс, предназначенный для тестирования фильтра FlightFilterDepartingBeforeArrives.
 */
class FlightFilterDepartingBeforeArrivesTest {

    /**
     * Тест проверяющий корректность данных о вылетах.
     */
    @DisplayName("Check correct depart")
    @Test
    void filterShouldReturnCorrectSegmentTest() {
        Segment correctSegment1 = new Segment(LocalDateTime.now(), LocalDateTime.now().plusHours(2));
        Segment correctSegment2 = new Segment(LocalDateTime.now().plusHours(3), LocalDateTime.now().plusHours(5));
        List<Segment> segmentList = new ArrayList<>();
        segmentList.add(correctSegment1);
        segmentList.add(correctSegment2);
        Flight flight = new Flight(segmentList);
        List<Flight> flightList = new FlightFilterDepartingBeforeArrives().filter(List.of(flight));

        assertFalse(flightList.isEmpty());
    }

    /**
     * Тест проверяющий наличие ошибочных данных о вылетах.
     */
    @DisplayName("Check segment depart after arrival")
    @Test
    void filterShouldReturnNullWithIncorrectSegmentTest() {
        Segment incorrectSegment1 = new Segment(LocalDateTime.now().plusDays(2), LocalDateTime.now());
        List<Segment> segmentList = new ArrayList<>(List.of(incorrectSegment1));
        Flight flight = new Flight(segmentList);
        List<Flight> flightList = new FlightFilterDepartingBeforeArrives().filter(List.of(flight));

        assertTrue(flightList.isEmpty());
    }
}