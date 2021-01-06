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
import modelos.Objetivo;

/**
 *
 * @author Manu
 */
public class ServicioObjetivo {
    private static Connection connection=null;
    
      public static void agregar(Objetivo objetivo) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into objetivos(descripcion_objetivo , id_derivacion) values (?,?)");
            preparedStatement.setString(1, objetivo.getDescripcion());
            preparedStatement.setInt(2, objetivo.getIdDerivacion());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     public static void actualizar(Objetivo objetivo) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update objetivos set descripcion_objetivo = ? , id_derivacion=? where id_objetivo = ?");
            preparedStatement.setString(1, objetivo.getDescripcion());
            preparedStatement.setInt(2, objetivo.getIdDerivacion());
            preparedStatement.setInt(3, objetivo.getIdObjetivo());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public static void eliminar(String id) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from objetivos where id_objetivo=?");
            // Parameters start with 1
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static List<Objetivo> listar(int idDerivacion) {
        List<Objetivo> list = new ArrayList<Objetivo>();
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from objetivos where id_derivacion=? ");
            preparedStatement.setInt(1, idDerivacion);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Objetivo obj = new Objetivo();
                obj.setIdObjetivo(rs.getInt("id_objetivo"));
                obj.setDescripcion(rs.getString("descripcion_objetivo"));
                obj.setIdDerivacion(rs.getInt("id_derivacion"));
                list.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
        
    public static Objetivo obtener(int id) {
        Objetivo obj = null;
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from objetivos where id_objetivo=? ");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()) {
                obj.setIdObjetivo(rs.getInt("id_objetivo"));
                obj.setDescripcion(rs.getString("descripcion_objetivo"));
                obj.setIdDerivacion(rs.getInt(" id_derivacion"));   
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return obj;
    }
    
    
}
