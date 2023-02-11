package com.company.repository;

import com.company.model.Course;
import com.company.model.CourseEnrollment;
import com.company.model.Student;

import java.sql.*;

public class CourseEnrollmentRepository {
    private static String url = "jdbc:postgresql://127.0.0.1:5432/java24";
    private static String username = "postgres";
    private static String password = "12345";

    public static void getEnrollments(){
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from enrollment");

            while (resultSet.next()){
                new CourseEnrollment(
                        resultSet.getInt("id"),
                        resultSet.getInt("studentId"),
                        resultSet.getInt("courseId")
                );
            }
            conn.close();
        } catch (Exception e) {
            System.err.println("Не удалось подключиться к базе данных");
            System.err.println(e.getMessage());
        }
    }

    public static void insertEnrollment(int id, Student student, Course course){
        try {
            Connection connection = DriverManager.getConnection(
                    url, username, password);
            String query = "insert into enrollment(id, studentId, courseId) values(?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);
            statement.setInt(2, student.getId());
            statement.setInt(3, course.getId());
            statement.executeUpdate();

            connection.close();
        } catch (Exception e){
            System.out.println("Не удалось сохранить запись в БД");
            System.out.println(e.getMessage());
        }
    }

    public static void deleteEnrollment(int id){
        try {
            Connection connection = DriverManager.getConnection(
                    url, username, password);
            String query = "delete from enrollment where id= ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);
            statement.executeUpdate();

            connection.close();
        } catch (Exception e){
            System.out.println("Не удалось удалить запись из БД");
            System.out.println(e.getMessage());
        }
    }

    public static void deleteEnrollmentByStudentId(int studentId){
        try {
            Connection connection = DriverManager.getConnection(
                    url, username, password);
            String query = "delete from enrollment where studentid = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, studentId);
            statement.executeUpdate();

            connection.close();
        } catch (Exception e){
            System.out.println("Не удалось удалить запись из БД");
            System.out.println(e.getMessage());
        }
    }

}
