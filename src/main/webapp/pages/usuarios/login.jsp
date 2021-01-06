<%-- 
    Document   : Login
    Created on : 10-oct-2020, 0:07:05
    Author     : NeloGrahl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Login - SB Admin</title>

        <link href="../../assets/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

        <link href="../../assets/css/styles.css" rel="stylesheet" />

        <link href="../../assets/fontawesome-free/css/all.css" rel="stylesheet" type="text/css"/>
        <style>
            .bg-img {
                width: 100%;
                height: 100%;
                background: url('../../assets/img/bg3.jpg') center center no-repeat;
                background-size: cover;
                background-attachment: fixed;

                &:before {
                    content: '';
                    position: absolute;
                    top: 0;
                    right: 0;
                    bottom: 0;
                    left: 0;
                    background-image: linear-gradient(to bottom right,#002f4b,#dc4225);
                    opacity: .6; 
                }
            }
        </style>
        <% HttpSession ses = request.getSession(); %>
        <%@ page import="modelos.Usuario" %>
        <% ses.removeAttribute("loggedUser"); %>
        
    </head>
    <body class="bg-img">
        <div class="wrapper wrapper-full-page">
            <div class="container" style="position: absolute;  top: 50%;  left: 50%;  transform: translate(-50%, -50%);">
                <div class="row align-items-center">   
                    <div class="col-lg-4 col-md-6 col-sm-8 ml-auto mr-auto">
                        <form action='../../Usuarios?accion=login' method="post">
                            <div class="col container align-text-bottomm" >
                                <div class="card card-login card-hidden mb-3" style="background-color:#FDA014;">
                                    <div class="card-header card-header-info text-center" style="background-color:#FEF3DC;">
                                        <h4 class="card-title">Login</h4>
                                    </div>
                                    <div class="form-group col-12 mt-3 text-left">
                                        <label for="user">Usuario</label>
                                        <input type="text" name="user" required="true" class="form-control" placeholder="Ingrese su usuario">
                                    </div>
                                    <div class="form-group col-12 mt-3 text-left">
                                        <label for="password">Contraseña</label>
                                        <input type="password" name="password" required="true" class="form-control" placeholder="Ingrese su contraseña">
                                    </div>
                                    <div class="card-footer text-center">
                                        <input type="submit" class="btn btn-outline-dark" value="Ingresar">
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>