<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.User" %>
    
<html>
<head>
<title>login page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
	<div class="pt-5">
        <h1 class="text-center">Login Page</h1>
        <div class="container">
          <div class="row">
            <div class="col-md-5 mx-auto border-0">
              <div class="card card-body border-0">
             <!-- Login form -->
                 <form action="/HidernateSimpleDemo/Login" method="post">
                   <div class="form-group required"> <label for="username" class="d-flex flex-row align-items-center">Username / Email</label>
                       <input type="text" class="form-control text-lowercase " name="email" value=""> 
                   </div>
                   <div class="form-group required"> <label class="d-flex flex-row align-items-center" for="password">Password</label> 
                       <input type="password" class="form-control " name="password" value=""> 
                    </div>
                   <div class="form-group pt-1"> <button class="btn btn-primary btn-block w-100" type="submit">Log In</button> </div>
                  </form>
              <p class="small-xl pt-3 text-center"> <span class="text-muted">Do not have accounts?</span>
              <a href="signUp.jsp">Sign Up</a>
            </div>
          </div>
        </div>
      </div>
      </div>	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>	
</body>
</html>

