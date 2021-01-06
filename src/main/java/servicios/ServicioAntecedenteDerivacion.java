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
import modelos.Antecedente;

/**
 *
 * @author User
 */
public class ServicioAntecedenteDerivacion {
    private static Connection connection=null;
    
    public static void agregar(Antecedente ant, Derivacion deri) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into antecedentes_derivaciones(Antecedente_id_antecedente, "
                    + "Derivacion_id_derivacion) values (?,?)");            
            preparedStatement.setInt(1, ant.getIdAntecedente());
            preparedStatement.setInt(2, deri.getIdDerivacion());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void eliminar(String id_ant, String id_deri) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from antedecentes_derivacion where Antecedentes_id_antecedente=? and"
                    + " Derivacion_id_derivacion = ?");
            preparedStatement.setString(1, id_ant);
            preparedStatement.setString(2, id_deri);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }    
}
