<%-- 
    Document   : Index
    Created on : 09-oct-2020, 19:07:39
    Author     : NeloGrahl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html language="es" >
    <head>
        <meta contentType="text/html"  charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Dashboard - SB Admin</title>

        <link href="./assets/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

        <link href="./assets/css/styles.css" rel="stylesheet" />

        <link href="./assets/css/select2.min.css" rel="stylesheet" />
        <link href="./assets/fontawesome-free/css/all.css" rel="stylesheet" type="text/css"/>        

        <link href="./assets/select/select2.min.css" rel="stylesheet" type="text/css"/>

        <link href="assets/datatables/datatables.css" rel="stylesheet" type="text/css"/>       

        <link href="assets/datatables/jquery.dataTables.min.css" rel="stylesheet" type="text/css"/>

        <link href="assets/confirm/sweetalert2.min.css" rel="stylesheet" type="text/css"/>

        <link href="assets/jquery/dist/jquery-ui.css" rel="stylesheet" type="text/css"/>
        
        <link href="assets/datatables/datatables.min.css" rel="stylesheet" />
        
        <style type="text/css">
            .bgimg {
                background: url('./assets/img/bg4.jpg') center center no-repeat;
                width: 100%;
                height: 100%;
                background-size: cover;                
            }
        </style>

    </head>
    <body class="sb-nav-fixed">
        <% HttpSession ses = request.getSession(); %>
        <%@ page import="modelos.Usuario" %>
        <% Usuario usu = (Usuario) ses.getAttribute("loggedUser"); %>
        <nav class="sb-topnav navbar navbar-expand navbar-light" style="background-color:#FDA014;">
            <a class="navbar-brand" href="index.jsp?page=home">Kinesiologia</a>
            <button class="btn btn-link btn-sm order-1 order-lg-0" id="sidebarToggle" href="#"><i class="fas fa-bars"></i></button>
            <!-- Navbar Search-->
            <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">

            </form>
            <!-- Navbar-->
            <ul class="navbar-nav ml-auto ml-md-0 text-right">
                <li class="nav-item dropdown" style="background-color:#FFDE90;">
                    <a class="nav-link dropdown-toggle" id="userDropdown" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown" style="background-color:#FFDE90;">

                        <% if (usu != null) { %>
                        <a class="dropdown-item text-center card" style="background-color:#FDA014;" ><%out.print(usu.getNombreUsuario());%></a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="Usuarios?accion=cambiarclave&id=<%out.print(usu.getIdUsuario());%>">Cambiar contraseña</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="pages/usuarios/login.jsp">Salir</a>
                        <%} else {%>
                        <a class="dropdown-item" href="pages/usuarios/login.jsp">Ingresar</a>
                        <%}%>
                    </div>
                </li>
            </ul>
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-light" id="sidenavAccordion">
                    <div class="sb-sidenav-menu" style="background-color:#FFDE90;" >
                        <div class="nav">

                            <div class="sb-sidenav-menu-heading text-dark text-center">MENU</div>

                            <% if (usu != null) {
                                    if (usu.getRol().equals("Docente")) {%>
                            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseLayouts1" aria-expanded="false" aria-controls="collapseLayouts1">
                                <div class="sb-nav-link-icon text-dark"><i class="fas fa-columns"></i></div>
                                Administraci&oacute;n
                                <div class="sb-sidenav-collapse-arrow text-dark"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse " id="collapseLayouts1" aria-labelledby="headingOne" data-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" name="alumnos" id="listaalumnos" href="Alumnos?accion=index" >Alumnos</a>                                    
                                </nav>
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" name="usuarios" id="listausuarios" href="Usuarios?accion=index" >Usuarios</a>                                    
                                </nav>
                            </div>
                            <%}%>
                            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseLayouts2" aria-expanded="false" aria-controls="collapseLayouts2">
                                <div class="sb-nav-link-icon text-dark"><i class="fas fa-columns"></i></div>
                                &Aacute;rea de Pacientes
                                <div class="sb-sidenav-collapse-arrow text-dark" ><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse " id="collapseLayouts2" aria-labelledby="headingOne" data-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" name="fichas" id="listaalumnos" href="Fichas?accion=index" >Pacientes</a>                                    
                                </nav>
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" name="derivaciones" id="listaalumnos" href="Derivaciones?accion=index" >Derivaciones</a>                                    
                                </nav>                                
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" name="antecedentes" id="listaalumnos" href="Antecedentes?accion=index" >Antecedentes</a>
                                </nav>
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" name="patologias" id="listaalumnos" href="Patologias?accion=index" >Patolog&iacute;as</a>                                    
                                </nav>
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" name="ocupaciones" id="listaalumnos" href="Ocupaciones?accion=index" >Ocupaciones</a>
                                </nav>
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" name="estudios" id="listaalumnos" href="Estudios?accion=index" >Estudios</a>
                                </nav>
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" name="estados" id="listaalumnos" href="Estados?accion=index" >Estados</a>                                    
                                </nav>
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" name="medicos" id="listaalumnos" href="Medicos?accion=index" >M&eacute;dicos</a>
                                </nav>
                            </div>
                            <%if (usu.getRol().equals("Docente")) {%>
                            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseLayouts3" aria-expanded="false" aria-controls="collapseLayouts3">
                                <div class="sb-nav-link-icon text-dark"><i class="fas fa-columns"></i></div>
                                Informes
                                <div class="sb-sidenav-collapse-arrow text-dark" ><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse " id="collapseLayouts3" aria-labelledby="headingOne" data-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" name="resumen" id="informeingreso" href="ControladorInformes?accion=informeingreso" >Resumen de Ingresos</a>                                    
                                </nav>
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" name="historial" id="listaalumnos" href="ControladorInformes?accion=reportealumnos" >Reporte de Alumno</a>                                    
                                </nav>
                                

                            </div>
                            <%}%>
                            <%} else {%>

                            <%}%>
                            <div class="text-center" style="">
                                <img src="assets/img/logo_kinesio.jpg" style="border-radius:50%; width:50%; position: absolute;
                                     margin-left: auto;
                                     margin-right: auto;
                                     left: 0;
                                     right: 0;
                                     bottom: 0;
                                     text-align: center;">    
                            </div>
                            <div><br></div>
                        </div>

                    </div>
                </nav>

            </div>

            <script src="./assets/jquery/dist/jquery.min.js" type="text/javascript"></script>

            <script src="./assets/bootstrap/js/bootstrap.bundle.min.js" type="text/javascript"></script>

            <script src="./assets/js/scripts.js" type="text/javascript"></script>

            <script src="./assets/js/select2.min.js" type="text/javascript"></script>

            <script src="assets/datatables/jquery.dataTables.min.js" type="text/javascript"></script>

            <script src="./assets/select/select2.min.js" type="text/javascript"></script>

            <script src="assets/confirm/sweetalert2.min.js" type="text/javascript"></script>       

            <script src="assets/jquery/dist/jquery-ui.js" type="text/javascript"></script>

            <script src="assets/jquery/dist/jquery.numeric.js" type="text/javascript"></script>

            <script src="assets/jquery/dist/jquery.mask.min.js" type="text/javascript"></script>

            <div id="layoutSidenav_content" class="flex-column align-middle" style="background-color:#FCF7EF;">

                <div class="alert alert-success" id="success" style="display: none;">
                    ${success}
                </div>
                <div class="alert alert-danger" id="errors" style="display: none;">
                    ${errors}
                </div>
                <!-- Content-Wrapper -->

                <jsp:include page="contenido.jsp"/>

                <footer class="mt-4 bg-dark mt-auto">
                    <div class="container-fluid">
                        <div class="d-flex align-items-center justify-content-center">
                            <div class="text-white align-text-center">Copyright &copy; Programacion IV 2020</div>
                            <p>&nbsp;</p>
                        </div>
                    </div>
                </footer>
            </div>
        </div>              


        <script>

            $(document).ready(function () {
                if ($('#success').html().trim().length > 0) {
                    displayOk();
                } else if ($('#errors').html().trim().length > 0) {
                    displayError();
                }
            })
            function confirmDelete(url) {

                swal({
                    html: "<h4><p>Seguro que desea eliminar este registro?</p></h4>",
                    showCancelButton: true,
                    confirmButtonText: 'Eliminar',
                    cancelButtonText: 'Cancelar',
                    confirmButtonColor: '#3085d6',
                    cancelButtonColor: '#d33'
                }).then((isConfirmed) => {
                    if (isConfirmed.value) {
                        window.location.href = url;
                        return true;
                    } else {
                        return false;
                    }
                });
            }
            function displayOk() {
                $('#success').slideDown();
                setTimeout(function () {
                    $('#success').slideUp();
                }, 3000);
            }
            function displayError() {
                if (errors == true) {
                    $('#errors').slideDown();
                    setTimeout(function () {
                        $('#errors').slideUp();
                    }, 3000);
                }
            }
        </script>   
    <c:if test="${null != success}">
        <script>

        </script>
    </c:if>     
</body>
</html>