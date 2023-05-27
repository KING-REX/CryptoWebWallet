<%-- 
    Document   : backupWallet
    Created on : 11-Dec-2021, 23:57:22
    Author     : King Shadow
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/general.css" />
        <link rel="stylesheet" href="css/home.css" />
        <title>Backup Wallet | CryptoWebWallet</title>
        
        <style>
            .mnemonic-container,
            .privateKey-container {
                margin-top: 30px;
                padding: 20px 5px 10px;
                border: 2px solid #000;
                border-radius: 10px;
            }
            
            p {
                margin-top: 10px;
            }
            
            p,
            span {
                font-size: .87rem;
                color: rgba(0, 0, 0, .7);
            }
            
            input[type="text"],
            textarea,
            #texArea {
                margin-top: 20px;
                width: 100%;
                padding: 10px;
                border: 1px solid #000;
                border-radius: 10px;
            }
            
            #textArea {
                display: flex;
                flex-wrap: wrap;
                justify-content: space-around;
                margin: 2.5vh 0;
                padding: 10px 4px;
                height: 30vh;
                border: 1px solid #000;
                border-radius: 10px;
            }
            
            textarea {
                padding: 0 10px;
                color: #000;
                text-align: center;
            }
            
            .word {
                padding: 5px;
                height: 20%;
                background-color: #eee;
                border: 1px solid #222;
                border-radius: 5px;
            }
            
            .submit {
                margin-top: 30px;
            }
            
            input[type="submit"] {
                margin-top: 5px;
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
            <c:if test="${not empty backupType}">
                <c:if test="${backupType == 'mnemonic'}">
                    <h1>Backup Mnemonic</h1>
                    <form method="POST" action="backup-wallet" class="action-form">
                        <div class="mnemonic-container">
                            <h3>Recovery phrase</h3>
                            <p>Write down or copy these words in the right order and save them somewhere safe.</p>
                            <c:if test="${not empty seedWords}">
                                <div id="textArea">
                                    <c:forEach items="${seedWords}" var="seedWord" varStatus="each">
                                        <span class="word">${each.index + 1}|${seedWord}&#13</span>
                                    </c:forEach>
                                </div>
                            </c:if>
                            
                        </div>
                        
                        <div class="submit">
                            <input id="verify" type="checkbox" />
                            <label for="verify">I have saved them securely</label>
                            <input disabled type="submit" value="Continue" />
                        </div>
                        
                    </form>
                </c:if>
                <c:if test="${backupType == 'privateKey'}">
                    <h1>Backup Private Key</h1>
                    <form method="POST" action="backup-wallet" class="action-form">
                        <div class="privateKey-container">
                            <h3>Private Key</h3>
                            <p>Keep your private key safe and don't give anyone. Owning private key equals owning all assets!</p>
                            <c:if test="${not empty privateKey}">
                                <textArea disabled name="privateKey" rows="4">
                                    ${privateKey}
                                </textArea>
                            </c:if>
                        </div>
                        
                        <div class="submit">
                            <input id="verify" type="checkbox" />
                            <label for="verify">I have saved it securely</label>
                            <input disabled type="submit" value="Continue" />
                        </div>
                    </form>
                </c:if>
            </c:if>
        </div>
        
        <script>
            const verifyCheckbox = document.querySelector("#verify");
            verifyCheckbox.onchange = () => {
                if(verifyCheckbox.checked)
                    document.querySelector("input[type=\"submit\"]").disabled = false;
                else
                    document.querySelector("input[type=\"submit\"]").disabled = true;
            }
            
        </script>
    </body>
</html>