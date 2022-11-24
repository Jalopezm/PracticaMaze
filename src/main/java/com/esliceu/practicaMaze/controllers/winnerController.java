package com.esliceu.practicaMaze.controllers;

import com.esliceu.practicaMaze.DAO.WinnersMysql;
import com.esliceu.practicaMaze.model.Winner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/winners")
public class winnerController extends HttpServlet {
    WinnersMysql winnersMysql = new WinnersMysql();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Winner> winnerList = winnersMysql.getAllWinners();
        req.setAttribute("winnersList",winnerList);
        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/winner.jsp");
        dispatcher.forward(req, resp);
    }
}
