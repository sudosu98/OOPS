package com.fiscalyear;

import com.fiscalyear.entities.DateRange;
import com.fiscalyear.entities.FiscalYearSplitter;
import com.fiscalyear.entities.FiscalYear;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class FiscalYearSplitterTest {

    @Test
    void shouldSplitTheGivenDateRangesIntoFiscalYears() {
        List<FiscalYear> expected = getFiscalYears();

        LocalDate inputStart = LocalDate.of(2019, 5, 10);
        LocalDate inputEnd = LocalDate.of(2021, 5, 10);
        DateRange range = new DateRange(inputStart, inputEnd);
        int fiscalMonth = 3;

        FiscalYearSplitter fiscalYearSplitter = new FiscalYearSplitter(
                range,
                fiscalMonth
        );
        List<FiscalYear> fiscalYears = fiscalYearSplitter.split();

        System.out.println("Result -> " + fiscalYears);
        System.out.println("Expected -> " + expected);

        Assertions.assertEquals(expected.toString(), fiscalYears.toString());
    }

    private static List<FiscalYear> getFiscalYears() {
        LocalDate start1 = LocalDate.of(2019, 4, 1);
        LocalDate end1 = LocalDate.of(2020, 3, 31);
        LocalDate start2 = LocalDate.of(2020, 4, 1);
        LocalDate end2 = LocalDate.of(2021, 3, 31);
        LocalDate start3 = LocalDate.of(2021, 4, 1);
        LocalDate end3 = LocalDate.of(2022, 3, 31);
        return Arrays.asList(
                new FiscalYear(start1, end1),
                new FiscalYear(start2, end2),
                new FiscalYear(start3, end3)
        );
    }
}
