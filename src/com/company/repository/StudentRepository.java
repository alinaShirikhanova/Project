package com.company.repository;

import com.company.model.Student;

import java.sql.*;

public class StudentRepository {
    private static String url = "jdbc:postgresql://127.0.0.1:5432/java24";
    private static String username = "postgres";
    private static String password = "12345";

    public static void getStudents(){
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from student");

            while (resultSet.next()){
                new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname")
                );
            }
            conn.close();
        } catch (Exception e) {
            System.err.println("Не удалось подключиться к базе данных");
            System.err.println(e.getMessage());
        }
    }

    public static void insertStudent(int id, String name, String surname){
        try {
            Connection connection = DriverManager.getConnection(
                    url, username, password);
            String query = "insert into student(id, name, surname) values(?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setString(3, surname);
            statement.executeUpdate();

            connection.close();
        } catch (Exception e){
            System.out.println("Не удалось сохранить студента в БД");
            System.out.println(e.getMessage());
        }
    }

    public static void deleteStudent(int id){
        try {
            Connection connection = DriverManager.getConnection(
                    url, username, password);
            String query = "delete from student where id= ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);
            statement.executeUpdate();

            connection.close();
            CourseEnrollmentRepository.deleteEnrollmentByStudentId(id);
        } catch (Exception e){
            System.out.println("Не удалось удалить студента из БД");
            System.out.println(e.getMessage());
        }
    }

    public static void updateStudent(int id, String name, String surname){
        try {
            Connection connection = DriverManager.getConnection(
                    url, username, password);
            String query = "update student set name=?, surname=? where id=?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, name);
            statement.setString(2, surname);
            statement.setInt(3, id);
            statement.executeUpdate();

            connection.close();
        } catch (Exception e){
            System.out.println("Не удалось обновить данные студента в БД");
            System.out.println(e.getMessage());
        }
    }
}
