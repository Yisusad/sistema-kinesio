<%-- 
    Document   : nuevo
    Created on : Oct 20, 2020, 7:16:28 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="container-fluid bg-dark">
    <h1 class="bg-dark text-light">Nuevo Usuario</h1> 
</div>
<p></p>
<div class="container-fluid">
    <form method="post" action='Usuarios?accion=nuevo' onsubmit="return verificaClave( )">
        <div class="card card-login card-hidden mb-3">
            <div class="card-body">
                <label class="col-sm-2 col-form-label">Nombre completo</label>
                <div class="form-group mt-2">
                    <div class="col-sm-10">
                        <input type="text" name="user" class="form-control" placeholder="Ingrese el nombre de usuario" required value="<c:out value="${usuarios.nombreUsuario}" />">
                    </div>
                </div>
                <label class="col-sm-2 col-form-label">Contraseña</label>
                <div class="form-group mt-2">
                    <div class="col-sm-10">
                        <input type="password" name="password" id="password" class="form-control" placeholder="Ingrese la contraseña" required>
                    </div>
                </div>
                <label class="col-sm-2 col-form-label">Verificación de Contraseña</label>
                <div class="form-group mt-2">
                    <div class="col-sm-10">
                        <input type="password" name="passverif" id="passverif" class="form-control" placeholder="Ingrese la contraseña de nuevo" required>
                    </div>
                </div>
                <div class="form-group mt-2">
                    <div class="col-sm-10">
                        <label>Rol</label>
                        <select name="rol" id="sexo" class="form-control">
                            <option value="Docente">Docente</option>
                            <option value="Alumno">Alumno</option>
                        </select>
                    </div>
                </div>
                <div class="d-flex justify-content-center">
                    <button type="submit" class="btn btn-outline-primary pull-center"><spam class="fas fa-save"></spam> Guardar</button>
                    &nbsp;&nbsp;&nbsp;
                    <a href="index.jsp" class="btn btn-outline-danger pull-center"><spam class="fas fa-recycle"></spam> Cancelar</a>
                </div>
            </div>
        </div>
    </form>
</div>
<script>
    function verificaClave(){
        if($("#password").val().trim()==""){
            alert("La contraseña no puede estar vacia");
            return false;
        }
        if($("#password").val().trim()!=$("#passverif").val().trim()){
            alert("La contraseñas no coinciden");
            return false;
        }
        return true;
    }
</script>