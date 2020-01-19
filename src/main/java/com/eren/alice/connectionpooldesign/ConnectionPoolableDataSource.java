package com.eren.alice.connectionpooldesign;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class ConnectionPoolableDataSource {
    private static ConnectionPoolableDataSource instance;
    private final Set<PoolableConnection> connections = new HashSet<>();
    private static int DEFAULT_POOL_SIZE = 10;

    private ConnectionPoolableDataSource(DataSource dataSource) throws SQLException {
        for (int i = 0; i < DEFAULT_POOL_SIZE; i++) {
            connections.add(new PoolableConnection(dataSource.getConnection()));
        }
    }

    public static synchronized ConnectionPoolableDataSource getInstance(DataSource dataSource) throws SQLException {
        if (instance == null) {
            instance = new ConnectionPoolableDataSource(dataSource);
        }
        return instance;
    }

    public synchronized Connection getConnection() throws SQLException {
        PoolableConnection poolableConnection = connections.stream().filter(PoolableConnection::isClosed).findFirst().get();
        poolableConnection.open();
        return poolableConnection;
    }

}