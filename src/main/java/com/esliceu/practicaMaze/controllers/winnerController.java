package com.esliceu.practicaMaze.controllers;

import com.esliceu.practicaMaze.DAO.WinnersMysql;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/winners")
public class winnerController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("winners","WinnersMysql.getWinners()");
        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/winner.jsp");
        dispatcher.forward(req, resp);
    }
}
