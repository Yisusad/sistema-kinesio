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
import modelos.Patologia;
import servicios.ServicioAntecedente;
import servicios.ServicioPatologia;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "Patologias", urlPatterns = {"/Patologias"})
public class ControladorPatologia extends HttpServlet {

    public ControladorPatologia() {
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
            forward = "index.jsp?page=nuevapatologia";
        } else if (accion.equalsIgnoreCase("editar")) {
            String id = request.getParameter("id");
            Patologia obj = ServicioPatologia.obtener(Integer.valueOf(id));
            forward = "index.jsp?page=editarpatologia";
            request.setAttribute("patologia", obj);
        } else if (accion.equalsIgnoreCase("eliminar")) {
            String id = request.getParameter("id");
            ServicioPatologia.eliminar(id);
            forward = "index.jsp?page=patologias";
            request.setAttribute("success","Registro eliminado exitosamente.");
            request.setAttribute("patologias", ServicioPatologia.listar());
        } else {
            request.setAttribute("patologias", ServicioPatologia.listar());
            forward = "index.jsp?page=patologias";
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
        Patologia obj = new Patologia();
        obj.setDescripcion(descripcion);
        if (id == null) {            
            ServicioPatologia.agregar(obj);
            request.setAttribute("success","Registro guardado exitosamente.");
        } else {
            obj.setIdPatologia(Integer.valueOf(id));
            ServicioPatologia.actualizar(obj);
            request.setAttribute("success","Registro modificado exitosamente.");
        }
        request.setAttribute("patologias", ServicioPatologia.listar());
        RequestDispatcher view = request.getRequestDispatcher("index.jsp?page=patologias");
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
