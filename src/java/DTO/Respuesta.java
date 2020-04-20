package DTO;

import java.util.ArrayList;

public class Respuesta {
    
    private int codigo;
    private String descripcion;
    private ArrayList<Object> objetoRespuesta;

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

    /**
     * @return the objetoRespuesta
     */
    public ArrayList<Object> getObjetoRespuesta() {
        return objetoRespuesta;
    }

    /**
     * @param objetoRespuesta the objetoRespuesta to set
     */
    public void setObjetoRespuesta(ArrayList<Object> objetoRespuesta) {
        this.objetoRespuesta = objetoRespuesta;
    }
}
