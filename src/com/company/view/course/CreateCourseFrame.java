package com.company.view.course;

import javax.swing.*;

public class CreateCourseFrame extends JFrame {
    public CreateCourseFrame(){
        setTitle("Добавление нового курса");
        setSize(400, 250);
        setLocation(-650, 150);
        add(new CreateCoursePanel());
        setVisible(false);
    }
}
