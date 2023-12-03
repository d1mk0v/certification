package com.gridnine.testing.model;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс, представляющий перелет, содержащий список сегментов.
 */
public class Flight {
    private final List<Segment> segments; // Список сегментов

    /**
     * Конструктор класса.
     * @param segs список сегментов, составляющих перелет
     */
    public Flight(final List<Segment> segs) {
        segments = segs;
    }

    /**
     * Получает список сегментов, составляющих перелет.
     * @return список сегментов
     */
    public List<Segment> getSegments() {
        return segments;
    }

    /**
     * Переопределение метода toString для представления перелета в виде строки.
     * @return строковое представление перелета
     */
    @Override
    public String toString() {
        return segments.stream().map(Object::toString)
                .collect(Collectors.joining(" "));
    }
}
