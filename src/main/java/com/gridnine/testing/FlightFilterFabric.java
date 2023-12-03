package com.gridnine.testing;

import com.gridnine.testing.filter.inter.FlightFilter;
import com.gridnine.testing.model.Flight;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс, предоставляющий фабрику для фильтрации перелетов с использованием заданных фильтров.
 */
public class FlightFilterFabric {


    private final List<FlightFilter> filters; //Список фильтров

    /**
     * Конструктор класса.
     * @param filters список фильтров, которые будут применены к перелетам
     */
    public FlightFilterFabric(List<FlightFilter> filters) {
        this.filters = filters;
    }

    /**
     * Применяет список фильтров к набору перелетов для фильтрации.
     * @param flights набор перелетов, которые будут отфильтрованы
     * @return отфильтрованный список перелетов
     */
    public List<Flight> doFilter(List<Flight> flights) {
        List<Flight> filterList = new ArrayList<>(flights);

        for(FlightFilter filter : filters){
            filterList = filter.filter(filterList);
        }
        return filterList;
    }
}
