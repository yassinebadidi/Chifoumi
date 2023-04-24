package servelet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Post;
import model.User;
import service.PostService;

import java.io.IOException;
import java.sql.*;
import java.util.List;

@WebServlet(urlPatterns = PostListServlet.URL)
public class PostListServlet extends HttpServlet {
    public static final String URL = "/posts";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse rep) throws ServletException, IOException {
        String url = "jdbc:mysql://localhost:3306/projet_posts";
        String user ="root";
        String myPassword ="yassine";

        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection myConnection = DriverManager.getConnection(url, user, myPassword);

            Statement myStatement = myConnection.createStatement();
            ResultSet myResultSet = myStatement.executeQuery("SELECT id,username,password FROM users");

            while (myResultSet.next()){
                int id = myResultSet.getInt("id");
                String username = myResultSet.getString("username");
                String password = myResultSet.getString("password");

                User u = new User(id,username,password);
                System.out.println(u.getId());
                System.out.println(u.getUsername());
                System.out.println(u.getPassword());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        PostService postService = new PostService();
        List<Post> postList = postService.fetchPosts();

        req.setAttribute("posts", postList);
        req.getRequestDispatcher("/WEB-INF/post-list.jsp").forward(req,rep);
    }
}
