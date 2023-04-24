package servelet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.UserService;

import java.io.IOException;

@WebServlet(urlPatterns = AddUserServlet.URL)
public class AddUserServlet extends HttpServlet {

    public static final String URL = "/register";
    public static final String RegisterJSPpath = "/WEB-INF/register.jsp";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(RegisterJSPpath).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newusername = req.getParameter("newusername");
        String newpassword = req.getParameter("newpassword");

        UserService userService = new UserService();
        boolean Existe = userService.IsInDataBase(newusername);

        HttpSession session = req.getSession();

        if(!Existe){
            boolean UserCreated = userService.userCreat(newusername,newpassword);
            if(UserCreated){
                session.setAttribute("isCreated",true);
            }else{
                session.setAttribute("isCreated",false);
            }
        }else {
            session.setAttribute("Existe", true);
        }
    }
}
