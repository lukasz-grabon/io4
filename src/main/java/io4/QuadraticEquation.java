package io4;

public class QuadraticEquation {

    private double a, b, c, delta;
    private String resultMessage;

    public QuadraticEquation(double a, double b, double c) {
        setA(a);
        setB(b);
        setC(c);
        countDelta();
    }

    private void countDelta(){
        setDelta(Math.pow(getB(), 2) - 4 * getA() * getC());
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getDelta() {
        return delta;
    }

    public void setDelta(double delta) {
        this.delta = delta;
    }
}