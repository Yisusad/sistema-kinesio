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
import modelos.Objetivo;
import servicios.ServicioObjetivo;

/**
 *
 * @author Manu
 */
@WebServlet(name = "Objetivos", urlPatterns = {"/Objetivos"})
public class ControladorObjetivo extends HttpServlet{
    
    

   public ControladorObjetivo() {
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = "";
        String accion = request.getParameter("accion");
        String idDeriva = request.getParameter("idDerivacion");
        if (accion.equalsIgnoreCase("nuevo")) {
            forward = "index.jsp?page=nuevoobjetivo";
        } else if (accion.equalsIgnoreCase("editar")) {
            String id = request.getParameter("id");
            Objetivo obj = ServicioObjetivo.obtener(Integer.valueOf(id));
            forward = "index.jsp?page=editarobjetivo";
            request.setAttribute("objetivo", obj);
        } else if (accion.equalsIgnoreCase("eliminar")) {
            String id = request.getParameter("id");
            ServicioObjetivo.eliminar(id);
            forward = "index.jsp?page=objetivo";
            request.setAttribute("success","Registro eliminado exitosamente.");
            request.setAttribute("objetivos", ServicioObjetivo.listar(Integer.parseInt(idDeriva)));
        } else {
            request.setAttribute("objetivos", ServicioObjetivo.listar(Integer.parseInt(idDeriva)));
            forward = "index.jsp?page=objetivos";
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id_objetivos");
        String idDeriva = request.getParameter("idDerivacion");
        String descripcion = request.getParameter("descripcion_objetivo");
        Objetivo obj = new Objetivo();
        obj.setDescripcion(descripcion);
        obj.setIdDerivacion(Integer.parseInt(idDeriva));
        if (id == null) {
            ServicioObjetivo.agregar(obj);
            request.setAttribute("success","Registro guardado exitosamente.");
        } else {
            obj.setIdObjetivo(Integer.valueOf(id));
            ServicioObjetivo.actualizar(obj);
            request.setAttribute("success","Registro modificado exitosamente.");
        }
        request.setAttribute("objetivos", ServicioObjetivo.listar(Integer.parseInt(idDeriva)));
        RequestDispatcher view = request.getRequestDispatcher("index.jsp?page=objetivos");
        view.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
