<%-- 
    Document   : GestionUsuarios
    Created on : Oct 18, 2020, 2:35:16 PM
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container-fluid bg-dark">
    <h1 class="bg-dark text-light">Pacientes</h1> 
</div>
<div class="content" >
    <div class="container-fluid" >
        <div class="row">   
            <div class="col-lg-12">
                <hr/>
                <a class="btn btn-outline-primary" href="Fichas?accion=nuevo"><span class="fas fa-plus-circle"></span> &nbsp;&nbsp;Nuevo</a>
                <a class="fas fa-eye text-danger" href="Fichas?accion=verextranjero" title="Ver Extranjeros"></a>
                <a class="fas fa-list text-info" title="Listar Pacientes" href="ControladorInformes?accion=fichapacientes&idFicha=${ficha.getIdFicha()}"></a>
                
                <p></p>
                <div class="card card-plain">
                    <div class="card-body">
                        <div class="table-responsive">
                            <table id="table" class="table table-striped table-bordered dt-responsive nowrap no-footer">
                                <thead>
                                    <tr>
                                        <th style="width: 10%;">Documento</th>
                                        <th style="width: 20%;">Nombre</th>
                                        <th style="width: 20%;">Apellido</th>
                                        <th class="text-center" style="width: 10%;">Edad</th>
                                        <th style="width: 10%;">Sexo</th>
                                        <th style="width: 15%;">Telefono</th>
                                        <th style="width: 15%;">Correo</th>
                                        <th style="width: 10%;">Extranjero</th>
                                        <th class="text-center">Acciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${fichas}" var="ficha">
                                        <tr>
                                            <td>${ficha.nroDocumento}</td>
                                            <td>${ficha.nombre}</td>
                                            <td>${ficha.apellido}</td>
                                            <td class="text-center">${ficha.edad}</td>
                                            <td>${ficha.sexo}</td>
                                            <td>${ficha.telefono}</td>
                                            <td>${ficha.correo}</td>
                                            <td>${ficha.extranjero}</td>
                                            <td class="text-center">
                                                <a class="fas fa-edit text-info" title="Editar" href="Fichas?accion=editar&id=${ficha.getId()}"></a>             
                                                
                                                <a class="fas fa-trash text-danger" href="#" title="Eliminar" onclick="confirmDelete('Fichas?accion=eliminar&id=${ficha.getId()}');"></a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    $(document).ready(function(){
        $("#table").DataTable({
            language: {
                search: "",
                zeroRecords: "No se encontraron resultados.",
                lengthMenu: "",
                emptyTable: "No hay datos disponibles.",
                info: "Desde _START_ hasta _END_ de _TOTAL_ entradas",
                infoEmpty: " ",
                infoFiltered: "(filtradas de _MAX_ entradas totales)",
                paginate: {
                    first: "Primero",
                    last: "Ultimo",
                    next: "Siguiente",
                    previous: "Anterior"
                }
            }
        });
    });
</script>