package com.esliceu.practicaMaze.controllers;

import com.esliceu.practicaMaze.model.Item;
import com.esliceu.practicaMaze.model.Player;
import com.esliceu.practicaMaze.model.Room;
import com.esliceu.practicaMaze.services.CoinService;
import com.esliceu.practicaMaze.services.GameService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/getCoin")
public class getCoinController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Player player = (Player) session.getAttribute("player");
        CoinService coinService = new CoinService();
        Room room = player.getCurrRoom();


        boolean haveCoin = room.haveCoin();
        if (haveCoin) {
            Item coin = room.getItem(1);
             String message = coinService.getCoin(coin, player, room);
            String myjson = GameService.getJsonInfo(room, player, message);
            req.setAttribute("myjson", myjson);
            RequestDispatcher dispatcher =
                    req.getRequestDispatcher("/WEB-INF/jsp/nav.jsp");
            dispatcher.forward(req, resp);
        }else{
            resp.sendRedirect("/nav");
        }
    }
}
