/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package filter;

import entity.User;
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

/**
 *
 * @author King Shadow
 */
@WebFilter(filterName="UserFilter", urlPatterns={"/*"})
public class UserFilter implements Filter 
{

    private FilterConfig filterConfig = null; 

    @Override
    public void init(FilterConfig filterConfig) 
    { 
	
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException 
    {
//        HttpServletRequest req = (HttpServletRequest) request;
//        HttpServletResponse resp = (HttpServletResponse) response;
//        
//        User user = (User)req.getSession().getAttribute("user");
//        if(user == null)
//        {
//            req.getSession().invalidate();
//            resp.sendRedirect("login.jsp");
//            req.getRequestDispatcher("login").forward(req, resp);
//        }
//        else
            chain.doFilter(request, response);
    }
    
    @Override
    public void destroy() 
    { 
    }
}
