package com.company.model;

import com.company.repository.CourseEnrollmentRepository;

import java.util.ArrayList;

public class CourseEnrollment {
    private int id;
    private Student student;
    private Course course;

    private static int lastId = 0;
    public static ArrayList<CourseEnrollment> list = new ArrayList<>();

    public void getEnrollment(){
        System.out.println(student.name + " " + student.surname + " => " + course.title);
    }

    public CourseEnrollment(Student student, Course course){
        System.out.println("Course + Student!!!");
        this.id = ++lastId;
        this.student = student;
        this.course = course;
        list.add(this);
        CourseEnrollmentRepository.insertEnrollment(id, student, course);
    }

    public CourseEnrollment(int id, int studentId, int courseId){
        this.id = lastId = id;
        this.student = Student.getStudentById(studentId);
        this.course = Course.getCourseById(courseId);
        list.add(this);
    }

    public static ArrayList<Course> getCoursesByStudent(Student student){
        ArrayList<Course> courses = new ArrayList<>();
        for (CourseEnrollment value : list){
            if (value.student.getId() == student.getId()){
                courses.add(value.course);
            }
        }
        return courses;
    }

    public static ArrayList<Student> getStudentsByCourse(Course course){
        ArrayList<Student> students = new ArrayList<>();
        for (CourseEnrollment value : list){
            if (value.course.getId() == course.getId()){
                students.add(value.student);
            }
        }
        return students;
    }

    public static CourseEnrollment getCourseEnrollment(Student student, Course course){
        for (CourseEnrollment ce : list)
            if (ce.course == course && ce.student == student)
                return ce;
        return new CourseEnrollment(student, course);
    }
}
