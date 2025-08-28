package com.threedequation.entities;

import com.threedequation.interfaces.Equation;
import com.threedequation.interfaces.SolutionStrategy;

import java.util.ArrayList;
import java.util.List;

public class CramersStrategy implements SolutionStrategy<List<Equation<Integer>>, List<Integer>> {

    @Override
    public List<Integer> solve(List<Equation<Integer>> input) {
        List<Integer> res = new ArrayList<>();
        int determinant = solveForDeterminantOfMatrix(input);
        if (determinant == 0) {
            System.out.println("No Solution / Infinite Solutions since Determinant of Coefficient Matrix is Zero");
            return res;
        }
        for (int i = 0; i < input.size(); i++) {
            List<Equation<Integer>> newInput = createVariableMatrix(input, i);
            double variableDet = solveForDeterminantOfMatrix(newInput);
            res.add((int) Math.round(variableDet / determinant));
        }
        return res;
    }

    private List<Equation<Integer>> createVariableMatrix(List<Equation<Integer>> input, int col) {
        List<Equation<Integer>> newInput = new ArrayList<>();
        for (Equation<Integer> currentEq : input) {
            List<Integer> coefficients = new ArrayList<>(currentEq.LHS());
            coefficients.remove(col);
            coefficients.add(col, currentEq.RHS());
            Equation<Integer> eq = currentEq.create(coefficients, 0);
            newInput.add(eq);
        }
        return newInput;
    }

    private int solveForDeterminantOfMatrix(List<Equation<Integer>> input) {
        int[][] matrix = new int[input.size()][];
        for (int i = 0; i < input.size(); i++) {
            List<Integer> coefficients = input.get(i).LHS();
            matrix[i] = coefficients.stream().mapToInt(Integer::intValue).toArray();
        }

        return calculateDeterminant(matrix);
    }

    private int calculateDeterminant(int[][] matrix) {
        int n = matrix.length;

        if (n == 1) {
            return matrix[0][0];
        }

        if (n == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        int determinant = 0;
        for (int col = 0; col < n; col++) {
            int cofactor = matrix[0][col] * getCofactor(matrix, col);

            if (col % 2 == 0) {
                determinant += cofactor;
            } else {
                determinant -= cofactor;
            }
        }

        return determinant;
    }

    private int getCofactor(int[][] matrix, int excludeCol) {
        int n = matrix.length;
        int[][] subMatrix = new int[n - 1][n - 1];

        int subRow = 0;
        for (int row = 0; row < n; row++) {
            if (row == 0) continue;

            int subCol = 0;
            for (int col = 0; col < n; col++) {
                if (col == excludeCol) continue;

                subMatrix[subRow][subCol] = matrix[row][col];
                subCol++;
            }
            subRow++;
        }

        return calculateDeterminant(subMatrix);
    }
}
