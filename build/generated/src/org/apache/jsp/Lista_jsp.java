package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Modelo.Con;
import Controlador.ventas;
import java.util.List;
import Modelo.Venta;

public final class Lista_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Lista de Ventas</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/css/materialize.min.css\">\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/js/materialize.min.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://opensource.keycdn.com/fontawesome/4.7.0/font-awesome.min.css\" integrity=\"sha384-dNpIIXE8U05kAbPhy3G1cz+yZmTzA6CY8Vg/u2L9xRnHjJiAK76m2BIEaSEV+/aU\" crossorigin=\"anonymous\">\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            String ses="";
            if(session.getAttribute("msj")!=null&&session.getAttribute("tipo").equals("Administrador")){
                ses="<p class='pSession'>"+session.getAttribute("nombre")+"</p>"+
                        "<p class='pSession'>"+session.getAttribute("tipo")+"</p>"+
                        "<a href='./ServCerrar'>Cerrar Sesión</a>";
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
        
      out.write("\n");
      out.write("                \n");
      out.write("        <table class=\"cabezera\">\n");
      out.write("            <tr>\n");
      out.write("                <td><h1>Ventas Registradas</h1></td>\n");
      out.write("                <td>  ");
out.print(ses);
      out.write("\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <table>\n");
      out.write("        ");
            
            if(ventas.size()>0){
                out.print(
                "<tr>"+
                    "<td>N° Venta</td>"+
                    "<td>Vehiculo</td>"+
                    "<td>Precio</td>"+
                    "<td colspan='2'>Acciones</td>"+
                "</tr>");
                
                for(Venta v:ventas){
                    out.print("<tr>"+
                                "<td>"+v.getIdVenta()+"</td>"+
                                "<td>"+v.getVehiculo()+"</td>"+
                                "<td>"+v.getPrecio()+"</td>"+
                                "<td><a href='./Editar.jsp?id="+v.getIdVenta()+"'><i class='fa fa-pencil fa-2x' aria-hidden='true'></i></a></td>"+
                                "<td><a href='./ServEliminar?id="+v.getIdVenta()+"'><i class='fa fa-trash-o fa-2x' aria-hidden='true'></i></a></td>"+
                            "</tr>");
                }
            }
            
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td colspan=\"10\"><a href=\"./Agregar.jsp\"><i class='fa fa-plus fa-2x' aria-hidden='true'></i> Registrar Venta</a></td>\n");
      out.write("            </tr>\n");
      out.write("        \n");
      out.write("        </table>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("        \n");
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
