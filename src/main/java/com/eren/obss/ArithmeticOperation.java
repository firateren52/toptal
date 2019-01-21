package com.eren.practice.stream;

import java.util.List;
import java.util.Scanner;



public class ArithmeticOperation {
    private enum Operation{
        PLUS("+"), SUB("-"),MUL("*"), DIV("/");
        String op;

        Operation(String op) {
            this.op = op;
        }

        public String getOp() {
            return op;
        }
    };

    public double calculate(String statement) {
        Double result = new Double(0);
        for(Operation operation: Operation.values()) {
            int index = statement.indexOf(operation.op);
            if(index > 0) {
                Integer first = Integer.parseInt(statement.substring(0, index));
                Integer second = Integer.parseInt(statement.substring(index + 1));
                if (Operation.PLUS.equals(operation)) {
                    result = (double) (first + second);

                } else if (Operation.SUB.equals(operation)) {
                    result = (double) (first - second);

                } else if (Operation.MUL.equals(operation)) {
                    result = (double) (first * second);

                }
                if (Operation.DIV.equals(operation)) {
                    result = (double)first / (double)second;
                }
                return result;
            }
        }
        return result;
    }


    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        ArithmeticOperation arithmeticOperation = new ArithmeticOperation();
        Double result = arithmeticOperation.calculate(input);
        System.out.println("input = " + result);
    }
}
