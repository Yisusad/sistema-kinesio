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
import modelos.Patologia;
/**
 *
 * @author Jesús
 */
public class ServicioPatologia {
    private static Connection connection=null;
    
     
    public static void agregar(Patologia patologia) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into patologias(descripcion_patologia) values (?)");
            
            preparedStatement.setString(1, patologia.getDescripcion());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
     public static void actualizar(Patologia patologia) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update patologias set descripcion_patologia = ? where id_patologia = ?");
            preparedStatement.setString(1, patologia.getDescripcion());
            preparedStatement.setInt(2, patologia.getIdPatologia());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public static void eliminar(String id) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from patologias where id_patologia=?");
            // Parameters start with 1
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static List<Patologia> listar() {
        List<Patologia> list = new ArrayList<Patologia>();
        try {
            connection = BasedeDatos.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from patologias");
            while (rs.next()) {
                Patologia obj = new Patologia();
                obj.setIdPatologia(rs.getInt("id_patologia"));
                obj.setDescripcion(rs.getString("descripcion_patologia"));
                list.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
        
    public static Patologia obtener(int id) {
        Patologia obj = null;
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from patologias where id_patologia=? ");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()) {
                obj = new Patologia();
                obj.setIdPatologia(rs.getInt("id_patologia"));
                obj.setDescripcion(rs.getString("descripcion_patologia"));   
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return obj;
    }
}
