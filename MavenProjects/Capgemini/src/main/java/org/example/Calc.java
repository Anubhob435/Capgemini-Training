package org.example;

public class Calc {
    public double add(Object a, Object b) {
        double num1 = parseDouble(a);
        double num2 = parseDouble(b);
        return num1 + num2;
    }

    private double parseDouble(Object value) {
        if (value instanceof Number) {
            return ((Number) value).doubleValue();
        }
        if (value instanceof String) {
            try {
                return Double.parseDouble((String) value);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Enter numbers only");
            }
        }
        throw new IllegalArgumentException("enter numbers");
    }
}
