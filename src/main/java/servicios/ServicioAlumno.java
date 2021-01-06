/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelos.Usuario;
import modelos.Alumno;

/**
 *
 * @author Jesús
 */
public class ServicioAlumno {
    private static Connection connection=null;
    
    public static void verificar(Alumno alumno) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement ps = connection.prepareStatement("select id_alumno from alumnos where id_alumno = ?");
            ps.setInt(1, alumno.getIdAlumno());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // encontrado
            {
                actualizar(alumno);
            } else {
                agregar(alumno);
            }
        } catch (Exception ex) {
            System.out.println("Error in check() -->" + ex.getMessage());
        } 
    }
    
    public static void agregar(Alumno alumno) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into alumnos(nombre_alumno, apellido_alumno, telefono_alumno, correo_alumno, id_usuario) values (?,?,?,?,?)");
            
            preparedStatement.setString(1, alumno.getNombre());
            preparedStatement.setString(2, alumno.getApellido());
            preparedStatement.setString(3, alumno.getTelefono());
            preparedStatement.setString(4, alumno.getCorreo());
            preparedStatement.setInt(5, alumno.getIdUsuario());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Alumno obtener(int id) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from alumnos where id_alumno = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // encontrado
            {
                Alumno alum = new Alumno();
                alum.setIdAlumno(id);
                alum.setNombre(rs.getString("nombre_alumno"));
                alum.setApellido(rs.getString("apellido_alumno"));
                alum.setTelefono(rs.getString("telefono_alumno"));
                alum.setCorreo(rs.getString("correo_alumno"));
                alum.setIdUsuario(rs.getInt("id_usuario"));
                return alum;
            }
            
        } catch (Exception ex) {
            System.out.println("Error in check() -->" + ex.getMessage());
        }
        return null;
    }
    
    public static Alumno obtenerFromUser(int id) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from alumnos where id_usuario = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // encontrado
            {
                Alumno alum = new Alumno();
                alum.setIdAlumno(rs.getInt("id_alumno"));
                alum.setNombre(rs.getString("nombre_alumno"));
                alum.setApellido(rs.getString("apellido_alumno"));
                alum.setTelefono(rs.getString("telefono_alumno"));
                alum.setCorreo(rs.getString("correo_alumno"));
                alum.setIdUsuario(rs.getInt("id_usuario"));
                return alum;
            }            
        } catch (Exception ex) {
            System.out.println("Error in check() -->" + ex.getMessage());
        }
        return null;
    }
    
    public static void actualizar(Alumno alumno) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update alumnos set nombre_alumno=?, apellido_alumno=?, telefono_alumno=?, correo_alumno=?, id_usuario=? "
                    + "where id_alumno=?");
            // Parametros  empiezan en  1
            preparedStatement.setString(1, alumno.getNombre());
            preparedStatement.setString(2, alumno.getApellido());
            preparedStatement.setString(3, alumno.getTelefono());
            preparedStatement.setString(4, alumno.getCorreo());
            preparedStatement.setInt(5, alumno.getIdUsuario());
            preparedStatement.setInt(6, alumno.getIdAlumno());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void eliminar(String id) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from alumnos where id_alumno=?");
            // Parameters start with 1
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static List<Alumno> listar() {
        List<Alumno> list = new ArrayList<Alumno>();
        try {
            connection = BasedeDatos.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select id_alumno, nombre_alumno, apellido_alumno, telefono_alumno, correo_alumno, nombre_usuario from alumnos a "
                    + " inner join usuarios u on u.id_usuario = a.id_usuario ");
            while (rs.next()) {
                Alumno obj = new Alumno();
                obj.setIdAlumno(rs.getInt("id_alumno"));
                obj.setNombre(rs.getString("nombre_alumno"));
                obj.setApellido(rs.getString("apellido_alumno"));  
                obj.setTelefono(rs.getString("telefono_alumno")); 
                obj.setCorreo(rs.getString("correo_alumno")); 
                obj.setNombreUsuario(rs.getString("nombre_usuario"));
                list.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
        
}
