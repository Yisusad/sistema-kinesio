<%-- 
    Document   : GestionUsuarios
    Created on : Oct 18, 2020, 2:35:16 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="container-fluid bg-dark">
    <h1 class="bg-dark text-light">Cambiar Contraseña</h1> 
</div>
<p></p>
<div class="container-fluid">
    <form method="post" action='Usuarios?accion=cambiarclave' onsubmit="return verificar( )">
        <div class="card card-login card-hidden mb-3">
            <div class="card-body">

                <label class="col-sm-2 col-form-label">Contraseña Actual</label>
                <div class="form-group mt-2">
                    <div class="col-sm-10">
                        <input type="password" name="oldpass" id="oldpass" class="form-control" placeholder="Ingrese la contraseña" required>
                    </div>
                </div>
                <label class="col-sm-2 col-form-label">Nueva Contraseña</label>
                <div class="form-group mt-2">
                    <div class="col-sm-10">
                        <input type="password" name="newpass" id="newpass" class="form-control" placeholder="Ingrese la nueva contraseña" required>
                    </div>
                </div>
                <label class="col-sm-2 col-form-label">Verificación de Contraseña</label>
                <div class="form-group mt-2">
                    <div class="col-sm-10">
                        <input type="password" name="passverif" id="passverif" class="form-control" placeholder="Ingrese la contraseña de nuevo" required>
                    </div>
                </div>

                <div class="d-flex justify-content-center">
                    <button type="submit" class="btn btn-outline-primary pull-center"><spam class="fas fa-save"></spam> Guardar</button>
                    &nbsp;&nbsp;&nbsp;
                    <a href="index.jsp" class="btn btn-outline-danger pull-center"><spam class="fas fa-recycle"></spam> Cancelar</a>
                </div>
                <div style="visibility:hidden">
                    <input
                        type="text" name="id"
                        value="<c:out value="${usuarios.idUsuario}" />" visible="false" /> 
                    <input
                        type="text" name="contravieja" id="contravieja"
                        value="<c:out value="${usuarios.clave}" />" visible="false" /> 
                </div>
            </div>
        </div>
    </form>
</div>
<script>
    function verificar() {
        if ($("#newpass").val().trim() == "") {
            alert("La contraseña no puede estar vacia");
            return false;
        }
        if ($("#newpass").val().trim() != $("#passverif").val().trim()) {
            alert("La contraseñas no coinciden");
            return false;
        }
        if ($("#oldpass").val().trim() != $("#contravieja").val().trim()) {
            alert("Verifique el campo de contraseña actual");
            return false;
        }
        return true;
    }
</script>