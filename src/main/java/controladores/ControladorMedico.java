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
import modelos.Medico;
import servicios.ServicioMedico;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "Medicos", urlPatterns = {"/Medicos"})
public class ControladorMedico extends HttpServlet {

    public ControladorMedico() {
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
            forward = "index.jsp?page=nuevomedico";
        } else if (accion.equalsIgnoreCase("editar")) {
            String id = request.getParameter("id");
            Medico obj = ServicioMedico.obtener(Integer.valueOf(id));
            forward = "index.jsp?page=editarmedico";
            request.setAttribute("medico", obj);
        } else if (accion.equalsIgnoreCase("eliminar")) {
            String id = request.getParameter("id");
            ServicioMedico.eliminar(id);
            forward = "index.jsp?page=medicos";
            request.setAttribute("success","Registro eliminado exitosamente.");
            request.setAttribute("medicos", ServicioMedico.listar());
        } else {
            request.setAttribute("medicos", ServicioMedico.listar());
            forward = "index.jsp?page=medicos";
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
        //response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");
        Medico obj = new Medico();
        obj.setNombre(nombre);
        obj.setApellido(apellido);
        obj.setTelefono(telefono);
        obj.setCorreo(correo);
        if (id == null) {            
            ServicioMedico.agregar(obj);
            request.setAttribute("success","Registro guardado exitosamente.");
        } else {
            obj.setIdMedico(Integer.valueOf(id));
            ServicioMedico.actualizar(obj);
            request.setAttribute("success","Registro modificado exitosamente.");
        }
        request.setAttribute("medicos", ServicioMedico.listar());
        RequestDispatcher view = request.getRequestDispatcher("index.jsp?page=medicos");
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
