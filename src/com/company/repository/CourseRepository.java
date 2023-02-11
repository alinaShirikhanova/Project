package com.company.repository;

import com.company.model.Course;

import java.sql.*;

public class CourseRepository {
    private static String url = "jdbc:postgresql://127.0.0.1:5432/java24";
    private static String username = "postgres";
    private static String password = "12345";

    public static void getCourses(){
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from course");

            while (resultSet.next()){
                new Course(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("description")
                );
            }
            conn.close();
        } catch (Exception e) {
            System.err.println("Не удалось подключиться к базе данных");
            System.err.println(e.getMessage());
        }
    }

    public static void insertCourse(int id, String title, String description){
        try {
            Connection connection = DriverManager.getConnection(
                    url, username, password);
            String query = "insert into course(id, title, description) values(?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);
            statement.setString(2, title);
            statement.setString(3, description);
            statement.executeUpdate();

            connection.close();
        } catch (Exception e){
            System.out.println("Не удалось сохранить курс в БД");
            System.out.println(e.getMessage());
        }
    }
}
