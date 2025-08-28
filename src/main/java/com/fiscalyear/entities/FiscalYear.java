package com.fiscalyear.entities;

import com.fiscalyear.interfaces.Year;

import java.time.LocalDate;

public class FiscalYear implements Year {
    private final LocalDate start;
    private final LocalDate end;
    private final String label;

    public FiscalYear(LocalDate start, LocalDate end) {
        this.start = start;
        this.end = end;
        if(start.isAfter(end)){
            throw new IllegalArgumentException("Invalid Date Ranges");
        }
        this.label = "FY" + end.getYear();
    }

    @Override
    public String toString() {
        return start + "->" + end + " " + label;
    }

    @Override
    public DateRange getDateRange() {
        return new DateRange(start, end);
    }
}
