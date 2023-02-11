package com.company.view.student;

import com.company.model.Student;
import com.company.view.course.ChoiceCourse;
import com.company.view.course.CourseListFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentListPopupMenu extends JPopupMenu{
    private static JTable table;
    StudentListPopupMenu(JTable table){
        this.table = table;
        add(item("Сохранить", "save"));
        addSeparator();
        add(item("Зачислить на курс", "addCourse"));
        add(item("Показать курсы студента", "getCourses"));
        addSeparator();
        add(item("Удалить", "delete"));
    }

    JMenuItem item(String title, String command){
        JMenuItem item = new JMenuItem(title);
        item.setActionCommand(command);
        item.addActionListener(itemMenuListener);
        return item;
    }

    static ItemMenuListener itemMenuListener = new ItemMenuListener();

    static class ItemMenuListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            int index = table.getSelectedRow();
            int id = Integer.parseInt(table.getValueAt(index, 0).toString());
            String name = table.getValueAt(index, 1).toString();
            String surname = table.getValueAt(index, 2).toString();

            switch (e.getActionCommand()){
                case "addCourse":
                    new ChoiceCourse(Student.getStudentById(id)); break;
                case "getCourses": 
                    new CourseListFrame(Student.getStudentById(id)); break;
                case "save":
                    Student.update(id, index, name, surname); break;
                case "delete":
                    Student.delete(id, index); break;
                default:
                    System.err.println("Команду " + e.getActionCommand() + "невозможно обработать.");
            }
        }
    }
}
