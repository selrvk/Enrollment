package com.selrvk.enrollment;

public class Course {

    private String courseCode = "IT 123";
    private String name = "Course Name";

    private int units = 3;
    private int slots;

    public Course(){
    }

    public Course(String courseCode, String name, int units){
        this.courseCode = courseCode;
        this.units = units;
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSlots() {
        return slots;
    }

    public void setSlots(int slots) {
        this.slots = slots;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
