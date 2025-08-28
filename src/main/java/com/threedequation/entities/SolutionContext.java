package com.threedequation.entities;

import com.threedequation.interfaces.SolutionStrategy;

public class SolutionContext<T, Result> {
    private SolutionStrategy<T, Result> solutionStrategy;

    public SolutionContext(SolutionStrategy<T, Result> strategy){
        this.solutionStrategy = strategy;
    }

    public Result solve(T input) {
        return solutionStrategy.solve(input);
    }

    public void setSolutionStrategy(SolutionStrategy<T, Result> strategy){
        this.solutionStrategy = strategy;
    }

}
