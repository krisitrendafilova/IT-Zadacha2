package servlets;

import collection.Storage;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.ChessPlayer;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/players/add")
public class AddPlayer extends HttpServlet {
    private final Storage storage = Storage.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Registration:</title></head>");
        out.println("<body>");

        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String strElo = request.getParameter("elo");
        if(strElo == null){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.println("<p>Invalid value for elo!</p>");
            return;
        }
        int elo = Integer.parseInt(strElo);

        if(name == null || name.isEmpty() || lastName == null || lastName.isEmpty()){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.println("<p>Name and last name are required!</p>");
        } else {
            response.setStatus(HttpServletResponse.SC_OK);
            ChessPlayer player = new ChessPlayer(name, lastName, elo);
            storage.addPlayer(player);
            out.println("<p>Player is added successfully!</p>");
        }
        out.println("</body>");
        out.println("</html>");
    }
}
