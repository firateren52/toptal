package com.eren.puzzlers;

import java.util.*;

public class JavaPuzzler {
    public static void main2(String[] args) {
        // remove with integer doesnt effect short keys
        HashSet<Short> s = new HashSet<Short>();//1
        for (short i = 0; i < 100; i++) {//2
            s.add(i);//3
            s.remove((i - 1));//4
        }
        System.out.println(s.size());//5


        // finally get called even if we return in try block
        System.out.println("testReturnWithFinally: " + testReturnWithFinally());//5

        // int divide by zero throws ArithmeticException, double divide by zero return Double.Infinity
        divideByZero();

        charToStringToByteCovnersion();
    }

    private static String testReturnWithFinally() {
        String state = "";
        try {
            state = "try";
            return state;
        } finally {
            state = "finally";
        }
    }

    private static void divideByZero() {
        double x = 1.0 / 0.0;
        System.out.println("1/0 = " + x);

        try {
            int y = 1 / 0;
            System.out.println("1/0 = " + x);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
    }

    private static void charToStringToByteCovnersion() {
        char[] chars = new char[]{'\u0097'};
        String str = new String(chars);
        byte[] bytes = str.getBytes();
        System.out.println(Arrays.toString(bytes));
        Course c = new Course();
        List<String> aaa = new ArrayList();
        aaa.sort((a, b) -> a.compareTo(b));
        test2(new Course(), new Course());
    }

    private static void test2(Course...course) {

    }

    public static int getLargestNumber(int input) {
        // Your code goes here
        List<Integer> digits = new ArrayList<>();
        while(input > 0) {
            digits.add(input % 10);
            input = input / 10;
        }
        digits.sort((a,b) -> a.compareTo(b));
        int digitSize = 0;
        int maxNumber = 0;
        for(int digit: digits) {
            maxNumber += digit * (Math.pow(10, digitSize));
            digitSize ++;
        }
        return maxNumber;
    }

    public static void main(String[] args) {
        System.out.println(getLargestNumber(2147483642));
    }
}

class Course
{
    public Course()
    {
    }

    Room room;

    Optional getRoom()
    {
        return Optional.of(room);
    }
}

class Room
{
    Integer number;
    Optional getNumber()
    {
        return Optional.of(number);
    }
}

