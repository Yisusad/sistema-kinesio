/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Derivacion;
import servicios.ServicioAlumno;
import servicios.ServicioAntecedente;
import servicios.ServicioDerivacion;
import servicios.ServicioEstado;
import servicios.ServicioEstudio;
import servicios.ServicioEvolucion;
import servicios.ServicioFicha;
import servicios.ServicioMedico;
import servicios.ServicioObjetivo;
import servicios.ServicioPatologia;

/**
 *
 * @author Fabi Garcia
 */
@WebServlet(name = "Derivaciones", urlPatterns = {"/Derivaciones"})
public class ControladorDerivacion extends HttpServlet {

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
        if (accion.equalsIgnoreCase("nuevo")) {
            forward = "index.jsp?page=nuevaderivacion";
            request.setAttribute("alumnos", ServicioAlumno.listar());
            request.setAttribute("medicos", ServicioMedico.listar());
            request.setAttribute("fichas", ServicioFicha.listar());
            request.setAttribute("patologias", ServicioPatologia.listar());
        } else if (accion.equalsIgnoreCase("editar")) {
            String id = request.getParameter("id");
            Derivacion deri = ServicioDerivacion.obtener(Integer.valueOf(id));
            forward = "index.jsp?page=editarderivacion";
            request.setAttribute("idDerivacion", deri.getIdDerivacion());
            request.setAttribute("abona", deri.getAbona());
            request.setAttribute("diagMed", deri.getDiagMed());
            request.setAttribute("diagKine", deri.getDiagKine());
            request.setAttribute("numSesiones", deri.getNumSesiones());
            request.setAttribute("motivo", deri.getMotivo());
            request.setAttribute("idPato", deri.getIdPato());
            request.setAttribute("idMed", deri.getIdMed());
            request.setAttribute("idAlum", deri.getIdAlum());
            request.setAttribute("idFicha", deri.getIdFicha());
            request.setAttribute("alumnos", ServicioAlumno.listar());
            request.setAttribute("medicos", ServicioMedico.listar());
            request.setAttribute("fichas", ServicioFicha.listar());
            request.setAttribute("patologias", ServicioPatologia.listar());
            request.setAttribute("antecedentes", ServicioAntecedente.listar());
            request.setAttribute("antecedentesD", ServicioDerivacion.listarAntecedentes(deri.getIdDerivacion()));
            request.setAttribute("objetivos", ServicioObjetivo.listar(deri.getIdDerivacion()));
            request.setAttribute("estudiosD", ServicioDerivacion.listarEstudios(deri.getIdDerivacion()));
            request.setAttribute("estudios", ServicioEstudio.listar());
            request.setAttribute("estadosD", ServicioDerivacion.listarEstados(deri.getIdDerivacion()));
            request.setAttribute("estados", ServicioEstado.listar());
            request.setAttribute("evoluciones", ServicioEvolucion.listar(deri.getIdDerivacion()));
            request.setAttribute("alumno", ServicioAlumno.obtener(deri.getIdAlum()));
            request.setAttribute("paciente", ServicioFicha.obtener("" + deri.getIdFicha()));
            request.setAttribute("patologia", ServicioPatologia.obtener(deri.getIdPato()));
            request.setAttribute("derivacion", deri);
            request.setAttribute("sender", request.getParameter("sender"));
        } else if (accion.equalsIgnoreCase("eliminar")) {
            String id = request.getParameter("id");
            ServicioDerivacion.eliminar(id);
            forward = "index.jsp?page=derivaciones";
            request.setAttribute("derivaciones", ServicioDerivacion.listarTodos());
            request.setAttribute("success", "Registro eliminado exitosamente.");
        } else if (accion.equalsIgnoreCase("eliminarantecedente")) {
            String idderi = request.getParameter("idderi");
            String idant = request.getParameter("idant");
            ServicioDerivacion.eliminarAntecedente(Integer.valueOf(idant), Integer.valueOf(idderi));
            forward = "index.jsp?page=derivaciones";
            request.setAttribute("derivaciones", ServicioDerivacion.listarTodos());
            request.setAttribute("success", "Registro eliminado exitosamente.");
        } else if (accion.equalsIgnoreCase("eliminarobjetivo")) {
            String idobj = request.getParameter("idobj");
            ServicioObjetivo.eliminar(idobj);
            forward = "index.jsp?page=derivaciones";
            request.setAttribute("derivaciones", ServicioDerivacion.listarTodos());
            request.setAttribute("success", "Registro eliminado exitosamente.");
        } else if (accion.equalsIgnoreCase("eliminarestado")) {
            String idderi = request.getParameter("idderi");
            String idestado = request.getParameter("idestado");
            ServicioDerivacion.eliminarEstados(Integer.valueOf(idestado), Integer.valueOf(idderi));
            forward = "index.jsp?page=derivaciones";
            request.setAttribute("derivaciones", ServicioDerivacion.listarTodos());
            request.setAttribute("success", "Registro eliminado exitosamente.");
        } else if (accion.equalsIgnoreCase("eliminarestudio")) {
            String idderi = request.getParameter("idderi");
            String idestudio = request.getParameter("idestudio");
            ServicioDerivacion.eliminarEstudios(Integer.valueOf(idestudio), Integer.valueOf(idderi));
            forward = "index.jsp?page=derivaciones";
            request.setAttribute("derivaciones", ServicioDerivacion.listarTodos());
            request.setAttribute("success", "Registro eliminado exitosamente.");
        } else if (accion.equalsIgnoreCase("eliminarevolucion")) {
            String idevo = request.getParameter("idevo");
            ServicioEvolucion.eliminar(idevo);
            forward = "index.jsp?page=derivaciones";
            request.setAttribute("derivaciones", ServicioDerivacion.listarTodos());
            request.setAttribute("success", "Registro eliminado exitosamente.");
        } else {
            request.setAttribute("derivaciones", ServicioDerivacion.listarTodos());
            forward = "index.jsp?page=derivaciones";
        }

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
        String id = request.getParameter("idDerivacion");
        String abona = request.getParameter("abona");
        String diagMed = request.getParameter("diagMed");
        String diagKine = request.getParameter("diagKine");
        String numSesiones = request.getParameter("numSesiones");
        String motivo = request.getParameter("motivo");
        String idPato = request.getParameter("idPatologia");
        String idMed = request.getParameter("idMedico");
        String idAlum = request.getParameter("idAlumno");
        String idFicha = request.getParameter("idFicha");
        String antecedente = request.getParameter("antecedente");
        String monto = request.getParameter("monto");
        monto = monto == null ? "0" : monto;

        Derivacion deri = new Derivacion();
        deri.setAbona(abona);
        deri.setDiagMed(diagMed);
        deri.setDiagKine(diagKine);
        deri.setNumSesiones(Integer.valueOf(numSesiones));
        deri.setMotivo(motivo);
        deri.setIdPato(Integer.valueOf(idPato));
        deri.setIdMed(Integer.valueOf(idMed));
        deri.setIdAlum(Integer.valueOf(idAlum));
        deri.setIdFicha(Integer.valueOf(idFicha));
        deri.setAntecedente(antecedente);
        deri.setMonto(Integer.valueOf(monto));
        if (id == null) {
            int nId = ServicioDerivacion.agregar(deri);
            request.setAttribute("success", "Registro guardado exitosamente.");
        } else {
            deri.setIdDerivacion(Integer.valueOf(id));
            ServicioDerivacion.actualizar(deri);
            request.setAttribute("success", "Registro modificado exitosamente.");
        }
        request.setAttribute("derivaciones", ServicioDerivacion.listarTodos());
        RequestDispatcher view = request.getRequestDispatcher("index.jsp?page=derivaciones");
        view.forward(request, response);

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
