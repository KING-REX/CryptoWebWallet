<%-- 
    Document   : signup
    Created on : 10-Dec-2021, 08:30:27
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
        <title>JSP Page</title>
        
        <style>
            .form-field {
                display: flex;
                flex-direction: column;
            }
            
            label {
                margin: 20px 0 10px;
            }
            
            .link {
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
            
            .link:disabled {
                background-color: #ddd;
                color: initial;
                transition: none;
            }
            
            .link:disabled:hover {
                background-color: #ddd;
                color: initial;
                box-shadow: 0 0 3px 3px rgba(0, 0, 0, .5);
            }
            
            input:not(input[type="submit"]){
                padding: 10px 10px;
                border-radius: 10px;
                border: 1px solid #222;
            }
            
            .login-container {
                display: flex;
                flex-direction: column;
                align-items: center;
                justify-content: space-around;
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
            <h1>Sign up</h1>
            
            <c:if test="${not empty feedback}">
                <div class="feedback ${feedback.type}">
                    <span class="content">${feedback.message}</span>
                    <button id="cancel-button">X</button>
                </div>

                <c:remove var="feedback"/>
            </c:if>
                    
           <div class="welcome-div">
                <div class="links-container">
                    <form method="POST" action="signup">
                        <div class="form-field">
                            <label for="name">Username</label>
                            <input id="name" type="text" name="username" placeholder="Enter your username" />
                        </div>
                        <div class="form-field">
                            <label for="password">Password</label>
                            <input id="password" type="password" name="password" placeholder="Enter your password" />
                        </div>
                        <div class="form-field">
                            <label for="password">Confirm Password</label>
                            <input id="confirm-password" type="password" name="password" placeholder="Enter your password" />
                        </div>

                        <input disabled class="link" type="submit" value="Sign up" />
                    </form>
                    
                    <div class='login-container'>
                        <span>Already have an account?</span>
                        <a href="login.jsp" id="login">Login</a>
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
            
            const passwordInput = document.querySelector("input#password");
            const confirmPasswordInput = document.getElementById("confirm-password");
            
            confirmPasswordInput.oninput = () => {
                console.log("Inputs are the same: " + passwordInput.value === confirmPasswordInput.value);
                if(passwordInput.value === confirmPasswordInput.value)
                    document.querySelector("input[type=\"submit\"]").disabled = false;
                else
                    document.querySelector("input[type=\"submit\"]").disabled = true;
            }
        </script>
    </body>
</html>