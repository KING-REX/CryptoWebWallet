package controller;

import entity.Address;
import entity.Token;
import entity.Transaction;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import repository.AddressRepository;
import resources.FeedBack;

/**
 *
 * @author King Shadow
 */
@WebServlet(name="AddressController", urlPatterns={
    "/send-receive", "/send-tokens"
})
public class AddressController extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        String servletPath = request.getServletPath();
        
        if(servletPath.equals("/send-receive"))
        {
            String action = request.getParameter("send-receive");
            if(action != null)
            {
                response.sendRedirect(action + ".jsp");
            }
        }
        else if(servletPath.equals("/send-tokens"))
        {
            Address address = (Address) session.getAttribute("currentAddress");
            Token token = (Token) session.getAttribute("tokenSelected");
            
            double amountTransferred = Double.parseDouble(request.getParameter("amount"));
            Address receivingAddress = AddressRepository.getAddressByAddressStr(request.getParameter("receivingAccount"));
            
            if(address != null && token != null && amountTransferred > 0 && receivingAddress != null)
            {
                Transaction transaction = AddressRepository.sendTokens(address, token, amountTransferred, receivingAddress);
                
                FeedBack feedBack = new FeedBack("info", "Transaction submitted.");
                session.setAttribute("feedback", feedBack);
                
                response.sendRedirect("viewSelectedWallet.jsp");
            }
            else
            {
                FeedBack feedBack;
                if(amountTransferred <= 0)
                {
                    feedBack = new FeedBack("error", "Amount transferred must be positive.");
                }
                else if(amountTransferred > AddressRepository.getAddressTokenBalance(address, token).getBalance())
                {
                    feedBack = new FeedBack("error", "Insufficient balance.");
                }
                else
                {
                    feedBack = new FeedBack("error", "One parameter is null. Check your values.");
                }
                
                session.setAttribute("feedback", feedBack);
                request.getRequestDispatcher("sendTokens.jsp").forward(request, response);
            }
        }
    }
}
