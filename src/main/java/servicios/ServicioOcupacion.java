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
import modelos.Ocupacion;

/**
 *
 * @author Jesús
 */
public class ServicioOcupacion {
     private static Connection connection=null;
    
     public static void agregar(Ocupacion ocupacion) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into ocupaciones(descripcion_ocupacion) values (?)");
            
            preparedStatement.setString(1, ocupacion.getDescripcion());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     
      public static void actualizar(Ocupacion ocupacion) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update ocupaciones set descripcion_ocupacion=? where id_ocupacion=?");
            
            preparedStatement.setString(1, ocupacion.getDescripcion());
            preparedStatement.setInt(2, ocupacion.getIdOcupacion());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public static void eliminar(String id) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from ocupaciones where id_ocupacion=?");
            // Parameters start with 1
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static List<Ocupacion> listar() {
        List<Ocupacion> list = new ArrayList<Ocupacion>();
        try {
            connection = BasedeDatos.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from ocupaciones");
            while (rs.next()) {
                Ocupacion obj = new Ocupacion();
                obj.setIdOcupacion(rs.getInt("id_ocupacion"));
                obj.setDescripcion(rs.getString("descripcion_ocupacion"));
                list.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
        
    public static Ocupacion obtener(String id) {
        Ocupacion obj = null;
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from ocupaciones where id_ocupacion=? ");
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()) {
                obj = new Ocupacion();
                obj.setIdOcupacion(rs.getInt("id_ocupacion"));
                obj.setDescripcion(rs.getString("descripcion_ocupacion"));   
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return obj;
    }
    
}
