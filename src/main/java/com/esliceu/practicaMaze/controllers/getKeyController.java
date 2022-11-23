package com.esliceu.practicaMaze.controllers;

import com.esliceu.practicaMaze.model.Item;
import com.esliceu.practicaMaze.model.Key;
import com.esliceu.practicaMaze.model.Player;
import com.esliceu.practicaMaze.model.Room;
import com.esliceu.practicaMaze.services.GameService;
import com.esliceu.practicaMaze.services.KeyService;
import com.esliceu.practicaMaze.services.RoomService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/getKey")
public class getKeyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Player player = (Player) session.getAttribute("player");
        KeyService keyService = new KeyService();
        Room room = player.getCurrRoom();
        boolean haveKey = room.haveKey();

        if (haveKey) {
            Key key = (Key) room.getItem(0);
            if (player.playerTotalCoins(player) >= key.getValue()) {
                for (int i = 0; i < key.getValue(); i++) {
                  String message = keyService.getKey(key, player, room);
                    String myjson = GameService.getJsonInfo(room, player, message);

                    req.setAttribute("myjson", myjson);
                }

            }else{
                String message = "NOT ENOUGH COINS";
                String myjson = GameService.getJsonInfo(room, player, message);

                req.setAttribute("myjson", myjson);
            }
            RequestDispatcher dispatcher =
                    req.getRequestDispatcher("/WEB-INF/jsp/nav.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
