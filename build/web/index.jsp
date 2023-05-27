<%-- 
    Document   : index
    Created on : 10-Dec-2021, 08:51:27
    Author     : King Shadow
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/general.css" />
        <link rel="stylesheet" href="css/home2.css" />
        <link rel="stylesheet" href="fontawesome-free-5.15.4-web/css/all.min.css" />
        <title>Index | CryptoWebWallet</title>
        
        <style>
            /*NAV SECTION**************************/
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
            
            
            
            
            /*OVERVIEW SECTION ***********************/
            .overview {
                position: absolute;
                top: 30%;
                left: 50%;
                transform: translate(-50%, -50%);
                padding: 30px;
                
                width: 50vw;
                height: 40vh;
                
                background-color: #2c62fd;
                border-radius: 30px;
            }
            
            .address {
                color: #eee;
                font-size: .7rem;
            }
            
            
            .balance1 {
                margin-top: 30px;
                color: #fff;
                font-size: 2rem;
                font-weight: bold;
            }
            
            .balance1.center,
            .balance2.center {
                margin-left: auto;
                margin-right: auto;
            }
            
            .balance2 {
                color: #fff;
                font-size: 1rem;
            }
            
            
            .wallet-balance {
                display: flex;
                flex-direction: column;
            }
            
            
            /*ASSETS SECTION **********************************/
            .assets {
                position: absolute;
                top: 80%;
                left: 50%;
                transform: translate(-50%, -50%);
                
                width: 50vw;
                height: 40vh;
            }
            
            .assets-container {
                margin: 30px 0;
            }
            
            .assets-form {
                padding: 20px 0;
            }
            
            .token-assets {
                display: flex;
                flex-direction: row;
                align-items: center;
                width: 100%;
                text-decoration: none;
                text-align: left;
                background-color: #fff;
                color: #000;
                padding: 15px 0;
                border-radius: 25px;
                box-shadow: 0 0 3px 3px rgba(0, 0, 0, .5);
                cursor: pointer;
                transition: all .2s linear;
            }
            
            .token-assets:hover {
                background-color: #2c62fd;
                color: #fff;
                box-shadow: 0 0 3px 3px #2c62fd;
                border-color: #2c62fd;
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
            
            .img-container img {
                width: 100%;
                border-radius: 60px;
            }
            
            .token-name {
                font-size: 1.5rem;
            }
            
            .token-balance {
                margin-left: auto;
                margin-right: 20px;
                font-size: 1.5rem;
            }
            
            form.logout-form {
                position: fixed;
                bottom: 5vh;
                right: 5vw;
                
                border-radius: 10px;
                cursor: pointer;
            }
            
            #logout-button {
                padding: 10px;
                border-radius: 20px;
            }
            
            #logout-button:hover {
                background-color: #2c62fd;
                color: #fff;
            }
        </style>
    </head>
    <body>
        <div class="page-container">
            <nav class="menu-bar">
                <c:if test="${not empty currentWallet}">
                    <c:if test="${currentWalletType == 'multiChain'}">
                        <div class="primary-div">
                            <a href="view-wallets">
                                <h1>${currentWallet.name} <i class="fas fa-angle-right"></i></h1>
                                <span>MultiChain</span>
                            </a>
                        </div>
                    </c:if>
                    <c:if test="${currentWalletType == 'singleChain'}">
                        <div class="primary-div">
                            <a href="view-wallets">
                                <h1>${currentWallet.name} <i class="fas fa-angle-right"></i></h1>
                                <span>${currentWallet.chain.chain.name}</span>
                            </a>
                        </div>
                    </c:if>
                </c:if>
                
                <div class="secondary-div">
                    <a id="add-wallet" href="addWallet.jsp">Add Wallet</a>
                </div>
            </nav>
            
            
            <div class="overview">
                <div class="content-container">
                    <c:if test="${not empty currentWalletType}">
                        <c:if test="${currentWalletType == 'singleChain'}">
                            <span class="address">${currentWallet.address.address}</span>
                            
                            <div class="wallet-balance">
                                <span class="balance1">${totalWalletBalanceInNT} ${currentWallet.chain.nativeToken.symbol}</span>
                                <span class="balance2">
                                    <fmt:formatNumber currencySymbol="$" maxFractionDigits="3"
                                                      minFractionDigits="2" type="currency"  value="${totalWalletBalanceInUSD}">    
                                    </fmt:formatNumber>
                                </span>
                            </div>
                        </c:if>
                        <c:if test="${currentWalletType == 'multiChain'}">
                            <span class="address"></span>
                            
                            <div class="wallet-balance">
                                <span class="balance1 center">
                                    <fmt:formatNumber currencySymbol="&#x0024;" maxFractionDigits="3"
                                                      minFractionDigits="2" type="currency" value="${totalWalletBalanceInUSD}">
                                    </fmt:formatNumber>
                                </span>
                                <span class="balance2 center">${currentWallet.name}</span>
                            </div>
                        </c:if>
                    </c:if>
                </div>
            </div>
            
            <div class="assets">
                <h4>Assets</h4>
                <div class="assets-container">
                    <c:forEach items="${allTokens}" var="token" varStatus="eachToken">
                        <form method="POST" action="view-selected-wallet" class="assets-form">
                            <button class="token-assets">
                                <input hidden name="tokenSelected" value="${token.id}" />
                                <div class="img-container">
                                    <img src="${token.imagePath}" alt="${token.parentChain.chain.name}"/>
                                </div>
                                <span class="token-name">${token.parentChain.chain.name}</span>
                                <span class="token-balance">

                                    <fmt:formatNumber maxFractionDigits="7" minFractionDigits="2" type="number" groupingUsed="true" 
                                                      value="${allValues[eachToken.index]}">
                                    </fmt:formatNumber>
                                </span>
                            </button>
                        </form>
                    </c:forEach>
                </div>
                
            </div>
            
            
            
            <form action="logout" method="POST" class="logout-form">
                <input id="logout-button" type="submit" value="Logout" />
            </form>
        </div>
            

        <script src="fontawesome-free-5.15.4-web/js/all.min.js"></script>
    </body>
</html>
