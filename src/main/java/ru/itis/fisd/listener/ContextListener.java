package ru.itis.fisd.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.flywaydb.core.Flyway;
import ru.itis.fisd.database.DBConnection;

@WebListener
public class ContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("start migration config");

        Flyway flyway = Flyway
                .configure()
                .dataSource("jdbc:postgresql://localhost:5432/kr1", "postgres", "postgres")
                .load();
        System.out.println("start migration");

        flyway.migrate();
        System.out.println("migration done");

        DBConnection.getInstance();
    }

    public void contextDestroyed(ServletContextEvent sce) {
        DBConnection.getInstance().closeAllConnections();
    }
}
