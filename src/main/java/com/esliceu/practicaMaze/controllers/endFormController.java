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

@WebServlet("/endform")
public class endFormController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String winnerName = (String) req.getAttribute("Winner");

        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/endform.jsp");
        dispatcher.forward(req, resp);
    }
}
