package com.selrvk.enrollment;

public class Subject {

    private int id;
    private int slots;

    private String section;
    private String name;

    public Subject(){
    }

    public Subject(int id, int slots, String section, String name){
        this.id = id;
        this.slots = slots;
        this.section = section;
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public int getSlots() {
        return slots;
    }

    public void setSlots(int slots) {
        this.slots = slots;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
