package com.fiscalyear;

import com.fiscalyear.entities.FiscalYear;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class FiscalYearTest {
    @Test
    void shouldFormatFiscalYear() {
        FiscalYear fiscalYear = new FiscalYear(LocalDate.of(2019, 4, 1),
                                               LocalDate.of(2020, 3, 31));

        Assertions.assertEquals("2019-04-01->2020-03-31 FY2020",
                                fiscalYear.toString());
    }
}
