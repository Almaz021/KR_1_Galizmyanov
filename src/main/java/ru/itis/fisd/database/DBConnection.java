package ru.itis.fisd.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Stack;

public class DBConnection {
    private static DBConnection instance;
    private static final int POOL_SIZE = 5;
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/kr1";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "postgres";

    private final Stack<Connection> connectionPool;

    private DBConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            connectionPool = new Stack<>();
            for (int i = 0; i < POOL_SIZE; i++) {
                connectionPool.push(createConnection());
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static DBConnection getInstance() {
        if (instance == null) {
            synchronized (DBConnection.class) {
                if (instance == null) {
                    instance = new DBConnection();
                }
            }
        }
        return instance;
    }

    private Connection createConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public Connection getConnection() {
        if (connectionPool.isEmpty()) {
            try {
                return createConnection();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            return connectionPool.pop();
        }
    }

    public void releaseConnection(Connection connection) {
        if (connection != null) {
            connectionPool.push(connection);
        }
    }

    public void closeAllConnections() {
        while (!connectionPool.isEmpty()) {
            try {
                connectionPool.pop().close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
