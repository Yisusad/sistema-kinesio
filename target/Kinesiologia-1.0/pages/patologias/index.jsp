<%-- 
    Document   : nuevo
    Created on : Oct 20, 2020, 11:05:16 AM
    Author     : Hernan Grahl
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container-fluid bg-dark">
    <h1 class="bg-dark text-light">Patolog&iacute;as</h1> 
</div>
<div class="content" >
    <div class="container-fluid" >
        <div class="row">   
            <div class="col-lg-12">
                <hr/>
                <a class="btn btn-outline-primary" href="Patologias?accion=nuevo"><span class="fas fa-plus-circle"></span> &nbsp;&nbsp;Nuevo</a>
                <p></p>
                <div class="card card-plain">
                    <div class="card-body">
                        <div class="table-responsive">
                            <table  id="table" class="table table-striped table-bordered dt-responsive nowrap no-footer">
                                <thead >
                                    <tr>
                                        <th>
                                            C&oacute;digo&nbsp;
                                        </th>
                                        <th>
                                            Descripci&oacute;n &nbsp; &nbsp;
                                        </th>
                                        <th class="text-center">
                                            Acciones        
                                        </th>
                                    </tr>
                                </thead>
                                <tbody class="text-left">
                                    <c:forEach items = "${patologias}" var="patologia">
                                        <tr class= "display">
                                            <td>
                                                <c:out value="${patologia.getIdPatologia()}"/>
                                            </td>
                                            <td>
                                                <c:out value="${patologia.getDescripcion()}"/>
                                            </td>
                                            <td class="text-center">  
                                                <a class="fas fa-edit text-info" title="Editar" href="Patologias?accion=editar&id=<c:out value="${patologia.getIdPatologia()}"/>"></a>
                                                &nbsp;&nbsp;&nbsp;
                                                <a class="fas fa-trash text-danger" href="#" title="Eliminar" onclick="confirmDelete('Patologias?accion=eliminar&id=<c:out value="${patologia.getIdPatologia()}"/>');"></a>
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