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

## Estructura 🔩
![ServiciosREST Estructura](https://github.com/SebastianP07/ServiciosREST/web/images/Estructura_proyecto.jpg)

## Más documentación 📖
* [Tutorial de Servicios REST con Java JAX-RS](https://www.oscarblancarteblog.com/api-rest-java-jax-rs/)


## Autor ✒️

* **Sebastian Pinto Becerra** - *Trabajo Inicial* - [SebastianP07](https://github.com/SebastianP07)
* **Sebastian Pinto Becerra** - *Documentación* -  [SebastianP07](https://github.com/SebastianP07)

También puedes mirar la lista de todos los [contribuyentes](https://github.com/SebastianP07/ServiciosREST/graphs/contributors) quíenes han participado en este proyecto. 


---
⌨️ por [SebastianP07](https://github.com/SebastianP07) ☕