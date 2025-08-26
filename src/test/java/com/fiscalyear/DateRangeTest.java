package com.fiscalyear;

import com.fiscalyear.entities.DateRange;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class DateRangeTest {

    @Test
    void shouldReturnANewDateRangeIfThereIsOverlap() {
        DateRange range1 = new DateRange(LocalDate.of(2020, 1, 1),
                                         LocalDate.of(2020, 12, 31));
        DateRange range2 = new DateRange(LocalDate.of(2020, 6, 1),
                                         LocalDate.of(2021, 3, 31));
        DateRange clampedDateRange = range1.clamp(range2);
        DateRange expected = new DateRange(LocalDate.of(2020, 6, 1),
                                           LocalDate.of(2020, 12, 31));
        Assertions.assertEquals(expected.toString(),
                                clampedDateRange.toString());
    }

    @Test
    void shouldReturnNullIfThereAreNoOverlaps() {
        DateRange range1 = new DateRange(LocalDate.of(2020, 1, 1),
                                         LocalDate.of(2020, 4, 30));
        DateRange range2 = new DateRange(LocalDate.of(2020, 6, 1),
                                         LocalDate.of(2020, 8, 31));
        DateRange clampedDateRange = range1.clamp(range2);
        Assertions.assertNull(clampedDateRange);
    }

    @Test
    void shouldThrowErrorOnInvalidDateRange() {
        Assertions.assertThrows(IllegalArgumentException.class,
                                () -> new DateRange(LocalDate.of(2020, 1, 1),
                                                    LocalDate.of(2019, 4, 30)));
    }
}
