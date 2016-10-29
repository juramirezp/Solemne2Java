<%-- 
    Document   : Lista
    Created on : 28-10-2016, 12:00:24
    Author     : juramirezp
--%>

<%@page import="Modelo.Con"%>
<%@page import="Controlador.ventas"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Venta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Ventas</title>
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

            ventas conVentas=new ventas();
            List<Venta> ventas= conVentas.listarVentas(Con.Conectar());
            try{
                if(ventas.size()<=0){
                    out.print("No Existen Ventas Registradas");
                }
            }catch(Exception e){
                out.print("<b>Error: " + e.getMessage() + "</b>");
            }
        %>
                
        <div class="row">
            <div class="col s10"><h1>Ventas Registradas</h1></div>
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
        
        
        <table class="highlight centered col s6" id="ListaVentas">
        <%            
            if(ventas.size()>0){
                out.print(
                        "<thead>"+
                "<tr>"+
                    "<td>N° Venta</td>"+
                    "<td>Vehiculo</td>"+
                    "<td>Precio</td>"+
                    "<td colspan='2'>Acciones</td>"+
                "</tr>"+
                "</thead>"+ 
                "<tbody>");
                for(Venta v:ventas){
                    out.print("<tr>"+
                                "<td>"+v.getIdVenta()+"</td>"+
                                "<td>"+v.getVehiculo()+"</td>"+
                                "<td>"+v.getPrecio()+"</td>"+
                                "<td><a href='./Editar.jsp?id="+v.getIdVenta()+"'><i class='small material-icons'>mode_edit</i></a></td>"+
                                "<td><a href='./ServEliminar?id="+v.getIdVenta()+"'><i class='small material-icons'>delete</i></a></td>"+
                            "</tr>");
                }
                out.print("</tbody>");
            }
            %>
        </table>
            <div id="ListaAgregar" class="row">
                <a href="./Agregar.jsp" class="col s12"><i class="small material-icons">playlist_add</i> Registrar Venta</a>
            </div>
            
        
    </body>
</html>
