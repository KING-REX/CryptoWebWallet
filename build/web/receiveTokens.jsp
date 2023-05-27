<%-- 
    Document   : receiveTokens
    Created on : 13-Dec-2021, 03:00:29
    Author     : King Shadow
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Receive Tokens | CryptoWebWallet</title>
        <link rel="stylesheet" href="css/general.css" />
        <link rel="stylesheet" href="css/home.css" />
        <link rel="stylesheet" href="fontawesome-free-5.15.4-web/css/all.min.css" />
        
        <style>
            .page-container {
                width: 30vw;
            }
            
            a {
                margin: 0;
                padding: 10px;
                width: 50%;
                text-decoration: none;
                text-align: center;
                color: #000;
                border-radius: 45px;
                box-shadow: none;
                transition: .2s all linear;
            }
            
            a:hover {
                box-shadow: 0 0 3px 3px rgba(0, 0, 0, .5);
            }
            
            a h1 {
                margin: 0;
            }
            
            .info-container {
                display: flex;
                flex-direction: column;
                justify-content: space-around;
                margin-top: 10vh;
                padding: 20px;
                height: 20vh;
                border: 2px solid #000;
                border-radius: 5px;
                cursor: pointer;
                transition: all .2s linear;
            }
            
            .info-container:hover {
                background-color: #2c62fd;
                color: #fff;
            }
            
            #wallet-name {
                align-self: center;
                font-size: 1.4rem;
                font-weight: bold;
            }
            
            #wallet-address {
                font-size: .8rem;
                background-color: inherit;
                color: inherit;
                border: none;
            }
            
            #copy-address {
                margin-top: 30vh;
                width: 100%;
                height: 45px;
                
                color: #fff;
                background-color: #2c62fd;
                
                font-weight: bold;
                
                border: 1px solid #000;
                border-radius: 10px;
                
                cursor: pointer;
                transition: all .2s linear;
            }
            
            #copy-address:disabled {
                background-color: #bbbdc2;
                cursor: auto;
            }
        </style>
    </head>
    <body>
        <div class="page-container">
            <a href='view-selected-wallet'>
                <h1><i class="fas fa-angle-left"></i> Receive</h1>
            </a>
            
            <d:if test="${not empty currentAddress and not empty currentWallet}">
                
                <div class='info-container'>
                    <span id='wallet-name'>${currentWallet.name}</span>
                    <input type='text' id='wallet-address' value='${currentAddress}' />
                </div>
                
                
                <button id='copy-address'>Copy Receiving Address</button>
            </d:if>
        </div>
        
        
        <script>
            const infoContainer = document.querySelector("div.info-container");
            const copyAddressBtn = document.getElementById("copy-address");
            const mouseOver = new Event("mouseover");
            
            if(copyAddressBtn !== null) {
                copyAddressBtn.onclick = () => {
                    copyAddressToClipBoard(document.getElementById("wallet-address"));
                    switchUp(copyAddressBtn);
                    infoContainer.dispatchEvent(mouseOver);
                    document.getElementById("wallet-address").blur();
                }
            }
            else
            {
                alert("Copy address btn is null!!");
            }
            
            function copyAddressToClipBoard(addressInput) {
                addressInput.select();
                
                document.execCommand("copy");
            }
            
            function switchUp(element) {
                element.innerHTML = "Copied"
                element.disabled = true;
            }
            
            if(infoContainer !== null) {
                infoContainer.onclick = () => {
                    copyAddressToClipBoard(document.getElementById("wallet-address"));
                    switchUp(copyAddressBtn);
                    document.getElementById("wallet-address").blur();
                }
            }
        </script>
    </body>
</html>