<%-- 
    Document   : createWallet
    Created on : 01-Dec-2021, 00:55:36
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
        <title>Create Wallet | Web Wallet</title>
        
        <style>
            .mnemonic-container,
            .password-container {
                margin-top: 30px;
                padding: 20px 5px 10px;
                border: 2px solid #000;
                border-radius: 10px;
            }
            
            p,
            span {
                margin-top: 10px;
                font-size: .87rem;
                color: rgba(0, 0, 0, .7);
            }
            
            input[type="text"],
            input[type="password"] {
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
            
            li {
                font-size: .87rem;
                margin-left: 20px;
            }
            
            li.not-checked {
                color: red;
            }
            
            li.checked {
                color: green;
            }
        </style>
    </head>
    <body>
        <div class="page-container">
            <h1>Create Wallet</h1>  
            
            <c:if test="${not empty feedback}">
                <div class="feedback ${feedback.type}">
                    <span class="content">${feedback.message}</span>
                    <button id="cancel-button">X</button>
                </div>

                <c:remove var="feedback"/>
            </c:if>
            
            <c:if test="${empty importedWallet}">
                <c:if test="${empty walletName}">
                    <form method="POST" action="create-wallet" class="action-form">
                        <div class="mnemonic-container">
                            <h3>Set Name</h3>
                            <p>A wallet name is used to help you distinguish different wallet accounts from one another.</p>
                            <input name="walletName" type="text" placeholder="1-14 characters" maxlength="14" />
                        </div>

                        <input disabled type="submit" value="Next Step" />
                    </form>
                </c:if>

                <c:if test="${not empty walletName}">
                    <c:if test="${empty walletPassword}">
                        <form method="POST" action="create-wallet" class="action-form">
                            <div class="password-container">
                                <h3>Set Password</h3>
                                <p>Password is used to encrypt private keys, transfer funds, etc. So a strong password is necessary.</p>
                                <p>Please note that we won't store the password and cannot retrieve it for you.</p>
                                <input name="walletPassword" type="password" />
                            </div>

                            <div class="password-check">
                                <span>To protect your assets, your password should include:</span>
                                <ul>
                                    <li id="upper" class="not-checked">1 uppercase letter</li>
                                    <li id="lower" class="not-checked">1 lowercase letter</li>
                                    <li id="number" class="not-checked">1 number</li>
                                    <li id="chars" class="not-checked">At least 8 characters</li>
                                </ul>
                            </div>

                            <input disabled type="submit" value="Next Step" />
                        </form>
                    </c:if>
                </c:if>
            </c:if>
            
            <c:if test="${not empty importedWallet}">
                <c:if test="${empty walletName}">
                    <form method="POST" action="setup-imported-wallet" class="action-form">
                        <div class="mnemonic-container">
                            <h3>Set Name</h3>
                            <p>A wallet name is used to help you distinguish different wallet accounts from one another.</p>
                            <input name="walletName" type="text" placeholder="1-14 characters" maxlength="14" />
                        </div>

                        <input disabled type="submit" value="Next Step" />
                    </form>
                </c:if>

                <c:if test="${not empty walletName}">
                    <c:if test="${empty walletPassword}">
                        <form method="POST" action="setup-imported-wallet" class="action-form">
                            <div class="password-container">
                                <h3>Set Password</h3>
                                <p>Password is used to encrypt private keys, transfer funds, etc. So a strong password is necessary.</p>
                                <p>Please note that we won't store the password and cannot retrieve it for you.</p>
                                <input name="walletPassword" type="password" />
                            </div>

                            <div class="password-check">
                                <span>To protect your assets, your password should include:</span>
                                <ul>
                                    <li id="upper" class="not-checked">1 uppercase letter</li>
                                    <li id="lower" class="not-checked">1 lowercase letter</li>
                                    <li id="number" class="not-checked">1 number</li>
                                    <li id="chars" class="not-checked">At least 8 characters</li>
                                </ul>
                            </div>

                            <input disabled type="submit" value="Next Step" />
                        </form>
                    </c:if>
                </c:if>
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
            
            const nameInput = document.querySelector("input[type=\"text\"]");
            const passwordInput = document.querySelector("input[type=\"password\"]")
            
            if(nameInput !== null)
            {
                nameInput.oninput = () => {
                    if(nameInput.value === "")
                        document.querySelector("input[type=\"submit\"]").disabled = true;
                    else
                        document.querySelector("input[type=\"submit\"]").disabled = false;
                }
            }
            
            if(passwordInput !== null)
            {
                var hasNumber = false;
                var hasUpperCase = false;
                var hasLowerCase = false;
                var upToEight = false;

                passwordInput.oninput = () => {
                    for(let char of passwordInput.value)
                    {
                        if(!isNaN(char))
                            hasNumber = true;
                        if(isNaN(char) && char === char.toUpperCase())
                            hasUpperCase = true;
                        if(isNaN(char) && char === char.toLowerCase())
                            hasLowerCase = true;
                    }
                    upToEight = (passwordInput.value.length >= 8);
                    console.log("Up to eight: " + upToEight);


                    if(hasNumber)
                    {
                        document.querySelector("#number").classList.remove("not-checked");
                        document.querySelector("#number").classList.add("checked");
                    }
                    else
                    {
                        document.querySelector("#number").classList.remove("checked");
                        document.querySelector("#number").classList.add("not-checked");
                    }

                    if(hasUpperCase)
                    {
                        document.querySelector("#upper").classList.remove("not-checked");
                        document.querySelector("#upper").classList.add("checked");
                    }
                    else
                    {
                        document.querySelector("#upper").classList.remove("checked");
                        document.querySelector("#upper").classList.add("not-checked");
                    }

                    if(hasLowerCase)
                    {
                        document.querySelector("#lower").classList.remove("not-checked");
                        document.querySelector("#lower").classList.add("checked");
                    }
                    else
                    {
                        document.querySelector("#lower").classList.remove("checked");
                        document.querySelector("#lower").classList.add("not-checked");
                    }

                    if(upToEight)
                    {
                        document.querySelector("#chars").classList.remove("not-checked");
                        document.querySelector("#chars").classList.add("checked");
                    }
                    else
                    {
                        document.querySelector("#chars").classList.remove("checked");
                        document.querySelector("#chars").classList.add("not-checked");
                    }
                    
                    if(hasNumber && hasUpperCase && hasLowerCase && upToEight)
                        document.querySelector("input[type=\"submit\"]").disabled = false;
                    else
                        document.querySelector("input[type=\"submit\"]").disabled = true;


                    hasNumber = false;
                    hasUpperCase = false;
                    hasLowerCase = false;
                }
            }
        </script>
    </body>
</html>