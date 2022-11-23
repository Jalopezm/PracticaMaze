package com.esliceu.practicaMaze.controllers;

import com.esliceu.practicaMaze.model.*;
import com.esliceu.practicaMaze.services.GameService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/open")
public class openController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Player player = (Player) session.getAttribute("player");

        String dir = req.getParameter("dir");
        Room room = player.getCurrRoom();
        MapSite ms = room.getSides(Maze.Directions.valueOf(dir));
String message = "";
        if (ms instanceof Door) {
            ((Door) ms).openDoor(player);
            if (((Door) ms).isOpen()){
                message = "YOU'VE OPENED THE DOOR";
            }else {
                message = "YOU DON'T HAVE THE KEY";
            }
            String myjson = GameService.getJsonInfo(room, player, message);
            req.setAttribute("myjson", myjson);
        }
        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/nav.jsp");
        dispatcher.forward(req, resp);    }
}
