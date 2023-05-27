<%-- 
    Document   : createWallet
    Created on : 30-Nov-2021, 21:40:21
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
        <title>Add Wallet</title>
        
        <style>
            h1#create {
                margin: 65px 0;
            }
            
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
        </style>
    </head>
    <body>
        <div class="page-container">
            <h1>Import Wallet</h1>
            <c:if test="${not empty user}">
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
            <h1 id="create">Create Wallet</h1>
            <c:if test="${not empty user}">
                <div class="welcome-div">
                    <div class="links-container">
                        <a href="createWallet.jsp">Create wallet</a>
                    </div>
                </div>
            </c:if>
        </div>
    </body>
</html>
