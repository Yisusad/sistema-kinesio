<%-- 
    Document   : Home
    Created on : 10-oct-2020, 0:00:25
    Author     : NeloGrahl
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container-fluid bg-dark">
    <h1 class="bg-dark text-light">Alumnos</h1> 
</div>

<!-- Contenido -->
<div class="content" >
    <div class="container-fluid" >
        <div class="row">   
            <div class="col-lg-12">
                <hr/>
                <a class="btn btn-outline-primary" href="Alumnos?accion=nuevo"><span class="fas fa-plus-circle"></span> &nbsp;&nbsp;Nuevo</a>
                <p></p>
                <div class="card card-plain">
                    <div class="card-body">
                        <div class="table-responsive">
                            <table  id="table" class="table table-striped table-bordered dt-responsive nowrap no-footer">
                                <thead>
                                    <tr class= "display">
                                        <th>
                                            ID &nbsp &nbsp
                                        </th>
                                        <th>
                                            Nombre &nbsp &nbsp
                                        </th>
                                        <th>
                                            Apellido &nbsp &nbsp
                                        </th>
                                        <th>
                                            Teléfono &nbsp &nbsp
                                        </th>
                                        <th>
                                            e-mail &nbsp &nbsp
                                        </th>
                                        <th>
                                            Usuario &nbsp &nbsp
                                        </th>
                                        <th class="text-center">
                                            Acciones        
                                        </th>

                                    </tr>
                                </thead>
                                <tbody class="text-left">
                                    <c:forEach items = "${alumnos}" var="alumno">
                                        <tr class= "display">
                                            <td>
                                                <c:out value="${alumno.getIdAlumno()}"/>
                                            </td>
                                            <td>
                                                <c:out value="${alumno.getNombre()}"/>
                                            </td>
                                            <td>  
                                                <c:out value="${alumno.getApellido()}"/>
                                            </td>
                                            <td>  
                                                <c:out value="${alumno.getTelefono()}"/>
                                            </td>
                                            <td>  
                                                <c:out value="${alumno.getCorreo()}"/>
                                            </td>
                                            <td>  
                                                <c:out value="${alumno.getNombreUsuario()}"/>
                                            </td> 
                                            <td class="text-center">  
                                                <a class="fas fa-edit text-info" href="Alumnos?accion=editar&id=<c:out value="${alumno.getIdAlumno()}"/>"></a>
                                                &nbsp;&nbsp;&nbsp;
                                                <a class="fas fa-trash text-danger" href="#" title="Eliminar" onclick="confirmDelete('Alumnos?accion=eliminar&id=<c:out value="${alumno.getIdAlumno()}"/>');"></a>
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