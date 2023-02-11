package com.company.view.course;

import com.company.Main;
import com.company.model.Course;
import com.company.model.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateCoursePanel extends JPanel {
    public CreateCoursePanel(){
        JTextField title = new JTextField(10);
        JTextField description = new JTextField(10);
        JButton saveButton = new JButton("Создать курс");

        add(title);
        add(description);
        add(saveButton);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!title.getText().isEmpty()) {
                    new Course(title.getText(), description.getText());
                    title.setText("");
                    description.setText("");
                    Main.createCourseFrame.setVisible(false);
                }
            }
        });
    }
}
