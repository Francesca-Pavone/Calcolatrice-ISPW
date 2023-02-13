package com.example.calcolatrice;

public class Calculation {
    public double calculateSingleMemberOperations(double firstOperand, String operationToDo) {
        switch (operationToDo) {

            case "√x":
                return Math.sqrt(firstOperand);
            case "x²":
                return firstOperand * firstOperand;
            case "log":
                return Math.log10(firstOperand);
            case "ln":
                return Math.log(firstOperand);
            case "sin":
                return Math.sin(firstOperand);
            case "cos":
                return Math.cos(firstOperand);
            default:
                break;
        }
        return 0;
    }

    public double calculateSimpleOperations(double firstOperand, double secondOperand, String operationToDo) {
        switch (operationToDo) {

            case "÷":
                return firstOperand / secondOperand;
            case "×":
                return firstOperand * secondOperand;
            case "−":
                return firstOperand - secondOperand;
            case "+":
                return firstOperand + secondOperand;
            default:
                break;
        }
        return 0;
    }

}