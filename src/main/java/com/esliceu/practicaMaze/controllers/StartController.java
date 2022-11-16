package com.esliceu.practicaMaze.controllers;

import com.esliceu.practicaMaze.model.Player;
import com.esliceu.practicaMaze.utils.GameUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/start")
public class StartController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/start.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        GameUtil gameUtil = new GameUtil();
        int mapId = Integer.parseInt(req.getParameter("map"));
        Player player = new Player();
        session.setAttribute("player", player);
        session.setAttribute("mapID",mapId);
        gameUtil.createMaze(mapId,player);
        resp.sendRedirect("/nav");

    }
}
