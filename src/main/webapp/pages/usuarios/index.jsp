<%-- 
    Document   : GestionUsuarios
    Created on : Oct 18, 2020, 2:35:16 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<div class="container-fluid bg-dark">
    <h1 class="bg-dark text-light">Usuarios</h1> 
</div>
<div class="content" >
    <div class="container-fluid" >
        <div class="row">   
            <div class="col-lg-12">
                <hr/>
                <a class="btn btn-outline-primary" href="Usuarios?accion=nuevo"><span class="fas fa-plus-circle"></span> &nbsp;&nbsp;Nuevo</a>
                <p></p>
                <div class="card card-plain">
                    <div class="card-body">
                        <div class="table-responsive">
                            <table id="table" class="table table-striped table-bordered dt-responsive nowrap no-footer">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Nombre de Usuario</th>
                                        <th>Rol</th>
                                        <th>Estado</th>
                                        <th class="text-center">Acciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${usuarios}" var="usuario">
                                        <tr>
                                            <td><c:out value="${usuario.idUsuario}" /></td>
                                            <td><c:out value="${usuario.nombreUsuario}" /></td>
                                            <td><c:out value="${usuario.rol}" /></td>
                                            <td><c:out value="${usuario.estado == 0 ? 'Activo': 'Inactivo'}" /></td>
                                            <td class="text-center">
                                                <a class="fas fa-edit text-info" title="Editar" href="Usuarios?accion=editar&id=<c:out value="${usuario.getIdUsuario()}"/>"></a>
                                                &nbsp;&nbsp;&nbsp;
                                                <a class="fas fa-trash text-danger" href="#" title="Eliminar" onclick="confirmDelete('Usuarios?accion=eliminar&id=<c:out value="${usuario.getIdUsuario()}"/>');"></a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table> 
                            <script>
                                $(document).ready(function () {
                                    $('#tabla').DataTable({
                                        "serverSide": true,
                                        "processing": true
                                    });
                                });
                            </script>
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