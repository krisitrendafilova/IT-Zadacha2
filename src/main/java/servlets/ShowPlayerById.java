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

@WebServlet("/players/view")
public class ShowPlayerById extends HttpServlet {
    private final Storage storage = Storage.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Details:</title></head>");
        out.println("<body>");

        String fideId = request.getParameter("fideId");
        if(fideId == null){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.println("<p>Invalid value for fideId! </p>");
            return;
        }
        int fID = Integer.parseInt(fideId);
        ChessPlayer chessPlayer = storage.showPlaayerByID(fID);
        if(chessPlayer == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            out.println("<p>There is no player with this id!</p>");
        } else {
            response.setStatus(HttpServletResponse.SC_OK);
            out.println("<hr>");
            out.println("<p>ID: " + chessPlayer.getFideId() + "</p>");
            out.println("<p>Name: " + chessPlayer.getName() + "</p>");
            out.println("<p>Last name: " + chessPlayer.getLastName() + "</p>");
            out.println("<p>Elo: " + chessPlayer.getElo() + "</p>");

        }
        out.println("</body>");
        out.println("</html>");
    }

}
