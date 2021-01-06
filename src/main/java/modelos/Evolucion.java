/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.Date;

/**
 *
 * @author User
 */
public class Evolucion {
    int IdEvolucion;    
    Date FechaEvaluacion;
    int MontoEvaluacion;
    int Turno;
    int NroSesion;
    String Kinesioterapia;
    String Fisioterapia;
    String Kinefilaxia;
    int IdDerivacion;
    int IdAlumno;

    public Evolucion() {
    }

    public Evolucion(int IdEvolucion, Date FechaEvaluacion, int MontoEvaluacion, int Turno, int NroSesion, String Kinesioterapia, String Fisioterapia, String Kinefilaxia, int IdDerivacion, int IdAlumno) {
        this.IdEvolucion = IdEvolucion;
        this.FechaEvaluacion = FechaEvaluacion;
        this.MontoEvaluacion = MontoEvaluacion;
        this.Turno = Turno;
        this.NroSesion = NroSesion;
        this.Kinesioterapia = Kinesioterapia;
        this.Fisioterapia = Fisioterapia;
        this.Kinefilaxia = Kinefilaxia;
        this.IdDerivacion = IdDerivacion;
        this.IdAlumno = IdAlumno;
    }

    public Evolucion(Date FechaEvaluacion, int MontoEvaluacion, int Turno, int NroSesion, String Kinesioterapia, String Fisioterapia, String Kinefilaxia, int IdDerivacion, int IdAlumno) {
        this.FechaEvaluacion = FechaEvaluacion;
        this.MontoEvaluacion = MontoEvaluacion;
        this.Turno = Turno;
        this.NroSesion = NroSesion;
        this.Kinesioterapia = Kinesioterapia;
        this.Fisioterapia = Fisioterapia;
        this.Kinefilaxia = Kinefilaxia;
        this.IdDerivacion = IdDerivacion;
        this.IdAlumno = IdAlumno;
    }
    
    
    public int getIdEvolucion() {
        return IdEvolucion;
    }

    public void setIdEvolucion(int IdEvolucion) {
        this.IdEvolucion = IdEvolucion;
    }

    public Date getFechaEvaluacion() {
        return FechaEvaluacion;
    }

    public void setFechaEvaluacion(Date FechaEvaluacion) {
        this.FechaEvaluacion = FechaEvaluacion;
    }

    public int getMontoEvaluacion() {
        return MontoEvaluacion;
    }

    public void setMontoEvaluacion(int MontoEvaluacion) {
        this.MontoEvaluacion = MontoEvaluacion;
    }

    public int getTurno() {
        return Turno;
    }

    public void setTurno(int Turno) {
        this.Turno = Turno;
    }

    public int getNroSesion() {
        return NroSesion;
    }

    public void setNroSesion(int NroSesion) {
        this.NroSesion = NroSesion;
    }

    public String getKinesioterapia() {
        return Kinesioterapia;
    }

    public void setKinesioterapia(String Kinesioterapia) {
        this.Kinesioterapia = Kinesioterapia;
    }

    public String getFisioterapia() {
        return Fisioterapia;
    }

    public void setFisioterapia(String Fisioterapia) {
        this.Fisioterapia = Fisioterapia;
    }

    public String getKinefilaxia() {
        return Kinefilaxia;
    }

    public void setKinefilaxia(String Kinefilaxia) {
        this.Kinefilaxia = Kinefilaxia;
    }

    public int getIdDerivacion() {
        return IdDerivacion;
    }

    public void setIdDerivacion(int IdDerivacion) {
        this.IdDerivacion = IdDerivacion;
    }

    public int getIdAlumno() {
        return IdAlumno;
    }

    public void setIdAlumno(int IdAlumno) {
        this.IdAlumno = IdAlumno;
    }
    
    
    
}
