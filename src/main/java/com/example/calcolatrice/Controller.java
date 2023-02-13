package com.example.calcolatrice;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class Controller {

    public Button moonLight_button;
    public ImageView moonLight_image;
    @FXML
    private Label resultLabel;
    @FXML
    private Label historyLabel;

    private boolean isLightMode = true;

    private double first_operand = 0;

    private String operationToDo = "";

    private boolean start = true;
    private boolean startFromResult = false;
    private boolean positiveSign = true;

    private final Calculation calculation = new Calculation();


    @FXML
    public void changeMode(ActionEvent event){
        isLightMode = !isLightMode;
        if(!isLightMode){
            Main.stage.getScene().getStylesheets().clear();
            Main.stage.getScene().setUserAgentStylesheet(null);
            Main.stage.getScene().getStylesheets().add(Objects.requireNonNull(getClass().getResource("darkMode.css")).toExternalForm());
        }else {
            Main.stage.getScene().getStylesheets().clear();
            Main.stage.getScene().setUserAgentStylesheet(null);
            Main.stage.getScene().getStylesheets().add(Objects.requireNonNull(getClass().getResource("lightMode.css")).toExternalForm());
        }
    }

    @FXML
    public void insertValue(ActionEvent event){
        if(start){
            resultLabel.setText("");
            historyLabel.setText("");
            positiveSign = true;
            start = false;
        }
        startFromResult = false;
        String value=((Button)event.getSource()).getText();
        resultLabel.setText(resultLabel.getText() + value);
    }

    @FXML
    public void changeSign(ActionEvent event) {
        if(positiveSign){
            resultLabel.setText("-" + resultLabel.getText());
            positiveSign = false;
        }else {
            String substring = resultLabel.getText().substring(1);
            resultLabel.setText(substring);
            positiveSign = true;
        }
    }

    @FXML
    public void singleMemberOperation(ActionEvent event) {
        positiveSign = true;
        String value=((Button)event.getSource()).getText();
        if(!operationToDo.isEmpty())
            return;
        operationToDo = value;
        first_operand = Float.parseFloat(resultLabel.getText());
        resultLabel.setText("");

        if(startFromResult)
            historyLabel.setText("");

        if(operationToDo.equals("x²")) {
            historyLabel.setText(historyLabel.getText() + "(" + first_operand + ")" + "²");

        }else if(operationToDo.equals("√x")){
            historyLabel.setText(historyLabel.getText() + "√" + "(" + first_operand + ")");

        }else {
            historyLabel.setText(historyLabel.getText() + operationToDo + "(" + first_operand + ")");
        }

        double result = calculation.calculateSingleMemberOperations(first_operand, operationToDo);
        if(result<0){
            positiveSign = false;
        }
        resultLabel.setText(String.valueOf(result));
        historyLabel.setText(historyLabel.getText() + "=" + result);
        operationToDo = "";
        startFromResult = true;
    }

    @FXML
    public void simpleOperation(ActionEvent event){
        positiveSign = true;
        String value=((Button)event.getSource()).getText();
        if(!value.equals("=")) {
            if(!operationToDo.isEmpty())
                return;
            operationToDo = value;
            first_operand = Float.parseFloat(resultLabel.getText());
            if(startFromResult)
                historyLabel.setText("");
            historyLabel.setText(historyLabel.getText() + first_operand + operationToDo );
            resultLabel.setText("");

        }else{
            if(operationToDo.isEmpty())
                return;
            double second_operand = Float.parseFloat(resultLabel.getText());
            double result = calculation.calculateSimpleOperations(first_operand, second_operand, operationToDo);
            if(result<0){
                positiveSign = false;
            }
            historyLabel.setText(historyLabel.getText() + second_operand + "=" + result);
            resultLabel.setText(String.valueOf(result));
            startFromResult = true;
            operationToDo = "";
        }
    }

    @FXML
    public void clearAll(ActionEvent event){
        resultLabel.setText("");
        historyLabel.setText("");
        operationToDo = "";
        start = true;
        startFromResult = false;
        positiveSign = true;
    }
}