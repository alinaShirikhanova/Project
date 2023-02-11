package com.company.view;

import com.company.model.Student;
import com.company.view.course.CourseListPanel;
import com.company.view.student.StudentListPanel;
import com.company.view.student.StudentListPopupMenu;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public static StudentListPanel studentListPanel = new StudentListPanel();
    public static CourseListPanel courseListPanel = new CourseListPanel();

    public MainFrame(){
        setTitle("Наше приложение LMS");
        setLocation(-700, 100); //!!! ВАЖНО !!! Размеры я задал для своих 2х мониторов
        setLayout(new FlowLayout());

        setJMenuBar(new MainMenu());
        add(studentListPanel);

        pack();
        setVisible(false);
    }
}
