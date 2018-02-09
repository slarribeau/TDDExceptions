package main;

import java.util.AbstractList;

import static org.hamcrest.core.Is.is;

public class Calculator {
    public int div(int dividend, int divisor) {
        return dividend/divisor;
    }

    public int safeDiv(int dividend, int divisor) {
        try {
            return dividend / divisor;
        } catch (ArithmeticException e) {
            System.out.println("Not good!");
            return -1;
        }
    }
}

