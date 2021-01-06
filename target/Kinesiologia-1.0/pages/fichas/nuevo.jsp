<%-- 
    Document   : nuevo
    Created on : Oct 20, 2020, 7:16:28 PM
    Author     : User
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="container-fluid bg-dark">
    <h1 class="bg-dark text-light">Nuevo Paciente</h1> 
</div>
<p></p>
<div class="container-fluid">
    <form method="post" action='Fichas?accion=nuevo'>
        <div class="card card-login card-hidden mb-3">
            <div class="card-body">
               <div class="row col-10">
                    <div class="col">
                        <div class="form-group">
                            <label>Número de Documento</label>
                            <input type="number" name="numerodocumento" class="form-control" placeholder="Ingrese el número de documento" required>
                        </div>
                    </div>
                </div>
                <div class="row col-10">
                    <div class="col">
                        <div class="form-group">
                            <label class="col-form-label">Nombre</label>
                            <input type="text" name="nombre" class="form-control" placeholder="Ingrese el nombre" required>
                        </div>
                    </div>
                </div>
                <div class="row col-10">
                    <div class="col">
                        <div class="form-group">
                            <label class="col-form-label">Apellido</label>
                            <input type="text" name="apellido" class="form-control" placeholder="Ingrese el apellido" required>
                        </div>
                    </div>
                </div>
                <div class="row col-10">
                    <div class="col-4">
                        <div class="form-group">
                            <label for="fechaingreso">Fecha de Ingreso</label>
                            <input type="date" name="fechaingreso" class="form-control" required>                        
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
                            <input type="date" name="fechanacimiento" class="form-control" required>
                        </div>
                    </div>
                </div>
                <div class="row col-10">
                    <div class="col">
                        <div class="form-group">
                            <label class="col-sm-2 col-form-label">Domicilio</label>
                            <input type="text" name="domicilio" class="form-control" placeholder="Ingrese el domicilio" required>
                        </div>
                    </div>
                </div> 
                <div class="row col-10">
                    <div class="col-6">
                        <div class="form-group">
                            <label>Teléfono</label>
                            <input type="text" name="telefono" class="form-control" placeholder="Ingrese el número de teléfono" required>
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="form-group">
                            <label>Correo</label>
                            <input type="text" name="correo" class="form-control" placeholder="Ingrese el correo electrónico" required>
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
                    <div class="col-6">
                        <div class="form-group">
                            <label class="col-form-label">Ocupacion</label>
                            <select class="js-example-basic-single form-control" name="ocupacion">
                                <c:forEach items="${ocupaciones}" var="ocupa">
                                    <option value="${ocupa.getIdOcupacion()}">${ocupa.getDescripcion()}</option>
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
            </div>
        </div>
    </form>
</div>
<script src="./assets/jquery/dist/jquery.min.js" type="text/javascript"></script>
<script>
        $(document).ready(function() {
            $('.js-example-basic-single').select2();
        });
</script>