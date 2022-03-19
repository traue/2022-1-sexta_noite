package br.uninove;

public class Bhaskara {

    private double a;
    private double b;
    private double c;
    private double delta;
    private double rP;
    private double rN;

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

    public double getrP() {
        return rP;
    }

    public void setrP(double rP) {
        this.rP = rP;
    }

    public double getrN() {
        return rN;
    }

    public void setrN(double rN) {
        this.rN = rN;
    }

    public void calculaDelta() {
        setDelta((b * b) - 4 * a * c);
    }

    public void calculaRaizes() {
        setrP((-getB() + Math.sqrt(getDelta())) / (2 * getA()));
        setrN((-getB() - Math.sqrt(getDelta())) / (2 * getA()));
    }
}
