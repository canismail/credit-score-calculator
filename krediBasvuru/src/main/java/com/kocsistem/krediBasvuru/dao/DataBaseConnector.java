package com.kocsistem.krediBasvuru.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.jboss.logging.Logger;

public class DataBaseConnector {

    public static Logger logger = Logger.getLogger(DataBaseConnector.class);

    public Connection getConnection(String driver, String url, String userName, String password) {
        try {
            Class.forName(driver).newInstance();

            return DriverManager.getConnection(url, userName, password);

        } catch (Exception e) {
            logger.error(e);
            return null;
        }
    }

    /**
     * 
     * Close DB Objects like PreparedStatement, Connection..
     */
    public static void closeDatabaseConnection(Object... obj) {
        try {
            for (Object type : obj) {
                if (type instanceof PreparedStatement) {
                    ((PreparedStatement) type).close();
                } else if (type instanceof Connection) {
                    ((Connection) type).close();
                }
            }

        } catch (Exception e) {
            logger.error(e);
        }

    }
}