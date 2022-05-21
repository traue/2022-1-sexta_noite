package br.sisacademico.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String urlDB = "jdbc:derby://localhost:1527/sisacademico_6noite";
    private static final String usuario = "root";
    private static final String senha = "root";

    public static Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
        return DriverManager.getConnection(urlDB, usuario, senha);
    }
}
