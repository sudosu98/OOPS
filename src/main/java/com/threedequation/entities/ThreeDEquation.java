package com.threedequation.entities;

import com.threedequation.interfaces.Equation;

import java.util.List;

public class ThreeDEquation implements Equation<Integer> {
    private final List<Integer> coefficients;
    private final int determinant;

    public ThreeDEquation(List<Integer> LHS, int RHS) {
        this.coefficients = LHS;
        this.determinant = RHS;
        if (coefficients.size() > 3) {
            throw new IllegalArgumentException("There can be at most 3 coefficients for a 3D equation");
        } else if (coefficients.size() < 3) {
            throw new IllegalArgumentException("At least 3 coefficients required for a 3D equation");
        }
    }

    @Override
    public String toString() {
        if (coefficients.size() != 3) {
            return "Invalid number of coefficients for a 3D equation.";
        }

        String[] variables = {"x", "y", "z"};
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            int coef = coefficients.get(i);
            if (i > 0 && coef >= 0) {
                sb.append("+");
            }
            sb.append(coef).append(variables[i]);
        }

        sb.append(" = ").append(determinant);
        return sb.toString();
    }

    @Override
    public List<Integer> LHS() {
        return coefficients;
    }

    @Override
    public Integer RHS() {
        return determinant;
    }

    @Override
    public Equation<Integer> create(List<Integer> coefficients, Integer determinant) {
        return new ThreeDEquation(coefficients, determinant);
    }

    @Override
    public boolean isLhsEqualsRhs(List<Integer> LHS, Integer RHS) {
        int result = 0;
        for (int i = 0; i < coefficients.size(); i++) {
            result += coefficients.get(i) * LHS.get(i);
        }
        return result == RHS;
    }

}
