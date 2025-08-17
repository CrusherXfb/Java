package org.example;

import java.sql.*;

import static org.example.DumpUtils.dd;

public class HotelDBConnection {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/hotel_db?charset=UTF-8";
        String user = "postgres";
        String password = "11223344";

        String sql = "SELECT g.first_name, g.last_name, " +
                "r.room_number, " +
                "(b.check_out_date - b.check_in_date) as days_stayed " +
                "FROM bookings b " +
                "JOIN guests g ON b.guest_id = g.guest_id " +
                "JOIN rooms r ON b.room_id = r.room_id " +
                "WHERE b.check_out_date - b.check_in_date > 5 " +
                "ORDER BY days_stayed DESC";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("✓ Подключение установлено\n");

            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {

                dd(resultSet); //использовал чтобы посмотреть в каком виде приходят данные из бд

                System.out.println("┌───────────────────────────────────┐");
                System.out.println("│ Гости с длительным проживанием:   │");
                System.out.println("├──────────┬──────────┬───────┬─────┤");
                System.out.printf("│ %-8s │ %-8s │ %-4s │ %-3s │\n",
                        "Имя", "Фамилия", "Номер", "Дн.");
                System.out.println("├──────────┼──────────┼───────┼─────┤");

                while (resultSet.next()) {
                    System.out.printf("│ %-8s │ %-8s │  %-4s │ %-3d │\n",
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name"),
                            resultSet.getString("room_number"),
                            resultSet.getInt("days_stayed"));
                }
                System.out.println("└──────────┴──────────┴───────┴─────┘");
            }
        } catch (SQLException e) {
            System.out.println("✗ Ошибка подключения");
        }
    }
}