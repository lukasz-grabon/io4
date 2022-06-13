package io4;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuadraticEquationTest {

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(1d, 2d, 1d, 0d, -1d, null, null, "Delta równa 0, pierwiastek x0 = -1.0"),
                Arguments.of(2d, 1d, 2d, 4d, null, null, null, "Delta mniejsza od zera, brak pierwiastków"),
                Arguments.of(1d, 4d, 3d, 4d, null, -1d, -3d, "Delta wieksza od zera, pierwiastki: x1 = -1.0, x2 = -3.0"),
                Arguments.of(null, 3d, 1d, null, null, null, null, null),
                Arguments.of(1d, null, 1d, null, null, null, null, null),
                Arguments.of(1d, 3d, null, null, null, null, null, null)
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    public void testResult(Double a, Double b, Double c, Double delta, Double x0, Double x1, Double x2, String resultMessage) {
        //for

        //when
        QuadraticEquation equation = new QuadraticEquation(a, b, c);

        //then
        assertEquals(delta, equation.getDelta());
        assertEquals(x0, equation.getX0());
        assertEquals(x1, equation.getX1());
        assertEquals(x2, equation.getX2());
        assertEquals(resultMessage, equation.getResultMessage());
    }
}