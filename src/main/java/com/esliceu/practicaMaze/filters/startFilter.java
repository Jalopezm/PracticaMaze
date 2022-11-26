package com.esliceu.practicaMaze.filters;

import com.esliceu.practicaMaze.model.Player;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class startFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();
        Player player = (Player) session.getAttribute("player");
        if (player == null) {
            res.sendRedirect("/start");
            return;
        }else {
            req.setAttribute("player", player);
        }
        chain.doFilter(req, res);
    }
}
