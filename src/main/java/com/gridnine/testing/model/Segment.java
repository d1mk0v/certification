package com.gridnine.testing.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * Класс, представляющий сегмент перелета с определенной датой и временем вылета и прилета.
 */
public class Segment {
    private final LocalDateTime departureDate; // Дата и время вылета
    private final LocalDateTime arrivalDate; // Дата и время прилета

    /**
     * Конструктор класса.
     * @param dep дата и время вылета
     * @param arr дата и время прилета
     */
    public Segment(final LocalDateTime dep, final LocalDateTime arr) {
        departureDate = Objects.requireNonNull(dep);
        arrivalDate = Objects.requireNonNull(arr);
    }

    /**
     * Получает дату и время вылета сегмента.
     * @return дата и время вылета
     */
    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    /**
     * Получает дату и время прилета сегмента.
     * @return дата и время прилета
     */
    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    /**
     * Переопределение метода toString для представления сегмента в виде строки.
     * @return строковое представление сегмента
     */
    @Override
    public String toString() {
        DateTimeFormatter fmt =
                DateTimeFormatter.ofPattern("yyyy-MM-dd 'T:'HH:mm");
        return '[' + departureDate.format(fmt) + '|' + arrivalDate.format(fmt)
                + ']';
    }
}
