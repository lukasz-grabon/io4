package io4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuadraticEquationTest {

    QuadraticEquation equation = new QuadraticEquation();

    @Test
    public void testQuadraticEquation_delta0(){
        //for
        float a = 1, b = 2, c = 1;

        //when
        float delta = equation.countDelta(a, b, c);

        //then
        assertEquals(delta, 0);
    }

    @Test
    public void testQuadraticEquation_deltaLowerThan0(){
        //for
        float a = 1, b = 1, c = 1;

        //when
        Exception thrown = assertThrows(Exception.class, () -> {
            equation.countDelta(a, b, c);
        });

        //then
        assertEquals("Delta mniejsza od zera", thrown.getMessage());
    }

    @Test
    public void testQuadraticEquation_deltaHigherThan0(){
        //for
        float a = 1, b = 3, c = 1;

        //when
        float delta = equation.countDelta(a, b, c);

        //then
        assertEquals(delta, 5);
    }
}