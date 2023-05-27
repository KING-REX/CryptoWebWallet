<%-- 
    Document   : login.jsp
    Created on : 10-Dec-2021, 07:55:25
    Author     : King Shadow
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/general.css" />
        <link rel="stylesheet" href="css/home.css" />
        <link rel="stylesheet" href="css/feedback.css" />
        <title>Login | CryptoWebWallet</title>
        
        <style>
            .form-field {
                display: flex;
                flex-direction: column;
            }
            
            label {
                margin: 30px 0 10px;
            }
            
            .link {
                margin-top: 2vh;
                display: block;
                margin: 40px 0;
                padding: 10px 0;
                width: 100%;
                text-decoration: none;
                text-align: center;
                font-size: 1rem;
                background-color: #fff;
                color: #000;
                border: none;
                border-radius: 45px;
                box-shadow: 0 0 3px 3px rgba(0, 0, 0, .5);
                cursor: pointer;
                transition: .2s all linear;
            }
            
            input:not(input[type="submit"]){
                padding: 10px 10px;
                border-radius: 10px;
                border: 1px solid #222;
            }
            
            .sign-up-container {
                display: flex;
                flex-direction: column;
                align-items: center;
                justify-content: space-around;
                margin-top: 15vh;
            }
            
            #login {
                margin-left: auto;
                margin-right: auto;
                margin-top: 2vh;
                padding: 10px 0;
                width: 40%;
                font-size: .9rem;
                transition: .2s all linear;
            }
            
            #login:hover,
            .link:hover {
                background-color: #2c62fd;
                color: #fff;
                box-shadow: 0 0 3px 3px #2c62fd;
            }
        </style>
    </head>
    <body>
        <div class="page-container">
            <h1>Login</h1>
            
            <c:if test="${not empty feedback}">
                <div class="feedback ${feedback.type}">
                    <span class="content">${feedback.message}</span>
                    <button id="cancel-button">X</button>
                </div>

                <c:remove var="feedback"/>
            </c:if>
                    
           <div class="welcome-div">
                <div class="links-container">
                    <form method="POST" action="login">
                        <div class="form-field">
                            <label for="name">Username</label>
                            <input id="name" type="text" name="username" placeholder="Enter your username" />
                        </div>
                        <div class="form-field">
                            <label for="password">Password</label>
                            <input id="password" type="password" name="password" placeholder="Enter your password" />
                        </div>

                        <input class="link" type="submit" value="Login" />
                    </form>
                    <div class='sign-up-container'>
                        <span>Don't have an account?</span>
                        <a href="signup.jsp" id="login">Sign up</a>
                    </div>
                </div>
            </div>
        </div>
                    
        <script>
            const cancelButton = document.querySelector("button#cancel-button");
            if(cancelButton !== null)
            {
                cancelButton.onclick = () => {
                    document.querySelector("div.feedback").style.display = "none";
                }
            }
        </script>
    </body>
</html>
