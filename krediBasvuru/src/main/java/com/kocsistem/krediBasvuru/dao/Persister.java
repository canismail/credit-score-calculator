package com.kocsistem.krediBasvuru.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.jboss.logging.Logger;

import com.kocsistem.krediBasvuru.model.PersonInfo;
import com.kocsistem.krediBasvuru.dao.DataBaseConnector;

public class Persister {

    public static Logger logger = Logger.getLogger(Persister.class);

    public void save(PersonInfo info, String error) {

        DataBaseConnector connector = new DataBaseConnector();

        Connection con = connector.getConnection("org.h2.Driver", "jdbc:h2:mem:testdb", "kocsistem", "");
        PreparedStatement stmPerson = null;
        try {
            String sql = "insert into credit_person_info(id,name,phone_number,salary,credit_score,credit_limit,error) values(?,?,?,?,?,?,?)";
            con.setAutoCommit(true);
            stmPerson = con.prepareStatement(sql);
            stmPerson.setString(1, info.getId());
            stmPerson.setString(2, info.getName());
            stmPerson.setString(3, info.getPhoneNumber());
            stmPerson.setInt(4, info.getSalary());
            stmPerson.setString(5, info.getScore());
            stmPerson.setInt(6, info.getLimit());
            stmPerson.setString(7, error);

            stmPerson.execute();
        } catch (Exception e) {
            logger.error(e);
        } finally {
            DataBaseConnector.closeDatabaseConnection(stmPerson, con);
        }
    }
}
