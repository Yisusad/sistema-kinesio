package servicios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelos.Estudio;

/**
 *
 * @author Jesús
 */
public class ServicioEstudio {
    private static Connection connection=null;
    
     public static void agregar(Estudio estudio) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into estudios(descripcion_estudio) values (?)");
            preparedStatement.setString(1, estudio.getDescripcion());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     public static void actualizar(Estudio estudio) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update estudios set descripcion_estudio = ? where id_estudio = ?");
            preparedStatement.setString(1, estudio.getDescripcion());
            preparedStatement.setInt(2, estudio.getIdEstudio());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public static void eliminar(String id) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from estudios where id_estudio=?");
            // Parameters start with 1
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static List<Estudio> listar() {
        List<Estudio> list = new ArrayList<Estudio>();
        try {
            connection = BasedeDatos.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from estudios ");
            while (rs.next()) {
                Estudio obj = new Estudio();
                obj.setIdEstudio(rs.getInt("id_estudio"));
                obj.setDescripcion(rs.getString("descripcion_estudio"));
                list.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
        
    public static Estudio obtener(int id) {
        Estudio obj = null;
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from estudios where id_estudio=? ");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()) {
                obj = new Estudio();
                obj.setIdEstudio(rs.getInt("id_estudio"));
                obj.setDescripcion(rs.getString("descripcion_estudio"));   
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return obj;
    }
}
