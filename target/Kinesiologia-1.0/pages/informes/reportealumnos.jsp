<%-- 
    Document   : nuevo
    Created on : Oct 20, 2020, 11:05:16 AM
    Author     : Hernan Grahl
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="container-fluid bg-dark text-center">
    <h1 class="bg-dark text-light"> Historial de Alumno</h1> 
</div>
<form action="ControladorInformes?informe=reportealumnos" method="post">
    <div class="container-fluid">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <p></p>
                <div class="card">
                    <div class="card-body">
                        <form>
                            <div class="row">
                                <div class="col-md-2"></div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label class="bmd-label-floating">Desde</label>
                                        <input type="date" id="desde" name="desde" class="form-control text-center" value="${desde}" >
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label class="bmd-label-floating">Hasta</label>
                                        <input type="date" name="hasta" id="hasta" class="form-control  text-center"  value="${hasta}">
                                    </div>
                                </div>
                                <div class="col-md-2"></div>
                            </div>
                            <div class="row">
                                <div class="col-md-2"></div>
                                <div class="col">
                                    <div class="form-group">
                                        <label class="bmd-label-floating">Alumno</label>
                                        <select class="alumnos" style="width:100%;" id="alumnos" name="alumnos">
                                            <c:forEach items = "${alumnos}" var="alumno">
                                                <option value="${alumno.getIdAlumno()}">${alumno.getNombre()} ${alumno.getApellido()}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-2"></div>
                            </div>
                            <br>
                            <div class="d-flex justify-content-center">
                                <button type="submit" class="btn btn-outline-primary pull-center"><spam class="fas fa-save"></spam> Mostrar</button>
                                <div class="clearfix"></div>
                            </div>
                            
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>