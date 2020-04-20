package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    public static Connection connection;
    private static String user = "aecsariesgo";
    private static String password = "A3cs4r13sg0";

    public Connection conectar() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://172.16.0.211:5432/estrategia", user, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error de conexion PostgreSQL 211 estrategia " + e);
        }
        return connection;
    }

    public void desconectarse() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error al desconectar PoostgreSQL " + e);
        }
    }
}
