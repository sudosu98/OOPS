package com.fiscalyear.entities;

import com.fiscalyear.interfaces.YearSplitter;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class FiscalYearSplitter implements YearSplitter<FiscalYear> {
    private final DateRange range;
    private final int fiscalMonth;

    public FiscalYearSplitter(DateRange range, int fiscalMonth){
        this.fiscalMonth = fiscalMonth;
        this.range = range;
    }

    @Override
    public List<FiscalYear> split() {
        List<FiscalYear> fiscalYears = new ArrayList<>();
        LocalDate start = range.getStart();
        int startMonth = fiscalMonth % 12 + 1;
        LocalDate fiscalStart;

        if(start.getMonthValue() <= fiscalMonth){
            fiscalStart = LocalDate.of(start.getYear() - 1, startMonth, 1);
        } else {
            fiscalStart = LocalDate.of(start.getYear(), startMonth, 1);
        }


        while (!fiscalStart.isAfter(range.getEnd())) {
            int endYear = fiscalStart.getYear() + (fiscalMonth < startMonth ? 1 : 0);
            YearMonth endYm = YearMonth.of(endYear, fiscalMonth);
            LocalDate fiscalEnd = endYm.atEndOfMonth();

            FiscalYear fy = new FiscalYear(fiscalStart, fiscalEnd);
            DateRange overlap = range.clamp(fy.getDateRange());
            if (overlap != null) {
                fiscalYears.add(fy);
            }

            fiscalStart = fiscalEnd.plusDays(1);
        }
        return fiscalYears;
    }
}
