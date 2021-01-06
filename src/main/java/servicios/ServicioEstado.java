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
import modelos.Estado;

/**
 *
 * @author Jesús
 */
public class ServicioEstado {
    private static Connection connection=null;
    
     public static void agregar(Estado estado) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into estados(descripcion_estado) values (?)");
            
            preparedStatement.setString(1, estado.getDescripcion());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void actualizar(Estado estado) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update estados set descripcion_estado=? where id_estado=?");
            
            preparedStatement.setString(1, estado.getDescripcion());
            preparedStatement.setInt(2, estado.getIdEstado());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    
    public static void eliminar(int id) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from estados where id_estado=?");
            // Parameters start with 1
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static List<Estado> listar() {
        List<Estado> list = new ArrayList<Estado>();
        try {
            connection = BasedeDatos.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from estados");
            while (rs.next()) {
                Estado obj = new Estado();
                obj.setIdEstado(rs.getInt("id_estado"));
                obj.setDescripcion(rs.getString("descripcion_estado"));
                list.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
        
    public static Estado obtener(int id) {
        Estado obj = null;
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from estados where id_estado=? ");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()) {
                obj = new Estado();
                obj.setIdEstado(rs.getInt("id_estado"));
                obj.setDescripcion(rs.getString("descripcion_estado"));   
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return obj;
    }
    
}
