package com.company.view;

import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JMenuBar {

    public MainMenu(){
        add(fileMenu());
        add(getLists());
        add(helpMenu());
    }

    private JMenu getLists(){
        JMenu lists = new JMenu("Списки");

        JMenuItem students = new JMenuItem("Список студентов");
        JMenuItem courses = new JMenuItem("Список курсов");

        lists.add(students);
        lists.add(courses);

        students.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.mainFrame.remove(MainFrame.courseListPanel);
                Main.mainFrame.add(MainFrame.studentListPanel);
                Main.mainFrame.pack();
            }
        });

        courses.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.mainFrame.remove(MainFrame.studentListPanel);
                Main.mainFrame.add(MainFrame.courseListPanel);
                Main.mainFrame.pack();
            }
        });

        return lists;
    }

    private JMenu helpMenu(){
        JMenu help = new JMenu("Помощь");

        JMenuItem about = new JMenuItem("О программе");
        JMenuItem reference = new JMenuItem("Справка");

        help.add(about);
        help.add(reference);

        return help;
    }

    private JMenu fileMenu(){
        JMenu file = new JMenu("Файл");

        JMenu newItem = new JMenu("Новый");
        JMenuItem newStudent = new JMenuItem("Студент");
        JMenuItem newCourse = new JMenuItem("Курс");
        JMenuItem newEnrollment = new JMenuItem("Зачисление");
        newItem.add(newStudent);
        newItem.add(newCourse);
        newItem.add(newEnrollment);

        JMenuItem settings = new JMenuItem("Настройки");

        JMenuItem close = new JMenuItem("Выйти");

        file.add(newItem);
        file.add(settings);
        file.addSeparator();
        file.add(close);

        newStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.createStudentFrame.setVisible(true);
            }
        });

        newCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.createCourseFrame.setVisible(true);
            }
        });

        return file;
    }
}