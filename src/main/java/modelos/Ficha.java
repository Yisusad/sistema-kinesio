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
public class Ficha {
    int Id;
    int NroDocumento;
    String Nombre;
    String Apellido;
    Date FechaIngreso;
    int Edad;
    String Sexo;
    Date FechaNacimiento;
    String Domicilio;
    String Telefono;
    String Correo;
    String Extranjero;
    int IdOcupacion;

    public Ficha() {
    }
    
    
    public Ficha(int Id, int NroDocumento, String Nombre, String Apellido, Date FechaIngreso, String Sexo, Date FechaNacimiento, String Domicilio, String Telefono, String Correo,String Extranjero, int IdOcupacion) {
        this.Id = Id;
        this.NroDocumento = NroDocumento;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.FechaIngreso = FechaIngreso;
        this.Sexo = Sexo;
        this.FechaNacimiento = FechaNacimiento;
        this.Domicilio = Domicilio;
        this.Telefono = Telefono;
        this.Correo = Correo;
        this.Extranjero = Extranjero;
        this.IdOcupacion = IdOcupacion;
    }    
    
    public Ficha(int NroDocumento, String Nombre, String Apellido, Date FechaIngreso, String Sexo, Date FechaNacimiento, String Domicilio, String Telefono, String Correo,String Extranjero, int IdOcupacion) {
        this.NroDocumento = NroDocumento;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.FechaIngreso = FechaIngreso;
        this.Sexo = Sexo;
        this.FechaNacimiento = FechaNacimiento;
        this.Domicilio = Domicilio;
        this.Telefono = Telefono;
        this.Correo = Correo;
        this.Extranjero = Extranjero;
        this.IdOcupacion = IdOcupacion;
    }    
    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getNroDocumento() {
        return NroDocumento;
    }

    public void setNroDocumento(int NroDocumento) {
        this.NroDocumento = NroDocumento;
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

    public Date getFechaIngreso() {
        return FechaIngreso;
    }

    public void setFechaIngreso(Date FechaIngreso) {
        this.FechaIngreso = FechaIngreso;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(Date FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public String getDomicilio() {
        return Domicilio;
    }

    public void setDomicilio(String Domicilio) {
        this.Domicilio = Domicilio;
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
    
    public String getExtranjero() {
        return Extranjero;
    }

    public void setExtranjero(String Extranjero) {
        this.Extranjero = Extranjero;
    }

    public int getIdOcupacion() {
        return IdOcupacion;
    }

    public void setIdOcupacion(int IdOcupacion) {
        this.IdOcupacion = IdOcupacion;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }
    
    
}

