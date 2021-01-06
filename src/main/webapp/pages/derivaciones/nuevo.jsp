<%-- 
    Document   : nuevo
    Created on : Oct 20, 2020, 11:05:16 AM
    Author     : Hernan Grahl
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="container-fluid bg-dark text-center">
    <h1 class="bg-dark text-light">Nueva Derivaci&oacute;n</h1> 
</div>
<p></p>
<form action="Derivaciones" method="post">
    <div class="container-fluid">
        <div class="row  justify-content-center  div-derivacion">
            <div class="col-md-12">
                <p></p>
                <div class="card">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="bmd-label-floating">Paciente</label>
                                    <select class="js-example-basic-single" style="width:100%;" id="idFicha" name="idFicha">
                                        <c:forEach items = "${fichas}" var="ficha">
                                            <option value="${ficha.getId()}">${ficha.getNombre()} ${ficha.getApellido()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="col-md-8" style="background-color: #ededed">
                                <div class="row">
                                    <div class="col-4">
                                        <div class="col text-center">
                                            <div class="from-group">
                                                <label for="abona" class="label-info bmd-label-floating">Abona</label>
                                                <br>
                                                <input type="radio" id="abona" name="abona" id="si" value="SI" checked >
                                                <label for="si">Si &nbsp;&nbsp;</label>
                                                <input type="radio" id="noabona" name="abona" id="no" value="NO" >
                                                <label for="no">No&nbsp;&nbsp;</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-8 form-group">
                                        <div class="col-10" >
                                            <div id="divMotivo" style="display: none;">
                                                <label for="motivo" class="control-label align-text-center">Motivo</label>
                                                <input name="motivo" id="motivo" type="text" class="form-control"/>
                                            </div>
                                            <div id="divMonto">
                                                <label for="monto" class="control-label align-text-center">Monto</label>
                                                <input name="monto" id="monto" type="number" value="0" class="form-control text-right"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            

                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="bmd-label-floating">Diagnostico Medico</label>
                                    <textarea type="text" name="diagMed" class="form-control"></textarea>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="bmd-label-floating">Diagnostico Kinesico</label>
                                    <textarea name="diagKine" class="form-control"></textarea>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="bmd-label-floating">Antecedente</label>
                                    <textarea name="antecedente" class="form-control"></textarea>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-2">
                                <div class="form-group">
                                    <label class="bmd-label-floating">Nº de Sesiones</label>
                                    <input type="number" name="numSesiones" required="true" class="form-control text-right" >
                                </div>
                            </div>
                            <div class="col-md-2">
                                <div class="form-group">
                                    <label class="bmd-label-floating">Patologia</label>
                                    <select class="js-example-basic-single" style="width:100%;" id="idPatologia" name="idPatologia">
                                        <c:forEach items = "${patologias}" var="patologia">
                                            <option value="${patologia.getIdPatologia()}">${patologia.getDescripcion()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="bmd-label-floating">Medico que Deriva</label>
                                    <select class="js-example-basic-single" style="width:100%;" id="idMedico" name="idMedico">
                                        <c:forEach items = "${medicos}" var="medico">
                                            <option value="${medico.getIdMedico()}">${medico.getNombre()} ${medico.getApellido()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="bmd-label-floating">Alumno a Cargo</label>
                                    <select class="js-example-basic-single" style="width:100%;" id="idAlumno" name="idAlumno">
                                        <c:forEach items = "${alumnos}" var="alumno">
                                            <option value="${alumno.getIdAlumno()}">${alumno.getNombre()} ${alumno.getApellido()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="d-flex justify-content-center">
                            <button type="submit" class="btn btn-outline-primary pull-center"><spam class="fas fa-save"></spam> Guardar</button>
                            &nbsp;&nbsp;&nbsp;
                            <a href="Derivaciones?accion=index" class="btn btn-outline-danger pull-center">Cancelar</a>
                            <div class="clearfix"></div>
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
        $('#abona').on('click', function(){
            if($("#noabona").is(":checked")){
                $('#divMonto').css('display','none');
                $('#divMotivo').css('display','inline');
                $('#motivo').focus();
            }else {
                $('#divMotivo').css('display','none');
                $('#divMonto').css('display','inline');
                $('#monto').focus();
            }
        });
        $('#noabona').on('click', function(){
            if($("#noabona").is(":checked")){
                $('#divMonto').css('display','none');
                $('#divMotivo').css('display','inline');
                $('#motivo').focus();
            }else {
                $('#divMotivo').css('display','none');
                $('#divMonto').css('display','inline');
                $('#monto').focus();
            }
        });
        
    });
</script>