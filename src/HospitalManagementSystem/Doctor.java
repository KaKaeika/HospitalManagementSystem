package HospitalManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Doctor {
    private Connection connection;
    private Scanner scanner;

    public Doctor(Connection connection,Scanner scanner){
        this.connection = connection;
        this.scanner = scanner;
    }

    public void addDoctor(){
        System.out.println("Enter Doctor Name: ");
        String name = scanner.next();
        System.out.println("Enter Patient Specialization: ");
        String specialization = scanner.next();

        try {

            String query = "INSERT INTO doctors(name,specialization) VALUES(?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,specialization);

            int affectedRows = preparedStatement.executeUpdate();
            if(affectedRows > 0){
                System.out.println("Doctor Added Successfully!!");
            }else {
                System.out.println("Failed to add Patient!!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void viewDoctors(){
        String query = "select * from doctors";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Doctors:");
            System.out.println("+------------+--------------------+--------------------+");
            System.out.println("|Doctor  Id  | Name               | Specialization     |");
            System.out.println("+------------+--------------------+--------------------+");

            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String specialization = resultSet.getString("specialization");
                System.out.printf("| %-12s | %-20s | %-20s |\n", id, name, specialization);
                System.out.println("+------------+--------------------+--------------------+");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public boolean getDoctorById(int id){
        String query = "select * from doctors where id = ?";

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
