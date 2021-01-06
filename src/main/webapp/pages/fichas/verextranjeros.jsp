<%-- 
    Document   : GestionUsuarios
    Created on : Oct 18, 2020, 2:35:16 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="container-fluid bg-dark">
    <h1 class="bg-dark text-light">Extranjeros</h1> 
</div>
<p></p>
<div class="content" >
    <div class="container-fluid" >
        <form method="post" action='Fichas?accion=verextranjero'>
        <div class="row">   
            <div class="col-lg-12">
                <hr/>
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
                                        <th class="text-center">Acciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${listarextranjero}" var="ficha">
                                        <tr>
                                            <td>${ficha.nroDocumento}</td>
                                            <td>${ficha.nombre}</td>
                                            <td>${ficha.apellido}</td>
                                            <td class="text-center">${ficha.edad}</td>
                                            <td>${ficha.sexo}</td>
                                            <td>${ficha.telefono}</td>
                                            <td>${ficha.correo}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <form/>
    </div>
</div>
<script src="./assets/jquery/dist/jquery.min.js" type="text/javascript"></script>
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