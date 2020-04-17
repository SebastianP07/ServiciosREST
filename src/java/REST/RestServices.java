package REST;

import DTO.Respuesta;
import DTO.Usuario;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("restServices")
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
