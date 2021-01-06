/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author Jesús
 */
public class EstadoDerivacion {
    int IdEstado;
    int IdDerivacion;
    String Descripcion;
    String DescripcionEstado;

    public int getIdEstado() {
        return IdEstado;
    }

    public void setIdEstado(int IdEstado) {
        this.IdEstado = IdEstado;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getIdDerivacion() {
        return IdDerivacion;
    }

    public void setIdDerivacion(int IdDerivacion) {
        this.IdDerivacion = IdDerivacion;
    }

    public String getDescripcionEstado() {
        return DescripcionEstado;
    }

    public void setDescripcionEstado(String DescripcionEstado) {
        this.DescripcionEstado = DescripcionEstado;
    }
    
}
