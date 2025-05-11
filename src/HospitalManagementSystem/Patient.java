package HospitalManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Patient {
    private Connection connection;
    private Scanner scanner;

    public Patient(Connection connection,Scanner scanner){
        this.connection = connection;
        this.scanner = scanner;
    }
    //这样写的目的是让 Patient 类内部也能使用数据库连接和用户输入功能。

    //连接数据库（Connection） 只需要建一次，就能重复用。避免每次操作都重新连接数据库，浪费资源。
    //Scanner 负责读取用户输入，也只需要创建一次，传给不同的类用。

    public void addPatient(){
        System.out.println("Enter Patient Name: ");
        String name = scanner.next();
        System.out.println("Enter Patient Age: ");
        int age = scanner.nextInt();
        System.out.println("Enter Patient Gender: ");
        String gender = scanner.next();

        try {

            String query = "INSERT INTO patients(name,age,gender) VALUES(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,age);
            preparedStatement.setString(3,gender);
            int affectedRows = preparedStatement.executeUpdate();
            if(affectedRows > 0){
                System.out.println("Patient Added Successfully!!");
            }else {
                System.out.println("Failed to add Patient!!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void viewPatients(){
        String query = "select * from patients";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Patients:");
            System.out.println("+------------+--------------------+----------+------------+");
            System.out.println("|Patient Id  | Name               | Age      | Gender     |");
            System.out.println("+------------+--------------------+----------+------------+");

            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");
                System.out.printf("| %-12d | %-20s | %-10d | %-12s |\n", id, name, age, gender);
                System.out.println("+------------+--------------------+----------+------------+");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public boolean getPatientById(int id){
        String query = "select * from patients where id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }




}
