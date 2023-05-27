<%-- 
    Document   : welcome
    Created on : 30-Nov-2021, 09:59:02
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
        <title>Welcome Page</title>
    </head>^
    <body>
        <div class="page-container">
            <h1>Welcome to Crypto Web Wallet</h1>
            <c:if test="${not empty user}">
                <div class="welcome-div">
                    <div class="links-container">
                        <a href="addWallet.jsp">Create wallet</a>
                        <a href="importWallet.jsp">Import wallet</a>
                    </div>
                </div>
            </c:if>
        </div>
    </body>
</html>
