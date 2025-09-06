package com.selrvk.enrollment;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class DashboardController {

    @FXML
    private Label label_welcomeBack;
    @FXML
    private Button button_enrollment;
    @FXML
    private Button button_grades;
    @FXML
    private Button button_settings;


    public DashboardController(){}

    public void initialize(){

        Student student = new Student();

        label_welcomeBack.setText(label_welcomeBack.getText() + " " + student.getName() + "!");

        button_enrollment.setOnAction(e -> enrollment());
        button_grades.setOnAction(e -> grades());
        button_settings.setOnAction(e -> settings());
    }

    public void enrollment(){

        try{

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Enrollment.fxml")));
            Stage stage = (Stage) button_enrollment.getScene().getWindow();
            stage.setTitle("Enrollment");
            stage.setScene(new Scene(root));
            stage.show();

        } catch(IOException e){

            throw new RuntimeException(e);
        }
    }

    public void grades(){

        try{

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Grades.fxml")));
            Stage stage = (Stage) button_grades.getScene().getWindow();
            stage.setTitle("Grades");
            stage.setScene(new Scene(root));
            stage.show();

        } catch(IOException e){

            throw new RuntimeException(e);
        }
    }

    public void settings(){

        try{

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Settings.fxml")));
            Stage stage = (Stage) button_settings.getScene().getWindow();
            stage.setTitle("Settings");
            stage.setScene(new Scene(root));
            stage.show();

        } catch(IOException e){

            throw new RuntimeException(e);
        }
    }


}
