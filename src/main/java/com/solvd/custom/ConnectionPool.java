package com.solvd.custom;

import java.sql.Connection;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {
    private static ConnectionPool INSTANCE;
    private BlockingQueue<Connection> connections;

    private ConnectionPool(int poolSize) {
        connections = new ArrayBlockingQueue<>(poolSize);
        for (int i = 0; i < poolSize; i++) {
            connections.add(new MyConnection());
        }
    }

    public static ConnectionPool getInstance() {
        if (INSTANCE == null) {
            synchronized (ConnectionPool.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ConnectionPool(5);
                }
            }

        }
        return INSTANCE;
    }

    public Connection getConnection() throws InterruptedException {
        return connections.take();
    }

    public void releaseConnection(Connection conn) throws InterruptedException {
        connections.put(conn);
    }
}
