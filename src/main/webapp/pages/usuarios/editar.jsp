<%-- 
    Document   : GestionUsuarios
    Created on : Oct 18, 2020, 2:35:16 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="container-fluid bg-dark">
    <h1 class="bg-dark text-light">Editar Usuario</h1> 
</div>
<p></p>
<div class="container-fluid">
    <form method="post" action='Usuarios?accion=editar'>
        <div class="card card-login card-hidden mb-3">
            <div class="card-body">
                <label class="col-sm-2 col-form-label">Nombre completo</label>
                <div class="form-group mt-2">
                    <div class="col-sm-10">
                        <input type="text" name="user" class="form-control" placeholder="Ingrese el nombre de usuario" required value="<c:out value="${usuarios.nombreUsuario}" />">
                    </div>
                </div>
                
               
                <div class="form-group mt-2">
                    <div class="col-sm-10">
                        <label>Rol</label>
                        <select name="rol" id="sexo" class="form-control"> 
                            <option value="Docente" <c:if test="${usuarios.rol eq 'Docente'}">selected</c:if> >Docente</option>
                            <option value="Alumno" <c:if test="${usuarios.rol eq 'Alumno'}">selected</c:if> >Alumno</option>
                        </select>
                    </div>
                </div>
                <div class="d-flex justify-content-center">
                    <button type="submit" class="btn btn-outline-primary pull-center"><spam class="fas fa-save"></spam> Guardar</button>
                    &nbsp;&nbsp;&nbsp;
                    <a href="Usuarios?accion=index" class="btn btn-outline-danger pull-center"><spam class="fas fa-recycle"></spam> Cancelar</a>
                </div>
                <div style="visibility:hidden">
                    <input
                        type="text" name="id"
                        value="<c:out value="${usuarios.idUsuario}" />" visible="false" /> 
                </div>
            </div>
        </div>
    </form>
</div>