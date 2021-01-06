/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperRunManager;

import servicios.BasedeDatos;
import servicios.ServicioAlumno;
import servicios.ServicioFicha;
import servicios.ServicioPatologia;


/**
 *
 * @author Fabi Garcia
 */
@WebServlet(name = "ControladorInformes", urlPatterns = {"/ControladorInformes"})
public class ControladorInformes extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorInforme</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorInforme at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        Date dateDesde = new java.util.Date();
        Date dateHasta = new java.util.Date();
        dateDesde.setDate(1);
        java.text.DateFormat formato = new java.text.SimpleDateFormat("yyyy-MM-dd");
        Date finicio = new Date();
        finicio = new Date(finicio.getYear(), finicio.getMonth(), 1);
        request.setAttribute("desde", formato.format(finicio));
        request.setAttribute("hasta", formato.format(new Date()));
        String accion = request.getParameter("accion");
        String forward = "index.jsp?page="+accion;
        
        request.setAttribute("alumnos", ServicioAlumno.listar());
        request.setAttribute("fichas", ServicioFicha.listar());
        request.setAttribute("patologias", ServicioPatologia.listar());    

        if (accion.equals("fichakinesica")){
            try {
                Connection con = null;
                con = BasedeDatos.getConnection();
                ServletOutputStream output = response.getOutputStream();
                File reportFile = null;
                String idDerivacion = request.getParameter("idDerivacion");
                Map<String, Object> param = new HashMap<String, Object>();
                param.put("IdDerivacion", Integer.valueOf(idDerivacion));
                reportFile = new File(getServletConfig().getServletContext().getRealPath("/reports/FichaKinesica.jasper"));
                byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), param, con);
                response.setContentType("application/pdf");
                response.setContentLength(bytes.length);
                output.write(bytes, 0, bytes.length);
                output.flush();
                output.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }else if (accion.equals("ordenderivacion")){
            try {
                Connection con = null;
                con = BasedeDatos.getConnection();
                ServletOutputStream output = response.getOutputStream();
                File reportFile = null;
                String idDerivacion = request.getParameter("idDerivacion");
                Map<String, Object> param = new HashMap<String, Object>();
                param.put("IdDerivacion", Integer.valueOf(idDerivacion));
                reportFile = new File(getServletConfig().getServletContext().getRealPath("/reports/OrdenPagoF.jasper"));
                byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), param, con);
                response.setContentType("application/pdf");
                response.setContentLength(bytes.length);
                output.write(bytes, 0, bytes.length);
                output.flush();
                output.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }else if (accion.equals("ordenevolucion")){
            try {
                Connection con = null;
                con = BasedeDatos.getConnection();
                ServletOutputStream output = response.getOutputStream();
                File reportFile = null;
                String idEvolucion = request.getParameter("idEvolucion");
                Map<String, Object> param = new HashMap<String, Object>();
                param.put("IdEvolucion", Integer.valueOf(idEvolucion));
                reportFile = new File(getServletConfig().getServletContext().getRealPath("/reports/OrdenPagoE.jasper"));
                byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), param, con);
                response.setContentType("application/pdf");
                response.setContentLength(bytes.length);
                output.write(bytes, 0, bytes.length);
                output.flush();
                output.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }else if (accion.equals("fichapacientes")){
            try {
                Connection con = null;
                con = BasedeDatos.getConnection();
                ServletOutputStream output = response.getOutputStream();
                File reportFile = null;
                String idFicha = request.getParameter("idFicha");
                Map<String, Object> param = new HashMap<String, Object>();
                param.put("IdFicha", Integer.valueOf(idFicha));
                reportFile = new File(getServletConfig().getServletContext().getRealPath("/reports/OrdenPagoE.jasper"));
                byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), param, con);
                response.setContentType("application/pdf");
                response.setContentLength(bytes.length);
                output.write(bytes, 0, bytes.length);
                output.flush();
                output.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }else{
        
            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
        }
        
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
        Connection con = null;
        con = BasedeDatos.getConnection();
        ServletOutputStream output = response.getOutputStream();
        File reportFile = null;
        String inf = request.getParameter("informe");
        String todos = request.getParameter("todos");
        String idAlumno = request.getParameter("alumnos");
        String idDerivacion = request.getParameter("idDerivacion");
        
        Date desde = null;
        Date hasta = null;
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("idDerivacion", idDerivacion);
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        try {
            desde = formato.parse(request.getParameter("desde"));
            hasta = formato.parse(request.getParameter("hasta"));
            param.put("desde", desde);
            param.put("hasta", hasta);
            Integer.valueOf(idAlumno);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (inf.equals("ingreso")) {
            if (todos == null) {
                param.put("idAlumno", Integer.valueOf(idAlumno));
            }
            reportFile = new File(getServletConfig().getServletContext().getRealPath("/reports/InformeIngreso.jasper"));
        } else if (inf.endsWith("historialpaciente")) {
            reportFile = new File(getServletConfig().getServletContext().getRealPath("/reports/HistorialPaciente.jasper"));
        } else if (inf.equals("antecedentes")) {
            reportFile = new File(getServletConfig().getServletContext().getRealPath("/reports/AntecedentesPaciente.jasper"));
        } else if (inf.equals("estados")) {
            reportFile = new File(getServletConfig().getServletContext().getRealPath("/reports/EstadosPaciente.jasper"));
        } else if (inf.equals("estudios")) {
            reportFile = new File(getServletConfig().getServletContext().getRealPath("/reports/EstudiosPaciente.jasper"));
        } else if (inf.equals("evoluciones")) {
            reportFile = new File(getServletConfig().getServletContext().getRealPath("/reports/EvolucionesPaciente.jasper"));
        } else if (inf.equals("reportealumnos")){
            param.put("idAlumno", Integer.valueOf(idAlumno));
            reportFile = new File(getServletConfig().getServletContext().getRealPath("/reports/ReporteDerivacionesPorAlumno.jasper"));
        }else if (inf.equals("fichakinesica")){
            param.put("idDerivacion", Integer.valueOf(idDerivacion));
            reportFile = new File(getServletConfig().getServletContext().getRealPath("/reports/FichaKinesica.jasper"));
        }else if (inf.equals("ordenderivacion")){
            try {
                param.put("IdDerivacion", Integer.valueOf(idDerivacion));
                reportFile = new File(getServletConfig().getServletContext().getRealPath("/reports/OrdenPagoF.jasper"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }else if (inf.equals("ordenevolucion")){
            try {
                String idEvolucion = request.getParameter("idEvolucion");
                param.put("IdEvolucion", Integer.valueOf(idEvolucion));
                reportFile = new File(getServletConfig().getServletContext().getRealPath("/reports/OrdenPagoE.jasper"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        try {
            byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), param, con);
            response.setContentType("application/pdf");
            response.setContentLength(bytes.length);
            output.write(bytes, 0, bytes.length);
            output.flush();
            output.close();
        } catch (Exception ex) {
            ex.printStackTrace();
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
