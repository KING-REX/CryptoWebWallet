<%-- 
    Document   : importWallet
    Created on : 01-Dec-2021, 00:23:44
    Author     : King Shadow
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/general.css" />
        <link rel="stylesheet" href="css/home.css" />
        <link rel="stylesheet" href="css/feedback.css" />
        <title>Import Wallet | CryptoWebWallet</title>
        
        <style>
            .link {
                display: block;
                margin: 30px 0;
                padding: 15px 0;
                width: 100%;
                text-decoration: none;
                text-align: center;
                background-color: #fff;
                color: #000;
                border-radius: 45px;
                box-shadow: 0 0 3px 3px rgba(0, 0, 0, .5);
                cursor: pointer;
            }
            
            .mnemonic-container {
                margin-top: 30px;
                padding: 20px 5px 10px;
                border: 2px solid #000;
                border-radius: 10px;
            }
            
            p {
                margin-top: 10px;
                font-size: .87rem;
                color: rgba(0, 0, 0, .7);
            }
            
            input[type="text"],
            textarea {
                margin-top: 20px;
                width: 100%;
                padding: 10px;
                border: 1px solid #000;
                border-radius: 10px;
            }
            
            input[type="submit"] {
                margin-top: 30px;
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
            <h1>Import Wallet</h1>
            <c:if test="${empty importMethod and empty importedWallet}">
                <div class="welcome-div">
                    <div class="links-container">
                        <form method="POST" action="import-wallet">
                            <input type="hidden" name="by" value="seedWords" />
                            <input type="submit" class="link" value="Seed Words" />
                        </form>
                        <form method="POST" action="import-wallet">
                            <input type="hidden" name="by" value="privateKey" />
                            <input type="submit" class="link" value="Private Key" />
                        </form>
                    </div>
                </div>
            </c:if>
            
            <c:if test="${not empty importMethod}">
                <c:if test="${importMethod == 'seedWords'}">
                    <form method="POST" action="import-wallet" class="action-form">
                        <div class="mnemonic-container">
                            <h3>Input Mnemonic</h3>
                            <p>Supports 12 or 24 words, separated by spaces between words.</p>
                            <textarea id="sw" name="seedPhrase" rows="4" type="text" placeholder="Please enter here"></textarea>
                        </div>

                        <input disabled type="submit" value="Next Step" />
                    </form>
                </c:if>
                
                
                
                <c:if test="${importMethod == 'privateKey'}">
                    <form method="POST" action="import-wallet" class="action-form">
                        <div class="mnemonic-container">
                            <h3>Input Private Key</h3>
                            <p>Enter private key below.</p>
                            <textarea id="pk" name="privateKey" rows="4" type="text" placeholder="Please enter here"></textarea>
                        </div>

                        <input disabled type="submit" value="Next Step" />
                    </form>
                </c:if>
            </c:if>
            
            <c:if test="${not empty feedback}">
                <div class="feedback ${feedback.type}">
                    <span class="content">${feedback.message}</span>
                    <button id="cancel-button">X</button>
                </div>

                <c:remove var="feedback"/>
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
            
            
            const seedWords = document.querySelector("textarea#sw");
            const privateKey = document.querySelector("textarea#pk");
            
            seedWords.oninput = () => {
                let words = seedWords.value;
                let wordsArr = words.split(" ");
                console.log("wordsArr length: " + wordsArr.length);
                
                if((wordsArr.length === 12 || wordsArr.length === 24) && noEmptyWords(wordsArr))
                    document.querySelector("input[type=\"submit\"]").disabled = false;
                else
                    document.querySelector("input[type=\"submit\"]").disabled = true;
            }
            
            
            function noEmptyWords(wordsArr) {
                for(let word of wordsArr)
                    if(word === "")
                        return false;
                
                return true;
            }
        </script>
    </body>
</html>
