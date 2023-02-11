package com.company.view.course;

import com.company.model.Course;
import com.company.model.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChoiceCourse extends JFrame {
    CourseListPanel panel;
    public ChoiceCourse(Student student){
        setLayout(new FlowLayout());
        setTitle("Выбор курса для зачисления студента");
        setSize(400, 520);
        setLocation(-650, 150);
        panel = new CourseListPanel();
        add(panel);

        JButton button = new JButton("Зачислить");
        add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = panel.table.getSelectedRow();
                int courseId = Integer.parseInt(panel.table.getValueAt(index, 0).toString());
                student.addCourse(Course.getCourseById(courseId));
            }
        });

        setVisible(true);
    }
}
