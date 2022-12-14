package com.esliceu.practicaMaze.controllers;

import com.esliceu.practicaMaze.model.*;
import com.esliceu.practicaMaze.services.DoorService;
import com.esliceu.practicaMaze.services.GameService;
import com.esliceu.practicaMaze.services.RoomService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/open")
public class openController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Player player = (Player) session.getAttribute("player");

        String dir = req.getParameter("dir");
        DoorService doorService = new DoorService();
        String myjson = doorService.open(dir, player);

        req.setAttribute("myjson", myjson);

        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/nav.jsp");
        dispatcher.forward(req, resp);
    }
}
