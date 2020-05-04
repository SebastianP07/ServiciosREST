# ServiciosREST

Ejemplo de implementación de servicios REST en java con JAX-RS.

## URL Consumo de servicios ⚙️

### POST 
_HTTP/1.1_
* **URL:** /ServiciosREST/app/restServices/pruebaPOST
* **Host:** localhost:8080
* **Content-Type:** application/json
* **body:** {"nombre":"Sebastian"}

### GET
_HTTP/1.1_
* **URL:** /ServiciosREST/app/restServices/pruebaGET
* **Host:** localhost:8080

## Paso a paso 🔧

* Crear proyecto Java WEB.

* Agregar las librarías de:

``` bash

- JAX-RS 2.0

- Jersey 2.5.1 (JAX-RS RI)

```

* Se crean las clases para configuración y servicios.

#### Configuración:
``` java

package XXXX;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("XXXXXX")
public class RestConf extends Application {

}

```



#### Servicios

``` java

package REST;

import DTO.Respuesta;
import DTO.Usuario;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

Path("XXXXXXXXXX")
public class RestServices {

    @POST
    @Path("pruebaPOST")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Respuesta pruebaPOST(Usuario usuario) {
        Respuesta rta = new Respuesta();
        rta.setDescripcion("Prueba POST OK. nombre: " + usuario.getNombre());
        return rta;
    }

    @GET
    @Path("pruebaGET")
    @Produces({MediaType.APPLICATION_JSON})
    public String pruebaGET() {
        return "Prueba GET OK.";
    }
}

```

* Se deben crear para el servicio POST dos DTO para el manejo de Consumes y Produces

``` java
package DTO;
public class Respuesta {

    private int codigo;
    private String descripcion;

    /**
    * @return the codigo
    */
    public int getCodigo() {
        return codigo;
    }

    /**
    * @param codigo the codigo to set
    */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
    * @return the descripcion
    */
    public String getDescripcion() {
        return descripcion;
    }

    /**
    * @param descripcion the descripcion to set
    */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

package DTO;

public class Usuario {
    private String nombre;

    /**
    * @return the nombre
    */
    public String getNombre() {
        return nombre;
    }

    /**
    * @param nombre the nombre to set
    */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
```
# Persistencia a BD PostgreSQL con JDBC

* Agregar la libreria

``` bash

- PostgreSQL JDBC Driver

```

* Crear la clase para la conexión a la BD

### Ejemplo
``` java

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

```

* Se crea la Interface para el manejo de metodos dentro de la clase para el DAO

### Ejemplo
``` java

package Interface;

import DTO.Respuesta;

public interface interfaceUser {

    public abstract Respuesta getUsers();
}

```

* Se crea la clase para la implementacion de la conexion JDBC

### Ejemplo
``` java

package DAO;

import Conexion.ConexionBD;
import DTO.Respuesta;
import DTO.Usuario;
import Interface.interfaceUser;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO implements interfaceUser {

    private ConexionBD cn = new ConexionBD();
    
    @Override
    public Respuesta getUsers() {
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


```


## Estructura 🔩
![ScreenShot](https://raw.githubusercontent.com/SebastianP07/ServiciosREST/master/web/images/Estructura_proyecto.jpg)

## Más documentación 📖
* [Tutorial de Servicios REST con Java JAX-RS](https://www.oscarblancarteblog.com/api-rest-java-jax-rs/)

## Autor ✒️

* **Sebastian Pinto Becerra** - *Trabajo Inicial* - [SebastianP07](https://github.com/SebastianP07)
* **Sebastian Pinto Becerra** - *Documentación* -  [SebastianP07](https://github.com/SebastianP07)

También puedes mirar la lista de todos los [contribuyentes](https://github.com/SebastianP07/ServiciosREST/graphs/contributors) quíenes han participado en este proyecto. 


---
⌨️ por [SebastianP07](https://github.com/SebastianP07) ☕
