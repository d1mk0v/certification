package com.gridnine.testing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlightFilterDepartingInPastTest {

    @DisplayName("Check correct depart")
    @Test
    void filterShouldReturnCorrectSegment() {
        Segment correctSegment1 = new Segment(LocalDateTime.now().plusHours(1), LocalDateTime.now().plusDays(1));
        List<Segment> segmentList = new ArrayList<>();
        segmentList.add(correctSegment1);
        Flight flight = new Flight(segmentList);
        List<Flight> flightList = new FlightFilterDepartingInPast().filter(List.of(flight));

        assertFalse(flightList.isEmpty());
    }

    @DisplayName("Check depart in the past")
    @Test
    void filterShouldReturnNull() {
        Segment incorrectSegment1 = new Segment(LocalDateTime.now().minusDays(3), LocalDateTime.now());
        List<Segment> segmentList = new ArrayList<>(List.of(incorrectSegment1));
        Flight flight = new Flight(segmentList);
        List<Flight> flightList = new FlightFilterDepartingInPast().filter(List.of(flight));

        assertTrue(flightList.isEmpty());
    }
}