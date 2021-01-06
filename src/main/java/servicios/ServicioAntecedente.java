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
import modelos.Antecedente;

/**
 *
 * @author Jesús
 */
public class ServicioAntecedente {
    private static Connection connection=null;
    
     public static void agregar(Antecedente antecedente) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into antecedentes(descripcion_antecedente) values (?)");
            preparedStatement.setString(1, antecedente.getDescripcion());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     public static void actualizar(Antecedente antecedente) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update antecedentes set descripcion_antecedente = ? where id_antecedente = ?");
            preparedStatement.setString(1, antecedente.getDescripcion());
            preparedStatement.setInt(2, antecedente.getIdAntecedente());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public static void eliminar(String id) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from antecedentes where id_antecedente=?");
            // Parameters start with 1
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static List<Antecedente> listar() {
        List<Antecedente> list = new ArrayList<Antecedente>();
        try {
            connection = BasedeDatos.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from antecedentes ");
            while (rs.next()) {
                Antecedente obj = new Antecedente();
                obj.setIdAntecedente(rs.getInt("id_antecedente"));
                obj.setDescripcion(rs.getString("descripcion_antecedente"));
                list.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
        
    public static Antecedente obtener(int id) {
        Antecedente obj = null;
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from antecedentes where id_antecedente=? ");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()) {
                obj = new Antecedente();
                obj.setIdAntecedente(rs.getInt("id_antecedente"));
                obj.setDescripcion(rs.getString("descripcion_antecedente"));   
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return obj;
    }
}
