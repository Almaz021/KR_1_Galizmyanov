package ru.itis.fisd.repository;

import ru.itis.fisd.database.DBConnection;
import ru.itis.fisd.model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    private final DBConnection db = DBConnection.getInstance();

    /* language=sql */
    private static final String SQL_FIND_BY_ID = """
            SELECT *
            FROM orders
            WHERE id = ?
            """;
    private static final String SQL_FIND_ALL = """
            SELECT *
            FROM orders
            """;

    public Order findById(Long id) {
        try (
                Connection conn = db.getConnection();
        ) {
            PreparedStatement preparedStatement = conn.prepareStatement(SQL_FIND_BY_ID);

            preparedStatement.setLong(1, id);
            ResultSet result = preparedStatement.executeQuery();
            Order order = null;
            if (result.next()) {
                order = new Order(
                        result.getLong("id"),
                        result.getString("bludo"),
                        result.getInt("table_number"),
                        result.getString("server_name")
                );
            }
            return order;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Order> findAll() {
        List<Order> orders = new ArrayList<>();

        try (Connection connection = db.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_ALL);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                Order order = new Order(
                        resultSet.getLong("id"),
                        resultSet.getString("bludo"),
                        resultSet.getInt("table_number"),
                        resultSet.getString("server_name")
                );
                orders.add(order);
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orders;
    }
}
