package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "PrivateController", urlPatterns = "/private/*")
public class PrivateController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        if ("/logout".equals(request.getPathInfo())){
            HttpSession session = request.getSession(false);
            if (session!= null){
                session.invalidate();
            }
            response.sendRedirect("/");
        }else
        if ("/private".equals(request.getServletPath())){
            if(request.isUserInRole("private")) {
                request.setAttribute("name", request.getUserPrincipal().getName());
                request.getRequestDispatcher("WEB-INF/private/private_article.jsp").
                        forward(request, response);
            }
        }

    }
}
