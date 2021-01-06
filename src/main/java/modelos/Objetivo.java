/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author Manu
 */
public class Objetivo {
    int IdObjetivo;
    int IdDerivacion;
    String Descripcion;

    public int getIdObjetivo() {
        return IdObjetivo;
    }

    public void setIdObjetivo(int IdObjetivo) {
        this.IdObjetivo = IdObjetivo;
    }

    public int getIdDerivacion() {
        return IdDerivacion;
    }

    public void setIdDerivacion(int IdDerivacion) {
        this.IdDerivacion = IdDerivacion;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
}
