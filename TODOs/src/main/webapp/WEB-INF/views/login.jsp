<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" media="screen">
<style type="text/css">
      body {
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #f5f5f5;
      }

      .form-signin {
        max-width: 300px;
        padding: 19px 29px 29px;
        margin: 0 auto 20px;
        background-color: #fff;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
           -moz-border-radius: 5px;
                border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
      }
      .form-signin .form-signin-heading,
      .form-signin .checkbox {
        margin-bottom: 10px;
      }
      .form-signin input[type="text"],
      .form-signin input[type="password"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;
      }

    </style>
<title>MTT Login</title>
</head>
<body>
<div class="container">

      <form class="form-signin" method="POST" action="resources/j_spring_security_check">
        <div class="alert alert-info">
            <button type="button" class="close" data-dismiss="alert">×</button>
        Sign in with <Strong>test/abc123</Strong>
            
        </div>
        <h2 class="form-signin-heading">Please sign in</h2>
        <input class="input-block-level" name="j_username" type="text" placeholder="Username" />
        <input class="input-block-level" name="j_password" type="password" type="password"  placeholder="Password" />
        <button class="btn btn-large btn-primary"type="submit" value="login">Sign in</button>
      </form>
    </div>
    
<script src="http://code.jquery.com/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>