/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author pc
 */
public class Usuario {
    int IdUsuario;
    String NombreUsuario;
    String Rol;
    String Clave;
    int Estado;
    Alumno Alumno;

    public Usuario(String NombreUsuario, String Rol, String Clave, int Estado) {
        this.NombreUsuario = NombreUsuario;
        this.Rol = Rol;
        this.Clave = Clave;
        this.Estado = Estado;
    }

    public Usuario(int IdUsuario, String NombreUsuario, String Rol, String Clave) {
        this.IdUsuario = IdUsuario;
        this.NombreUsuario = NombreUsuario;
        this.Rol = Rol;
        this.Clave = Clave;
    }    
    
    public Usuario() {
    }    


    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.IdUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.NombreUsuario = nombreUsuario;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String rol) {
        this.Rol = rol;
    }

    public String getClaveUsuario() {
        return Clave;
    }

    public void setClaveUsuario(String claveUsuario) {
        this.Clave = claveUsuario;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int estado) {
        this.Estado = estado;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }

    public Alumno getAlumno() {
        return Alumno;
    }

    public void setAlumno(Alumno Alumno) {
        this.Alumno = Alumno;
    }
    
}
