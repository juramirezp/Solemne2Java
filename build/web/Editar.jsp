<%-- 
    Document   : Editar
    Created on : 27-10-2016, 20:28:14
    Author     : juramirezp
--%>

<%@page import="Modelo.Con"%>
<%@page import="Modelo.Venta"%>
<%@page import="java.util.List"%>
<%@page import="Controlador.ventas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Venta</title>
        <script src="https://code.jquery.com/jquery-3.1.1.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/css/materialize.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/js/materialize.min.js"></script>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <%
            String usNombre, usTipo;
            if(session.getAttribute("msj")!=null&&session.getAttribute("tipo").equals("Administrador")){
                usNombre=String.valueOf(session.getAttribute("nombre"));
                usTipo=String.valueOf(session.getAttribute("tipo"));
            }else{
                out.print("<script>location.href='./ServCerrar';</script>");
            }

            int id=Integer.parseInt(request.getParameter("id"));
            
            ventas conVentas=new ventas();
            Venta v=null;
            v=conVentas.consultarVenta(Con.Conectar(), id);
            try{
                if(v==null){
                    out.print("Venta No Existe");
                }
            }catch(Exception e){
                out.print("<b>Error: " + e.getMessage() + "</b>");
            }
        %>
                
        <div class="row">
            <div class="col s1" style="padding-top:15px;">
                 <a href="javascript:history.back()"><i class="medium material-icons">keyboard_arrow_left</i></a>
            </div>
            <div class="col s9"><h1>Ventas Registradas</h1></div>
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
        <form action="./ServEditar" method="post">
            <%            
                if(v!=null){
                    out.print(
                            "<div class='container'>"+
                                   "<div class='row'>"+
                                        "<div class='input-field col s6 offset-s3'>"+
                                            "<input placeholder='N° de Venta' id='idVenta'  name='numVentav' type='text' class='validate' value='"+v.getIdVenta()+"' disabled>"+
                                            "<label for='numVentav'>Vehiculo</label>"+
                                            "<input type='text'  name='numVenta' value='"+v.getIdVenta()+"' style='display:none;'/>"+
                                        "</div>"+
                                    "</div> "+
                                    "<div class='row'>"+
                                        "<div class='input-field col s6 offset-s3'>"+
                                            "<input placeholder='Marca' id='marca' name='marca' type='text' class='validate' value='"+v.getMarca()+"' disabled>"+
                                            "<label for='marca'>Marca</label>"+
                                        "</div>"+
                                    "</div> "+
                                    "<div class='row'>"+
                                        "<div class='input-field col s6 offset-s3'>"+
                                            "<input placeholder='Tipo' id='tipo' name='tipo' type='text' class='validate' value='"+v.getTipo()+"' disabled>"+
                                            "<label for='tipo'>Tipo</label>"+
                                        "</div>"+
                                    "</div> "+
                                    "<div class='row'>"+
                                        "<div class='input-field col s6 offset-s3'>"+
                                            "<input placeholder='Vehiculo' id='vehiculo' name='vehiculo' type='text' class='validate' value='"+v.getVehiculo()+"' disabled>"+
                                            "<label for='vehiculo'>Vehiculo</label>"+
                                        "</div>"+
                                    "</div> "+
                                    "<div class='row'>"+
                                        "<div class='input-field col s6 offset-s3'>"+
                                            "<input placeholder='Motor' id='motor' name='motor' type='text' class='validate' value='"+v.getMotor()+"' disabled>"+
                                            "<label for='motor'>Motor</label>"+
                                        "</div>"+
                                    "</div> "+
                                    "<div class='row'>"+
                                        "<div class='input-field col s6 offset-s3'>"+
                                            "<input placeholder='Precio' id='precio' name='precio' type='text' class='validate' value='"+v.getPrecio()+"' disabled>"+
                                            "<label for='precio'>Precio</label>"+
                                        "</div>"+
                                    "</div> "+
                                    "<div class='row'>"+
                                        "<div class='input-field col s6 offset-s3'>"+
                                            "<textarea name='descripcion' id='descripcion' class='materialize-textarea' value='"+v.getDescripcion()+"' disabled></textarea>"+
                                            "<label for='descripcion'>Descripción</label>"+
                                        "</div>"+
                                    "</div>"+
                                    "<div class='row'>"+
                                        "<div class='input-field col s6 offset-s3'>"+
                                            "<select name='estado' id='selectEstado'>"+
                                                "<option value='Pendiente'");
                                                    if(v.getEstado().equalsIgnoreCase("Pendiente")){
                                                        out.print("selected");
                                                    }
                                                    out.print(">Pendiente</option>"+
                                                "<option value='Rechazado'");
                                                    if(v.getEstado().equalsIgnoreCase("Rechazado")){
                                                        out.print("selected");
                                                    }
                                                    out.print(">Rechazado</option>"+
                                                "<option value='Aprobado'");
                                                    if(v.getEstado().equalsIgnoreCase("Aprobado")){
                                                        out.print("selected");
                                                    }
                                                    out.print(">Aprobado</option>"+
                                                "</select>"+
                                            "<label>Estado</label>"+
                                        "</div>"+
                                    "</div>"+  
                                    "<div class='row centered'>"+
                                        "<div class='input-field col s4 offset-s5'>"+
                                            "<button class='btn waves-effect waves-light centered' type='submit' name='action'>Ingresar"+
                                                "<i class='material-icons right'>send</i>"+
                                            "</button>"+
                                        "</div>"+
                                    "</div>"+
                            "</div>");
                }
                %>
        </form>
        <script>
            $(document).ready(function() {
                $('#selectEstado').material_select();
            });
        </script>
    </body>
</html>
