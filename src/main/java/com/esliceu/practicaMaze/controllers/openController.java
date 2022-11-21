package com.esliceu.practicaMaze.controllers;

import com.esliceu.practicaMaze.model.*;

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

        if (ms instanceof Door) {
            ((Door) ms).openDoor(player);
        }
        resp.sendRedirect("/nav");
    }
}
