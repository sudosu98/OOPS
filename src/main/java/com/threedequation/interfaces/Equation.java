package com.threedequation.interfaces;

import java.util.List;

public interface Equation<T> {
    List<T> LHS();
    T RHS();
    Equation<T> create(List<T> LHS, T RHS);
    boolean isLhsEqualsRhs(List<T> LHS, T RHS);
}
