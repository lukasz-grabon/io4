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
        QuadraticEquation equation = new QuadraticEquation(a, b, c);

        //when
        float delta = equation.countDelta();

        //then
        assertEquals(0, delta);
    }

    @Test
    public void testQuadraticEquation_deltaLowerThan0(){
        //for
        float a = 1, b = 1, c = 1;
        QuadraticEquation equation = new QuadraticEquation(a, b, c);

        //when
        Exception thrown = assertThrows(Exception.class, () -> {
            equation.countDelta();
        });

        //then
        assertEquals("Delta mniejsza od zera", thrown.getMessage());
    }

    @Test
    public void testQuadraticEquation_deltaHigherThan0(){
        //for
        float a = 1, b = 3, c = 1;
        QuadraticEquation equation = new QuadraticEquation(a, b, c);

        //when
        float delta = equation.countDelta();

        //then
        assertEquals(5, delta);
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(1, 2, 1, "Delta równa 0, pierwiastek x0 = -1"),
                Arguments.of(1, 1, 1, "Delta mniejsza od zera, brak pierwiastków"),
                Arguments.of(1, 3, 1, "Delta wieksza od zera, pierwiastki: x1 = 2, x2 = -2")
        );
    }

    @ParameterizedTest
    @MethodSource("provideData")
    public void testResult(float a, float b, float c, String resultMessage){
        //for
        QuadraticEquation equation = new QuadraticEquation(a, b, c);

        //when
//        String result = equation.getResult();

        //then
        assertEquals(resultMessage, result);
    }
}