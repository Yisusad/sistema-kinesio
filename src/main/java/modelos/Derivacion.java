/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author Fabi Garcia
 */
public class Derivacion {
    int idDerivacion;
    String abona;
    String diagMed;
    String diagKine;
    int numSesiones;
    String motivo;
    int idPato;
    int idMed;
    int idAlum;
    int idFicha;
    Ficha Ficha;
    Patologia Patologia;
    Alumno Alumno;
    String Antecedente;
    int Monto;
    public int getIdDerivacion() {
        return idDerivacion;
    }

    public void setIdDerivacion(int idDerivacion) {
        this.idDerivacion = idDerivacion;
    }

    public String getAbona() {
        return abona;
    }

    public void setAbona(String abona) {
        this.abona = abona;
    }

    public String getDiagMed() {
        return diagMed;
    }

    public void setDiagMed(String diagMed) {
        this.diagMed = diagMed;
    }

    public String getDiagKine() {
        return diagKine;
    }

    public void setDiagKine(String diagKine) {
        this.diagKine = diagKine;
    }

    public int getNumSesiones() {
        return numSesiones;
    }

    public void setNumSesiones(int numSesiones) {
        this.numSesiones = numSesiones;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public int getIdPato() {
        return idPato;
    }

    public void setIdPato(int idPato) {
        this.idPato = idPato;
    }

    public int getIdMed() {
        return idMed;
    }

    public void setIdMed(int idMed) {
        this.idMed = idMed;
    }

    public int getIdAlum() {
        return idAlum;
    }

    public void setIdAlum(int idAlum) {
        this.idAlum = idAlum;
    }

    public int getIdFicha() {
        return idFicha;
    }

    public void setIdFicha(int idFicha) {
        this.idFicha = idFicha;
    }

    public Ficha getFicha() {
        return Ficha;
    }

    public void setFicha(Ficha Ficha) {
        this.Ficha = Ficha;
    }

    public Patologia getPatologia() {
        return Patologia;
    }

    public void setPatologia(Patologia Patologia) {
        this.Patologia = Patologia;
    }

    public Alumno getAlumno() {
        return Alumno;
    }

    public void setAlumno(Alumno Alumno) {
        this.Alumno = Alumno;
    }

    public String getAntecedente() {
        return Antecedente;
    }

    public void setAntecedente(String Antecedente) {
        this.Antecedente = Antecedente;
    }

    public int getMonto() {
        return Monto;
    }

    public void setMonto(int Monto) {
        this.Monto = Monto;
    }
    
    
}
