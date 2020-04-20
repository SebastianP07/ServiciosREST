package DAO;

import Conexion.ConexionBD;
import DTO.Respuesta;
import DTO.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO {

    private ConexionBD cn = new ConexionBD();
    
    public Respuesta obtenerUsuario() {
        Respuesta rta = new Respuesta();
        ArrayList<Object> objetoRespuesta = new ArrayList<>();

        String consultaSql = "SELECT * FROM usuario;";
        try {
            PreparedStatement ps = cn.conectar().prepareStatement(consultaSql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setNombre(rs.getString("NOMBRE"));
                objetoRespuesta.add(usuario);
            }
            rta.setCodigo(1);
            rta.setDescripcion("Consulta Exitosa.");
            rta.setObjetoRespuesta(objetoRespuesta);
        } catch (SQLException e) {
            rta.setCodigo(0);
            rta.setDescripcion("Error obtenerUsuario: " + e);
        } finally {
            cn.desconectarse();
        }

        return rta;
    }

}
