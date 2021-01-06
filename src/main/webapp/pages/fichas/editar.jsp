<%-- 
    Document   : GestionUsuarios
    Created on : Oct 18, 2020, 2:35:16 PM
    Author     : User
--%>
<html lang="es">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

    <div class="container-fluid bg-dark">
        <h1 class="bg-dark text-light">Editar Paciente</h1> 
    </div>
    <p></p>
    <div class="container-fluid">
        <form method="post" action='Fichas?accion=editar'>
            <div class="card card-login card-hidden mb-3">
                <div class="card-body">
                    <div class="row col-10">
                        <div class="col">
                            <div class="form-group">
                                <label>Número de Documento</label>
                                <input type="number" name="numerodocumento" class="form-control" placeholder="Ingrese el número de documento" required value="<c:out value="${fichas.nroDocumento}" />">
                            </div>
                        </div>
                    </div>
                    <div class="row col-10">
                        <div class="col">
                            <div class="form-group">
                                <label class="col-form-label">Nombre</label>
                                <input type="text" name="nombre" class="form-control" placeholder="Ingrese el nombre" required value="<c:out value="${fichas.nombre}" />">
                            </div>
                        </div>
                    </div>
                    <div class="row col-10">
                        <div class="col">
                            <div class="form-group">
                                <label class="col-form-label">Apellido</label>
                                <input type="text" name="apellido" class="form-control" placeholder="Ingrese el apellido" required value="${fichas.apellido}">
                            </div>
                        </div>
                    </div>
                    <div class="row col-10">
                        <div class="col-4">
                            <div class="form-group">
                                <label>Fecha de Ingreso</label>
                                <input type="date" name="fechaingreso" class="form-control" required value="<c:out value="${fichas.fechaIngreso}" />">
                            </div>
                        </div>
                        <div class="col-4">
                            <div class="form-group">
                                <label>Sexo</label>
                                <select name="sexo" id="sexo" class="form-control">
                                    <option value="Masculino">Masculino</option>
                                    <option value="Femenino">Femenino</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-4">
                            <div class="form-group">
                                <label>Fecha de Nacimiento</label>
                                <input type="date" name="fechanacimiento" class="form-control" required value="${fichas.fechaNacimiento}" placeholder="dd/MM/yyyy" >

                            </div>
                        </div>
                    </div>
                    <div class="row col-10">
                        <div class="col">
                            <div class="form-group">        
                                <label class="col-form-label">Domicilio</label>
                                <input type="text" name="domicilio" class="form-control" placeholder="Ingrese el domicilio" required value="<c:out value="${fichas.domicilio}" />">
                            </div>
                        </div>
                    </div>
                    <div class="row col-10">
                        <div class="col-6">
                            <div class="form-group">
                                <label>Teléfono</label>
                                <input type="text" name="telefono" class="form-control" placeholder="Ingrese el número de teléfono" required value="<c:out value="${fichas.telefono}" />">
                            </div>
                        </div>
                        <div class="col-6">
                            <div class="form-group">
                                <label>Correo</label>
                                <input type="text" name="correo" class="form-control" placeholder="Ingrese el correo electrónico" required value="<c:out value="${fichas.correo}" />">
                            </div>
                        </div>
                    </div>
                    <div class="row col-10">
                        <div class="col-6">
                            <div class="form-group">
                                <label>Extranjero</label>
                                <select name="extranjero" id="extranjero" class="form-control">
                                    <option value="No">No</option>
                                    <option value="Si">Si</option>
                                </select>
                            </div>
                        </div>
                        <div class="col">
                            <div class="form-group">
                                <label class="col-form-label">Ocupacion</label>
                                <select class="js-example-basic-single form-control" name="ocupacion">
                                    <c:forEach items="${ocupaciones}" var="ocupa">
                                        <option value="${ocupa.getIdOcupacion()}" <c:if test="${fichas.getIdOcupacion() == ocupa.getIdOcupacion()}">selected</c:if> >${ocupa.getDescripcion()}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>  
                    <div class="d-flex justify-content-center">
                        <button type="submit" class="btn btn-outline-primary pull-center"><spam class="fas fa-save"></spam> Guardar</button>
                        &nbsp;&nbsp;&nbsp;
                        <a href="Fichas?accion=index" class="btn btn-outline-danger pull-center"><spam class="fas fa-recycle"></spam> Cancelar</a>
                    </div>
                    <div style="display: none;">
                        <input
                            type="text" name="id"
                            value="<c:out value="${fichas.id}" />" visible="false" /> 
                    </div> 
                </div>
            </div>
        </form>
    </div>
    <script src="./assets/jquery/dist/jquery.min.js" type="text/javascript"></script>
    <script>
        $(document).ready(function () {
            $('.js-example-basic-single').select2();
        });
    </script>
</html>