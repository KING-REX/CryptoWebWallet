<%-- 
    Document   : viewWallets
    Created on : 11-Dec-2021, 12:58:08
    Author     : King Shadow
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/general.css" />
        <link rel="stylesheet" href="css/home2.css" />
        <link rel="stylesheet" href="fontawesome-free-5.15.4-web/css/all.min.css" />
        
        <title>View Wallets | CryptoWebWallet</title>
        
        <style>
            nav.menu-bar {
                display: flex;
                flex-direction: row;
                justify-content: space-between;
                align-items: center;
                width: 100%;
            }
            
            nav.menu-bar a:not(#add-wallet) {
                margin: 0;
                padding: 10px;
                width: 100%;
                text-decoration: none;
                text-align: center;
                color: #000;
                border-radius: 45px;
                box-shadow: none;
                transition: .2s all linear;
            }
            
            nav.menu-bar a:not(#add-wallet):hover {
                box-shadow: 0 0 3px 3px rgba(0, 0, 0, .5);
            }
            
            nav.menu-bar a h1 {
                margin: 0;
            }
            
            #add-wallet {
                margin: 10px 0;
            }
            
            .wallets-container {
                margin-top: 10vh;
                margin-left: auto;
                margin-right: auto;
                width: 40vw;
            }
            
            .multichain-wallet {
                margin-bottom: 35px;
            }
            
            .multichain-wallet, .singlechain-wallet {
                display: flex;
                margin: 30px 0;
                width: 100%;
                text-decoration: none;
                text-align: left;
                background-color: #fff;
                color: #000;
                padding: 15px 0;
                /*border: 3px solid #000;*/
                border-radius: 45px;
                box-shadow: 0 0 3px 3px rgba(0, 0, 0, .5);
                cursor: pointer;
            }
            
            .singlechain-wallet.not-supported, 
            .singlechain-wallet.not-supported .link{
                background-color: #b1acac;
                cursor: auto;
            }
            
            .singlechain-wallet.not-supported:hover {
            }
            
            .img-container {
                margin: 0 20px;
                height: 40px;
                width: 40px;
                border: 1px solid #222;
                border-radius: 50%;
                padding: 0;
                background-color: #000;
            }
            
            .not-single {
                background-color: #fff;
                border: none;
            }
            
            .img-container img {
                width: 100%;
                border-radius: 60px;
            }
            
            .link {
                border: none;
                outline: none;
                background-color: inherit;
                cursor: pointer;
            }
            
            .chain-separator {
                margin: 60px 0;
                height: 30px;
                width: 100%;
                background-color: #837f7f;
                border: 1px solid black;
                border-radius: 45px;
                box-shadow: inset 0 0 3px 3px rgba(0, 0, 0, .5);
            }
        </style>
    </head>
    <body>
        <div class="page-container">
            <nav class="menu-bar">
                <div class="primary-div">
                    <a href="index.jsp">
                        <h1><i class="fas fa-angle-left"></i> ${user.name}! Switch wallets here...</h1>
                    </a>
                </div>
                
                <div class="secondary-div">
                    <a id="add-wallet" href="addWallet.jsp">Add Wallet</a>
                </div>
            </nav>
            
            
            <div class="wallets-container">
                <c:if test="${not empty userMCWallets}">
                    <h3>Multi-Chain Wallets</h3>
                    <c:forEach items="${userMCWallets}" var="multichainWallet">
                        <form method="POST" action="switch-wallet">
                            <input type="hidden" name="walletId" value="${multichainWallet.id}"/>
                            <input type="hidden" name="walletType" value="multiChain"/>
                            <div class="multichain-wallet">
                                <div class="img-container not-single">
                                    <img src="images/MULTICOIN.png" alt="Multi Coin Wallet"/>
                                </div>
                                <input type="submit" name="multicoin" value="${multichainWallet.name}" class="link"/>
                            </div>
                        </form>
                    </c:forEach>
                </c:if>

                <c:if test="${not empty userSCWallets}">
                    <div class="chain-separator"></div>
                    <h3>Single-Chain Wallets</h3>
                    <c:forEach items="${userSCWallets}" var="singlechainWallet">
                        <form method="POST" action="switch-wallet">
                            <input type="hidden" name="walletId" value="${singlechainWallet.id}"/>
                            <input type="hidden" name="walletType" value="singleChain"/>
                            <div class="singlechain-wallet">
                                <div class="img-container">
                                    <img src="${singlechainWallet.chain.nativeToken.imagePath}" alt="${singlechainWallet.chain.chain.name}"/>
                                </div>
                                <input type="submit" name="blockchainName" value="${singlechainWallet.name} | ${singlechainWallet.chain.chain.name}" class="link"/>
                            </div>
                        </form>
                    </c:forEach>
            </c:if>
            </div>
        </div>
    </body>
</html>
