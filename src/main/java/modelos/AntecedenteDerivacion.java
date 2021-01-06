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
public class AntecedenteDerivacion {
    
    int IdAntecedente;
    String Descripcion;
    int IdDerivacion;
    public int getIdAntecedente() {
        return IdAntecedente;
    }

    public void setIdAntecedente(int IdAntecedente) {
        this.IdAntecedente = IdAntecedente;
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
    
}
