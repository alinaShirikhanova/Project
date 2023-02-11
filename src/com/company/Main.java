package com.company;

import com.company.model.CourseEnrollment;
import com.company.repository.CourseEnrollmentRepository;
import com.company.repository.CourseRepository;
import com.company.repository.StudentRepository;
import com.company.view.MainFrame;
import com.company.view.course.CreateCourseFrame;
import com.company.view.student.CreateStudentFrame;

public class Main {
    public static CreateStudentFrame createStudentFrame = new CreateStudentFrame();
    public static CreateCourseFrame createCourseFrame = new CreateCourseFrame();
    public static MainFrame mainFrame = new MainFrame();

    public static void main(String[] args) {
        CourseRepository.getCourses();
        StudentRepository.getStudents();
        CourseEnrollmentRepository.getEnrollments();
        mainFrame.setVisible(true);
    }
}
