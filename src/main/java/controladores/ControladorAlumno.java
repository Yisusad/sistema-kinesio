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
import modelos.Alumno;
import servicios.ServicioAlumno;
import servicios.ServicioUsuario;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "Alumnos", urlPatterns = {"/Alumnos"})
public class ControladorAlumno extends HttpServlet {

    public ControladorAlumno() {
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
        ServicioAlumno.listar();
        String forward = "";
        String accion = request.getParameter("accion");
        if (accion.equalsIgnoreCase("nuevo")) {
            forward = "index.jsp?page=nuevoalumno";
            request.setAttribute("usuarios", ServicioUsuario.listar());
        } else if (accion.equalsIgnoreCase("editar")) {
            String id = request.getParameter("id");
            forward = "index.jsp?page=editaralumno";
            request.setAttribute("alumno", ServicioAlumno.obtener(Integer.valueOf(id)));
            request.setAttribute("usuarios", ServicioUsuario.listar());
        } else if (accion.equalsIgnoreCase("eliminar")) {
            String id = request.getParameter("id");
            ServicioAlumno.eliminar(id);
            forward = "index.jsp?page=alumnos";
            request.setAttribute("success","Registro eliminado exitosamente.");
            request.setAttribute("alumnos", ServicioAlumno.listar());
        } else {
            request.setAttribute("alumnos", ServicioAlumno.listar());
            forward = "index.jsp?page=alumnos";
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
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");
        String usuario = request.getParameter("usuario");
        Alumno alum = new Alumno();
        alum.setNombre(nombre);
        alum.setApellido(apellido);
        alum.setTelefono(telefono);
        alum.setCorreo(correo);
        alum.setIdUsuario(Integer.valueOf(usuario));
        if (id == null) {
            ServicioAlumno.agregar(alum);
            request.setAttribute("success","Registro guardado exitosamente.");
        } else {
            alum.setIdAlumno(Integer.valueOf(id));
            ServicioAlumno.actualizar(alum);
            request.setAttribute("success","Registro modificado exitosamente.");
        }
        request.setAttribute("alumnos", ServicioAlumno.listar());
        RequestDispatcher view = request.getRequestDispatcher("index.jsp?page=alumnos");
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
