package org.example;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try (var connection = DriverManager.getConnection(ConnectionConstants.URL,
                ConnectionConstants.USERNAME, ConnectionConstants.PASSWORD)){
            Statement statement = connection.createStatement();

            var usersYounger_18 = statement.executeQuery(SqlQueries.USERS_YOUNGER_18);
            System.out.println("Users younger 18:");
            showUsers(usersYounger_18);

            var usersNameFinishedO = statement.executeQuery(SqlQueries.FIRST_NAME_FINISHED_WITH_O);
            System.out.println("Users, who's name finished with O:");
            showUsers(usersNameFinishedO);

            var usersBetween18And60 = statement.executeQuery(SqlQueries.USERS_BETWEEN_18_AND_60);
            System.out.println("Users, who's age between 18 and 60:");
            showUsers(usersBetween18And60);

            var firstNameConsistsA = statement.executeQuery(SqlQueries.COUNT_FIRST_NAME_CONSIST_O);
            firstNameConsistsA.next();
            System.out.println("Users, who's first name consists A: " + firstNameConsistsA.getInt("UsersCount"));

            var countOfAdultUsers = statement.executeQuery(SqlQueries.USERS_OLDER_THEN_18);
            countOfAdultUsers.next();
            System.out.println("Users, who's older then 18: " + countOfAdultUsers.getInt("AdultUsers"));

        } catch (SQLException e){
            System.out.println("Error " + e.getMessage());
        }
    }

    private static void showUsers(ResultSet resultSet) throws SQLException {

        List<User> users = new ArrayList<>();
        while (resultSet.next()){
            users.add(new User(resultSet.getInt("id"), resultSet.getString("first_name"),
                    resultSet.getString("last_name"), resultSet.getString("gender"),
                    resultSet.getInt("age")));
        }

        System.out.println(users.toString());
    }

}