package io4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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
        assertEquals(-1d, equation.getX1());
        assertEquals(-3d, equation.getX2());
        assertEquals("Delta wieksza od zera, pierwiastki: x1 = -1.0, x2 = -3.0", equation.getResultMessage());
    }

    @Test
    public void testAEqualZero() {
        //for
        Double a = null, b = 4d, c = 3d;

        //when
        QuadraticEquation equation = new QuadraticEquation(a, b, c);

        //then
        assertEquals(4d, equation.getDelta());
        assertNull(equation.getX0());
        assertEquals(-1d, equation.getX1());
        assertEquals(-3d, equation.getX2());
        assertEquals("Delta wieksza od zera, pierwiastki: x1 = -1.0, x2 = -3.0", equation.getResultMessage());
    }
}