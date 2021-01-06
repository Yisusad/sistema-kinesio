<%-- 
    Document   : nuevo
    Created on : Oct 20, 2020, 11:05:16 AM
    Author     : Hernan Grahl
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% HttpSession ses = request.getSession(); %>
<%@ page import="modelos.Usuario" %>
<%@ page import="modelos.Alumno" %>
<% Usuario usu = (Usuario) ses.getAttribute("loggedUser"); %>
<% 
    Alumno alumno = null;
    if(null != usu) alumno = usu.getAlumno(); 
%>

<div class="container-fluid bg-dark justify-content-center">
    <h1 class="bg-dark text-light">Agregar Evolucion </h1> 
</div>
<div class="content">
    <form action="DetalleDerivacion?accion=evolucion" method="post" id="DetalleDerivacion">
        <div class="container-fluid">
            <div class="row justify-content-center">
                <div class="col-md-9">
                    <p></p>
                    <div class="card">
                        <div class="card-body">
                            <div class="row">                                    
                                   <div class="col-3">
                                        <div class="from-group">
                                            <label for="fecha_evaluacion" class="bmd-label-floating align-te">Fecha de Evaluación:</label>
                                            <input id="fecha_evaluacion" class="form-control" type="text" name="fecha_evaluacion" value="${fechaHoy}" readonly>
                                        </div>
                                    </div>
                                    <div class="col-1"></div>
                                    <div class="col-2">
                                        <div class="from-group">
                                            <label for="turno" class="bmd-label-floating">Turno:</label>  
                                            <input id="turno" class="form-control text-right" type="number" name="turno" value="">
                                        </div>
                                    </div>
                                    <div class="col-1"></div>
                                    <div class="col-2">
                                        <div class="from-group">
                                            <label for="nro_sesion" class="bmd-label-floating">Nº de Sesión:</label>
                                            <input id="nro_sesion" class="form-control text-right" type="number" name="nro_sesion" value="">
                                        </div>
                                    </div>
                                    <div class="col-1"></div>
                                    <div class="col-2">
                                        <div class="from-group">
                                         <label for="monto_evaluacion" class="bmd-label-floating">Monto:</label>
                                        <input id="monto_evaluacion" class="form-control text-right" type="number" name="monto_evaluacion" value="0">
                                    </div>
                                </div>
                            </div>
                            <p></p>
                            <div class="row">
                                <div class="col-4">
                                    <div class="from-group">
                                        <label for="kinesioterapia" class="bmd-label-floating">Kinesioterapia</label>
                                        <textarea id="kinesioterapia" class="form-control" name="kinesioterapia"></textarea>
                                    </div>
                                </div>
                                <div class="col-4">
                                    <label for="fisioterapia" class="bmd-label-floating">Fisioterapia</label>
                                        <textarea id="fisioterapia" class="form-control" name="fisioterapia"></textarea>
                                </div>
                                <div class="col-4">
                                    <label for="kinefilaxia" class="bmd-label-floating">Kinefilaxia</label> 
                                    <textarea id="kinefilaxia" class="form-control" name="kinefilaxia"></textarea>
                                </div>
                           </div>
                            <div class="d-flex justify-content-center mt-3">
                                <% if(alumno != null){ %>
                                    <button type="submit" class="btn btn-outline-primary pull-center"><spam class="fas fa-save"></spam> Guardar</button>
                                <%}%>
                                
                                &nbsp;&nbsp;&nbsp;
                                <a class="btn btn-outline-danger" title="Editar" href='Derivaciones?accion=editar&id=${derivacion.getIdDerivacion()}'>&nbsp;&nbsp;Cancelar&nbsp;</a>
                            </div>
                            <% if(alumno == null){ %>
                                <div class="row text-danger text-center">
                                    <div class="col">
                                        <spam class="fas fa-exclamation-circle"></spam>&nbsp;Debe iniciar sesi&oacute;n como un alumno...
                                    </div>
                                </div>
                            <%}%>
                            
                            <input type="hidden" name="idDerivacion" id="idDerivacion" value="${derivacion.getIdDerivacion()}">
                            <input type="hidden" name="idAlumno" id="id_alumno" value="<% 
                                if (alumno != null) {
                                    out.print(alumno.getIdAlumno());
                                } else {
                                    out.print("0");
                                }%>">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
<script>
    $(document).ready(function () {
        $('.js-example-basic-single').select2();
    });
</script>