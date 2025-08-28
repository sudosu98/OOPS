package com.fiscalyear.entities;

import com.fiscalyear.abstractions.Range;

import java.time.LocalDate;

public class DateRange extends Range<LocalDate> {

    public DateRange(LocalDate start, LocalDate end) {
        super(start, end);
        if(start.isAfter(end)){
            throw new IllegalArgumentException("Invalid Date range");
        }
    }

    public DateRange clamp(DateRange dateRange) {
        LocalDate newStart = this.getStart().isAfter(
                dateRange.getStart()) ? this.getStart() : dateRange.getStart();
        LocalDate newEnd = this.getEnd().isBefore(
                dateRange.getEnd()) ? this.getEnd() : dateRange.getEnd();
        if (newStart.isAfter(newEnd)) return null;
        return new DateRange(newStart, newEnd);
    }

}
