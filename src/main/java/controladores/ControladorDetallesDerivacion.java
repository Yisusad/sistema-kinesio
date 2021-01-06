/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.io.IOException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.AntecedenteDerivacion;
import modelos.Derivacion;
import modelos.EstadoDerivacion;
import modelos.EstudioDerivacion;
import modelos.Evolucion;
import modelos.Objetivo;
import servicios.ServicioAlumno;
import servicios.ServicioAntecedente;
import servicios.ServicioDerivacion;
import servicios.ServicioEstado;
import servicios.ServicioEstudio;
import servicios.ServicioEvolucion;
import servicios.ServicioObjetivo;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "DetalleDerivacion", urlPatterns = {"/DetalleDerivacion"})
public class ControladorDetallesDerivacion extends HttpServlet {
    java.text.DateFormat formato = new java.text.SimpleDateFormat("yyyy-MM-dd");
    public ControladorDetallesDerivacion() {
        super();
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = "";
        String accion = request.getParameter("accion");
        String idDerivacion = request.getParameter("idDerivacion");
        if(accion.equalsIgnoreCase("agregarestado")){
            request.setAttribute("estados", ServicioEstado.listar());
        }else if(accion.equalsIgnoreCase("agregarestudio")){
            request.setAttribute("estudios", ServicioEstudio.listar());
        }else if(accion.equalsIgnoreCase("agregarantecedentes")){
            request.setAttribute("antecedentes", ServicioAntecedente.listar());
        }if(accion.equalsIgnoreCase("editarevolucion")){
            String id = request.getParameter("idEvolucion");
            request.setAttribute("evolucion", ServicioEvolucion.obtener(Integer.valueOf(id)));
        }
        request.setAttribute("antecedentes", ServicioAntecedente.listar());
        Derivacion deri = ServicioDerivacion.obtener(Integer.valueOf(idDerivacion));
        request.setAttribute("fechaHoy", formato.format(new Date()));
        request.setAttribute("derivacion", deri);
        request.setAttribute("alumno", ServicioAlumno.obtener(deri.getIdAlum()));
        forward = "index.jsp?page=" + accion;
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String idDerivacion = request.getParameter("idDerivacion");
        String descripcion = request.getParameter("descripcion");
        String idAlumno = request.getParameter("idAlumno");
        int idDeriva = Integer.valueOf(idDerivacion);
        String accion = request.getParameter("accion");
        try{
            if (accion.equals("estudio")) {
                String id = request.getParameter("idEstudio");
                String fecha = request.getParameter("fecha");
                EstudioDerivacion obj = new EstudioDerivacion();
                obj.setIdEstudio(Integer.valueOf(id));
                obj.setIdDerivacion(idDeriva);
                obj.setFecha(formato.parse(fecha));
                obj.setDescripcion(descripcion);
                ServicioDerivacion.agregarEstudio(obj);
                request.setAttribute("success","Registro guardado exitosamente.");
            } else if (accion.equals("estado")) {
                String id = request.getParameter("idEstado");
                EstadoDerivacion obj = new EstadoDerivacion();
                obj.setIdEstado(Integer.valueOf(id));
                obj.setIdDerivacion(idDeriva);
                obj.setDescripcion(descripcion);
                ServicioDerivacion.agregarEstado(obj);
            } else if (accion.equals("antecedente")) {
                String id = request.getParameter("idAntecedente");
                AntecedenteDerivacion ad = new AntecedenteDerivacion();
                ad.setIdAntecedente(Integer.valueOf(id));
                ad.setIdDerivacion(idDeriva);
                ServicioDerivacion.agregarAntecedente(ad);
                request.setAttribute("success","Registro guardado exitosamente.");
            } else if (accion.equals("objetivo")) {
                Objetivo obj = new Objetivo();
                obj.setIdDerivacion(idDeriva);
                obj.setDescripcion(descripcion);
                ServicioObjetivo.agregar(obj);
                request.setAttribute("success","Registro guardado exitosamente.");
            } else {
                String idEvolucion = request.getParameter("idEvolucion");
                String fecha = request.getParameter("fecha_evaluacion");
                String turno = request.getParameter("turno");
                String sesion = request.getParameter("nro_sesion");
                String monto = request.getParameter("monto_evaluacion");
                String fisioterapia = request.getParameter("fisioterapia");
                String kinesioterapia = request.getParameter("kinesioterapia");
                String kinefilaxia = request.getParameter("kinefilaxia");
                fisioterapia = fisioterapia.length() == 0 ? null: fisioterapia;
                kinesioterapia = kinesioterapia.length() == 0 ? null: kinesioterapia;
                kinefilaxia = kinefilaxia.length() == 0 ? null: kinefilaxia;
                if(idEvolucion == null) idEvolucion = "0";
                Evolucion evo = new Evolucion(
                        Integer.valueOf(idEvolucion),
                        formato.parse(fecha),
                        Integer.valueOf(monto),
                        Integer.valueOf(turno),
                        Integer.valueOf(sesion),
                        kinesioterapia,
                        fisioterapia,
                        kinefilaxia,
                        idDeriva,
                        Integer.valueOf(idAlumno)
                );
                ServicioEvolucion.verificar(evo);
                request.setAttribute("success","Registro guardado exitosamente.");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        //request.setAttribute("derivaciones", ServicioDerivacion.listar());
        request.setAttribute("id", idDerivacion);
        request.setAttribute("accion", "editar");
        //RequestDispatcher view = request.getRequestDispatcher("Derivaciones?accion=editar?id=" + idDerivacion);
        //view.forward(request, response);
        response.sendRedirect("Derivaciones?accion=editar&id=" + idDerivacion + "&sender=" + accion);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
