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
import modelos.Antecedente;
import servicios.ServicioAntecedente;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "Antecedentes", urlPatterns = {"/Antecedentes"})
public class ControladorAntecedentes extends HttpServlet {

    public ControladorAntecedentes() {
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
        if (accion.equalsIgnoreCase("nuevo")) {
            forward = "index.jsp?page=nuevoantecedente";
        } else if (accion.equalsIgnoreCase("editar")) {
            String id = request.getParameter("id");
            Antecedente obj = ServicioAntecedente.obtener(Integer.valueOf(id));
            forward = "index.jsp?page=editarantecedente";
            request.setAttribute("antecedente", obj);
        } else if (accion.equalsIgnoreCase("eliminar")) {
            String id = request.getParameter("id");
            ServicioAntecedente.eliminar(id);
            forward = "index.jsp?page=antecedentes";
            request.setAttribute("success","Registro eliminado exitosamente.");
            request.setAttribute("antecedentes", ServicioAntecedente.listar());
        } else {
            request.setAttribute("antecedentes", ServicioAntecedente.listar());
            forward = "index.jsp?page=antecedentes";
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
        String id = request.getParameter("id");
        String descripcion = request.getParameter("descripcion");
        Antecedente obj = new Antecedente();
        obj.setDescripcion(descripcion);
        if (id == null) {            
            ServicioAntecedente.agregar(obj);
            request.setAttribute("success","Registro guardado exitosamente.");
        } else {
            obj.setIdAntecedente(Integer.valueOf(id));
            ServicioAntecedente.actualizar(obj);
            request.setAttribute("success","Registro modificado exitosamente.");
        }
        request.setAttribute("antecedentes", ServicioAntecedente.listar());
        RequestDispatcher view = request.getRequestDispatcher("index.jsp?page=antecedentes");
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
