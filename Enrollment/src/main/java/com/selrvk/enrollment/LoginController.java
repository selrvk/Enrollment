package com.selrvk.enrollment;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class LoginController {

    @FXML
    private Button button_login;
    @FXML
    private TextField email_input;
    @FXML
    private TextField password_input;

    public LoginController(){

    }

    public void initialize(){

        button_login.setOnAction(e -> login());
    }

    public void login() {

        System.out.println("BUTTON CLICKED");

        try{

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

