package com.selrvk.enrollment;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class DashboardController {

    @FXML
    private Label label_welcomeBack;
    @FXML
    private Button button_enrollment;
    @FXML
    private Button button_grades;
    @FXML
    private Button button_settings;


    public DashboardController(){
    }

    public void initialize(){

        Student student = new Student();

        label_welcomeBack.setText(label_welcomeBack.getText() + " " + student.getName() + "!");

        button_enrollment.setOnAction(e -> enrollment());
        button_grades.setOnAction(e -> grades());
        button_settings.setOnAction(e -> settings());


    }

    public void enrollment(){

    }

    public void grades(){

    }

    public void settings(){

    }


}
