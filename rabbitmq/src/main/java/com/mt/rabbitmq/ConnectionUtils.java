package com.mt.rabbitmq;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * author: liqm
 * 2019-11-15
 */
public class ConnectionUtils {

    private static String USERNAME = "guest";
    private static String PASSWORD = "guest";
    private static String ADDRESS = "localhost";
    private static Integer PORT = 5672;

    public static Connection getConnection() {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername(USERNAME);
        factory.setPassword(PASSWORD);
        factory.setVirtualHost("test") ;
        factory.setHost(ADDRESS);
        factory.setPort(PORT) ;
        Connection connection = null;
        try {
            factory.newConnection();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return connection;
    }


}
