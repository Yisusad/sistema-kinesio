<%-- 
    Document   : nuevo
    Created on : Oct 20, 2020, 11:05:16 AM
    Author     : Hernan Grahl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="container-fluid bg-dark text-center">
    <h1 class="bg-dark text-light">Editar Derivaci&oacute;n</h1> 
</div>
<%@ page import="modelos.Derivacion" %>
<form action="Derivaciones" method="post">
    <div class="container-fluid">
        <div class="row  justify-content-center  div-derivacion">
            <div class="col-md-12">
                <p></p>
                <div class="card">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-md-2">
                                <div class="form-group">
                                    <label class="bmd-label-floating">Id Derivacion</label>
                                    <input type="text" name="idDerivacion" value="${idDerivacion}" class="form-control" readonly>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="bmd-label-floating">Paciente</label>
                                    <select class="js-example-basic-single" style="width:100%;" id="idFicha" name="idFicha">
                                        <c:forEach items = "${fichas}" var="ficha">
                                            <option value="${ficha.getId()}">${ficha.getNombre()} ${ficha.getApellido()}</option>
                                        </c:forEach>
                                    </select>
                                    <input type="hidden" id="idFichaActual" value="${derivacion.idFicha}">
                                </div>
                            </div>
                            <div class="col-md-6" style="background-color: #ededed">
                                <div class="row">
                                    <div class="col-4">
                                        <div class="col text-center">
                                            <div class="from-group">
                                                <label for="abona" class="label-info bmd-label-floating">Abona</label>
                                                <br>
                                                <input type="radio" id="abona" name="abona" value="SI" ${abona eq 'SI' ? 'checked' : ''} >
                                                <label for="si">Si &nbsp;&nbsp;</label>
                                                <input type="radio" id="noabona" name="abona" value="NO" ${abona eq 'NO' ? 'checked' : ''} >
                                                <label for="no">No&nbsp;&nbsp;</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-8 form-group">
                                        <div class="col-10">
                                            <div id="divMotivo" style="display: none;">
                                                <label for="motivo" class="control-label align-text-center">Motivo</label>
                                                <input name="motivo" type="text" value="${motivo}" class="form-control"/>
                                            </div>
                                            <div id="divMonto">
                                                <label for="monto" class="control-label align-text-center">Monto</label>
                                                <input name="monto" id="monto" type="number" value="${derivacion.monto}" class="form-control text-right"/>
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
                                    <textarea type="text" name="diagMed" class="form-control">${diagMed}</textarea>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="bmd-label-floating">Diagnostico Kinesico</label>
                                    <textarea name="diagKine" class="form-control">${diagKine}</textarea>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="bmd-label-floating">Antecedente</label>
                                    <textarea name="antecedente" class="form-control">${derivacion.antecedente}</textarea>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-2">
                                <div class="form-group">
                                    <label class="bmd-label-floating">Cantidad de Sesiones</label>
                                    <input type="text" name="numSesiones" required="true" class="form-control text-right" value="${numSesiones}">
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
                                    <input type="hidden" id="idPatologiaActual" value="${derivacion.idPato}">
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
                                    <input type="hidden" id="idMedicoActual" value="${derivacion.idMed}">
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
                                    <input type="hidden" id="idAlumnoActual" value="${derivacion.idAlum}">
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
                                <p></p>
        <div class="row  justify-content-center">
            <div class="col-md-10">
                <div class="card" style="border-radius: 25px;">
                    <div class="card-body">
                        <div class="row justify-content-center div-derivacion">
                            <button onclick="return showAntecedentes();" class="btn btn-outline-danger pull-center"><span class="fas fa-eye text-primary"></span>Antecedentes</button>
                            &nbsp;
                            <button onclick="return showObjetivos();" class="btn btn-outline-info pull-center"><span class="fas fa-eye text-primary"></span>&nbsp;&nbsp;Objetivos&nbsp;&nbsp;</button>
                            &nbsp;
                            <button onclick="return showEstados();" class="btn btn-outline-warning pull-center"><span class="fas fa-eye text-primary"></span>&nbsp;&nbsp;&nbsp;Estados&nbsp;&nbsp;&nbsp;</button>
                            &nbsp;
                            <button onclick="return showEstudios();" class="btn btn-outline-dark pull-center"><span class="fas fa-eye text-primary"></span>&nbsp;&nbsp;&nbsp;Estudios&nbsp;&nbsp;&nbsp;</button>
                            &nbsp;
                            <button onclick="return showEvoluciones();" class="btn btn-outline-success pull-center"><span class="fas fa-eye text-primary"></span>&nbsp;Evoluciones</button>
                        </div>
                        <div class="row div-detalles" id="divSlideDown" style="display: none;">
                            <div class="col">
                                <div class="row justify-content-center">
                                    <div class="col-2 text-center">
                                        <button onclick="showDerivaciones();  return false;" class="btn btn-outline-dark pull-center"><span class="fas fa-eye-slash"></span>&nbsp;Ocultar Detalles</button>
                                    </div>
                                </div>
                                <hr/>
                                <div class="row">
                                    <div class="col-5">
                                        <div class="form-group bg-transparent">
                                            <label class="bmd-label-floating">Paciente</label>
                                            <input type="text" required="true" class="form-control" value="${paciente.getNombre()} ${paciente.getApellido()}" readonly>
                                        </div>
                                    </div>
                                    <div class="col-md-5">
                                        <div class="form-group">
                                            <label class="bmd-label-floating">Patolog&iacute;a</label>
                                            <input type="text" value="${patologia.getDescripcion()}" class="form-control" readonly>
                                        </div>
                                    </div>
                                    <div class="col-md-2">
                                        <div class="form-group">
                                            <label class="bmd-label-floating">Sesiones</label>
                                            <input class="form-control" value="${numSesiones}" readonly>
                                        </div>
                                    </div>
                                </div>
                                <div class="row"><div class="col"><hr/></div></div>

                            </div>
                        </div>
                        <div class="row div-detalles" id="divAntecedentes" style="display: none;">
                            <div class="col">
                                <div class="row">
                                    <div class="col-2">
                                        <div class="bt-agregar">
                                            <button onclick="return agregarDetalle();" class="btn btn-outline-primary pull-center"><span class="fas fa-plus-circle"></span>&nbsp;Agregar&nbsp;</button>
                                        </div>
                                    </div>
                                    <div class="col-8 text-center">
                                        <h2>Antecedentes</h2>
                                    </div>
                                    <div class="col-2 text-right">
                                        <Button formaction="ControladorInformes?informe=antecedentes&idDevicacion=${idDerivacion}" class="btn link" type="submit" formmethod="post" ><span class="fas fa-print"></span>&nbsp; Listar</Button>
                                    </div>
                                </div>
                                <div class="row div-agregar" style="display: none;">
                                    <div class="col">
                                        <div style="background-color: papayawhip;">
                                            <form action="DetalleDerivacion?accion=antecedente" method="post" name="DetalleAntecedente">
                                                <div class="row">
                                                    <div class="col-5">
                                                        <div class="form-group">
                                                            <label class="bmd-label-floating">Antecedente</label>
                                                            <select class="js-example-basic-single" style="width:100%;" id="idAntecedente" name="idAntecedente">
                                                                <c:forEach items ="${antecedentes}" var="antecedente">
                                                                    <option value="${antecedente.getIdAntecedente()}">${antecedente.getDescripcion()}</option>
                                                                </c:forEach>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <div class="col-2">
                                                        <label style="width: 100%;">&nbsp;</label>
                                                        <button formaction="DetalleDerivacion?accion=antecedente" type="submit" class="btn btn-outline-primary pull-center">Agregar</button>
                                                    </div>
                                                    <input type="hidden" name="idDerivacion" value="${idDerivacion}">
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col">
                                        <table  id="table" class="table table-striped table-bordered dt-responsive nowrap no-footer">
                                            <thead>
                                                <tr>
                                                    <th>
                                                        C&oacute;digo&nbsp;
                                                    </th>
                                                    <th>
                                                        Descripcion&nbsp; &nbsp;
                                                    </th>
                                                    <th class="text-center">
                                                        Acciones        
                                                    </th>
                                                </tr>
                                            </thead>
                                            <tbody class="text-left">
                                                <c:forEach items = "${antecedentesD}" var="antecedente">
                                                    <tr class= "display">
                                                        <td>
                                                            <c:out value="${antecedente.getIdAntecedente()}"/>
                                                        </td>
                                                        <td>
                                                            <c:out value="${antecedente.getDescripcion()}"/>
                                                        </td>
                                                        <td class="text-center">                                                              
                                                            <a class="fas fa-trash text-danger" href="#" title="Eliminar" onclick="confirmDelete('Derivaciones?accion=eliminarantecedente&idderi=${derivacion.getIdDerivacion()}&idant=${antecedente.getIdAntecedente()}');"></a>
                                                        </td> 
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row div-detalles" id="divObjetivos" style="display: none;">
                             <div class="col">
                                <div class="row">
                                    <div class="col-2">
                                        <div class="bt-agregar">
                                            <button onclick="return agregarDetalle();" class="btn btn-outline-primary pull-center"><span class="fas fa-plus-circle"></span>&nbsp;Agregar&nbsp;</button>
                                        </div>
                                    </div>
                                    <div class="col-8 text-center">
                                        <h2>Objetivos</h2>
                                    </div>
                                    <div class="col-2"></div>
                                </div>
                                <p></p>
                                <div class="row div-agregar" style="display: none;">
                                    <div class="col">
                                        <div style="background-color: papayawhip;">
                                            <form action="DetalleDerivacion?accion=objetivo" method="post" name="DetalleObjetivo">
                                                <div class="row">
                                                    <div class="col-6">
                                                        <div class="form-group">
                                                            <label class="bmd-label-floating">Objetivo</label>
                                                            <textarea name="descripcion" style="width: 100%;"></textarea>
                                                        </div>
                                                    </div>
                                                    <div class="col-2">
                                                        <label style="width: 100%;">&nbsp;</label>
                                                        <button formaction="DetalleDerivacion?accion=objetivo" type="submit" class="btn btn-outline-primary pull-center">Agregar</button>
                                                    </div>
                                                    <input type="hidden" name="idDerivacion" value="${idDerivacion}">
                                                </div>
                                           </form>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col">
                                        <table  id="table" class="table table-striped table-bordered dt-responsive nowrap no-footer">
                                            <thead>
                                                <tr>
                                                    <th>
                                                        C&oacute;digo&nbsp;
                                                    </th>
                                                    <th>
                                                        Descripcion&nbsp; &nbsp;
                                                    </th>
                                                    <th class="text-center">
                                                        Acciones        
                                                    </th>
                                                </tr>
                                            </thead>
                                            <tbody class="text-left">
                                                <c:forEach items = "${objetivos}" var="objetivo">
                                                    <tr class= "display">
                                                        <td>
                                                            <c:out value="${objetivo.getIdObjetivo()}"/>
                                                        </td>
                                                        <td>
                                                            <c:out value="${objetivo.getDescripcion()}"/>
                                                        </td>
                                                        <td class="text-center">                                                            
                                                            <a class="fas fa-trash text-danger" href="#" title="Eliminar" onclick="confirmDelete('Derivaciones?accion=eliminarobjetivo&idobj=${objetivo.getIdObjetivo()}');"></a>
                                                        </td> 
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row justify-content-center div-detalles" id="divEstados" style="display: none;">
                             <div class="col">
                                <div class="row">
                                    <div class="col-2">
                                        <div class="bt-agregar">
                                            <button onclick="return agregarDetalle();" class="btn btn-outline-primary pull-center"><span class="fas fa-plus-circle"></span>&nbsp;Agregar&nbsp;</button>
                                        </div>
                                    </div>
                                    <div class="col-8 text-center">
                                        <h2>Estados</h2>
                                    </div>
                                    <div class="col-2 text-right">
                                        <Button formaction="ControladorInformes?informe=estados&idDevicacion=${idDerivacion}" class="btn link" type="submit" formmethod="post" ><span class="fas fa-print"></span>&nbsp; Listar</Button>
                                    </div>
                                </div>
                                <div class="row div-agregar" style="display: none;">
                                    <div class="col">
                                        <div style="background-color: papayawhip;">
                                            <form action="DetalleDerivacion?accion=estado" method="post" name="DetalleEstado">
                                                <div class="row">
                                                    <div class="col-4">
                                                        <div class="form-group">
                                                            <label class="bmd-label-floating">Antecedente</label>
                                                            <select class="js-example-basic-single" style="width:100%;" id="idAntecedente" name="idEstado">
                                                                <c:forEach items ="${estados}" var="estado">
                                                                    <option value="${estado.getIdEstado()}">${estado.getDescripcion()}</option>
                                                                </c:forEach>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <div class="col-5">
                                                        <div class="form-group">
                                                            <label class="bmd-label-floating">Comentarios</label>
                                                            <textarea name="descripcion" style="width: 100%;"></textarea>
                                                        </div>
                                                    </div>
                                                    <div class="col-2">
                                                        <label style="width: 100%;">&nbsp;</label>
                                                        <button formaction="DetalleDerivacion?accion=estado" type="submit" class="btn btn-outline-primary pull-center">Agregar</button>
                                                    </div>
                                                    <input type="hidden" name="idDerivacion" value="${idDerivacion}">
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col">
                                        <table  id="table" class="table table-striped table-bordered dt-responsive nowrap no-footer">
                                            <thead>
                                                <tr>
                                                    <th style="width: 10%;">
                                                        C&oacute;digo&nbsp;
                                                    </th>
                                                    <th style="width: 30%;">
                                                        Estado&nbsp; &nbsp;
                                                    </th>
                                                    <th style="width: 50%;">
                                                        Comentarios&nbsp; &nbsp;
                                                    </th>
                                                    <th class="text-center" style="width: 10%;">
                                                        Acciones        
                                                    </th>
                                                </tr>
                                            </thead>
                                            <tbody class="text-left">
                                                <tr class= "display">
                                                    <c:forEach items = "${estadosD}" var="estado">
                                                        <td>
                                                            <c:out value="${estado.getIdEstado()}"/>
                                                        </td>
                                                        <td>
                                                            <c:out value="${estado.getDescripcion()}"/>
                                                        </td>
                                                        <td>
                                                            <c:out value="${estado.getDescripcionEstado()}"/>
                                                        </td>
                                                        <td class="text-center">                                                            
                                                            <a class="fas fa-trash text-danger" href="#" title="Eliminar" onclick="confirmDelete('Derivaciones?accion=eliminarestado&idderi=${derivacion.getIdDerivacion()}&idestado=${estado.getIdEstado()}');"></a>
                                                        </td> 
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row justify-content-center div-detalles" id="divEstudios" style="display: none;">
                             <div class="col">
                                <div class="row">
                                    <div class="col-2">
                                        <div class="bt-agregar">
                                            <button onclick="return agregarDetalle();" class="btn btn-outline-primary pull-center"><span class="fas fa-plus-circle"></span>&nbsp;Agregar&nbsp;</button>
                                        </div>
                                    </div>
                                    <div class="col-8 text-center">
                                        <h2>Estudios</h2>
                                    </div>
                                    <div class="col-2 text-right">
                                        <Button formaction="ControladorInformes?informe=estudios&idDevicacion=${idDerivacion}" class="btn link" type="submit" formmethod="post" ><span class="fas fa-print"></span>&nbsp; Listar</Button>
                                    </div>
                                </div>
                                <div class="row div-agregar" style="display: none;">
                                    <div class="col">
                                        <div style="background-color: papayawhip;">
                                            <form action="DetalleDerivacion?accion=estudio" method="post" name="DetalleEstudio">
                                                <div class="row">
                                                    <div class="col-4">
                                                        
                                                        <div class="form-group">
                                                            <label class="bmd-label-floating">Estudio</label>
                                                            <select class="form-control js-example-basic-single" style="width:100%;" id="idEstudio" name="idEstudio">
                                                                <c:forEach items ="${estudios}" var="estudio">
                                                                    <option value="${estudio.getIdEstudio()}">${estudio.getDescripcion()}</option>
                                                                </c:forEach>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <div class="col-2">
                                                        <div class="form-group">
                                                            <label class="bmd-label-floating">Fecha</label>
                                                            <input type="text"  name="fecha" id="fecha" placeholder="dd/MM/aaaa">
                                                        </div>
                                                    </div>
                                                    <div class="col-4">
                                                        <div class="form-group">
                                                            <label class="bmd-label-floating">Comentarios</label>
                                                            <textarea name="descripcion" style="width: 100%;"></textarea>
                                                        </div>
                                                    </div>
                                                    <div class="col-2">
                                                        <label style="width: 100%;">&nbsp;</label>
                                                        <button formaction="DetalleDerivacion?accion=estudio" type="submit" class="btn btn-outline-primary pull-center">Agregar</button>
                                                    </div>
                                                    <input type="hidden" name="idDerivacion" value="${idDerivacion}">
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                                <p></p>
                                <div class="row">
                                    <div class="col">
                                        <table  id="table" class="table table-striped table-bordered dt-responsive nowrap no-footer">
                                            <thead>
                                                <tr>
                                                    <th style="width: 10%;">
                                                        C&oacute;digo&nbsp;
                                                    </th>
                                                    <th style="width: 30%;">
                                                        Estudio&nbsp; &nbsp;
                                                    </th>
                                                    <th style="width: 50%;">
                                                        Resultado&nbsp; &nbsp;
                                                    </th>
                                                    <th class="text-center" style="width: 10%;">
                                                        Acciones        
                                                    </th>
                                                </tr>
                                            </thead>
                                            <tbody class="text-left">
                                                <c:forEach items = "${estudiosD}" var="estudio">
                                                    <tr class= "display">
                                                        <td>
                                                            <c:out value="${estudio.getIdEstudio()}"/>
                                                        </td>
                                                        <td>
                                                            <c:out value="${estudio.getDescripcion()}"/>
                                                        </td>
                                                        <td>
                                                            <c:out value="${estudio.getResultado()}"/>
                                                        </td>
                                                        <td class="text-center">                                                              
                                                            <a class="fas fa-trash text-danger" href="#" title="Eliminar" onclick="confirmDelete('Derivaciones?accion=eliminarestudio&idderi=${derivacion.getIdDerivacion()}&idestudio=${estudio.getIdEstudio()}');"></a>
                                                        </td> 
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row justify-content-center div-detalles" id="divEvoluciones" style="display: none;">
                             <div class="col">
                                <div class="row">
                                    <div class="col">
                                        <a href="DetalleDerivacion?accion=agregarevolucion&idDerivacion=${idDerivacion}" class="btn btn-outline-primary pull-center">
                                            <span class="fas fa-plus-circle"></span>
                                            &nbsp;Agregar
                                        </a>
                                    </div>
                                    <div class="col-8 text-center">
                                        <h2>Evoluciones</h2>
                                    </div>
                                    <div class="col-2 text-right">
                                        <Button formaction="ControladorInformes?informe=evoluciones&idDevicacion=${idDerivacion}" class="btn link" type="submit" formmethod="post" ><span class="fas fa-print"></span>&nbsp; Listar</Button>
                                    </div>
                                </div>
                                <p></p>
                                <div class="row">
                                    <div class="col">
                                        <table  id="table" class="table table-striped table-bordered dt-responsive nowrap no-footer">
                                            <thead>
                                                <tr>
                                                    <th>
                                                        C&oacute;digo&nbsp;
                                                    </th>
                                                    <th>Fecha</th>
                                                    <th>
                                                        Evaluacion&oacute;n
                                                    </th>
                                                    <th class="text-center">
                                                        Acciones        
                                                    </th>
                                                </tr>
                                            </thead>
                                            <tbody class="text-left">
                                                <c:forEach items = "${evoluciones}" var="evolucion">
                                                    <tr class= "display">
                                                        <td>
                                                            <c:out value="${evolucion.getIdEvolucion()}"/>
                                                        </td>
                                                        <td>
                                                            <c:out value="${evolucion.getFechaEvaluacion()}"/>
                                                        </td>
                                                        <td>
                                                            <c:if test="${evolucion.getFisioterapia() != null}">
                                                                <b>Fisioterapia:</b> <c:out value="${evolucion.getFisioterapia()}"/>
                                                            </c:if>
                                                            <c:if test="${evolucion.getKinefilaxia() != null}">
                                                                <b>Kinefilaxia: </b><c:out value="${evolucion.getKinefilaxia()}"/>
                                                            </c:if>
                                                            <c:if test="${evolucion.getKinesioterapia() != null}">
                                                                <b>Kinesioterapia: </b><c:out value="${evolucion.getKinesioterapia()}"/>
                                                            </c:if>
                                                        </td>
                                                        <td class="text-center">
                                                            <a class="fas fa-print text-info" title="Imprimir Orden de Pago" href="ControladorInformes?accion=ordenevolucion&idEvolucion=${evolucion.getIdEvolucion()}"></a>
                                                            &nbsp;&nbsp;&nbsp;
                                                            <a class="fas fa-edit text-info" title="Editar" href="DetalleDerivacion?accion=editarevolucion&idEvolucion=${evolucion.getIdEvolucion()}&idDerivacion=${derivacion.getIdDerivacion()}"></a>
                                                            &nbsp;&nbsp;&nbsp;
                                                            <a class="fas fa-trash text-danger" href="#" title="Eliminar" onclick="confirmDelete('Derivaciones?accion=eliminarevolucion&idevo=${evolucion.getIdEvolucion()}')"></a>
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
        </div>
    </div>
</form>
<script>
    $(document).ready(function () {
        if($("#imprimir").val().trim() != ""){
            window.open('ControladorInformes?accion=ordenderivacion&idDerivacion='+$('#imprimir').val(),'hiddenFrame');
        }
        $('.js-example-basic-single').select2();
        $('#idFicha').select2("val",$("#idFichaActual").val());
        $('#idAlumno').select2("val",$("#idAlumnoActual").val());
        $('#idPatologia').select2("val",$("#idPatologiaActual").val());
        $('#idMedico').select2("val",$("#idMedicoActual").val());
        
        $('#abona').on('click', function(){
            abona();
        });
        $('#noabona').on('click', function(){
            abona();
        });
        
        
        $("#fecha").datepicker({ dateFormat: 'dd/mm/yy',
            changeMonth: true,
            changeYear: true,
            numberOfMonths: 1,
            dayNamesMin: ['Do', 'Lu', 'Ma', 'Mi', 'Ju', 'Vi', 'Sa'],
            monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo',
                'Junio', 'Julio', 'Agosto', 'Septiembre',
                'Octubre', 'Noviembre', 'Diciembre'],
            monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr',
                'May', 'Jun', 'Jul', 'Ago',
                'Sep', 'Oct', 'Nov', 'Dic'],
            beforeShowDay: function (day) {
                day = day.getDay();
                if (day == 0) {
                    return [false, "somecssclass"]
                } else {
                    return [true, "someothercssclass"]
                }
            }, onSelect: function () { $("#btnVerificar").focus(); }
        });
        abona();
    });
    function showDerivaciones() {
        $('.div-detalles').slideUp();
        $('.div-derivacion').slideDown();
        $('#divSlideDown').slideUp();
        return false;
    }
    function hide() {
        $('.div-derivacion').slideUp();
        $('.div-detalles').slideUp();
        cancelarAgregarDetalle();
    }
    function showAntecedentes() {
        hide();
        $('#divAntecedentes').slideDown();
        $('#divSlideDown').slideDown();
        return false;
    }
    function showObjetivos() {
        hide();
        $('#divObjetivos').slideDown();
        $('#divSlideDown').slideDown();
        return false;
    }
    function showEstados() {
        hide();
        $('#divEstados').slideDown();
        $('#divSlideDown').slideDown();
        return false;
    }
    function showEstudios() {
        hide();
        $('#divEstudios').slideDown();
        $('#divSlideDown').slideDown();
        return false;
    }
    function showEvoluciones() {
        hide();
        $('#divEvoluciones').slideDown();
        $('#divSlideDown').slideDown();
        return false;
    }
    function agregarDetalle(){
        $('.bt-agregar').slideUp();
        $('.div-agregar').slideDown();
        return false;
    }
    function cancelarAgregarDetalle(){
        $('.bt-agregar').slideDown();
        $('.div-agregar').slideUp();
        return false;
    }
    function abona(){
        if($("#abona").is(":checked")){
            $('#divMotivo').css('display','none');
            $('#divMonto').css('display','inline');
            $('#monto').focus();
        }else {
            $('#divMonto').css('display','none');
            $('#divMotivo').css('display','inline');
            $('#motivo').focus();
        }
    }
</script>
<c:if test="${sender eq 'antecedente'}">
    <script>
        $(document).ready(function(){
           showAntecedentes();
        });
    </script>
</c:if>
<c:if test="${sender eq 'estado'}">
    <script>
        $(document).ready(function(){
           showEstados();
        });
    </script>
</c:if>
<c:if test="${sender eq 'estudio'}">
    <script>
        $(document).ready(function(){
           showEstudios();
        });
    </script>
</c:if>
<c:if test="${sender eq 'objetivo'}">
    <script>
        $(document).ready(function(){
           showObjetivos();
        });
    </script>
</c:if>
<c:if test="${sender eq 'evolucion'}">
    <script>
        $(document).ready(function(){
           showEvolucion();
        });
    </script>
</c:if>