package com.company.model;

import com.company.repository.CourseRepository;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class Course {
    private int id;
    String title;
    String description;

    private static int lastId = 0;
    static ArrayList<Course> list = new ArrayList<>();
    static String[] headers = {"ID", "Название курса", "Описание"};
    public static DefaultTableModel model =
            new DefaultTableModel(headers, 0); // Model

    public Course(String title, String description){
        this.id = ++lastId;
        setProperties(title, description);
        CourseRepository.insertCourse(id, title, description);
    }

    public Course(int id, String title, String description){
        this.id = lastId = id;
        setProperties(title, description);
    }

    public static Course getCourseById(int id){
        for (Course course : list)
            if (course.id == id)
                return course;
        return null;
    }

    private void setProperties(String title, String description){
        this.title = title;
        this.description = description;
        list.add(this);
        addToModel(this);
    }

    public static void addToModel(Course course){
        model.addRow(
                new Object[] {
                        course.getId(),
                        course.getTitle(),
                        course.getDescription()
                }
        );
    }

    public String getInfo(){
        return this.id + " " + this.title + " " + this.description;
    }

    public int getId(){
        return this.id;
    }
    public String getTitle() { return this.title; }
    public String getDescription() { return this.description; }

    public ArrayList<Student> getStudents(){
        return CourseEnrollment.getStudentsByCourse(this);
    }

    public static DefaultTableModel getModelCourses(Student student){
        String[] headers = {"ID", "Название курса", "Описание"};
        DefaultTableModel model = new DefaultTableModel(headers, 0);
        for (Course course : student.getCourses()){
            model.addRow(
                    new Object[] {
                            course.getId(),
                            course.getTitle(),
                            course.getDescription()
                    }
            );
        }
        return model;
    }

    public CourseEnrollment addStudent(Student student){
        return new CourseEnrollment(student, this);
    }
}
