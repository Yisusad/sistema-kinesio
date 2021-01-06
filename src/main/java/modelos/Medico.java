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
public class Medico {
    int IdMedico;
    String Nombre, Apellido, Correo, Telefono;

    public int getIdMedico() {
        return IdMedico;
    }

    public void setIdMedico(int IdMedico) {
            this.IdMedico = IdMedico;
    }
    
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }
    
     public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
            this.Telefono = Telefono;
    }
    
    public String getCorreo() {
        return Correo;
    }
    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }
}
