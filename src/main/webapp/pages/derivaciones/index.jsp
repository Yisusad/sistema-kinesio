<%-- 
    Document   : nuevo
    Created on : Oct 20, 2020, 11:05:16 AM
    Author     : Hernan Grahl
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container-fluid bg-dark">
    <h1 class="bg-dark text-light">Derivaciones</h1> 
</div>
<div class="content" >
    <div class="container-fluid" >
        <div class="row">   
            <div class="col-lg-12">
                <hr/>
                <a class="btn btn-outline-primary" href="Derivaciones?accion=nuevo"><span class="fas fa-plus-circle"></span> &nbsp;&nbsp;Nuevo</a>
                <p></p>
                <div class="card card-plain">
                    <div class="card-body">
                        <div class="table-responsive">
                            <table  id="table" class="table table-striped table-bordered dt-responsive nowrap no-footer">
                                <thead class="text-left">
                                    <tr class= "display">
                                        <th  style="width: 8%;">
                                            C&oacute;digo&nbsp;
                                        </th>
                                        <th style="width: 19%;">
                                            Paciente &nbsp; &nbsp;
                                        </th>
                                        <th style="width: 19%;">
                                            Patolog&iacute;a &nbsp; &nbsp;
                                        </th>
                                        <th style="width: 19%;">
                                            Alumno a Cargo
                                        </th>
                                        <th class="text-center"  style="width: 13%;">
                                            Total Sesiones &nbsp; &nbsp;
                                        </th>
                                        <th class="text-center" style="width: 10%;">
                                            Abona &nbsp; &nbsp;
                                        </th>
                                        <th class="text-center" style="width: 12%;">
                                            Acciones        
                                        </th>
                                    </tr>
                                </thead>
                                <tbody class="text-left">
                                    <c:forEach items = "${derivaciones}" var="derivacion">
                                        <tr class= "display">
                                            <td>
                                                <c:out value="${derivacion.getIdDerivacion()}"/>
                                            </td>
                                            <td>
                                                ${derivacion.getFicha().getNombre()} ${derivacion.getFicha().getApellido()}
                                            </td>
                                            <td>
                                                ${derivacion.getPatologia().getDescripcion()}
                                            </td>
                                            <td>
                                                ${derivacion.getAlumno().getNombre()} ${derivacion.getAlumno().getApellido()}
                                            </td>
                                            <td class="text-center">
                                                ${derivacion.getNumSesiones()}
                                            </td>
                                            <td class="text-center">
                                                ${derivacion.getAbona()}
                                            </td>
                                            <td class="text-center">  
                                                <a class="fas fa-print text-info" title="Imprimir Orden de Pago" href="ControladorInformes?accion=ordenderivacion&idDerivacion=${derivacion.getIdDerivacion()}"></a>
                                                &nbsp;&nbsp;&nbsp;
                                                <a class="fas fa-list text-info" title="Imprimir" href="ControladorInformes?accion=fichakinesica&idDerivacion=${derivacion.getIdDerivacion()}"></a>
                                                &nbsp;&nbsp;&nbsp;
                                                <a class="fas fa-edit text-info" title="Editar" href="Derivaciones?accion=editar&id=${derivacion.getIdDerivacion()}"></a>
                                                &nbsp;&nbsp;&nbsp;
                                                <a class="fas fa-trash text-danger" href="#" title="Eliminar" onclick="confirmDelete('Derivaciones?accion=eliminar&id=<c:out value="${derivacion.getIdDerivacion()}"/>');"></a>
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
    function imprimirOrden(int idDeriva){
        window.open('ControladorInformes?accion=ordenderivacion&idDerivacion='+idDeriva,'hiddenFrame');
    }
</script>