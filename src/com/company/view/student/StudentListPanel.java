package com.company.view.student;

import com.company.model.Student;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StudentListPanel extends JPanel {
    public StudentListPanel(){
        JTable table = new JTable();
        table.setModel(Student.model);
        StudentListPopupMenu popupMenu = new StudentListPopupMenu(table);
        table.setComponentPopupMenu(popupMenu);
        JScrollPane scroll = new JScrollPane(table);
        add(scroll);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int currentRow = table.rowAtPoint(e.getPoint());
                table.setRowSelectionInterval(currentRow, currentRow);
            }
        });
    }
}