package servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelos.Medico;
import modelos.Patologia;


/**
 *
 * @author Manu
 * obtener
 * guardar
 * actualizar
 * eliminar
 * listar
 */
public class ServicioMedico {
 private static Connection connection=null;
    
      public static Medico obtener(String id) {
        Medico obj = null;
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from medicos where id_medico=? ");
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                obj = new Medico();
                obj.setIdMedico(rs.getInt("id_medico"));
                obj.setNombre(rs.getString("nombre_medico"));
                obj.setApellido(rs.getString("apellido_medico"));
                obj.setTelefono(rs.getString("telefono_medico"));
                obj.setCorreo(rs.getString("correo_medico"));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return obj;
    }


    public static void agregar(Medico medico) {
        //verificar
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into medicos(nombre_medico, apellido_medico, telefono_medico, correo_medico) values (?,?,?, ?)");

            preparedStatement.setString(1, medico.getNombre());
            preparedStatement.setString(2, medico.getApellido());
            preparedStatement.setString(3,medico.getTelefono());
            preparedStatement.setString(4, medico.getCorreo());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void actualizar(Medico medico) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update medicos set nombre_medico=?,apellido_medico=?,telefono_medico=?,correo_medico=? "
                    + "where id_medico=?");
            // Parametros  empiezan en  1
            preparedStatement.setString(1, medico.getNombre());
            preparedStatement.setString(2, medico.getApellido());
            preparedStatement.setString(3, medico.getTelefono());
            preparedStatement.setString(4, medico.getCorreo());
            preparedStatement.setInt(5, medico.getIdMedico());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
     
    }
        public static void eliminar(String id) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from medicos where id_medico=?");
            // Parameters start with 1
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }     
    } 
      
      public static List<Medico> listar() {
        List<Medico> list = new ArrayList<Medico>();
        try {
            connection = BasedeDatos.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from medicos");
            while (rs.next()) {
                Medico obj = new Medico();
                obj.setIdMedico(rs.getInt("id_medico"));
                obj.setNombre(rs.getString("nombre_medico"));
                obj.setApellido(rs.getString("apellido_medico"));
                obj.setTelefono(rs.getString("telefono_medico"));
                obj.setCorreo(rs.getString("correo_medico"));
                list.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
      public static Medico obtener(int id) {
        Medico obj = null;
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from medicos where id_medico=? ");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()) {
                obj = new Medico();
                obj.setIdMedico(rs.getInt("id_medico"));
                obj.setNombre(rs.getString("nombre_medico"));
                obj.setApellido(rs.getString("apellido_medico"));
                obj.setTelefono(rs.getString("telefono_medico"));
                obj.setCorreo(rs.getString("correo_medico"));  
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return obj;
    }


}

