<%-- 
    Document   : Home
    Created on : 10-oct-2020, 0:00:25
    Author     : NeloGrahl
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<% request.setAttribute("action", request.getParameter("page"));%>
<c:choose>
    <%-- Rutas de Usuarios --%>
    <c:when test="${action eq 'usuarios'}">
        <jsp:include page="pages/usuarios/index.jsp" />    
    </c:when>
    <c:when test="${action eq 'nuevousuario'}">
        <jsp:include page="pages/usuarios/nuevo.jsp" />    
    </c:when>
    <c:when test="${action eq 'editarusuario'}">
        <jsp:include page="pages/usuarios/editar.jsp" />    
    </c:when>
    <c:when test="${action eq 'cambiarclave'}">
        <jsp:include page="pages/usuarios/cambiarclave.jsp" />    
    </c:when>

    <%-- Rutas de Alumnos --%>
    <c:when test="${action eq 'alumnos'}">
        <jsp:include page="pages/alumnos/index.jsp" />
    </c:when>
    <c:when test="${action eq 'nuevoalumno'}">
        <jsp:include page="pages/alumnos/nuevo.jsp" />
    </c:when>
    <c:when test="${action eq 'editaralumno'}">
        <jsp:include page="pages/alumnos/editar.jsp" />
    </c:when>
    
     <%-- Rutas de Derivaciones --%>
    <c:when test="${action eq 'derivaciones'}">
        <jsp:include page="pages/derivaciones/index.jsp" />
    </c:when>
    <c:when test="${action eq 'nuevaderivacion'}">
        <jsp:include page="pages/derivaciones/nuevo.jsp" />
    </c:when>
    <c:when test="${action eq 'editarderivacion'}">
        <jsp:include page="pages/derivaciones/editar.jsp" />
    </c:when>
    <c:when test="${action eq 'agregarestado'}">
        <jsp:include page="pages/derivaciones/agregarestado.jsp" />
    </c:when>
    <c:when test="${action eq 'agregarestudio'}">
        <jsp:include page="pages/derivaciones/agregarestudio.jsp" />
    </c:when>
    <c:when test="${action eq 'agregarevolucion'}">
        <jsp:include page="pages/derivaciones/agregarevolucion.jsp" />
    </c:when>
    <c:when test="${action eq 'editarevolucion'}">
        <jsp:include page="pages/derivaciones/editarevolucion.jsp" />
    </c:when>
    <c:when test="${action eq 'agregarantecedente'}">
        <jsp:include page="pages/derivaciones/agregarantecedente.jsp" />
    </c:when>
    <c:when test="${action eq 'agregarobjetivo'}">
        <jsp:include page="pages/derivaciones/agregarobjetivo.jsp" />
    </c:when>
    

    <%-- Rutas de Pacientes --%>
    <c:when test="${action eq 'pacientes'}">
        <jsp:include page="pages/pacientes/index.jsp" />
    </c:when>
    <c:when test="${action eq 'nuevopaciente'}">
        <jsp:include page="pages/pacientes/nuevo.jsp" />
    </c:when>
    <c:when test="${action eq 'editarpaciente'}">
        <jsp:include page="pages/pacientes/editar.jsp" />
    </c:when>

    <%-- Rutas de Antecedentes --%>
    <c:when test="${action eq 'antecedentes'}">
        <jsp:include page="pages/antecedentes/index.jsp" />
    </c:when>
    <c:when test="${action eq 'nuevoantecedente'}">
        <jsp:include page="pages/antecedentes/nuevo.jsp" />
    </c:when>
    <c:when test="${action eq 'editarantecedente'}">
        <jsp:include page="pages/antecedentes/editar.jsp" />
    </c:when>
    
    <%-- Rutas de Estados --%>
    <c:when test="${action eq 'estados'}">
        <jsp:include page="pages/estados/index.jsp" />
    </c:when>
    <c:when test="${action eq 'nuevoestado'}">
        <jsp:include page="pages/estados/nuevo.jsp" />
    </c:when>
    <c:when test="${action eq 'editarestado'}">
        <jsp:include page="pages/estados/editar.jsp" />
    </c:when>
    
    <%-- Rutas de Pacientes --%>
    <c:when test="${action eq 'objetivos'}">
        <jsp:include page="pages/objetivos/index.jsp" />
    </c:when>
    <c:when test="${action eq 'nuevoobjetivo'}">
        <jsp:include page="pages/objetivos/nuevo.jsp" />
    </c:when>
    <c:when test="${action eq 'editarobjetivo'}">
        <jsp:include page="pages/objetivos/editar.jsp" />
    </c:when>
    
    <%-- Rutas de Fichas --%>
    <c:when test="${action eq 'fichas'}">
        <jsp:include page="pages/fichas/index.jsp" />
    </c:when>
    <c:when test="${action eq 'nuevaficha'}">
        <jsp:include page="pages/fichas/nuevo.jsp" />
    </c:when>
    <c:when test="${action eq 'editarficha'}">
        <jsp:include page="pages/fichas/editar.jsp" />
    </c:when>
    <c:when test="${action eq 'listarextranjero'}">
        <jsp:include page="pages/fichas/verextranjeros.jsp" />
    </c:when>
    
    
    <%-- Rutas de Patologias --%>
    <c:when test="${action eq 'patologias'}">
        <jsp:include page="pages/patologias/index.jsp" />
    </c:when>
    <c:when test="${action eq 'nuevapatologia'}">
        <jsp:include page="pages/patologias/nuevo.jsp" />
    </c:when>
    <c:when test="${action eq 'editarpatologia'}">
        <jsp:include page="pages/patologias/editar.jsp" />
    </c:when>
    
    
    <%-- Rutas de Estudios --%>
    <c:when test="${action eq 'estudios'}">
        <jsp:include page="pages/estudios/index.jsp" />
    </c:when>
    <c:when test="${action eq 'nuevoestudio'}">
        <jsp:include page="pages/estudios/nuevo.jsp" />
    </c:when>
    <c:when test="${action eq 'editarestudio'}">
        <jsp:include page="pages/estudios/editar.jsp" />
    </c:when>
    
    <%-- Rutas de Medicos --%>
    <c:when test="${action eq 'medicos'}">
        <jsp:include page="pages/medicos/index.jsp" />
    </c:when>
    <c:when test="${action eq 'nuevomedico'}">
        <jsp:include page="pages/medicos/nuevo.jsp" />
    </c:when>
    <c:when test="${action eq 'editarmedico'}">
        <jsp:include page="pages/medicos/editar.jsp" />
    </c:when>
    
    <%-- Rutas de Ocupaciones --%>
    <c:when test="${action eq 'ocupaciones'}">
        <jsp:include page="pages/ocupaciones/index.jsp" />
    </c:when>
    <c:when test="${action eq 'nuevaocupacion'}">
        <jsp:include page="pages/ocupaciones/nuevo.jsp" />
    </c:when>
    <c:when test="${action eq 'editarocupacion'}">
        <jsp:include page="pages/ocupaciones/editar.jsp" />
    </c:when>
    
    <%-- Rutas de Informes --%>
    <c:when test="${action eq 'informeingreso'}">
        <jsp:include page="pages/informes/ingreso.jsp" />
    </c:when>
    <c:when test="${action eq 'reportealumnos'}">
        <jsp:include page="pages/informes/reportealumnos.jsp" />
    </c:when>

    <%-- Ruta de inicio--%>
    <c:otherwise>
        <jsp:include page="pages/home.jsp" />
    </c:otherwise>

</c:choose>



