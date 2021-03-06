<%-- 
    Document   : nuevo
    Created on : Oct 18, 2020, 8:52:36 PM
    Author     : Fabi Garcia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="container-fluid bg-dark">
    <h1 class="bg-dark text-light">Nuevo Alumno</h1> 
</div>
<p></p>
<form action="Alumnos" method="post">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-body">
                        <form>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label class="bmd-label-floating">Nombre</label>
                                        <input type="text" name="nombre" class="form-control">
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label class="bmd-label-floating">Apellido</label>
                                        <input type="text" name="apellido" class="form-control">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label class="bmd-label-floating">Teléfono</label>
                                        <input type="text" name="telefono" class="form-control">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label class="bmd-label-floating">Correo Electrónico</label>
                                        <input type="text" name="correo" class="form-control">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col">
                                    <div class="form-group">
                                        <label class="col-form-label">Usuario</label>
                                        <select class="js-example-basic-single form-control" name="usuario">
                                            <c:forEach items="${usuarios}" var="usu">
                                                <option value="${usu.getIdUsuario()}">${usu.getNombreUsuario()}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <br>
                            <div class="d-flex justify-content-center">
                                <button type="submit" class="btn btn-outline-primary pull-center"><spam class="fas fa-save"></spam> Guardar</button>
                                &nbsp;&nbsp;&nbsp;
                                <a href="Alumnos?accion=index" class="btn btn-outline-danger pull-center"> Cancelar</a>
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
        $(document).ready(function() {
            $('.js-example-basic-single').select2();
        });
</script>
