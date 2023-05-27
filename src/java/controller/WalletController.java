package controller;

import entity.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import repository.BlockchainRepository;
import repository.UserRepository;
import repository.WalletRepository;
import resources.FeedBack;
import resources.Hash;

/**
 *
 * @author King Shadow
 */
@WebServlet(urlPatterns={
    "/backup-wallet", "/create-wallet", "/import-wallet", "/setup-imported-wallet", "/switch-wallet", "/view-wallets"
})
public class WalletController extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        String servletPath = request.getServletPath();
        HttpSession session = request.getSession();
        if(servletPath.equals("/create-wallet"))
            request.getRequestDispatcher("createWallet.jsp").forward(request, response);
        else if(servletPath.equals("/view-wallets"))
        {
            if(session.getAttribute("user") == null)
                response.sendRedirect("login");
            else
            {
                User user = (User)session.getAttribute("user");
                session.setAttribute("userMCWallets", user.getMultiChainWallets());
                session.setAttribute("userSCWallets", user.getPureSingleChainWallets());
                response.sendRedirect("viewWallets.jsp");
            }
        }
    } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String servletPath = request.getServletPath();
        HttpSession session = request.getSession();
        
        if(servletPath.equals("/backup-wallet"))
        {
            User user = (User)session.getAttribute("user");

            session.setAttribute("multiChainWallets", user.getMultiChainWallets());
            session.setAttribute("singleChainWallets", user.getSingleChainWallets());
            
            UserRepository.updateUserInfo(user);
            
                    
            session.removeAttribute("walletName");
            session.removeAttribute("walletPassword");
            session.removeAttribute("multicoin");
            session.removeAttribute("blockchainName");
            
            session.removeAttribute("seedWords");
            session.removeAttribute("privateKey");
            response.sendRedirect("index.jsp");
        }
        else if(servletPath.equals("/create-wallet"))
        {
            if(session.getAttribute("user") == null)
                response.sendRedirect("login");
            
            User user = (User)session.getAttribute("user");
            
            String walletName = request.getParameter("walletName");
            if(walletName != null)
            {
                if(!UserRepository.walletExists(user, walletName))
                    session.setAttribute("walletName", walletName);
                else
                {
                    FeedBack feedBack = new FeedBack("error", "Wallet exists. Choose another name.");
                    session.setAttribute("feedback", feedBack);
                    request.getRequestDispatcher(servletPath);
                }
            }
            
            String walletPassword = request.getParameter("walletPassword");
            if(walletPassword != null)
                session.setAttribute("walletPassword", walletPassword);
            
            if(session.getAttribute("walletName") != null && session.getAttribute("walletPassword") != null)
            {
                String blockchainName = request.getParameter("blockchainName");
                String multicoin = request.getParameter("multicoin");

                String name = session.getAttribute("walletName").toString();
                String password = session.getAttribute("walletPassword").toString();
                
                if(multicoin != null)
                {
                    MultiChainWallet multiChainWallet = new MultiChainWallet(name, password, user);
                    String[] seedWords = multiChainWallet.getAddressContainer().getSeedWords();
                    String privateKey = multiChainWallet.getAddressContainer().getPrivateKey();
                    user.getMultiChainWallets().add(multiChainWallet);
                    
                    session.setAttribute("currentWalletType", "multiChain");
                    session.setAttribute("currentWallet", multiChainWallet);
                    
                    session.setAttribute("backupType", "mnemonic");
                    
                    session.setAttribute("seedWords", seedWords);
                    session.setAttribute("privateKey", privateKey);
                    response.sendRedirect("backupWallet.jsp");
                    return;
                }
                else if(blockchainName != null)
                {
                    Blockchain blockchain = BlockchainRepository.getBlockchainByName(blockchainName);
                    
                    SingleChainWallet singleChainWallet = new SingleChainWallet(name, password, blockchain, false, user);
                    String[] seedWords = singleChainWallet.getAddress().getSeedWords();
                    String privateKey = singleChainWallet.getAddress().getPrivateKey();
                    user.getSingleChainWallets().add(singleChainWallet);
                    
                    session.setAttribute("currentWalletType", "singleChain");
                    session.setAttribute("currentWallet", singleChainWallet);
                    
                    session.setAttribute("backupType", "mnemonic");
                    
                    session.setAttribute("seedWords", seedWords);
                    session.setAttribute("privateKey", privateKey);
                    response.sendRedirect("backupWallet.jsp");
                    return;
                }
                
                List<Blockchain> blockchains = BlockchainRepository.getAllBlockchains();
                session.setAttribute("blockchains", blockchains);
                session.setAttribute("action", "create-wallet");
                request.getRequestDispatcher("chooseChain.jsp").forward(request, response);
                return;
            }
            
            request.getRequestDispatcher("createWallet.jsp").forward(request, response);
        }
        else if(servletPath.equals("/import-wallet"))
        {
            User user = (User)session.getAttribute("user");
            if(user == null)
                response.sendRedirect("login");
            
            String importMethod = (String)session.getAttribute("importMethod");
            System.out.println("Import method from parameter: " + importMethod);
            if(importMethod == null)
            {
                importMethod = request.getParameter("by");
                if(importMethod != null)
                {
                    session.setAttribute("importMethod", importMethod);
                    request.getRequestDispatcher("importWallet.jsp").forward(request, response);
                }
                else
                    request.getRequestDispatcher("addWallet.jsp").forward(request, response);
            }
            else
            {
                if(importMethod.equals("Seed Words"))
                    importMethod = "seedWords";
                else if(importMethod.equals("Private Key"))
                    importMethod = "privateKey";
                session.setAttribute("importMethod", importMethod);
            }
                

            String blockchainName = (String)session.getAttribute("blockchainName");
            String multicoin = (String)session.getAttribute("multicoin");
            
            if(blockchainName == null)
            {
                blockchainName = request.getParameter("blockchainName");
                if(blockchainName != null)
                {
                    System.out.println("Blockchain attribute successfully set to " + blockchainName);
                    session.setAttribute("blockchainName", blockchainName);
                }
            }
            else if(multicoin == null)
            {
                multicoin = request.getParameter("multicoin");
                if(multicoin != null)
                {                    
                    System.out.println("Multichain attribute successfully set to " + blockchainName);
                    session.setAttribute("multicoin", multicoin);
                }
            }
            
            
            if(multicoin != null)
            {
                session.setAttribute("multicoin", multicoin);
                if(importMethod.equals("seedWords"))
                {
                    String seedPhrase = request.getParameter("seedPhrase");
                    if(seedPhrase != null)
                    {
                        MultiChainWallet importedWallet = WalletRepository.getMCWalletBySeedPhrase(seedPhrase);
                        if(importedWallet != null)
                        {
                            System.out.println("Imported wallet is not null.");
                            session.setAttribute("importedWallet", importedWallet);
                            session.setAttribute("importedWalletType", "multichain");
                            
                            session.removeAttribute("blockchainName");
                            session.removeAttribute("multicoin");
                            session.removeAttribute("importMethod");
                            
                            FeedBack feedBack = new FeedBack("info", "Wallet successfully imported. Finish setting it up");
                            session.setAttribute("feedback", feedBack);
                            
                            request.getRequestDispatcher("/setup-imported-wallet").forward(request, response);
                        }
                        else
                        {
                            FeedBack feedBack = new FeedBack("error", "Wallet does not exist");
                        
                            session.setAttribute("feedback", feedBack);
                            request.getRequestDispatcher("importWallet.jsp").forward(request, response);
                        }
                        return;
                    }
                    else
                        request.getRequestDispatcher("importWallet.jsp").forward(request, response);
                }
                else if(importMethod.equals("privateKey"))
                {
                    String privateKey = request.getParameter("privateKey");
                    if(privateKey != null)
                    {
                        MultiChainWallet importedWallet = WalletRepository.getMCWalletByPrivateKey(privateKey);
                        if(importedWallet != null)
                        {
                            session.setAttribute("importedWallet", importedWallet);
                            session.setAttribute("importedWalletType", "multichain");
                            
                            session.removeAttribute("blockchainName");
                            session.removeAttribute("multicoin");
                            session.removeAttribute("importMethod");
                            
                            FeedBack feedBack = new FeedBack("info", "Wallet successfully imported. Finish setting it up");
                            session.setAttribute("feedback", feedBack);
                            
                            request.getRequestDispatcher("/setup-imported-wallet").forward(request, response);
                        }
                        else
                        {
                            FeedBack feedBack = new FeedBack("error", "Wallet does not exist");
                        
                            session.setAttribute("feedback", feedBack);
                            request.getRequestDispatcher("importWallet.jsp").forward(request, response);
                        }
                        return;
                    }
                    else
                        request.getRequestDispatcher("importWallet.jsp").forward(request, response);
                }
                
                request.getRequestDispatcher("importWallet.jsp").forward(request, response);
                
                return;
            }
            else if(blockchainName != null)
            {
                if(importMethod.equals("seedWords"))
                {
                    String seedPhrase = request.getParameter("seedPhrase");
                    if(seedPhrase != null)
                    {
                        SingleChainWallet importedWallet = WalletRepository.getSCWalletBySeedPhrase(seedPhrase, BlockchainRepository.getBlockchainByName(blockchainName));
                        if(importedWallet != null)
                        {
                            session.setAttribute("importedWallet", importedWallet);
                            session.setAttribute("importedWalletType", "singlechain");
                            
                            session.removeAttribute("blockchainName");
                            session.removeAttribute("multicoin");
                            session.removeAttribute("importMethod");
                            
                            FeedBack feedBack = new FeedBack("info", "Wallet successfully imported. Finish setting it up");
                            session.setAttribute("feedback", feedBack);
                            
                            request.getRequestDispatcher("/setup-imported-wallet").forward(request, response);
                        }
                        else
                        {
                            FeedBack feedBack = new FeedBack("error", "Wallet does not exist");
                            
                            session.setAttribute("feedback", feedBack);
                            request.getRequestDispatcher("importWallet.jsp").forward(request, response);
                        }
                        return;
                    }
                    else
                        request.getRequestDispatcher("importWallet.jsp").forward(request, response);

                }
                else if(importMethod.equals("privateKey"))
                {
                    String privateKey = request.getParameter("privateKey");
                    if(privateKey != null)
                    {
                        SingleChainWallet importedWallet = WalletRepository.getSCWalletByPrivateKey(privateKey, BlockchainRepository.getBlockchainByName(blockchainName));
                        if(importedWallet != null)
                        {
                            session.setAttribute("importedWallet", importedWallet);
                            session.setAttribute("importedWalletType", "singlechain");
                            
                            session.removeAttribute("blockchainName");
                            session.removeAttribute("multicoin");
                            session.removeAttribute("importMethod");
                            
                            FeedBack feedBack = new FeedBack("info", "Wallet successfully imported. Finish setting it up");
                            session.setAttribute("feedback", feedBack);
                            
                            request.getRequestDispatcher("/setup-imported-wallet").forward(request, response);
                        }
                        else
                        {
                            FeedBack feedBack = new FeedBack("error", "Wallet does not exist");
                            
                            session.setAttribute("feedback", feedBack);
                            request.getRequestDispatcher("importWallet.jsp").forward(request, response);
                        }
                        return;
                    }
                    else
                        request.getRequestDispatcher("importWallet.jsp").forward(request, response);
                }
                
                request.getRequestDispatcher("importWallet.jsp").forward(request, response);
                
                return;
            }
            
            List<Blockchain> blockchains = BlockchainRepository.getAllBlockchains();
            session.setAttribute("blockchains", blockchains);
            session.setAttribute("action", "import-wallet");
            request.getRequestDispatcher("chooseChain.jsp").forward(request, response);
        }
        else if(servletPath.equals("/setup-imported-wallet"))
        {
            MultiChainWallet importedMCWallet = null;
            SingleChainWallet importedSCWallet = null;
            
            if(session.getAttribute("importedWallet") != null && session.getAttribute("importedWalletType") != null)
            {
                String importedWalletType = (String)session.getAttribute("importedWalletType");
                if(importedWalletType.equals("multichain"))
                    importedMCWallet = (MultiChainWallet) session.getAttribute("importedWallet");
                else if(importedWalletType.equals("singlechain"))
                    importedSCWallet = (SingleChainWallet) session.getAttribute("importedWallet");
            }
            
            if(session.getAttribute("user") == null)
                response.sendRedirect("login");
            
            User user = (User)session.getAttribute("user");
            
            String walletName = request.getParameter("walletName");
            if(walletName != null)
            {
                if(!UserRepository.walletExists(user, walletName))
                    session.setAttribute("walletName", walletName);
                else
                {
                    FeedBack feedBack = new FeedBack("error", "Wallet exists. Choose another name.");
                    session.setAttribute("feedback", feedBack);
                    request.getRequestDispatcher(servletPath);
                }
            }
            
            String walletPassword = request.getParameter("walletPassword");
            if(walletPassword != null)
                session.setAttribute("walletPassword", walletPassword);
            
            if(session.getAttribute("walletName") != null && session.getAttribute("walletPassword") != null)
            {
                String name = session.getAttribute("walletName").toString();
                String password = session.getAttribute("walletPassword").toString();
                
                if(importedMCWallet != null)
                {
                    importedMCWallet.setName(name);
                    importedMCWallet.setHashedPassword(Hash.MD5_String(password));
                    user.getMultiChainWallets().add(importedMCWallet);
                    UserRepository.updateUserInfo(user);
                    
                    session.setAttribute("currentWalletType", "multiChain");
                    session.setAttribute("currentWallet", importedMCWallet);
                    
                    
                    session.removeAttribute("importMethod");
                    session.removeAttribute("blockchainName");
                    session.removeAttribute("multicoin");
                    session.removeAttribute("importedWallet");
                    session.removeAttribute("importedWalletType");
                    session.removeAttribute("feedback");                    
                    
                    
                    response.sendRedirect("index.jsp");
                    return;
                }
                else if(importedSCWallet != null)
                {
                    importedSCWallet.setName(name);
                    importedSCWallet.setHashedPassword(Hash.MD5_String(password));
                    user.getSingleChainWallets().add(importedSCWallet);
                    UserRepository.updateUserInfo(user);
                    
                    session.setAttribute("currentWalletType", "singleChain");
                    session.setAttribute("currentWallet", importedSCWallet);
                    
                    
                    session.removeAttribute("importMethod");
                    session.removeAttribute("blockchainName");
                    session.removeAttribute("multicoin");
                    session.removeAttribute("importedWallet");
                    session.removeAttribute("importedWalletType");
                    session.removeAttribute("feedback");
                    
                    
                    response.sendRedirect("index.jsp");
                    return;
                }
            }
            
            request.getRequestDispatcher("createWallet.jsp").forward(request, response);
        }
        else if(servletPath.equals("/switch-wallet"))
        {
            String walletId = request.getParameter("walletId");
            String walletType = request.getParameter("walletType");
            
            if(walletId != null && walletType != null)
            {
                if(walletType.equals("multiChain"))
                {
                    MultiChainWallet multiChainWallet = WalletRepository.findMCWalletById(Long.parseLong(walletId));
                    
                    session.setAttribute("currentWalletType", walletType);
                    session.setAttribute("currentWallet", multiChainWallet);
                    
                    response.sendRedirect("index.jsp");
                }
                else if(walletType.equals("singleChain"))
                {
                    SingleChainWallet singleChainWallet = WalletRepository.findSCWalletById(Long.parseLong(walletId));
                    
                    session.setAttribute("currentWalletType", walletType);
                    session.setAttribute("currentWallet", singleChainWallet);
                    
                    response.sendRedirect("index.jsp");
                }
            }
            else
                response.getWriter().print("WalletId and WalletType is null");
        }
        else if(servletPath.equals("/view-wallets"))
        {
            if(session.getAttribute("user") == null)
                response.sendRedirect("login");
            else
            {
                User user = (User)session.getAttribute("user");
                session.setAttribute("userMCWallets", user.getMultiChainWallets());
                session.setAttribute("userSCWallets", user.getPureSingleChainWallets());
                response.sendRedirect("viewWallets.jsp");
            }
        }
    }
}