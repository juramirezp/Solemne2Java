package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Login</title>\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.1.1.min.js\" integrity=\"sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/css/materialize.min.css\">\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/js/materialize.min.js\"></script>\n");
      out.write("         <link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\n");
      out.write("         <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("        <style>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("        </style>\n");
      out.write("            \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        ");

            if(session.getAttribute("msj")!=null){
                out.println("<div id='msjError'>Error - Verifica los datos ingresados</div>");
                session.invalidate();
            }
        
      out.write("\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <div class=\"row centered\" id=\"divLogin\">\n");
      out.write("            <h1>Autenticación de Usuarios</h1>\n");
      out.write("            <form class=\"col s12 centered\" action=\"/Solemne2_JuanRamirez/ServLogin\" method=\"post\">\n");
      out.write("              <div class=\"row\">\n");
      out.write("                <div class=\"input-field col s4 offset-s4\">\n");
      out.write("                  <i class=\"medium material-icons prefix\">supervisor_account</i>\n");
      out.write("                  <input id=\"icon_prefix\" type=\"text\" class=\"validate\" name=\"usuario\" required>\n");
      out.write("                  <label for=\"icon_prefix\">Nombre de Usuario</label>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("              </div>\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"input-field col s4 offset-s4\">\n");
      out.write("                  <i class=\"medium material-icons prefix\">vpn_key</i>\n");
      out.write("                  <input id=\"icon_telephone\" type=\"password\" class=\"validate\" name=\"pass\" required>\n");
      out.write("                  <label for=\"icon_telephone\">Contraseña</label>\n");
      out.write("                </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row centered\">\n");
      out.write("                    <div class=\"input-field col s4 offset-s4 centered\">\n");
      out.write("                        <button class=\"btn waves-effect waves-light\" type=\"submit\" name=\"action\">Ingresar\n");
      out.write("                            <i class=\"material-icons right\">send</i>\n");
      out.write("                        </button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("            </form>\n");
      out.write("          </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
