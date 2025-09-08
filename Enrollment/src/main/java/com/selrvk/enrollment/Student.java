package com.selrvk.enrollment;

public class Student {

    private int id_number = 32198171;
    private String name = "Charles";

    public Student(int id_number, String name){
        this.id_number = id_number;
        this.name = name;
    }

    public Student(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId_number() {
        return id_number;
    }

    public void setId_number(int id_number) {
        this.id_number = id_number;
    }
}
