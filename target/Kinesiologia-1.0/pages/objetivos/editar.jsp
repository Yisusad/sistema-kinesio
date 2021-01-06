<%-- 
    Document   : editar
    Created on : 26 oct 2020, 18:35:44
    Author     : Manu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- Contenido -->
<div class="container-fluid">
    <form method="post" action='Objetivos?accion=editar'>
        <div class="card card-login card-hidden mb-3">
            <div class="card-body">
                <div class="card-header text-left">
                    <h4 class="card-title"><strong>Actualizar Objetivos</strong></h4>
                </div>
                
                <div class="row col-10">
                    <div class="col">
                        <div class="form-group">
                            <label class="col-form-label">Descripcion</label>
                            <input type="text" name="descripcion" class="form-control" placeholder="Ingrese la descripcion" required value="<c:out value="${objetivo.descripcion}" />">
                        </div>
                    </div>
                </div>
                
            
                <div class="col-10 text-center">
                    <button type="submit" name="accion" value="editar" class="btn btn-primary">Editar</button>
                </div>
                 
            </div>
        </div>
    </form>
</div>