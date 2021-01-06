<%-- 
    Document   : nuevo
    Created on : Oct 20, 2020, 11:05:16 AM
    Author     : Hernan Grahl
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="container-fluid bg-dark justify-content-center">
    <h1 class="bg-dark text-light">Agregar Estudio </h1> 
</div>
<p></p>
<form action="DetalleDerivacion?accion=estudio" method="post">
    <div class="container-fluid">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-body">
                        <div class="row">
                            <div class="col">
                                <div class="form-group">
                                    <label class="bmd-label-floating">Estudio</label>
                                    <select class="js-example-basic-single" style="width:100%;" id="estudios" name="estudios">
                                        <c:forEach items = "${estudios}" var="estudio">
                                            <option value="${estudio.getIdEstudio()}">${estudio.getDescripcion()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col">
                                <div class="form-group">
                                    <label for="descripcion" class="bmd-label-floating">Resultado</label>
                                    <textarea id="descripcion" class="form-control" name="descripcion"></textarea>
                                </div>
                            </div>
                        </div>
                        <br>
                        <div class="d-flex justify-content-center">
                            <button type="submit" class="btn btn-outline-primary pull-center"><spam class="fas fa-save"></spam> Guardar</button>
                            &nbsp;&nbsp;&nbsp;
                            <a class="btn btn-outline-danger" title="Editar" href='Derivaciones?accion=editar&id=${derivacion.getIdDerivacion()}'>Cancelar</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
<script>
        $(document).ready(function() {
            $('.js-example-basic-single').select2();
        });
</script>