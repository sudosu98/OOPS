package com.threedequation;

import com.threedequation.entities.CramersStrategy;
import com.threedequation.entities.SolutionContext;
import com.threedequation.entities.ThreeDEquation;
import com.threedequation.interfaces.Equation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class CramersRuleSolutionTest {
    @Test
    void shouldFindValuesOfXYZUsingCramersRuleForThe3DEquation() {
        List<Integer> coefficients1 = Arrays.asList(1, 1, 1);
        ThreeDEquation equation1 = new ThreeDEquation(coefficients1, 5);

        List<Integer> coefficients2 = Arrays.asList(2, -1, 1);
        ThreeDEquation equation2 = new ThreeDEquation(coefficients2, 3);

        List<Integer> coefficients3 = Arrays.asList(1, 2, -3);
        ThreeDEquation equation3 = new ThreeDEquation(coefficients3, -4);

        SolutionContext<List<Equation<Integer>>, List<Integer>> solutionContext =
                new SolutionContext<>(new CramersStrategy());
        List<Integer> result = solutionContext.solve(Arrays.asList(equation1, equation2, equation3));

        List<Integer> expected = Arrays.asList(1 , 1, 3);

        Assertions.assertEquals(result, expected);

        Assertions.assertTrue(equation1.isLhsEqualsRhs(result, equation1.RHS()));
        Assertions.assertFalse(equation2.isLhsEqualsRhs(result, equation2.RHS()));
        Assertions.assertFalse(equation3.isLhsEqualsRhs(result, equation3.RHS()));

    }
}
