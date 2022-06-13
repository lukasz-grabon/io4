package io4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class QuadraticEquationTest {

    @Test
    public void testDeltaEqualZero() {
        //for
        Double a = 1d, b = 2d, c = 1d;

        //when
        QuadraticEquation equation = new QuadraticEquation(a, b, c);

        //then
        assertEquals(0d, equation.getDelta());
        assertEquals(-1d, equation.getX0());
        assertNull(equation.getX1());
        assertNull(equation.getX2());
        assertEquals("Delta równa 0, pierwiastek x0 = -1.0", equation.getResultMessage());
    }

    @Test
    public void testDeltaLowerThanZero() {
        //for
        Double a = 2d, b = 1d, c = 2d;

        //when
        QuadraticEquation equation = new QuadraticEquation(a, b, c);

        //then
        assertEquals(-15d, equation.getDelta());
        assertNull(equation.getX0());
        assertNull(equation.getX1());
        assertNull(equation.getX2());
        assertEquals("Delta mniejsza od zera, brak pierwiastków", equation.getResultMessage());
    }

    @Test
    public void testDeltaHigherThanZero() {
        //for
        Double a = 1d, b = 4d, c = 3d;

        //when
        QuadraticEquation equation = new QuadraticEquation(a, b, c);

        //then
        assertEquals(4d, equation.getDelta());
        assertNull(equation.getX0());
        assertEquals(-3d, equation.getX1());
        assertEquals(-1d, equation.getX2());
        assertEquals("Delta wieksza od zera, pierwiastki: x1 = -3.0, x2 = -1.0", equation.getResultMessage());
    }

    @ParameterizedTest
    @MethodSource("provideData")
    public void testAEqualZero(Double a, Double b, Double c) {
        //for

        //when

        //then
        assertThrows(NullPointerException.class, () -> {
            new QuadraticEquation(a, b, c);
        });
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(null, 3d, 1d),
                Arguments.of(1d, null, 1d),
                Arguments.of(1d, 3d, null)
        );
    }
}