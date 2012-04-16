/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cube;
import model.Field;
import model.GameInformation;
import model.Player;
import model.FieldList;

/**
 *
 * @author rainer
 */
public class GameServlet extends HttpServlet {
    private GameInformation gameInfo;
    private Player player1;
    private Player player2;
    private FieldList fieldList;
    private Random generator;
    private String computerCube = "";

    @Override
    public void init() throws ServletException {
        super.init();
        gameInfo = new GameInformation();
        player1 = new Player();
        player2 = new Player();
        fieldList = new FieldList();
        generator = new Random();
        
        //TODO
        //eigentlich ist die Startposition 43
        //aber zum Testen wird das erste Feld genommen
        player1.setActPosition(1);
        player1.setAlt("Feld 43: Startfeld Spieler 1: Spieler 1");
        player1.setCube(new Cube());
        player1.setId("player1");
        player1.setImage("img/field1_player1.png");
        player1.setName("Super Mario");
        player1.setTitle("Feld 43: Startfeld Spieler 1: Spieler 1");
        
        //eigentlich ist die Startposition 45
        //aber zum Testen wird da 11 Feld genommen
        player2.setActPosition(11);
        player2.setAlt("Feld 45: Startfeld Spieler 2: Spieler 2");
        player2.setCube(new Cube());
        player2.setId("player2");
        player2.setImage("img/field2_player2.png");
        player2.setName("Computer");
        player2.setTitle("Feld 45: Startfeld Spieler 2: Spieler 2");
        
        gameInfo.addPlayer("Spieler 1", player1);
        gameInfo.addPlayer("Spieler 2", player2);
        
        for (int i = 1; i <= 40; i++) {
            Field f = new Field();
            f.setId("field" + i);
            f.setSrc("img/field.png");
            //TODO richtige Werte
            f.setAlt("");
            f.setTitle("");
            fieldList.getFieldList().add(f);
            //fields.put(i, null);
        }
        
        //fields.put(1, pl1);
        
        
    }
    
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /*
             * TODO output your page here. You may use following sample code.
             */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GameServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GameServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
        String action = request.getParameter("action");
        
        if (action == null) {
            return;
        }
        
        if (action.equals("wuerfeln")) {                           
            HttpSession session = request.getSession(true);
            this.gameInfo.incrementRound();
            
            //player to cube
            wuerfeln(this.player1);
            move(this.player1);
            session.setAttribute("wuerfel", player1.getCube());
            session.setAttribute("fieldList", this.fieldList);
            
            // player got a 6
            if (this.player1.getCube().getNumber() == 6) {
                move(this.player1);
                // cube again
                session.setAttribute("gameInfo", gameInfo);
                session.setAttribute("fieldList", this.fieldList);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/table.jsp");
                dispatcher.forward(request, response);
            } else {
                // computer to cube
                wuerfeln(this.player2);
                //move(this.player2);
                //session.setAttribute("fieldList", this.fieldList);
                // computer got a 6
                 if (this.player2.getCube().getNumber() == 6) {
                    
                    this.computerCube = "6";
                    
                    while (this.player2.getCube().getNumber() == 6) {
                        wuerfeln(this.player2);
                        //move(this.player2);
                
                        computerCube += " - " + player2.getCube().getNumber();
                        gameInfo.setCubeComputer(computerCube);
                    }
                    session.setAttribute("gameInfo", gameInfo);
                    //session.setAttribute("fieldList", this.fieldList);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/table.jsp");
                    dispatcher.forward(request, response);
                } else {
                    computerCube = "";
                    gameInfo.setCubeComputer(computerCube + player2.getCube().getNumber());
                    session.setAttribute("gameInfo", gameInfo);
            
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/table.jsp");
                    dispatcher.forward(request, response);
                }
            }
        } else {
            
        }  
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
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
        //TODO
        // palce restart game here
        /*
         * Beispiel Code vom RegistrationMVC aus der LVA
         * 
         * HttpSession session = request.getSession(true);         
        User user =(User)session.getAttribute("user");
        boolean newuser = false;
        if(user == null) {
            user = new User();            
            newuser = true;
            user.setUsername(request.getParameter("username"));
        } else {
            user = userpool.getUser(user.getUsername());
        }
        user.setFirstname(request.getParameter("firstname"));
        user.setLastname(request.getParameter("lastname"));        
        user.setPassword(request.getParameter("password"));

        String[] inter = request.getParameterValues("interests");
        if(!newuser) {
            user.clearInterests();
        }
        if(inter != null ) {
            List<String> interests = Arrays.asList(inter);
            if(interests.contains("webEngineering")) {
                user.addInterest(Interest.WEBENINEERING);                
            }
            if(interests.contains("modelEngineering")) {
                user.addInterest(Interest.MODELENGINEERING);                
            }
            if(interests.contains("semanticWeb")) {
                user.addInterest(Interest.SEMANTICWEB);                
            }
            if(interests.contains("objectOrientedModeling")) {
                user.addInterest(Interest.OBJECTORIENTEDMODELING);                
            }
            if(interests.contains("businessInformatics")) {
                user.addInterest(Interest.BUSINESSINFORMATICS);                
            }         
        } 
        
        session.setAttribute("user", user);
        
        if(newuser) {
            userpool.registerUser(user);
        }           
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/userpage.jsp");
        dispatcher.forward(request, response);
         * 
         */
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
    
    private void wuerfeln(Player player) {
        int number = generator.nextInt(6) + 1;
        player.getCube().setNumber(number);
        
        if (number == 1) {
            player.getCube().setTitle("W&uuml;rfel Zahl 1");
            player.getCube().setImage("img/wuerfel1.png");
            player.getCube().setAlt("W&uuml;rfel Zahl 1");
        }
        if (number == 2) {
            player.getCube().setTitle("W&uuml;rfel Zahl 2");
            player.getCube().setImage("img/wuerfel2.png");
            player.getCube().setAlt("W&uuml;rfel Zahl 2");
        }
        if (number == 3) {
            player.getCube().setTitle("W&uuml;rfel Zahl 3");
            player.getCube().setImage("img/wuerfel3.png");
            player.getCube().setAlt("W&uuml;rfel Zahl 3");
        }
        if (number == 4) {
            player.getCube().setTitle("W&uuml;rfel Zahl 4");
            player.getCube().setImage("img/wuerfel4.png");
            player.getCube().setAlt("W&uuml;rfel Zahl 4");
        }
        if (number == 5) {
            player.getCube().setTitle("W&uuml;rfel Zahl 5");
            player.getCube().setImage("img/wuerfel5.png");
            player.getCube().setAlt("W&uuml;rfel Zahl 5");
        }
        if (number == 6) {
            player.getCube().setTitle("W&uuml;rfel Zahl 6");
            player.getCube().setImage("img/wuerfel6.png");
            player.getCube().setAlt("W&uuml;rfel Zahl 6");
        }
    }
    
    private int movePlayer(Player player, int currentPosition, int steps) {
        
        int newPosition = currentPosition + steps;
        
        //fields.remove(currentPosition);
        //fields.put(newPosition, player);
        
        return newPosition;
    }
    
    private void move(Player player) {
        // dirty
        int old = player.getActPosition();
        old += player.getCube().getNumber();
        player.setActPosition(old);
        player.setImage("img/field_" + player.getId() + ".png");
        this.fieldList = new FieldList();
        
        for (int i = 1; i <= 40; i++) {
            Field f = new Field();
            f.setId("field" + i);
            if (i == player.getActPosition())
                f.setSrc(player.getImage());
            else
                f.setSrc("img/field.png");
            //TODO richtige Werte
            f.setAlt("");
            f.setTitle("");
            fieldList.getFieldList().add(f);
            
        }
        
        
    }
}
