package com.esliceu.practicaMaze.controllers;

import com.esliceu.practicaMaze.model.Player;
import com.esliceu.practicaMaze.services.RoomService;
import com.esliceu.practicaMaze.excepcions.UnknownDirException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
        HttpSession session = req.getSession();
        player = (Player) session.getAttribute("player");

        String dir = req.getParameter("dir");
        RoomService roomService = new RoomService();
        try {
            String myjson = roomService.movePlayer(dir, player);

            req.setAttribute("myjson", myjson);

            RequestDispatcher dispatcher =
                    req.getRequestDispatcher("/WEB-INF/jsp/nav.jsp");
            dispatcher.forward(req, resp);


        }catch (UnknownDirException e){
            String error= "UNKNOWMN INPUT DIRECTION";
            req.setAttribute("error",error);
            RequestDispatcher dispatcher =
                    req.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/nav.jsp");
        dispatcher.forward(req, resp);
    }
}
