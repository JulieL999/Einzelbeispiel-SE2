package com.example.networktest;

public class MathOperations {
    public static int calcAltQuersumme(int number) {
        int temp = number;
        int sum = 0;
        int sign = 1;

        while (temp != 0) {
            sum = sum + (temp % 10) * sign;
            sign *= -1;
            temp /= 10;
        }

        return sum;
    }

    public static boolean isEval(int number) {
        return number % 2 == 0;
    }
}
