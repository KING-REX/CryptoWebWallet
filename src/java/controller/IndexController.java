package controller;

import entity.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import repository.AddressRepository;
import repository.TokenRepository;
import repository.TransactionRepository;

/**
 *
 * @author King Shadow
 */
@WebServlet(name="IndexController", urlPatterns={
    "/remove-address", "/view-selected-wallet"
})
public class IndexController extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        HttpSession session = request.getSession();
        String servletPath = request.getServletPath();
        
        if(servletPath.equals("/view-selected-wallet"))
            this.doPost(request, response);
        else if(servletPath.equals("/remove-address"))
        {
            session.removeAttribute("currentAddress");
            response.sendRedirect("index.jsp");
        }
    } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String servletPath = request.getServletPath();
        HttpSession session = request.getSession();
        
        if(servletPath.equals("/view-selected-wallet"))
        {
            String currentWalletType = (String) session.getAttribute("currentWalletType");
            if(currentWalletType != null)
            {
                if(currentWalletType.equals("multiChain"))
                {
                    MultiChainWallet multiChainWallet = (MultiChainWallet) session.getAttribute("currentWallet");
                    
                    Token tokenSelected;
                    if(session.getAttribute("tokenSelected") == null)
                    {
                        long id = Long.parseLong(request.getParameter("tokenSelected"));
                        tokenSelected = TokenRepository.getTokenById(id);
                    }
                    else
                    {
                        tokenSelected = (Token)session.getAttribute("tokenSelected");
                    }
                    
                    for(SingleChainWallet scWallet : multiChainWallet.getWallets())
                    {
                        for(Token token : scWallet.getChain().getTokensHosted())
                        {
                            if(token.equals(tokenSelected))
                            {
                                Address currentAddress = scWallet.getAddress();
                                session.setAttribute("currentAddress", currentAddress);
                                
                                double totalAddressBalanceInNT = AddressRepository.computeTotalBalanceInNT(scWallet.getAddress());
                                double totalAddressBalanceInUSD = AddressRepository.computeTotalBalanceInUSD(scWallet.getAddress());
                                
                                session.setAttribute("totalAddressBalanceInNT", totalAddressBalanceInNT);
                                session.setAttribute("totalAddressBalanceInUSD", totalAddressBalanceInUSD);
                                
                                List<Transaction> transactions = TransactionRepository.getAllTransactionsByAddress(currentAddress);
                                session.setAttribute("transactions", transactions);
                                
                                break;
                            }
                        }
                    
                    }
                    
                    session.setAttribute("tokenSelected", tokenSelected);
                    
                }
                else if(currentWalletType.equals("singleChain"))
                {
                    SingleChainWallet singleChainWallet = (SingleChainWallet) session.getAttribute("currentWallet");
                    
                    Token tokenSelected;
                    if(session.getAttribute("tokenSelected") == null)
                    {
                        long id = Long.parseLong(request.getParameter("tokenSelected"));
                        tokenSelected = TokenRepository.getTokenById(id);
                    }
                    else
                    {
                        tokenSelected = (Token)session.getAttribute("tokenSelected");
                    }
                    
                    for(Token token : singleChainWallet.getChain().getTokensHosted())
                    {
                        if(token.equals(tokenSelected))
                        {
                            session.setAttribute("currentAddress", singleChainWallet.getAddress());

                            double totalAddressBalanceInNT = AddressRepository.computeTotalBalanceInNT(singleChainWallet.getAddress());
                            double totalAddressBalanceInUSD = AddressRepository.computeTotalBalanceInUSD(singleChainWallet.getAddress());

                            session.setAttribute("totalAddressBalanceInNT", totalAddressBalanceInNT);
                            session.setAttribute("totalAddressBalanceInUSD", totalAddressBalanceInUSD);
                    
                            List<Transaction> transactions = TransactionRepository.getAllTransactionsByAddress(singleChainWallet.getAddress());
                            session.setAttribute("transactions", transactions);
                            break;
                        }
                    }
                    session.setAttribute("tokenSelected", tokenSelected);
                }
            }
            
            response.sendRedirect("viewSelectedWallet.jsp");
        }
    }
}
