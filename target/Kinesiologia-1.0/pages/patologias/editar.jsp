<%-- 
    Document   : nuevo
    Created on : Oct 20, 2020, 11:05:16 AM
    Author     : Hernan Grahl
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container-fluid bg-dark">
    <h1 class="bg-dark text-light">Editar Patolog&iacute;a</h1> 
</div>
<p></p>
<%@ page import="modelos.Patologia" %>
<form action="Patologias" method="post">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="bmd-label-floating">C&oacute;digo</label>
                                    <input type="text" name="id" value="${patologia.getIdPatologia()}" class="form-control" readonly>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label class="bmd-label-floating">Descripci&oacute;n</label>
                                    <input type="text" name="descripcion" required="true" value="${patologia.getDescripcion()}" class="form-control">
                                </div>
                            </div>
                        </div>
                        <div class="d-flex justify-content-center">
                            <button type="submit" class="btn btn-outline-primary pull-center"><spam class="fas fa-save"></spam> Guardar</button>
                            &nbsp;&nbsp;&nbsp;
                            <a href="Patologias?accion=index" class="btn btn-outline-danger pull-center"><spam class="fas fa-recycle"></spam> Cancelar</a>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>