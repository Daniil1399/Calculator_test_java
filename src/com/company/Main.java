package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите выражение:");


        int a;
        int b;
        String op;

        String[] roman = {"X", "IX", "VIII", "VII", "VI", "V", "IV", "III", "II", "I"};

        Scanner scan = new Scanner(System.in);

        String input = scan.next();

        String[] strings = input.split("\\W");
        String[] operator = input.split("\\w");

        boolean flag = false;

        for (int i = 0; i < roman.length; i++) {
            if (roman[i].equals(strings[0]));
            if (roman[i].equals(strings[1])){
                flag = true;
            }
        }

        if (flag) {
                a = romanToNumber(strings[0]);
                op = operator[operator.length - 1];
                b = romanToNumber(strings[1]);
        } else {
            a = Integer.parseInt(strings[0]);
            op = operator[operator.length - 1];
            b = Integer.parseInt(strings[1]);


        }
        if (flag) {
            if ((a >= 0 && a <= 10) && (b >= 0 && b <= 10)) {
                System.out.println(("Результат = " + convert(operation(a, b, op))));
            } else {
                System.out.println("Не верное выражение!");
            }
        } else {
            if ((a >= 0 && a <= 10) && (b >= 0 && b <= 10)) {
                System.out.println("Результат = " + operation(a, b, op));
            } else {
                System.out.println("Не верное выражение!");
            }

        }

    }
    public static int operation(int a, int b, String op) {
        switch (op) {
            case "*":
                return a * b;
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "/":
                return a / b;
            default:
                System.out.println("Вы ввели неверное выражение!");
                return 0;
        }
    }
    public static int romanToNumber(String roman) {
        if (roman.equals("I")) {
            return 1;
        } else if (roman.equals("II")) {
            return 2;
        } else if (roman.equals("III")) {
            return 3;
        } else if (roman.equals("IV")) {
            return 4;
        } else if (roman.equals("V")) {
            return 5;
        } else if (roman.equals("VI")) {
            return 6;
        } else if (roman.equals("VII")) {
            return 7;
        } else if (roman.equals("VIII")) {
            return 8;
        } else if (roman.equals("IX")) {
            return 9;
        } else if (roman.equals("X")) {
            return 10;
        } else {
            return -1;
        }
    }
    public static String romanDigit(int n, String one, String five, String ten) {

        if (n >= 1) {
            if (n == 1) {
                return one;
            } else if (n == 2) {
                return one + one;
            } else if (n == 3) {
                return one + one + one;
            } else if (n == 4) {
                return one + five;
            } else if (n == 5) {
                return five;
            } else if (n == 6) {
                return five + one;
            } else if (n == 7) {
                return five + one + one;
            } else if (n == 8) {
                return five + one + one + one;
            } else if (n == 9) {
                return one + ten;
            }

        }
        return "";
    }

    public static String convert(int number) {

        String romanOnes = romanDigit(number % 10, "I", "V", "X");
        number /= 10;
        String romanTens = romanDigit(number % 10, "X", "L", "C");
        number /= 10;

        String result = romanTens + romanOnes;
        return result;

    }
}