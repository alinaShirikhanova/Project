package com.company.view.course;

import com.company.model.Course;
import com.company.model.Student;

import javax.swing.*;
import java.awt.*;

public class CourseListFrame extends JFrame {
    public CourseListFrame(Student student){
        setLayout(new FlowLayout());
        setTitle("Выбор курса для зачисления студента");
        setSize(480, 450);
        setLocation(-690, 150);

        JTable table = new JTable();
        table.setModel(Course.getModelCourses(student));

        JScrollPane scroll = new JScrollPane(table);
        add(scroll);

        setVisible(true);
    }
}
