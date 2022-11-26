package com.esliceu.practicaMaze.controllers;

import com.esliceu.practicaMaze.DAO.WinnersMysql;
import com.esliceu.practicaMaze.model.Winner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet("/endform")
public class endFormController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/endform.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String winnerName = req.getParameter("Winner");
        WinnersMysql winnersMysql = new WinnersMysql();
        Winner winner = new Winner();
        winner.setWinnerName(winnerName);
        String mazeName;
        int mazeID = (int) session.getAttribute("mapID");
        if (mazeID == 1) {
            mazeName = "Maze 1";
        } else {
            mazeName = "Maze 2";
        }
        winner.setMazeName(mazeName);
        Date date = new Date();
        long timeFinish = date.getTime();
        long timeStart = (long) session.getAttribute("timeStart");
        long time = (timeFinish - timeStart);
        winner.setTime(time);
        winnersMysql.insertWinner(winner);

        resp.sendRedirect("/winners");
    }
}
