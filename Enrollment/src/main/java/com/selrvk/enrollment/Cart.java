package com.selrvk.enrollment;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {

    private final ObservableList<Course> courses = FXCollections.observableArrayList();

    public Cart(){

    }

    public ObservableList<Course> getCart(){
        return courses;
    }

    public void addToCart(Course course){
        this.courses.add(course);
    }

    public void removeFromCart(Course course){
        this.courses.remove(course);
    }
}
