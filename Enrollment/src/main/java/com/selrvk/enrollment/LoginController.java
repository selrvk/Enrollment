package com.selrvk.enrollment;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.Objects;

public class LoginController {

    @FXML private Button button_login;
    @FXML private TextField email_input;
    @FXML private TextField password_input;
    @FXML private Label label_login;

    private final Student student = new Student();
    private final DashboardController dashboardController = new DashboardController();

    public void initialize(){

        button_login.setOnAction(e -> login());
        System.out.println(label_login.getText());
    }

    public void login() {
        try{

            dashboardController.setStudent(student);
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Dashboard.fxml")));
            Stage stage = (Stage) button_login.getScene().getWindow();
            stage.setTitle("Main Dashboard");
            stage.setScene(new Scene(root));
            stage.show();

        } catch(IOException e){

            throw new RuntimeException(e);
        }
    }

}

