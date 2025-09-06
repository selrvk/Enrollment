package com.selrvk.enrollment;

public class Course {

    private String code;
    private String name;
    private int units;
    private int slots;

    public Course(){
    }

    public Course(String code, String name, int units){
        this.code = code;
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

    public String getCode() {
        return code;
    }

    public void setCourseCode(String code) { this.code = code; }
}
