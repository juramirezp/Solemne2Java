<%-- 
    Document   : Agregar
    Created on : 27-10-2016, 20:28:04
    Author     : juramirezp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Venta</title>
        <script src="https://code.jquery.com/jquery-3.1.1.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/css/materialize.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/js/materialize.min.js"></script>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <%
            String usNombre, usTipo;
            if(session.getAttribute("msj")!=null){
                usNombre=String.valueOf(session.getAttribute("nombre"));
                usTipo=String.valueOf(session.getAttribute("tipo"));
            }else{
                out.print("<script>location.href='./ServCerrar';</script>");
            }
        %>
                
        <div class="row">
            <div class="col s1" style="padding-top:15px;">
                 <a href="javascript:history.back()"><i class="medium material-icons">keyboard_arrow_left</i></a>
            </div>
            <div class="col s9"><h1>Registrar Nueva Venta</h1></div>
            <ul class="collection">
                <li class="collection-item avatar">
                  <img src="img/silueta.jpg" alt="" class="circle">
                  <span class="title"><%out.print(String.valueOf(session.getAttribute("nombre")));%></span>
                  <p><%out.print(String.valueOf(session.getAttribute("tipo")));%><br>
                     <a href='./ServCerrar'>Cerrar Sesión</a>
                  </p>
                </li>
            </ul>
        </div>
                
        <form action="./ServNueva" method="post">
            <div class="container">
                <div class="row">
                    <div class="input-field col s6 offset-s3">
                        <select name="marca" id="selectMarca">
                            <option value="" disabled selected>Seleccionar Opción</option>
                            <option value="Ford">Ford</option>
                            <option value="Chevrolet">Chevrolet</option>
                            <option value="Yeep">Yeep</option>
                            <option value="Toyota">Toyota</option>
                            <option value="Mini">Mini</option>
                        </select>
                        <label>Marca</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s6 offset-s3">
                        <select name="tipo" id="selectTipo">
                            <option value="" disabled selected>Seleccionar Opción</option>
                            <option value="Camioneta">Camioneta</option>
                                <option value="Camion">Camion</option>
                                <option value="Auto">Auto</option>
                                <option value="Furgon">Furgon</option>
                                <option value="Maquinaria">Maquinaria</option>
                        </select>
                        <label>Tipo</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s6 offset-s3">
                        <input placeholder="Vehiculo" id="vehiculo" name="vehiculo" type="text" class="validate">
                        <label for="vehiculo">Vehiculo</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s6 offset-s3">
                        <input placeholder="Motor" id="motor" name="motor" type="text" class="validate">
                        <label for="motor">Motor</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s6 offset-s3">
                        <input placeholder="Precio" name="precio" id="precio" type="number" class="validate">
                        <label for="precio">Precio</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s6 offset-s3">
                        <textarea name="descripcion" id="descripcion" class="materialize-textarea"></textarea>
                        <label for="descripcion">Descripción</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s6 offset-s3">
                        <input placeholder="" name="estadov" id="estado" type="text" class="validate" value="Pendiente" disabled>
                        <label for="estado">Estado</label>
                        <input type="text" name="estado" value="Pendiente" style="display:none;"/>
                    </div>
                </div>
                <div class="row centered">
                    <div class="input-field col s4 offset-s5">
                        <button class="btn waves-effect waves-light centered" type="submit" name="action">Ingresar
                            <i class="material-icons right">send</i>
                        </button>
                    </div>
                </div>
            </div>
        </form>        
                <script>
                    $(document).ready(function() {
                        $('#selectMarca').material_select();
                        $('#selectTipo').material_select();
                    });
                </script>
    </body>
</html>
