<%-- 
    Document   : nuevo
    Created on : Oct 20, 2020, 11:05:16 AM
    Author     : Hernan Grahl
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container-fluid bg-dark text-center">
    <h1 class="bg-dark text-light"> Informes de Ingresos</h1> 
</div>
<form action="ControladorInformes?informe=ingreso" method="post">
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
                                <div class="col-md-5">
                                    <div class="form-group">
                                        <label class="bmd-label-floating">Alumno:</label>
                                        <select class="alumnos" style="width:100%;" id="alumnos" name="alumnos">
                                            <c:forEach items = "${alumnos}" var="alumno">
                                                <option value="${alumno.getIdAlumno()}">${alumno.getNombre()} ${alumno.getApellido()}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label class="col-12">&nbsp;</label>
                                        <label for="todos" >Todos los alumnos</label>
                                        <input type="checkbox"  name="todos" id="todos"/>
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
<script>
    $(document).ready(function () {
        $("#todos").on('click', function(ev){
            if($("#todos").is(':checked')){
                $("#alumnos").attr("disabled",true);
            }else $("#alumnos").attr("disabled",false);
        })
    });
</script>