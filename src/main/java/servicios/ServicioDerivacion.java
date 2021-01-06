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
import java.util.Date;
import java.util.List;
import modelos.Alumno;
import modelos.AntecedenteDerivacion;
import modelos.Derivacion;
import modelos.Estado;
import modelos.EstadoDerivacion;
import modelos.EstudioDerivacion;
import modelos.Ficha;
import modelos.Patologia;

/**
 *
 * @author Fabi Garcia
 */
public class ServicioDerivacion {
    private static Connection connection=null;
    
    public static void verificar(Derivacion deri) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement ps = connection.prepareStatement("select id_derivacion from derivaciones where id_derivacion = ?");
            ps.setInt(1, deri.getIdDerivacion());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // encontrado
            {
                actualizar(deri);
            } else {
                agregar(deri);
            }
        } catch (Exception ex) {
            System.out.println("Error in check() -->" + ex.getMessage());
        } 
    }
    
    public static int agregar(Derivacion deri) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into derivaciones(abona, diagnostico_medico, diagnostico_kinesico, numero_sesiones, motivo_noabona, id_patologia, id_medico, id_alumno, id_ficha, antecedente, monto_abonado) values (?,?,?,?,?,?,?,?,?,?,?)");
            
            preparedStatement.setString(1, deri.getAbona());
            preparedStatement.setString(2, deri.getDiagMed());
            preparedStatement.setString(3, deri.getDiagKine());
            preparedStatement.setInt(4, deri.getNumSesiones());
            preparedStatement.setString(5, deri.getMotivo());
            preparedStatement.setInt(6, deri.getIdPato());
            preparedStatement.setInt(7, deri.getIdMed());
            preparedStatement.setInt(8, deri.getIdAlum());
            preparedStatement.setInt(9, deri.getIdFicha());
            preparedStatement.setString(10, deri.getAntecedente());
            preparedStatement.setInt(11, deri.getMonto());
            preparedStatement.executeUpdate();
            PreparedStatement ps = connection.prepareStatement("select max(id_derivacion) from derivaciones ");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // encontrado
            {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public static Derivacion obtener(int id) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from derivaciones where id_derivacion = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // encontrado
            {
                Derivacion deri = new Derivacion();
                deri.setIdDerivacion(id);
                deri.setAbona(rs.getString("abona"));
                deri.setDiagMed(rs.getString("diagnostico_medico"));
                deri.setDiagKine(rs.getString("diagnostico_kinesico"));
                deri.setNumSesiones(rs.getInt("numero_sesiones"));
                deri.setMotivo(rs.getString("motivo_noabona"));
                deri.setIdPato(rs.getInt("id_patologia"));
                deri.setIdMed(rs.getInt("id_medico"));
                deri.setIdAlum(rs.getInt("id_alumno"));
                deri.setIdFicha(rs.getInt("id_ficha"));
                deri.setAntecedente(rs.getString("antecedente"));
                deri.setMonto(rs.getInt("monto_abonado"));
                return deri;
            }
            
        } catch (Exception ex) {
            System.out.println("Error in check() -->" + ex.getMessage());
        }
        return null;
    }
    
    public static void actualizar(Derivacion deri) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update derivaciones set abona=?, diagnostico_medico=?, diagnostico_kinesico=?, numero_sesiones=?, motivo_noabona=?, id_patologia=?, id_medico=?, id_alumno=?, id_ficha=?, antecedente = ?, monto_abonado = ? "
                    + "where id_derivacion=?");
            // Parametros  empiezan en  1
            preparedStatement.setString(1, deri.getAbona());
            preparedStatement.setString(2, deri.getDiagMed());
            preparedStatement.setString(3, deri.getDiagKine());
            preparedStatement.setInt(4, deri.getNumSesiones());
            preparedStatement.setString(5, deri.getMotivo());
            preparedStatement.setInt(6, deri.getIdPato());
            preparedStatement.setInt(7, deri.getIdMed());
            preparedStatement.setInt(8, deri.getIdAlum());
            preparedStatement.setInt(9, deri.getIdFicha());
            preparedStatement.setString(10, deri.getAntecedente());
            preparedStatement.setInt(11, deri.getMonto());
            preparedStatement.setInt(12, deri.getIdDerivacion());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void eliminar(String id) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from derivaciones where id_derivacion=?");
            // Parameters start with 1
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static List<Derivacion> listar() {
        List<Derivacion> list = new ArrayList<Derivacion>();
        try {
            connection = BasedeDatos.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from derivaciones");
            while (rs.next()) {
                Derivacion obj = new Derivacion();
                obj.setIdDerivacion(rs.getInt("id_derivacion"));
                obj.setAbona(rs.getString("abona"));
                obj.setDiagMed(rs.getString("diagnostico_medico"));
                obj.setDiagKine(rs.getString("diagnostico_kinesico"));
                obj.setNumSesiones(rs.getInt("numero_sesiones"));
                obj.setMotivo(rs.getString("motivo_noabona"));
                obj.setIdPato(rs.getInt("id_patologia"));
                obj.setIdMed(rs.getInt("id_medico"));
                obj.setIdAlum(rs.getInt("id_alumno"));
                obj.setIdFicha(rs.getInt("id_ficha"));
                obj.setAntecedente(rs.getString("antecedente"));
                obj.setMonto(rs.getInt("monto_abonado"));
                list.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    public static List<Derivacion> listarTodos() {
        List<Derivacion> list = new ArrayList<Derivacion>();
        try {
            connection = BasedeDatos.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from derivaciones d inner join fichas f on f.id_ficha = d.id_ficha "
                    + " inner join patologias p on p.id_patologia = d.id_patologia "
                    + " inner join alumnos a on a.id_alumno = d.id_alumno ");
            while (rs.next()) {
                Derivacion obj = new Derivacion();
                obj.setIdDerivacion(rs.getInt("id_derivacion"));
                obj.setAbona(rs.getString("abona"));
                obj.setDiagMed(rs.getString("diagnostico_medico"));
                obj.setDiagKine(rs.getString("diagnostico_kinesico"));
                obj.setNumSesiones(rs.getInt("numero_sesiones"));
                obj.setMotivo(rs.getString("motivo_noabona"));
                obj.setIdPato(rs.getInt("id_patologia"));
                obj.setIdMed(rs.getInt("id_medico"));
                obj.setIdAlum(rs.getInt("id_alumno"));
                obj.setIdFicha(rs.getInt("id_ficha"));
                Ficha f = new Ficha();
                f.setId(obj.getIdFicha());
                f.setNombre(rs.getString("nombre_paciente"));
                f.setApellido(rs.getString("apellido_paciente"));
                Patologia p = new Patologia();
                p.setIdPatologia(obj.getIdPato());
                p.setDescripcion(rs.getString("descripcion_patologia"));
                obj.setFicha(f);
                obj.setPatologia(p);
                
                
                Alumno a = new Alumno();
                a.setIdAlumno(obj.getIdAlum());
                a.setNombre(rs.getString("nombre_alumno"));
                a.setApellido(rs.getString("apellido_alumno"));
                obj.setAlumno(a);
                obj.setAntecedente(rs.getString("antecedente"));
                obj.setMonto(rs.getInt("monto_abonado"));
                list.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    
    public static List<AntecedenteDerivacion> listarAntecedentes(int idDerivacion) {
        List<AntecedenteDerivacion> list = new ArrayList<AntecedenteDerivacion>();
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from antecedentes_derivaciones ad "
                    + "inner join antecedentes a on a.id_antecedente = ad.id_antecedente where id_derivacion=? ");
            preparedStatement.setInt(1, idDerivacion);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                AntecedenteDerivacion obj = new AntecedenteDerivacion();
                obj.setIdAntecedente(rs.getInt("id_antecedente"));
                obj.setIdDerivacion(rs.getInt("id_derivacion"));
                obj.setDescripcion(rs.getString("descripcion_antecedente"));
                list.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    public static void agregarAntecedente(AntecedenteDerivacion antecedente) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into antecedentes_derivaciones(id_antecedente,id_derivacion) values (?,?)");
            preparedStatement.setInt(1, antecedente.getIdAntecedente());
            preparedStatement.setInt(2, antecedente.getIdDerivacion());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void eliminarAntecedente(int idAntecedente, int idDerivacion) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from antecedentes_derivaciones where id_antecedente=? and id_derivacion = ?");
            preparedStatement.setInt(1, idAntecedente);
            preparedStatement.setInt(2, idDerivacion);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static List<EstadoDerivacion> listarEstados(int idDerivacion) {
        List<EstadoDerivacion> list = new ArrayList<EstadoDerivacion>();
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from estados_derivaciones ed "
                    + " inner join estados e on e.id_estado = ed.id_estado where id_derivacion=? ");
            preparedStatement.setInt(1, idDerivacion);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                EstadoDerivacion obj = new EstadoDerivacion();
                obj.setIdEstado(rs.getInt("id_estado"));
                obj.setIdDerivacion(rs.getInt("id_derivacion"));
                obj.setDescripcion(rs.getString("descripcion_estado"));
                obj.setDescripcionEstado(rs.getString("descripcion_estado_derivacion"));
                list.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    public static void agregarEstado(EstadoDerivacion estado) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into estados_derivaciones(id_estado,id_derivacion,descripcion_estado_derivacion) values (?,?,?)");
            preparedStatement.setInt(1, estado.getIdEstado());
            preparedStatement.setInt(2, estado.getIdDerivacion());
            preparedStatement.setString(3, estado.getDescripcion());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void eliminarEstados(int idEstado, int idDerivacion) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from estados_derivaciones where id_estado=? and id_derivacion = ?");
            // Parameters start with 1
            preparedStatement.setInt(1, idEstado);
            preparedStatement.setInt(2, idDerivacion);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public static List<EstudioDerivacion> listarEstudios(int idDerivacion) {
        List<EstudioDerivacion> list = new ArrayList<EstudioDerivacion>();
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from estudios_derivaciones ed "
                    + " inner join estudios e on e.id_estudio = ed.id_estudio where id_derivacion=? ");
            preparedStatement.setInt(1, idDerivacion);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                EstudioDerivacion obj = new EstudioDerivacion();
                obj.setIdEstudio(rs.getInt("id_estudio"));
                obj.setIdDerivacion(rs.getInt("id_derivacion"));
                obj.setDescripcion(rs.getString("descripcion_estudio"));
                obj.setResultado(rs.getString("resultado_estudio"));
                obj.setFecha(new Date(rs.getDate("fecha_estudio").getTime()));
                list.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    public static void agregarEstudio(EstudioDerivacion estado) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into Estudios_derivaciones(id_Estudio,id_derivacion,fecha_estudio,resultado_estudio) values (?,?,?,?)");
            preparedStatement.setInt(1, estado.getIdEstudio());
            preparedStatement.setInt(2, estado.getIdDerivacion());
            preparedStatement.setDate(3, new java.sql.Date(estado.getFecha().getTime()));
            preparedStatement.setString(4, estado.getDescripcion());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void eliminarEstudios(int idEstudio, int idDerivacion) {
        try {
            connection = BasedeDatos.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from estudios_derivaciones where id_estudio=? and id_derivacion = ?");
            // Parameters start with 1
            preparedStatement.setInt(1, idEstudio);
            preparedStatement.setInt(2, idDerivacion);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
