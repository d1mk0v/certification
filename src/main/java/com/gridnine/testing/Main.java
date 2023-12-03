package com.gridnine.testing;

import com.gridnine.testing.filter.FlightFilterFabric;
import com.gridnine.testing.filter.inter.FlightFilter;
import com.gridnine.testing.filter.impl.FlightFilterDepartingBeforeArrives;
import com.gridnine.testing.filter.impl.FlightFilterDepartingInPast;
import com.gridnine.testing.filter.impl.FlightFilterTimeOnEarthLessThanTwoHours;
import com.gridnine.testing.model.Flight;

import java.util.Arrays;
import java.util.List;

/**
 * Главный класс приложения, демонстрирующий использование фильтров для перелетов.
 */
public class Main {

    /**
     * Главный метод программы, запускающий демонстрацию использования фильтров для перелетов.
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {

        List<Flight> flightList = FlightBuilder.createFlights();

        // Вывод исходного списка перелетов
        flightList.forEach(System.out::println);
        System.out.println();

        // Фильтрация по первому правилу и вывод результата
        FlightFilter filter1 = new FlightFilterDepartingBeforeArrives();
        filter1.filter(flightList).forEach(System.out::println);
        System.out.println();

        // Фильтрация по второму правилу и вывод результата
        FlightFilter filter2 = new FlightFilterDepartingInPast();
        filter2.filter(flightList).forEach(System.out::println);
        System.out.println();

        // Фильтрация по третьему правилу и вывод результата
        FlightFilter filter3 = new FlightFilterTimeOnEarthLessThanTwoHours();
        filter3.filter(flightList).forEach(System.out::println);
        System.out.println();

        // Фабрика фильтров и вывод результата их комбинированной фильтрации
        FlightFilterFabric filterFabric = new FlightFilterFabric(Arrays.asList(filter1, filter2, filter3));
        filterFabric.doFilter(flightList).forEach(System.out::println);
    }
}