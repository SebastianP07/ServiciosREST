package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    public static Connection connection;
    private static String user = "userDb";
    private static String password = "contraseñaBD";

    public Connection conectar() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://[IP]:[Port]/[name DB]", user, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error de conexion PostgreSQL" + e);
        }
        return connection;
    }

    public void desconectarse() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error al desconectar PostgreSQL " + e);
        }
    }
}