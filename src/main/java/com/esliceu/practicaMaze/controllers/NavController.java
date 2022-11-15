package com.esliceu.practicaMaze.controllers;

import com.esliceu.practicaMaze.model.Maze;
import com.esliceu.practicaMaze.services.MazeService;
import com.esliceu.practicaMaze.services.RoomService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/nav")
public class NavController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String myjson = MazeService.getJsonInfo();
        req.setAttribute("myjson", myjson);
        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/nav.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/nav.jsp");
        dispatcher.forward(req, resp);
    }
}
