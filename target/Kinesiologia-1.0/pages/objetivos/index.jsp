<%-- 
    Document   : index.jsp
    Created on : 26 oct 2020, 18:34:49
    Author     : Manu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>

<!-- Content-Wrapper -->
<div class="container-fluid">
    <div class="card-body">
        <div class="card-header">
            <h4 class="text-center">Objetivos</h4>
            
        </div>
        <a href="Objetivos?accion=nuevo"><button type="button" class="btn btn-dark">Nuevo</button></a>
        <table id="usuario" class="table table-striped table-bordered dt-responsive nowrap no-footer">
            <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                    <th>ID Derivacion</th>
                    <th>Descripcion</th>
                    
                    <th colspan=2 class="text-center">Acciones</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${objetivos}" var="objetivo">
                    <tr>
                        <td><c:out value="${objetivo.id}" /></td>
                        <td><c:out value="${objetivo.id_derivacion }" /></td>
                        <td><c:out value="${objetivo.descripcion}" /></td>
                        
                        <td class="text-center"><a class="fas fa-edit text-info" title="Editar" href="Objetivos?accion=editar&id=<c:out value="${objetivo.getId()}"/>"></a>
                            &nbsp;&nbsp;&nbsp;
                            <a class="fas fa-trash text-danger" href="#" title="Eliminar" onclick="confirmDelete('Objetivos?accion=eliminar&id=<c:out value="${objetivo.getId()}"/>');"></a>
                    </tr>
                </c:forEach>
            </tbody>
        </table>                        
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