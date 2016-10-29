<%-- 
    Document   : login
    Created on : 27-10-2016, 11:00:12
    Author     : juramirezp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <script src="https://code.jquery.com/jquery-3.1.1.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/css/materialize.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/js/materialize.min.js"></script>
         <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
         <link rel="stylesheet" href="css/style.css">
        <style>
            
            
        </style>
            
    </head>
    <body>
        
        <%
            if(session.getAttribute("msj")!=null){
                out.println("<div id='msjError'>Error - Verifica los datos ingresados</div>");
                session.invalidate();
            }
        %>
        
        
        <div class="row centered" id="divLogin">
            <h1>Autenticación de Usuarios</h1>
            <form class="col s12 centered" action="/Solemne2_JuanRamirez/ServLogin" method="post">
              <div class="row">
                <div class="input-field col s4 offset-s4">
                  <i class="medium material-icons prefix">supervisor_account</i>
                  <input id="icon_prefix" type="text" class="validate" name="usuario" required>
                  <label for="icon_prefix">Nombre de Usuario</label>
                </div>
                
              </div>
                <div class="row">
                    <div class="input-field col s4 offset-s4">
                  <i class="medium material-icons prefix">vpn_key</i>
                  <input id="icon_telephone" type="password" class="validate" name="pass" required>
                  <label for="icon_telephone">Contraseña</label>
                </div>
                </div>
                <div class="row centered">
                    <div class="input-field col s4 offset-s4 centered">
                        <button class="btn waves-effect waves-light" type="submit" name="action">Ingresar
                            <i class="material-icons right">send</i>
                        </button>
                    </div>
                </div>
                
            </form>
          </div>
    </body>
</html>
