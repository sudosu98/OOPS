package com.fiscalyear.entities;

import java.time.LocalDate;

public class DateRange {
    private final LocalDate start;
    private final LocalDate end;

    public DateRange(LocalDate start, LocalDate end) {
        if(start.isAfter(end)){
            throw new IllegalArgumentException("Invalid date range");
        }
        this.start = start;
        this.end = end;
    }

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public DateRange clamp(DateRange dateRange) {
        LocalDate newStart = start.isAfter(dateRange.getStart()) ? start : dateRange.getStart();
        LocalDate newEnd  = end.isBefore(dateRange.end) ? end : dateRange.getEnd();
        if(newStart.isAfter(newEnd)) return null;
        return new DateRange(newStart, newEnd);
    }

    @Override
    public String toString() {
        return start + "->" + end;
    }
}
