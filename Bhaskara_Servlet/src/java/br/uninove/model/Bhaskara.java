package br.uninove.model;

public class Bhaskara {

    private int a;
    private int b;
    private int c;
    private double delta;
    private double xp;
    private double xn;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public double getDelta() {
        return delta;
    }

    public void setDelta(double delta) {
        this.delta = delta;
    }

    public double getXp() {
        return xp;
    }

    public void setXp(double xp) {
        this.xp = xp;
    }

    public double getXn() {
        return xn;
    }

    public void setXn(double xn) {
        this.xn = xn;
    }

    public double calculaDelta() {
        setDelta((b * b) - 4 * a * c);
        return getDelta();
    }

    public double[] calculaRaizes() {
        double[] raizes = new double[2];

        raizes[0] = (-b + Math.sqrt(getDelta()) / (2 * a));
        raizes[1] = (-b - Math.sqrt(getDelta()) / (2 * a));

        setXp(raizes[0]);
        setXn(raizes[1]);

        return raizes;
    }

    //solução alternativa
    public double[] calculaBhaskaraCompleto() {
        double[] resultado = new double[3];

        resultado[0] = (b * b) - 4 * a * c;

        setDelta(resultado[0]);

        if (resultado[0] > 0) {
            resultado[1] = (-b + Math.sqrt(getDelta())) / (2 * a);
            resultado[2] = (-b - Math.sqrt(getDelta())) / (2 * a);
        }

        setXp(resultado[1]);
        setXn(resultado[2]);

        return resultado;
    }

}
