package servelet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.UserService;

import java.io.IOException;
import java.net.URL;

@WebServlet(urlPatterns = LoginServlet.URL)
public class LoginServlet extends HttpServlet {
    public static final String URL= "/login";
    public static final String LoginJSPpath = "/WEB-INF/login.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(LoginJSPpath).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserService userService = new UserService();
        boolean isLogged = userService.Isloged(username,password);

        if(isLogged){
            HttpSession session = req.getSession();
            session.setAttribute("username",username);
            resp.sendRedirect(req.getContextPath() + PostListServlet.URL);
        }else{
            req.setAttribute("isError",true);
            req.getRequestDispatcher(LoginJSPpath).forward(req,resp);
        }
    }
}
