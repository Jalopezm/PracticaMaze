package com.esliceu.practicaMaze.controllers;

import com.esliceu.practicaMaze.model.Player;
import com.esliceu.practicaMaze.model.Room;
import com.esliceu.practicaMaze.services.GameService;
import com.esliceu.practicaMaze.services.RoomService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/nav")
public class NavController extends HttpServlet {
    Player player;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();
            player = (Player) session.getAttribute("player");

            String dir = req.getParameter("dir");
            RoomService roomService = new RoomService();
            roomService.movePlayer(dir, player);
            Room room = player.getCurrRoom();

            String myjson = GameService.getJsonInfo(room, player);
            req.setAttribute("myjson", myjson);
            if (room.isTarget()) {
                System.out.println("WINNER");
            }
            RequestDispatcher dispatcher =
                    req.getRequestDispatcher("/WEB-INF/jsp/nav.jsp");
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            resp.sendRedirect("/start");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/nav.jsp");
        dispatcher.forward(req, resp);
    }
}
