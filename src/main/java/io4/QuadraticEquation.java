package io4;

public class QuadraticEquation {

    private double a, b, c;
    private Double delta, x0, x1, x2;
    private final StringBuilder STRING_BUILDER = new StringBuilder();
    private String resultMessage;

    public QuadraticEquation(double a, double b, double c) {
        setA(a);
        setB(b);
        setC(c);
        countDelta();
        if (getDelta() == 0) {
            countX0();
            setResultMessage(STRING_BUILDER.append("Delta równa 0, pierwiastek x0 = ").append(getX0()).toString());
        }

        if (getDelta() > 0) {
            countX1();
            countX2();
            setResultMessage(STRING_BUILDER.append("Delta wieksza od zera, pierwiastki: x1 = ").append(getX1()).append(", x2 = ").append(getX2()).toString());
        }

        if (getDelta() < 0) {
            setResultMessage(STRING_BUILDER.append("Delta mniejsza od zera, brak pierwiastków").toString());
        }
    }

    private void countDelta() {
        setDelta(Math.pow(getB(), 2) - 4 * getA() * getC());
    }

    private void countX0() {
        setX0(-getB() / (2 * getA()));
    }

    private void countX1() {
        setX1(-getB() - Math.sqrt(getDelta()) / (2 * getA()));
    }

    private void countX2() {
        setX2(-getB() + Math.sqrt(getDelta()) / (2 * getA()));
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public Double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public Double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public Double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public Double getDelta() {
        return delta;
    }

    public void setDelta(double delta) {
        this.delta = delta;
    }

    public Double getX0() {
        return x0;
    }

    public void setX0(double x0) {
        this.x0 = x0;
    }

    public Double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public Double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }
}