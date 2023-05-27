package controller;


import entity.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import repository.UserRepository;
import resources.FeedBack;

/**
 *
 * @author King Shadow
 */
@WebServlet(urlPatterns={
    "/login", "/signup", "/logout"
})
public class UserController extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        if(request.getServletPath().equals("/login"))
            request.getRequestDispatcher("login.jsp").forward(request, response);
        else if(request.getServletPath().equals("/signup"))
            request.getRequestDispatcher("signup.jsp").forward(request, response);
    } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        HttpSession session = request.getSession();
        if(request.getServletPath().equals("/login"))
        {
            String name = request.getParameter("username");
            String password = request.getParameter("password");
            
            if(name == null && password == null)
                request.getRequestDispatcher("login.jsp").forward(request, response);
            
            User user = UserRepository.verifyUser(name, password);
            if(user != null)
            {
                session.setAttribute("user", user);
                if(user.getMultiChainWallets().isEmpty() && user.getSingleChainWallets().isEmpty())
                    response.sendRedirect("welcome.jsp");
                else
                {
                    if(!user.getMultiChainWallets().isEmpty())
                    {
                        session.setAttribute("currentWalletType", "multiChain");
                        session.setAttribute("currentWallet", user.getMultiChainWallets().get(0));
                    }
                    else
                    {
                        session.setAttribute("currentWalletType", "singleChain");
                        session.setAttribute("currentWallet", user.getSingleChainWallets().get(0));
                    }
                    response.sendRedirect("index.jsp");
                }
            }
            else
            {
                FeedBack feedBack = new FeedBack("error", "Invalid username and/or password");
                session.setAttribute("feedback", feedBack);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }
        else if(request.getServletPath().equals("/signup"))
        {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            
            if(username == null && password == null)
                request.getRequestDispatcher("signup.jsp").forward(request, response);
            
            if(UserRepository.userExists(username))
            {
                FeedBack feedBack = new FeedBack("error", "Username is taken. Use another one.");
                session.setAttribute("feedback", feedBack);
                request.getRequestDispatcher("signup.jsp").forward(request, response);
            }
            
            User user = new User(username, password);
            
            boolean addedUser = UserRepository.addUser(user);
            if(!addedUser)
            {
                FeedBack feedBack = new FeedBack("error", "Cannot create account. Please try again later.");
                session.setAttribute("feedback", feedBack);
                request.getRequestDispatcher("signup.jsp").forward(request, response);
            }
            else if(addedUser)
            {
                session.setAttribute("user", user);
                response.sendRedirect("welcome.jsp");
            }
        }
        else if(request.getServletPath().equals("/logout"))
        {
            session.invalidate();
            response.sendRedirect("login");
        }
    }
}
