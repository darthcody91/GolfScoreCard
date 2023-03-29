package com.thomas.golfapp_final;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletScoreCard", value = "/ServletScoreCard")
public class ServletScoreCard extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("Doesn't Work");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html><head></head><body>");
        int hole1 = Integer.parseInt(request.getParameter("hole1"));
        int hole2 = Integer.parseInt(request.getParameter("hole2"));
        int hole3 = Integer.parseInt(request.getParameter("hole3"));
        int hole4 = Integer.parseInt(request.getParameter("hole4"));
        int hole5 = Integer.parseInt(request.getParameter("hole5"));
        int hole6 = Integer.parseInt(request.getParameter("hole6"));
        int hole7 = Integer.parseInt(request.getParameter("hole7"));
        int hole8 = Integer.parseInt(request.getParameter("hole8"));
        int hole9 = Integer.parseInt(request.getParameter("hole9"));

        int coursescore = Integer.parseInt(String.valueOf((hole1 + hole2 + hole3 + hole4 + hole5 + hole6 + hole7 + hole8 + hole9)));

        out.println("<h1>Course Score</h1>");
        out.println("<p>Score: " + coursescore + "</p>");

        out.println("</body></html>");
    }
}
