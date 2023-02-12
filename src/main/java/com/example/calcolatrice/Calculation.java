package com.example.calcolatrice;

public class Calculation {
    public double calculateSingleMemberOperations(double first_operand, String operationToDo) {
        switch (operationToDo) {

            case "√x":
                return Math.sqrt(first_operand);
            case "x²":
                return first_operand * first_operand;
            case "log":
                return Math.log10(first_operand);
            case "ln":
                return Math.log(first_operand);
            case "sin":
                return Math.sin(first_operand);
            case "cos":
                return Math.cos(first_operand);
            default:
                break;
        }
        return 0;
    }

    public double calculateSimpleOperations(double first_operand, double second_operand, String operationToDo) {
        switch (operationToDo) {

            case "÷":
                return first_operand / second_operand;
            case "×":
                return first_operand * second_operand;
            case "−":
                return first_operand - second_operand;
            case "+":
                return first_operand + second_operand;
            default:
                break;
        }
        return 0;
    }

}