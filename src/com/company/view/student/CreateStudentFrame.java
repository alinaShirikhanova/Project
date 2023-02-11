package com.company.view.student;

import javax.swing.*;

public class CreateStudentFrame extends JFrame {
    public CreateStudentFrame(){
        setTitle("Добавление нового студента");
        setSize(400, 250);
        setLocation(-650, 150);
        add(new CreateStudentPanel());
        setVisible(false);
    }
}
