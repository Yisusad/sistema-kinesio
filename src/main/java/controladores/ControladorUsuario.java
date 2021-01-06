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
import modelos.Usuario;
import servicios.ServicioUsuario;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "Usuarios", urlPatterns = {"/Usuarios"})
public class ControladorUsuario extends HttpServlet {

    private static String editarUsuario = "index.jsp?page=editarusuario";
    private static String nuevoUsuario = "index.jsp?page=nuevousuario";
    private static String listarUsuarios = "index.jsp?page=usuarios";
    private static String loginUsuario = "pages/usuarios/login.jsp";

    public ControladorUsuario() {
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
        ServicioUsuario.listar();
        String forward = "";
        String accion = request.getParameter("accion");

        if (accion.equalsIgnoreCase("ingresar")) {
            response.sendRedirect(loginUsuario);
            return;
        } else if (accion.equalsIgnoreCase("editar")) {
            String id = request.getParameter("id");
            forward = editarUsuario;
            request.setAttribute("usuarios", ServicioUsuario.obtener(id));
            } else if (accion.equalsIgnoreCase("cambiarclave")) {
            String id = request.getParameter("id");
            forward = "index.jsp?page=cambiarclave";
            request.setAttribute("usuarios", ServicioUsuario.obtener(id));
        } else if (accion.equalsIgnoreCase("index")) {
            forward = listarUsuarios;
            request.setAttribute("usuarios", ServicioUsuario.listar());
        } else if (accion.equalsIgnoreCase("nuevo")) {
            forward = nuevoUsuario;
        } else if(accion.equalsIgnoreCase("eliminar")) {
            String id = request.getParameter("id");
            ServicioUsuario.eliminar(id);
            forward = listarUsuarios;
            request.setAttribute("success","Registro eliminado exitosamente.");
            request.setAttribute("usuarios", ServicioUsuario.listar());
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
        String forward = "";
        String accion = request.getParameter("accion");
        if (accion.equalsIgnoreCase("login")) {
            String user = request.getParameter("user");
            String password = request.getParameter("password");
            Usuario u = ServicioUsuario.login(user, password);
            if (null != u) {
                request.getSession().setAttribute("loggedUser", u);
                request.setAttribute("usuario", u.getNombreUsuario());
                response.sendRedirect("index.jsp");
            } else {
                response.sendRedirect(request.getHeader("Referer"));
            }
        } else if (accion.equalsIgnoreCase("nuevo")) {
            String user = request.getParameter("user");
            String password = request.getParameter("password");
            String rol = request.getParameter("rol");
            Usuario u = new Usuario(user,rol,password, 0);
            ServicioUsuario.agregar(u);
            forward = listarUsuarios;
            request.setAttribute("success","Registro guardado exitosamente.");
            request.setAttribute("usuarios", ServicioUsuario.listar());
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
        } else if (accion.equalsIgnoreCase("editar")) {
            String id = request.getParameter("id");
            String user = request.getParameter("user");
            
            String rol = request.getParameter("rol");
            Usuario u = new Usuario(Integer.valueOf(id),user,rol,"");
            ServicioUsuario.verificar(u);
            forward = listarUsuarios;
            request.setAttribute("success","Registro modificado exitosamente.");
            request.setAttribute("usuarios", ServicioUsuario.listar());
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);           
        } else if (accion.equalsIgnoreCase("cambiarclave")) {
            String id = request.getParameter("id");
            String oldpassw = request.getParameter("oldpass");
            String newpassw = request.getParameter("newpass");
            
          
            ServicioUsuario.cambiarClave(Integer.valueOf(id), oldpassw , newpassw);
            forward = "index.jsp";
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);           
        } 
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
