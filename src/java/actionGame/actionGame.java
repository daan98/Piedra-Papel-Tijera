/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actionGame;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Xcelsius
 */

public class actionGame extends HttpServlet {

        static int jugadasRealizadas = 0;
        static int jugadasEmpatadas = 0;
        
        static int jugadasGanadasCliente = 0;
        static int jugadasGanadasServidor = 0;
        
        static int partidasEmpatadas = 0;
        static int partidasGanadasCliente = 0;
        static int partidasGanadasServidor = 0;
        
        int jugadasLimite = 5;
    
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet actionGame</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet actionGame at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        //processRequest(request, response);
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
        //processRequest(request, response);
        
        
        String opcionCliente = "";
        String opcionServidor = "";
        String ganadorJugada = "";
        
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        
        Random aleatorio = new Random(System.currentTimeMillis());
        int intAleatorio = aleatorio.nextInt(2) + 1;
        
        if(jugadasRealizadas==jugadasLimite){
            jugadasEmpatadas = 0;
            jugadasRealizadas = 0;
            partidasGanadasServidor = 0;
            partidasGanadasCliente = 0;
            
            if(jugadasGanadasCliente > jugadasGanadasServidor){
                partidasGanadasCliente++;
            } else{
                partidasGanadasServidor++;
            }
        }
        
        if(jugadasRealizadas < jugadasLimite){
            
            if(opcion == intAleatorio){
                jugadasEmpatadas++;
                jugadasRealizadas++;
                ganadorJugada = "Empate";
            }else{
                if(opcion == 1 && intAleatorio == 2){
                    jugadasGanadasServidor++;
                    ganadorJugada = "Servidor";
                }else if(opcion == 1 && intAleatorio == 3){
                    jugadasGanadasCliente++;
                    ganadorJugada = "Cliente";
                }else if(opcion == 2 && intAleatorio == 1){
                    jugadasGanadasCliente++;
                    ganadorJugada = "Cliente";
                }else if(opcion == 2 && intAleatorio == 3){
                    jugadasGanadasServidor++;
                    ganadorJugada = "Servidor";
                }else if(opcion == 3 && intAleatorio ==1){
                    jugadasGanadasServidor++;
                    ganadorJugada = "Servidor";
                }else if(opcion == 3 && intAleatorio == 2){
                    jugadasGanadasCliente++;
                    ganadorJugada = "Cliente";
                }
            }
        }
        
        opcionCliente = getOpcion(opcion);
        opcionServidor = getOpcion(intAleatorio);
        request.setAttribute("opcionCliente", opcionCliente);
        request.setAttribute("opcionServidor", opcionServidor);
        
        request.setAttribute("jugadasRealizadas", jugadasRealizadas);
        request.setAttribute("jugadasEmpatadas", jugadasEmpatadas);
        
        request.setAttribute("jugadasGanadasCliente", jugadasGanadasCliente);
        request.setAttribute("jugadasGanadasServidor", jugadasGanadasServidor);
        
        request.setAttribute("partidasEmpatadas", partidasEmpatadas);
        request.setAttribute("partidasGanadasCliente", partidasGanadasCliente);
        request.setAttribute("partidasGanadasServidor", partidasGanadasServidor);
        
        request.setAttribute("jugadasLimite", jugadasLimite);
        
        RequestDispatcher requestDispatcher;
        requestDispatcher = request.getRequestDispatcher("juego.jsp");
        requestDispatcher.forward(request, response);
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

    

    private String getOpcion(int opcion) { //To change body of generated methods, choose Tools | Templates.
        String text = "";
        switch(opcion){
            case 1:
                text = "Piedra";
                break;
            case 2:
                text = "Papel";
                break;
            case 3:
                text = "Tijera";
                break;
        }
        return text;
    }
}
