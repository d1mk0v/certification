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
 * Класс для тестирования фильтра FlightFilterTimeOnEarthLessThanTwoHours.
 */
class FlightFilterTimeOnEarthLessThanTwoHoursTest {

    /**
     * Проверяет корректность данных с одним сегментом.
     */
    @DisplayName("Check one segment")
    @Test
    void filterShouldReturnCorrectCorrectAnswerWithOneSegmentTest() {
        Segment correctSegment1 = new Segment(LocalDateTime.now(), LocalDateTime.now().plusDays(1));
        List<Segment> segmentList = new ArrayList<>();
        segmentList.add(correctSegment1);
        Flight flight = new Flight(segmentList);
        List<Flight> flightList = new FlightFilterTimeOnEarthLessThanTwoHours().filter(List.of(flight));

        assertFalse(flightList.isEmpty());
    }

    /**
     * Проверяет правильность данных о времени на земле с несколькими сегментами.
     */
    @DisplayName("Check correct depart")
    @Test
    void filterShouldReturnCorrectSegmentTest() {
        Segment correctSegment1 = new Segment(LocalDateTime.now(), LocalDateTime.now().plusHours(5));
        Segment correctSegment2 = new Segment(LocalDateTime.now().plusHours(6), LocalDateTime.now().plusHours(8));
        Segment correctSegment3 = new Segment(LocalDateTime.now().plusHours(9), LocalDateTime.now().plusHours(12));
        List<Segment> segmentList = new ArrayList<>();
        segmentList.add(correctSegment1);
        segmentList.add(correctSegment2);
        segmentList.add(correctSegment3);
        Flight flight = new Flight(segmentList);
        List<Flight> flightList = new FlightFilterTimeOnEarthLessThanTwoHours().filter(List.of(flight));

        assertFalse(flightList.isEmpty());
    }

    /**
     * Проверяет данные о вылете в прошлом в случае нескольких сегментов.
     */
    @DisplayName("Check depart in the past")
    @Test
    void filterShouldReturnNullTest() {
        Segment segment1 = new Segment(LocalDateTime.now(), LocalDateTime.now().plusHours(5));
        Segment segment2 = new Segment(LocalDateTime.now().plusHours(8), LocalDateTime.now().plusHours(10));
        List<Segment> segmentList = new ArrayList<>();
        segmentList.add(segment1);
        segmentList.add(segment2);
        Flight flight = new Flight(segmentList);
        List<Flight> flightList = new FlightFilterTimeOnEarthLessThanTwoHours().filter(List.of(flight));

        assertTrue(flightList.isEmpty());
    }
}