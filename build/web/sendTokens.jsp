<%-- 
    Document   : sendTokens
    Created on : 13-Dec-2021, 03:00:14
    Author     : King Shadow
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/general.css" />
        <link rel="stylesheet" href="css/home.css" />
        <link rel="stylesheet" href="css/feedback.css" />
        <link rel="stylesheet" href="fontawesome-free-5.15.4-web/css/all.min.css" />
        <title>Send Tokens | CryptoWebWallet</title>
        
        <style>
            a {
                margin: 0;
                /*padding: 10px;*/
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
                font-weight: bold;
                font-size: 1.5rem;
            }
            
            .action-form {
                padding: 20px 15px 10px;
                border: 2px solid #000;
                border-radius: 10px;
            }
            
            .info-div {
                margin-bottom: 20px;
                width: 100%;
            }
            
            .info-div h3 {
                margin-bottom: 5px;
            }
            
            .info-div button {
                display: flex;
                flex-direction: row;
                align-items: center;
                padding: 10px;
                width: 100%;
                background-color: #fff;
                border-radius: 10px;
                border: 1px solid #000;
            }
            
            .info-div button span {
                color: #000;
                font-weight: bold;
                font-size: 1rem;
                letter-spacing: .2rem;
            }
            
            .img-container {
                margin-right: 15px;
                height: 22px;
                width: 22px;
                border: 1px solid #222;
                border-radius: 50%;
                padding: 0;
                background-color: #000;
            }
            
            .img-container img {
                width: 100%;
                border-radius: 60px;
            }
            
            input[type="text"] {
                width: 100%;
                padding: 10px;
                border: 1px solid #000;
                border-radius: 10px;
            }
            
            input[type="submit"] {
                margin-top: 20px;
                margin-bottom: 10px;
                width: 100%;
                height: 35px;
                
                color: #fff;
                background-color: #2c62fd;
                
                font-weight: bold;
                
                border: 1px solid #000;
                border-radius: 10px;
                
                cursor: pointer;
            }
            
            input[type="submit"]:disabled {
                background-color: #bbbdc2;
                cursor: auto;
            }
        </style>
    </head>
    <body>
        <div class="page-container">
            <a href='view-selected-wallet'
               <h1><i class="fas fa-angle-left"></i> Transfer</h1>
            </a>  
            
            <c:if test="${not empty feedback}">
                <div class="feedback ${feedback.type}">
                    <span class="content">${feedback.message}</span>
                    <button id="cancel-button">X</button>
                </div>

                <c:remove var="feedback"/>
            </c:if>
            
            <c:if test="${not empty currentAddress}">
                    <form method="POST" action="send-tokens" class="action-form">
                        <div class="info-div">
                            <h3>Transfer account</h3>
                            <input disabled name="transferAccount" type="text" value='${currentAddress}' />
                        </div>
                        <div class="info-div">
                            <h3>Receiving account</h3>
                            <input hidden id='address-format' value='${tokenSelected.parentChain.chain.addressFormat}' />
                            <input id='receiving-account' name="receivingAccount" type="text" />
                        </div>
                        <div class="info-div">
                            <h3>Token transferred</h3>
                            <button disabled name='tokenTransferred'>
                                <div class='img-container'>
                                    <img src="${tokenSelected.imagePath}" />
                                </div>
                                <span>${tokenSelected.symbol}</span>
                            </button>
                        </div>
                        <div class="info-div">
                            <h3>Balance</h3>
                            <input id='amount-input' name="amount" type="text" placeholder="0.00" />
                        </div>
                        

                        <input id='submit-input' disabled type="submit" value="Send" />
                    </form>
            </c:if>                        
        </div>
        
        
        <script>
            const cancelButton = document.querySelector("button#cancel-button");
            if(cancelButton !== null)
            {
                cancelButton.onclick = () => {
                    document.querySelector("div.feedback").style.display = "none";
                }
            }
            
            let isValidAddress = false;
            let isValidAmount = false;
            
            const receivingAccount = document.getElementById("receiving-account");
            const amountInput = document.getElementById("amount-input");
            
            const submit = document.getElementById("submit-input");
            
            if(receivingAccount !== null)
            {
                receivingAccount.oninput = () => {
                    const input = document.getElementById("address-format");
                    console.log("Regex: " + input.value);
                    let regex = new RegExp(input.value);

                    if(receivingAccount.value.match(regex))
                        isValidAddress = true;
                    
                    if(isValidAddress && isValidAmount)
                        submit.disabled = false;
                    else
                        submit.disabled = true;
                }
            }    
            
            if(amountInput !== null)
            {
                amountInput.oninput = () => {
                    if(!isNaN(amountInput.value) && amountInput.value.length !== 0)
                        isValidAmount = true;
                    
                    if(isValidAddress && isValidAmount)
                        submit.disabled = false;
                    else
                        submit.disabled = true;
                }
            }
            
        </script>
    </body>
</html>