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
 * Класс для тестирования фильтра FlightFilterDepartingInPast.
 */
class FlightFilterDepartingInPastTest {

    /**
     * Проверяет правильность данных о времени вылета.
     */
    @DisplayName("Check correct depart")
    @Test
    void filterShouldReturnCorrectSegmentTest() {
        Segment correctSegment1 = new Segment(LocalDateTime.now().plusHours(1), LocalDateTime.now().plusDays(1));
        List<Segment> segmentList = new ArrayList<>();
        segmentList.add(correctSegment1);
        Flight flight = new Flight(segmentList);
        List<Flight> flightList = new FlightFilterDepartingInPast().filter(List.of(flight));

        assertFalse(flightList.isEmpty());
    }

    /**
     * Проверяет данные о вылете в прошлом.
     */
    @DisplayName("Check depart in the past")
    @Test
    void filterShouldReturnNullTest() {
        Segment incorrectSegment1 = new Segment(LocalDateTime.now().minusDays(3), LocalDateTime.now());
        List<Segment> segmentList = new ArrayList<>(List.of(incorrectSegment1));
        Flight flight = new Flight(segmentList);
        List<Flight> flightList = new FlightFilterDepartingInPast().filter(List.of(flight));

        assertTrue(flightList.isEmpty());
    }
}