/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelos.Ficha;


/**
 *
 * @author User
 */
public class ServicioFicha {
    private static Connection connection=null;
    
    public static void verificar(Ficha ficha) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement ps = connection.prepareStatement("select id_ficha from fichas where id_ficha = ?");
            ps.setInt(1, ficha.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // encontrado
            {
                actualizar(ficha);
            } else {
                agregar(ficha);
            }
        } catch (Exception ex) {
            System.out.println("Error in check() -->" + ex.getMessage());
        }
    }
    
    public static void agregar(Ficha ficha) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into fichas(nro_documento, nombre_paciente, apellido_paciente, fecha_ingreso, sexo, "
                    + "fecha_nacimiento, domicilio_paciente, telefono_paciente, correo_paciente, extranjero, id_ocupacion) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            preparedStatement.setInt(1, ficha.getNroDocumento());
            preparedStatement.setString(2, ficha.getNombre());
            preparedStatement.setString(3, ficha.getApellido());
            preparedStatement.setDate(4, new Date(ficha.getFechaIngreso().getTime()));
            preparedStatement.setString(5, ficha.getSexo());
            preparedStatement.setDate(6, new Date(ficha.getFechaNacimiento().getTime()));
            preparedStatement.setString(7, ficha.getDomicilio());
            preparedStatement.setString(8, ficha.getTelefono());
            preparedStatement.setString(9, ficha.getCorreo());
            preparedStatement.setString(10, ficha.getExtranjero());
            preparedStatement.setInt(11, ficha.getIdOcupacion());            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void actualizar(Ficha ficha) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update fichas set nro_documento=?,nombre_paciente=?,apellido_paciente=?, "
                    + "fecha_ingreso=?, sexo=?, fecha_nacimiento=?, domicilio_paciente=?, telefono_paciente=?, "
                    + " correo_paciente=?, extranjero=?, id_ocupacion=? where id_ficha=?");
            // Parametros  empiezan en  1           
            preparedStatement.setInt(1, ficha.getNroDocumento());
            preparedStatement.setString(2, ficha.getNombre());
            preparedStatement.setString(3, ficha.getApellido());
            preparedStatement.setDate(4, new Date(ficha.getFechaIngreso().getTime()));
            preparedStatement.setString(5, ficha.getSexo());
            preparedStatement.setDate(6, new Date(ficha.getFechaNacimiento().getTime()));
            preparedStatement.setString(7, ficha.getDomicilio());
            preparedStatement.setString(8, ficha.getTelefono());
            preparedStatement.setString(9, ficha.getCorreo());
            preparedStatement.setString(10, ficha.getExtranjero());
            preparedStatement.setInt(11, ficha.getIdOcupacion());   
            preparedStatement.setInt(12, ficha.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void eliminar(String id) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from fichas where id_ficha=?");
            // Parameters start with 1
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static List<Ficha> listar() {
        List<Ficha> list = new ArrayList<Ficha>();
        try {
            connection = BasedeDatos.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select *, TIMESTAMPDIFF(YEAR,fecha_nacimiento,CURDATE()) as Edad from fichas");
            while (rs.next()) {
                Ficha obj = new Ficha();
                obj.setId(rs.getInt("id_ficha"));
                obj.setNroDocumento(rs.getInt("nro_documento"));
                obj.setNombre(rs.getString("nombre_paciente"));
                obj.setApellido(rs.getString("apellido_paciente"));
                obj.setFechaIngreso(rs.getDate("fecha_ingreso"));
                obj.setEdad(rs.getInt("Edad"));
                obj.setSexo(rs.getString("sexo"));
                obj.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                obj.setDomicilio(rs.getString("domicilio_paciente"));
                obj.setTelefono(rs.getString("telefono_paciente"));
                obj.setCorreo(rs.getString("correo_paciente"));
                obj.setExtranjero(rs.getString("extranjero"));
                obj.setIdOcupacion(rs.getInt("id_ocupacion"));
                list.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    
    public static List<Ficha> listarExtranjero() {
        List<Ficha> list = new ArrayList<Ficha>();
        try {
            connection = BasedeDatos.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT FROM fichas WHERE extranjero == 'Si' ");
            //"SELECT * FROM fichas WHERE extranjero = Si "
            while (rs.next()) {
                Ficha obj = new Ficha();
                obj.setId(rs.getInt("id_ficha"));
                obj.setNroDocumento(rs.getInt("nro_documento"));
                obj.setNombre(rs.getString("nombre_paciente"));
                obj.setApellido(rs.getString("apellido_paciente"));
                obj.setFechaIngreso(rs.getDate("fecha_ingreso"));
                obj.setEdad(rs.getInt("Edad"));
                obj.setSexo(rs.getString("sexo"));
                obj.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                obj.setDomicilio(rs.getString("domicilio_paciente"));
                obj.setTelefono(rs.getString("telefono_paciente"));
                obj.setCorreo(rs.getString("correo_paciente"));
                obj.setExtranjero(rs.getString("extranjero"));
                obj.setIdOcupacion(rs.getInt("id_ocupacion"));
                list.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    
    public static Ficha obtener(String id) {
        Ficha obj = null;
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("Select *, TIMESTAMPDIFF(YEAR,fecha_nacimiento,CURDATE()) as Edad from fichas where id_ficha=? ");
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                obj = new Ficha();
                obj.setId(rs.getInt("id_ficha"));
                obj.setNroDocumento(rs.getInt("nro_documento"));
                obj.setNombre(rs.getString("nombre_paciente"));
                obj.setApellido(rs.getString("apellido_paciente"));
                obj.setFechaIngreso(rs.getDate("fecha_ingreso"));
                obj.setEdad(rs.getInt("Edad"));
                obj.setSexo(rs.getString("sexo"));
                obj.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                obj.setDomicilio(rs.getString("domicilio_paciente"));
                obj.setTelefono(rs.getString("telefono_paciente"));
                obj.setCorreo(rs.getString("correo_paciente"));
                obj.setExtranjero(rs.getString("extranjero"));
                obj.setIdOcupacion(rs.getInt("id_ocupacion"));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return obj;
    }
}
