package com.selrvk.enrollment;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.Year;
import java.util.Objects;

public class EnrollmentController {

    @FXML private CheckBox checkBox_regularStudent;
    @FXML private Button button_home;
    @FXML private TableView<Course> table_courses;
    @FXML private TableColumn<Course, String> col_code;
    @FXML private TableColumn<Course, String> col_name;
    @FXML private TableColumn<Course, Integer> col_units;
    @FXML private TableColumn<Course, Void> col_action;
    @FXML private ListView<Course> list_cart;
    @FXML private Label label_totalUnits;
    @FXML private Label label_enterSection;
    @FXML private TextField textField_enterSection;
    @FXML private Button button_loadCourses;
    @FXML private Label label_sysemester;

    // Student
    private static Student student;

    // The list of available courses
    private ObservableList<Course> list_courses = FXCollections.observableArrayList();

    // Initialize instance of cart
    private final Cart cart;

    /*      CHANGE THESE TO TEST       */
    private static String yrsem_id = "";

    private static String string_year_sem;

    public EnrollmentController(){

        this.cart = new Cart();
    }

    @FXML
    public void initialize(){

        int year = Year.now().getValue();
        int current_sem = 1;

        set_yrsem_id(student.getYear(), current_sem);
        set_sem_string(year, current_sem);
        Semester sem1 = new Semester(yrsem_id);


        button_home.setOnAction(e -> home());
        button_loadCourses.setOnAction(e -> loadCourses(sem1));

        label_enterSection.disableProperty().bind(checkBox_regularStudent.selectedProperty().not());
        textField_enterSection.disableProperty().bind(checkBox_regularStudent.selectedProperty().not());
        button_loadCourses.disableProperty().bind(checkBox_regularStudent.selectedProperty().not());

        col_code.setCellValueFactory(new PropertyValueFactory<>("code"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_units.setCellValueFactory(new PropertyValueFactory<>("units"));

        // ADD TEST COURSES
        list_courses = FXCollections.observableArrayList(sem1.getSemester_courses());

        // Bind table courses(FX) with ObservableList
        table_courses.setItems(list_courses);
        // Bind list_cart(FX) with ObservableList, returned from Cart class
        list_cart.setItems(cart.getCart());

        label_sysemester.setText(string_year_sem);
        addRemoveButtonToCart();
        addButtonToTable();

        System.out.println("Your current year: " + student.getYear());
        System.out.println("Current year: " + year);
        System.out.println("Current sem: " + current_sem);
        System.out.println("Sem ID: " + yrsem_id);
    }

    public void addToCart(Course course){
        cart.addToCart(course);
    }

    private void addButtonToTable() {

        col_action.setCellFactory(param -> new TableCell<Course, Void>() {

            private final Button btn = new Button("Add to Cart");

            {
                btn.setOnAction(event -> {
                    Course course = getTableView().getItems().get(getIndex());
                    addToCart(course);
                    updateTotalUnits();
                    list_courses.remove(course);
                    table_courses.refresh();
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(btn);
                }
            }
        });
    }

    public void loadCourses(Semester sem){
        for(Course c : sem.getSemester_courses()){
            if(!cart.getCart().contains(c)){
                addToCart(c);
                list_courses.remove(c);
            }
        }

        updateTotalUnits();
    }

    public void addRemoveButtonToCart(){
        list_cart.setCellFactory(param -> new ListCell<Course>() {
            private final Button btnRemove = new Button("Remove");

            {
                btnRemove.setOnAction(event -> {
                    Course course = getItem();
                    if (course != null) {
                        cart.removeFromCart(course);
                        updateTotalUnits();
                        list_courses.add(course);
                        table_courses.refresh();
                    }
                });
            }

            @Override
            protected void updateItem(Course course, boolean empty) {
                super.updateItem(course, empty);

                if (empty || course == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    setText(course.getCode() + " - " + course.getName() + " (" + course.getUnits() + " units)");
                    setGraphic(btnRemove);
                }
            }
        });
    }

    public void updateTotalUnits(){

        int totalUnits = 0;

        for(Course c : cart.getCart()){
            totalUnits += c.getUnits();
        }

        label_totalUnits.setText("Total Units: " + totalUnits);
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

    public void set_yrsem_id(int year, int currSem){
        yrsem_id = year + "yr_" + currSem + "sem";
    }

    public void set_sem_string(int year, int currSem){

        string_year_sem = "S.Y. " + year % 100 + " - " + ((year % 100) + 1) + "  " + currSem + " Semester";
    }

    public void setStudent(Student student){
        EnrollmentController.student = student;
    }
}
