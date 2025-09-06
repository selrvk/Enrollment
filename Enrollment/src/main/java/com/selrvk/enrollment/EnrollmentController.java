package com.selrvk.enrollment;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class EnrollmentController {

    @FXML private Button button_home;
    @FXML private TableView<Course> table_courses;
    @FXML private TableColumn<Course, String> col_code;
    @FXML private TableColumn<Course, String> col_name;
    @FXML private TableColumn<Course, Integer> col_units;

    public EnrollmentController(){}

    @FXML
    public void initialize(){

        button_home.setOnAction(e -> home());

        col_code.setCellValueFactory(new PropertyValueFactory<>("code"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_units.setCellValueFactory(new PropertyValueFactory<>("units"));

        ObservableList<Course> courses = FXCollections.observableArrayList(
                new Course("CS101", "Intro to Programming", 3),
                new Course("MATH201", "Calculus II", 4),
                new Course("ENG150", "Technical Writing", 2),
                new Course("IT 123", "Course Test", 3)

        );

        table_courses.setItems(courses);
    }

    public void home(){

        try{

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Dashboard.fxml")));
            Stage stage = (Stage) button_home.getScene().getWindow();
            stage.setTitle("Main Dashboard");
            stage.setScene(new Scene(root));
            stage.show();

        } catch(IOException e){

            throw new RuntimeException(e);
        }
    }
}
