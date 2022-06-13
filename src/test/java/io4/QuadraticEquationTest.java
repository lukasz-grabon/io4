package io4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class QuadraticEquationTest {

    @Test
    public void testQuadraticEquation_delta0(){
        //for
        float a = 1, b = 2, c = 1;

        //when
        QuadraticEquation equation = new QuadraticEquation(a, b, c);

        //then
        assertEquals(0, equation.getDelta());
    }

    @Test
    public void testQuadraticEquation_deltaLowerThan0(){
        //for
        float a = 1, b = 1, c = 1;

        //when
        QuadraticEquation equation = new QuadraticEquation(a, b, c);

        //then
        assertTrue(equation.getDelta() < 0);
    }

    @Test
    public void testQuadraticEquation_deltaHigherThan0(){
        //for
        float a = 1, b = 4, c = 3;

        //when
        QuadraticEquation equation = new QuadraticEquation(a, b, c);

        //then
        assertEquals(4, equation.getDelta());
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(1d, 2d, 1d, "Delta równa 0, pierwiastek x0 = -1.0"),
                Arguments.of(1d, 1d, 1d, "Delta mniejsza od zera, brak pierwiastków"),
                Arguments.of(1d, 4d, 3d, "Delta wieksza od zera, pierwiastki: x1 = -1.0, x2 = -3.0"),
                Arguments.of(null, 3d, 1d, "Delta wieksza od zera, pierwiastki: x1 = 2, x2 = -2"),
                Arguments.of(1d, null, 1d, "Delta wieksza od zera, pierwiastki: x1 = 2, x2 = -2"),
                Arguments.of(1d, 3d, null, "Delta wieksza od zera, pierwiastki: x1 = 2, x2 = -2")
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    public void testResult(Double a, Double b, Double c, String resultMessage){
        //for

        //when
        QuadraticEquation equation = new QuadraticEquation(a, b, c);

        //then
        assertEquals(resultMessage, equation.getResultMessage());
    }
}