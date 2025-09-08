package com.selrvk.enrollment;

import java.util.ArrayList;

public class Semester {

    String semester_id;
    ArrayList<Course> semester_courses = new ArrayList<>();

    public Semester(String semester_id){

        this.semester_id = semester_id;
        addCourses(semester_id);
    }

    public void addCourses(String semester_id){
        if(semester_id.equals("1yr_1sem")){
            semester_courses.add(new Course("COMP1", "Introduction to Computing", 3));
            semester_courses.add(new Course("COMP2", "Computer Programming 1 (Fundamentals of Programming)", 3));
            semester_courses.add(new Course("GEC-UTS", "Understanding the Self", 3));
            semester_courses.add(new Course("GEC-MATH", "Mathematics in the Modern World", 3));
            semester_courses.add(new Course("GEC-TCW", "The Contemporary World", 3));
            semester_courses.add(new Course("GEC-ART", "Art Appreciation", 3));
            semester_courses.add(new Course("BSC1", "Being Skills Course 1", 2));
            semester_courses.add(new Course("PE1", "Physical Fitness & Gymnastics", 2));
            semester_courses.add(new Course("NSTP1", "National Service Training Program 1", 3));
        } else if(semester_id.equals("1yr_2sem")){
            semester_courses.add(new Course("COMP3", "Computer Programming 2 (Intermediate Programming)", 3));
            semester_courses.add(new Course("IT1", "Computer Organization", 3));
            semester_courses.add(new Course("IT3", "Elective 1", 3));
            semester_courses.add(new Course("GEC-PCOM", "Purposive Communication", 3));
            semester_courses.add(new Course("GEC-STS", "Science, Technology and Society", 3));
            semester_courses.add(new Course("EPC", "English Proficiency", 3));
            semester_courses.add(new Course("Math1", "College Algebra", 3));
            semester_courses.add(new Course("BSC2", "Being Skills Course 2", 2));
            semester_courses.add(new Course("PE2", "Rhythmic Activities", 2));
            semester_courses.add(new Course("NSTP2", "National Service Training Program 2", 3));
        }
    }

    public ArrayList<Course> getSemester_courses(){
        return semester_courses;
    }
}
