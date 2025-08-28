package com.threedequation.interfaces;

public interface SolutionStrategy<Input, Result> {
    Result solve(Input input);
}
