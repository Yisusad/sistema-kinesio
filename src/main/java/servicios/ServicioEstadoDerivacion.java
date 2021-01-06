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
import modelos.Derivacion;
import modelos.Estado;
/**
 *
 * @author User
 */
public class ServicioEstadoDerivacion {
    private static Connection connection=null;
    
    public static void agregar(Estado estado, String desc_estado_deri, Derivacion deri) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into estados_derivaciones(Derivacion_id_derivacion, "
                    + "descripcion_estado_derivacion, Estados_id_estado) values (?,?,?)");            
            preparedStatement.setInt(1, deri.getIdDerivacion());
            preparedStatement.setString(2, desc_estado_deri);
            preparedStatement.setInt(3, estado.getIdEstado());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void eliminar(String id_estado, String id_deri) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from estados_derivaciones where Estados_id_estado=? and"
                    + " Derivacion_id_derivacion = ?");
            preparedStatement.setString(1, id_estado);
            preparedStatement.setString(2, id_deri);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
}
