package com.fiscalyear.interfaces;

import java.util.List;

public interface YearSplitter<T> {
    List<T> split();
}
