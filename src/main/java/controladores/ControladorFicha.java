/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JSpinner.DefaultEditor;
import modelos.Ficha;
import servicios.ServicioFicha;
import servicios.ServicioOcupacion;

/**
 *
 * @author User
 */
@WebServlet(name = "Fichas", urlPatterns = {"/Fichas"})
public class ControladorFicha extends HttpServlet {

    private static String editarFicha = "index.jsp?page=editarficha";
    private static String nuevaFicha = "index.jsp?page=nuevaficha";
    private static String listarFichas = "index.jsp?page=fichas";
    private static String listarExtranjero = "index.jsp?page=listarextranjero";

    public ControladorFicha() {
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        ServicioFicha.listar();
        String forward = "";
        String accion = request.getParameter("accion");
        if (accion.equalsIgnoreCase("editar")) {
            String id = request.getParameter("id");
            forward = editarFicha;
            request.setAttribute("ocupaciones", ServicioOcupacion.listar());
            request.setAttribute("fichas", ServicioFicha.obtener(id));
        } else if (accion.equalsIgnoreCase("index")) {
            forward = listarFichas;
            request.setAttribute("fichas", ServicioFicha.listar());
        } else if (accion.equalsIgnoreCase("nuevo")) {
            forward = nuevaFicha;
            request.setAttribute("ocupaciones", ServicioOcupacion.listar());
         } else if (accion.equalsIgnoreCase("verextranjero")) {
            forward = listarExtranjero;
            ServicioFicha.listarExtranjero();
        } else if (accion.equalsIgnoreCase("eliminar")) {
            String id = request.getParameter("id");
            ServicioFicha.eliminar(id);
            forward = listarFichas;
            request.setAttribute("success","Registro eliminado exitosamente.");
            request.setAttribute("fichas", ServicioFicha.listar());
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
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String forward = "";
        String accion = request.getParameter("accion");        
        String nrodoc = request.getParameter("numerodocumento");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String sexo = request.getParameter("sexo");
        String domicilio = request.getParameter("domicilio");
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");
        String extranjero = request.getParameter("extranjero");
        String ocupacion = request.getParameter("ocupacion");
        try{
            String fechaingreso = request.getParameter("fechaingreso");
            String fechanacimiento = request.getParameter("fechanacimiento");
            System.out.println(fechaingreso);
            System.out.println(fechanacimiento);
            if (accion.equalsIgnoreCase("nuevo")) {
                Ficha ficha = new Ficha(Integer.valueOf(nrodoc), nombre, apellido, formato.parse(fechaingreso), sexo, formato.parse(fechanacimiento), domicilio, telefono, correo, extranjero, Integer.valueOf(ocupacion));
                ServicioFicha.agregar(ficha);
                request.setAttribute("success","Registro guardado exitosamente.");
            } else {
                String id = request.getParameter("id");
                Ficha ficha = new Ficha(Integer.valueOf(id), Integer.valueOf(nrodoc), nombre, apellido, formato.parse(fechaingreso), sexo, formato.parse(fechanacimiento), domicilio, telefono, correo, extranjero, Integer.valueOf(ocupacion));
                ServicioFicha.verificar(ficha);
                request.setAttribute("success","Registro modificado exitosamente.");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        forward = listarFichas;
        request.setAttribute("fichas", ServicioFicha.listar());
        RequestDispatcher view = request.getRequestDispatcher(forward);
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
