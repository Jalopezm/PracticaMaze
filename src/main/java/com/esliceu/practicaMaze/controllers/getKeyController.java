package com.esliceu.practicaMaze.controllers;

import com.esliceu.practicaMaze.model.Item;
import com.esliceu.practicaMaze.model.Key;
import com.esliceu.practicaMaze.model.Player;
import com.esliceu.practicaMaze.model.Room;
import com.esliceu.practicaMaze.services.KeyService;
import com.esliceu.practicaMaze.services.RoomService;

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
            for (int i = 0; i < key.getValue(); i++) {
                keyService.getKey(key,player,room);
            }
            resp.sendRedirect("/nav");
        }else{
            resp.sendRedirect("/nav");
        }
    }
}
