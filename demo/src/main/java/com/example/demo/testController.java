package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class testController {
    @FXML
    private Label lv1;



    @FXML
    protected void btn1() {
        lv1.setText("you clicked button 1");
    }
    @FXML
    protected void btn2() {
        lv1.setText("you clicked button 2");
    }
    @FXML
    protected void btn3() {
        lv1.setText("you clicked button 3");
    }
}
