package servlets;

import services.UserService;
import services.UserServiceImpl;
import user.User;
import util.DBHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class getAllUsersServlet extends HttpServlet {

    UserServiceImpl userServiceImpl = UserServiceImpl.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

    }
}
