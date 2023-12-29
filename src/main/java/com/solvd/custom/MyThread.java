package com.solvd.custom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;

public class MyThread extends Thread {
    private static final Logger LOGGER = LogManager.getLogger(MyThread.class);

    @Override
    public void run() {
        try {
            ConnectionPool connectionPool = ConnectionPool.getInstance();
            Connection connection = connectionPool.getConnection();

            if (connection != null) {
                LOGGER.info("The thread is running");
                // Simulating the work with the connection
                Thread.sleep(2000);
                connectionPool.releaseConnection(connection);
                LOGGER.info("The connection is released");
            } else {
                LOGGER.error("Timeout waiting for connection");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
