/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.tipoUsu;
import Controlador.ventas;
import Modelo.Con;
import Modelo.TipoUsuario;
import Modelo.Venta;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author juramirezp
 */
public class ServLogin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String usuario = request.getParameter("usuario");
        String pass = request.getParameter("pass");
        System.out.println("---------INFORMACION FORMULARIO");
        System.out.println(usuario);
        System.out.println(pass);
        HttpSession session = request.getSession();
        Modelo.Usuario usu;
        Controlador.usuarios conUsu;
        try{
            if(usuario!=null && pass!=null){
            usu=new Modelo.Usuario();
            conUsu=new Controlador.usuarios();
            System.out.println("---------usuario antes");
            System.out.println(usu.getNombre());
            usu=conUsu.login(Con.Conectar(), usuario, pass);
            usuario=null;
            pass=null;
            
            System.out.println("---------usuario despues");
            System.out.println(usu.getNombre());
            if(usu!=null){
                
                session.setAttribute("nombre", usu.getNombre()+" "+usu.getApellido());
                
                TipoUsuario tipoUsu=new TipoUsuario();
                tipoUsu conTipo=new tipoUsu();
                tipoUsu=conTipo.verificarTipo(Con.Conectar(), usu.getIdTipoUsuario());
                
                if(tipoUsu.getGlosa().equals("Administrador")){
                    session.setAttribute("tipo", "Administrador");
                }else{
                    session.setAttribute("tipo", "Usuario General");
                }
                session.setAttribute("user", usu.getUsuario());
                
                usu=null;
                conUsu=null;
                
                if (session.getAttribute("tipo").equals("Administrador")) {
                    session.setAttribute("msj", "ok");
                    request.getRequestDispatcher("/Lista.jsp").forward(request, response);
                }
                
                if(session.getAttribute("tipo").equals("Usuario General")){
                    session.setAttribute("msj", "ok");
                    request.getRequestDispatcher("/Agregar.jsp").forward(request, response);
                }else{
                    session.setAttribute("msj", "error");
                    request.getRequestDispatcher("/login.jsp");
                }
            }else{
                System.out.println("error en datos de ingreso");
                session.setAttribute("msj", "error");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }
        }catch(Exception e){
            System.out.println("sinusuario");
            session.setAttribute("msj", "error");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
