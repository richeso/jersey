package autologin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author SergeyZ
 *
 */
public class TomcatLogin extends HttpServlet {

    private static final long serialVersionUID = 1820705498195390552L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String user = req.getParameter("username");
        String password = req.getParameter("password");
        ArrayList<String> roles = new ArrayList<String>();
        roles.add("user");
        roles.add("adminstrator");
        roles.add("programmer");
        roles.add("supervisor");

        ProgrammaticAuthenticator authenticator = new ProgrammaticAuthenticator();
        authenticator.authenticate(req, resp, user, password, roles);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("showuser.jsp");
        requestDispatcher.forward(req, resp);
    }

}