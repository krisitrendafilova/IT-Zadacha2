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
import java.util.Comparator;
import java.util.List;

@WebServlet("/players/results")
public class ShowAllPlayers extends HttpServlet {
    private final Storage storage = Storage.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Players:</title></head>");
        out.println("<body>");

        List<ChessPlayer> players = storage.getPlayers();
        if(players.isEmpty()){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            out.println("<p>No players are added to the list! </p>");
        } else {
            response.setStatus(HttpServletResponse.SC_OK);
            players.sort(Comparator.comparing(ChessPlayer::getElo).reversed());
            for (int i = 0; i < players.size(); i++) {
                ChessPlayer pl = players.get(i);
                out.println("<hr>");
                out.println("<p>ID: " + pl.getFideId() + "</p>");
                out.println("<p>Name: " + pl.getName() + "</p>");
                out.println("<p>Last name: " + pl.getLastName() + "</p>");
                out.println("<p>Elo: " + pl.getElo() + "</p>");

            }
            out.println("</body>");
            out.println("</html>");
        }
    }
}