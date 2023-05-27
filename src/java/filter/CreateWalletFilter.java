/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package filter;

import java.io.IOException;
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

/**
 *
 * @author King Shadow
 */
@WebFilter(filterName="CreateWalletFilter", urlPatterns={
    "/createWallet.jsp"
})
public class CreateWalletFilter implements Filter 
{

    private FilterConfig filterConfig = null; 

    public void init(FilterConfig filterConfig) 
    {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException 
    {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        
        if(session.getAttribute("walletName") != null && session.getAttribute("walletPassword") != null)
        {
            response.sendRedirect("chooseChain.jsp");
        }
        else
        {
            chain.doFilter(request, response);
        }
    }
    
    public void destroy() 
    { 
    }
}
