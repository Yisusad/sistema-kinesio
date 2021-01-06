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

/**
 *
 * @author Usuario
 */
public class ServicioUsuario {

    private static Connection connection = null;

    public ServicioUsuario() {

    }

    public static void verificar(Usuario usuario) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement ps = connection.prepareStatement("select id_usuario from usuarios where id_usuario = ?");
            ps.setInt(1, usuario.getIdUsuario());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // encontrado
            {
                actualizar(usuario);
            } else {
                agregar(usuario);
            }
        } catch (Exception ex) {
            System.out.println("Error in check() -->" + ex.getMessage());
        }
    }

    public static Usuario login(String nombre, String clave) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement ps = connection.prepareStatement("select id_usuario, nombre_usuario, rol, estado_usuario from usuarios "
                    + " where estado_usuario = 0 and nombre_usuario = ? and clave_usuario = ?");
            ps.setString(1, nombre);
            ps.setString(2, clave);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // encontrado
            {
                Usuario usu = new Usuario();
                usu.setIdUsuario(rs.getInt("id_usuario"));
                usu.setNombreUsuario(rs.getString("nombre_usuario"));
                usu.setRol(rs.getString("rol"));
                usu.setEstado(rs.getInt("estado_usuario"));
                usu.setAlumno(ServicioAlumno.obtenerFromUser(usu.getIdUsuario()));
                return usu;
            }
        } catch (Exception ex) {
            System.out.println("Error in check() -->" + ex.getMessage());
        }
        return null;
    }

    public static void agregar(Usuario usuario) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into usuarios(nombre_usuario, rol, clave_usuario, estado_usuario) values (?,?,?, ?)");

            preparedStatement.setString(1, usuario.getNombreUsuario());
            preparedStatement.setString(2, usuario.getRol());
            preparedStatement.setString(3, usuario.getClaveUsuario());
            preparedStatement.setInt(4, usuario.getEstado());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void eliminar(String id) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from usuarios where id_usuario=?");
            // Parameters start with 1
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void actualizar(Usuario usuario) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update usuarios set nombre_usuario=?,rol=? "
                    + "where id_usuario=?");
            // Parametros  empiezan en  1
            preparedStatement.setString(1, usuario.getNombreUsuario());
            preparedStatement.setString(2, usuario.getRol());
            preparedStatement.setInt(3, usuario.getIdUsuario());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void cambiarClave(int id, String oldpass, String newpass) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update usuarios set clave_usuario=? "
                    + "where id_usuario=? and clave_usuario=?");
            // Parametros  empiezan en  1
            preparedStatement.setString(1, newpass);
            preparedStatement.setInt(2, id);
            preparedStatement.setString(3, oldpass);
           
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Usuario> listar() {
        List<Usuario> list = new ArrayList<Usuario>();
        try {
            connection = BasedeDatos.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from usuarios");
            while (rs.next()) {
                Usuario obj = new Usuario();
                obj.setIdUsuario(rs.getInt("id_usuario"));
                obj.setRol(rs.getString("rol"));
                obj.setNombreUsuario(rs.getString("nombre_usuario"));
                obj.setEstado(rs.getInt("estado_usuario"));
                list.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static Usuario obtener(String id) {
        Usuario obj = null;
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from usuarios where id_usuario=? ");
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                obj = new Usuario();
                obj.setIdUsuario(rs.getInt("id_usuario"));
                obj.setRol(rs.getString("rol"));
                obj.setClave(rs.getString("clave_usuario"));
                obj.setNombreUsuario(rs.getString("nombre_usuario"));
                obj.setEstado(rs.getInt("estado_usuario"));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return obj;
    }

}
