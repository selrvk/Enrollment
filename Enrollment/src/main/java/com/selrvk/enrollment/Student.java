package com.selrvk.enrollment;

public class Student {

    private int id_number;
    private String name;
    private int year;

    public Student(int id_number, String name){
        this.id_number = id_number;
        this.name = name;
    }

    public Student(){
        this.id_number = id_number = 32198171;
        this.name = "Charles";
        this.year = 1;
    }

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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
