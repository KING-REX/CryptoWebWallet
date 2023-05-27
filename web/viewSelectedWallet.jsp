<%-- 
    Document   : viewSelectedWallet
    Created on : 13-Dec-2021, 00:58:58
    Author     : King Shadow
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="g" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/general.css" />
        <link rel="stylesheet" href="css/home2.css" />
        <link rel="stylesheet" href="css/viewselectedwallet.css" />
        <link rel="stylesheet" href="fontawesome-free-5.15.4-web/css/all.min.css" />
        <title>View Selected Wallet | CryptoWebWallet</title>
    </head>
    <body>
        <div class="page-container">
            
            <nav class="menu-bar">
                <g:if test="${not empty currentAddress}">
                    <div class="primary-div">
                        <a href="remove-address">
                            <h1><i class="fas fa-angle-left"></i> Back</h1>
                        </a>
                    </div>
                </g:if>
                
                <div class="secondary-div">
                    <a id="add-wallet" href="addWallet.jsp">Add Wallet</a>
                </div>
            </nav>
            
            
            <div class="overview">
                <div class="content-container">
                    <g:if test="${not empty currentAddress}">
                        <span class="address">${currentAddress}</span>
                            
                        <div class="wallet-balance">
                            <div class='img-container center'>
                                <img src='${tokenSelected.imagePath}' />
                            </div>
                            <span class="balance1 center">
                                <fmt:formatNumber maxFractionDigits="5" minFractionDigits="2" type="number" groupingUsed="true" 
                                                          value="${totalAddressBalanceInNT}">
                                </fmt:formatNumber>
                                ${currentAddress.parentChain.nativeToken.symbol}
                            </span>
                            <span class="balance2 center">
                                <fmt:formatNumber currencySymbol="$" maxFractionDigits="3"
                                                  minFractionDigits="2" type="currency"  value="${totalAddressBalanceInUSD}">    
                                </fmt:formatNumber>
                            </span>
                        </div>
                    </g:if>
                </div>
            </div>
            
            
            <div class='action-container'>
                <form class='action-form' method='POST' action='send-receive'>
                    <button id='send-tokens' class="action-button" name='send-receive' value='sendTokens'>
                        <span class='icon'><i class="fas fa-plus"></i></span>
                        <span class='text'>Send</span>
                    </button>
                    <button id='receive-tokens' class="action-button" name='send-receive' value='receiveTokens'>
                        <span class='icon'><i class="fas fa-minus"></i></span>
                        <span class='text'>Receive</span>
                    </button>
                </form>
            </div>
            
            <div class="transactions">
                <h4>Transactions</h4>
                <g:if test="${not empty transactions}">
                    <div class="transactions-container">
                        <g:forEach items="${transactions}" var="transaction" varStatus="eachTransaction">
                            <form method="POST" action="view-transaction" class="transactions-form">
                                <button class="transaction-button">
                                    <g:if test="${transaction.from.address == currentAddress.address}">
                                        <div class="primary">
                                            <span class='to-address'>${transaction.to}</span>
                                            <span class='transaction-date'>${transaction.date}</span>
                                        </div>
                                        <div class="secondary">
                                            <span class='to-amount'>-${transaction.amountTransferred}</span>    
                                        </div>
                                    </g:if>
                                    <g:if test="${transaction.to.address == currentAddress.address}">
                                        <div class="primary">
                                            <span class='from-address'>${transaction.from}</span>
                                            <span class='transaction-date'>${transaction.date}</span>
                                        </div>
                                        <div class="secondary">
                                            <span class='from-amount'>+${transaction.amountTransferred}</span>    
                                        </div>
                                    </g:if>

                                        <fmt:formatNumber maxFractionDigits="7" minFractionDigits="2" type="number" groupingUsed="true" 
                                                          value="${allValues[eachToken.index]}">
                                        </fmt:formatNumber>
                                </button>
                            </form>
                        </g:forEach>
                    </div>
                </g:if>
            </div>
            
            <form action="logout" method="POST" class="logout-form">
                <input id="logout-button" type="submit" value="Logout" />
            </form>
        </div>
                                
        <script src="fontawesome-free-5.15.4-web/js/all.min.js"></script>
    </body>
</html>