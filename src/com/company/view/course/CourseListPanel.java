package com.company.view.course;

import com.company.model.Course;

import javax.swing.*;

public class CourseListPanel extends JPanel {
    public JTable table;
    public CourseListPanel(){
        table = new JTable();
        table.setModel(Course.model);
        JScrollPane scroll = new JScrollPane(table);
        add(scroll);
    }
}
