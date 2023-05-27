package filter;

import entity.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import repository.AddressRepository;
import repository.WalletRepository;

/**
 *
 * @author King Shadow
 */
@WebFilter(filterName="Authentication", urlPatterns={
    "/index.jsp"
})
public class IndexFilter implements Filter {

    private FilterConfig filterConfig = null; 

    @Override
    public void init(FilterConfig filterConfig) 
    {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException 
    {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user == null)
            response.sendRedirect("login");
        else
        {
            String currentWalletType = (String) session.getAttribute("currentWalletType");
            Wallet currentWallet = (Wallet) session.getAttribute("currentWallet");
            
            if(currentWalletType == null || currentWallet == null)
                response.sendRedirect("viewWallets.jsp");
            else
            {
                if(currentWalletType.equals("multiChain"))
                {
                    MultiChainWallet multiChainWallet = (MultiChainWallet) session.getAttribute("currentWallet");
                    double totalValue = WalletRepository.computeTotalMCValue(multiChainWallet);
                    
                    session.setAttribute("totalWalletBalanceInUSD", totalValue);
                    
                    List<Token> allTokens = new ArrayList<>();
                    List<Double> allValues = new ArrayList<>();
                    
                    for(SingleChainWallet singleChainWallet : multiChainWallet.getWallets())
                    {
                        for(Token token : AddressRepository.getAddressTokens(singleChainWallet.getAddress()))
                        {
                            allTokens.add(token);
                            allValues.add(AddressRepository.getAddressTokenBalance(singleChainWallet.getAddress(), token).getBalance());
                        }
                    }
                    
                    session.setAttribute("allTokens", allTokens);
                    session.setAttribute("allValues", allValues);
                }
                else if(currentWalletType.equals("singleChain"))
                {
                    SingleChainWallet singleChainWallet = (SingleChainWallet) session.getAttribute("currentWallet");
                    double totalValue = WalletRepository.computeTotalSCValue(singleChainWallet);
                    double totalBalanceInNativeToken = WalletRepository.computeTotalBalanceInNativeToken(singleChainWallet);
                    
                    session.setAttribute("totalWalletBalanceInNT", totalBalanceInNativeToken);
                    session.setAttribute("totalWalletBalanceInUSD", totalValue);
                    
                    List<Token> allTokens = new ArrayList<>();
                    List<Double> allValues = new ArrayList<>();
                    
                    for(Token token : AddressRepository.getAddressTokens(singleChainWallet.getAddress()))
                    {
                        allTokens.add(token);
                        allValues.add(AddressRepository.getAddressTokenBalance(singleChainWallet.getAddress(), token).getBalance());
                    }
                    
                    session.setAttribute("allTokens", allTokens);
                    session.setAttribute("allValues", allValues);
                }
            }
            session.removeAttribute("currentAddress");
            session.removeAttribute("tokenSelected");
            session.removeAttribute("totalAddressBalanceInNT");
            session.removeAttribute("totalAddressBalanceInUSD");
            
            chain.doFilter(request, response);
        }
    }
    
    @Override
    public void destroy() 
    { 
    }
}