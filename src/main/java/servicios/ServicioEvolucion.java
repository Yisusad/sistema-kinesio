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
import modelos.Evolucion;
/**
 *
 * @author User
 */
public class ServicioEvolucion {
    private static Connection connection=null;
    
    public static void verificar(Evolucion evo) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement ps = connection.prepareStatement("select id_evolucion from evoluciones where id_evolucion = ?");
            ps.setInt(1, evo.getIdEvolucion());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // encontrado
            {
                actualizar(evo);
            } else {
                agregar(evo);
            }
        } catch (Exception ex) {
            System.out.println("Error in check() -->" + ex.getMessage());
        } 
    }
    
    public static void agregar(Evolucion evo) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into evoluciones(fecha_evaluacion, monto_evaluacion,"
                    + " turno, num_sesion, kinesioterapia, fisioterapia, kinefilaxia, "
                    + "id_derivacion, id_alumno) values (?,?,?,?,?,?,?,?,?)");
            
            preparedStatement.setDate(1, new java.sql.Date(evo.getFechaEvaluacion().getTime()));
            preparedStatement.setInt(2, evo.getMontoEvaluacion());
            preparedStatement.setInt(3, evo.getTurno());
            preparedStatement.setInt(4, evo.getNroSesion());
            preparedStatement.setString(5, evo.getKinesioterapia());
            preparedStatement.setString(6, evo.getFisioterapia());
            preparedStatement.setString(7, evo.getKinefilaxia());
            preparedStatement.setInt(8, evo.getIdDerivacion());
            preparedStatement.setInt(9, evo.getIdAlumno());
            preparedStatement.executeUpdate();
            
            PreparedStatement ps = connection.prepareStatement("select max(id_evolucion) from evoluciones ");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // encontrado
            {
                evo.setIdEvolucion(rs.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static Evolucion obtener(int id) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from evoluciones where id_evolucion = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // encontrado
            {
                Evolucion evo = new Evolucion();
                evo.setIdEvolucion(id);
                evo.setFechaEvaluacion(rs.getDate("fecha_evaluacion"));
                evo.setMontoEvaluacion(rs.getInt("monto_evaluacion"));
                evo.setTurno(rs.getInt("turno"));
                evo.setNroSesion(rs.getInt("num_sesion"));
                evo.setKinesioterapia(rs.getString("kinesioterapia"));
                evo.setFisioterapia(rs.getString("fisioterapia"));
                evo.setKinefilaxia(rs.getString("kinefilaxia"));
                evo.setIdDerivacion(rs.getInt("id_derivacion"));
                evo.setIdAlumno(rs.getInt("id_alumno"));
                return evo;
            }
            
        } catch (Exception ex) {
            System.out.println("Error in check() -->" + ex.getMessage());
        }
        return null;
    }
    
    public static void actualizar(Evolucion evo) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update evoluciones set fecha_evaluacion=?, "
                    + "monto_evaluacion=?, turno=?, num_sesion=?, kinesioterapia=?, "
                    + "fisioterapia=?, kinefilaxia=?, id_derivacion=?, id_alumno=? "
                    + "where id_evolucion=?");
            // Parametros  empiezan en  1
            preparedStatement.setDate(1, new java.sql.Date(evo.getFechaEvaluacion().getTime()));
            preparedStatement.setInt(2, evo.getMontoEvaluacion());
            preparedStatement.setInt(3, evo.getTurno());
            preparedStatement.setInt(4, evo.getNroSesion());
            preparedStatement.setString(5, evo.getKinesioterapia());
            preparedStatement.setString(6, evo.getFisioterapia());
            preparedStatement.setString(7, evo.getKinefilaxia());
            preparedStatement.setInt(8, evo.getIdDerivacion());
            preparedStatement.setInt(9, evo.getIdAlumno());
            preparedStatement.setInt(10, evo.getIdEvolucion());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void eliminar(String id) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from evoluciones where id_evolucion=?");
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
     public static List<Evolucion> listar(int idDerivacion) {
        List<Evolucion> list = new ArrayList<Evolucion>();
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from evoluciones where id_derivacion = ?");
            preparedStatement.setInt(1, idDerivacion);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Evolucion evo = new Evolucion();
                evo.setIdEvolucion(rs.getInt("id_evolucion"));
                evo.setFechaEvaluacion(rs.getDate("fecha_evaluacion"));
                evo.setMontoEvaluacion(rs.getInt("monto_evaluacion"));
                evo.setTurno(rs.getInt("turno"));
                evo.setNroSesion(rs.getInt("num_sesion"));
                evo.setKinesioterapia(rs.getString("kinesioterapia"));
                evo.setFisioterapia(rs.getString("fisioterapia"));
                evo.setKinefilaxia(rs.getString("kinefilaxia"));
                evo.setIdDerivacion(rs.getInt("id_derivacion"));
                evo.setIdAlumno(rs.getInt("id_alumno"));
                list.add(evo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    
}
