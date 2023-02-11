package com.company.model;


import com.company.repository.StudentRepository;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class Student {
    private int id;
    String name;
    String surname;

    private static int lastId = 0;
    public static ArrayList<Student> list = new ArrayList<>();
    static String[] headers = {"ID", "Имя", "Фамилия"};
    public static DefaultTableModel model =
            new DefaultTableModel(headers, 0); // Model

    public Student(String name, String surname){
        this.id = ++lastId;
        setProperties(name, surname);
        StudentRepository.insertStudent(id, name, surname);
    }

    public Student(int id, String name, String surname){
        lastId = this.id = id;
        setProperties(name, surname);
    }

    public static Student getStudentById(int id){
        for (Student student : list)
            if (student.id == id)
                return student;
        return null;
    }

    public static void update(int id, int indexRow, String name, String surname){
        model.setValueAt(name, indexRow, 1);
        model.setValueAt(surname, indexRow, 2);
        list.get(indexRow).name = name;
        list.get(indexRow).surname = surname;
        StudentRepository.updateStudent(id, name, surname);
    }

    public static void delete(int userId, int indexRow){
        StudentRepository.deleteStudent(userId);
        model.removeRow(indexRow);
        list.remove(indexRow);
    }

    private void setProperties(String name, String surname){
        this.name = name;
        this.surname = surname;
        list.add(this);
        addToModel(this);
    }

    public static void addToModel(Student student){
        model.addRow(
                new Object[] {
                        student.getId(),
                        student.getName(),
                        student.getSurname()
                }
        );
    }

    public String getInfo(){
        return this.id + " " + this.name + " " + this.surname;
    }

    public int getId(){
        return this.id;
    }
    public String getName() { return this.name; }
    public String getSurname() { return this.surname; }

    public ArrayList<Course> getCourses(){
        return CourseEnrollment.getCoursesByStudent(this);
    }

    public CourseEnrollment addCourse(Course course){
        return new CourseEnrollment(this, course);
    }

    public ArrayList<Integer> getMarks(Course course){
        return AcademicPerformance.getMarksByStudentAndCourse(this, course);
    }
}
