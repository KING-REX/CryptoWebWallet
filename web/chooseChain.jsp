<%-- 
    Document   : chooseChain
    Created on : 09-Dec-2021, 16:06:59
    Author     : King Shadow
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/general.css" />
        <link rel="stylesheet" href="css/home.css" />
        
        <style>
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
            <h1>Choose Blockchain</h1>
            <c:if test="${not empty action}">
                <form method="POST" action="${action}">
                    <div class="wallets-container">
                        <div class="multichain-wallet">
                            <div class="img-container not-single">
                                <img src="images/MULTICOIN.png" alt="Multi Coin Wallet"/>
                            </div>
                            <input type="submit" name="multicoin" value="Multi-Coin" class="link"/>
                        </div>

                        <div class="chain-separator"></div>

                        <c:forEach items="${blockchains}" var="blockchain">
                            <c:if test="${blockchain.chain.addressFormat != ''}">
                                <div class="singlechain-wallet">
                                    <div class="img-container">
                                        <img src="${blockchain.nativeToken.imagePath}" alt="${blockchain.chain.name}"/>
                                    </div>
                                    <input type="submit" name="blockchainName" value="${blockchain.chain.name}" class="link"/>
                                </div>
                            </c:if>
                            <c:if test="${blockchain.chain.addressFormat == ''}">
                                <div class="singlechain-wallet not-supported">
                                    <div class="img-container">
                                        <img src="${blockchain.nativeToken.imagePath}" alt="${blockchain.chain.name}"/>
                                    </div>
                                    <input disabled type="submit" name="blockchainName" value="${blockchain.chain.name}" class="link"/>
                                </div>
                            </c:if>
                        </c:forEach>
                    </div>
                </form>
            </c:if>
        </div>
    </body>
</html>
