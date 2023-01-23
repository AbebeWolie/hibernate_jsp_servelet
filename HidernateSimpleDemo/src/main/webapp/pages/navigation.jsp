<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

</head>
<body>
 <nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container">
			<a class="navbar-brand" href="home.jsp"></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
		
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a href="/HidernateSimpleDemo" class="nav-link btn btn-light">Home</a></li>
					<li class="nav-item"><form action="/HidernateSimpleDemo/ProductList" method="post"> <input type="submit" class="nav-link btn btn-light" value=" Product List"> </form></li>
					<%
					 User auth = (User)request.getSession().getAttribute("auth");
					if (auth != null) {
					%>
					<li class="nav-item"><a href="addproduct.jsp" class="nav-link btn btn-light">AddProduct</a></li>
					<li class="nav-item"><form action="/HidernateSimpleDemo/Logout" method="post"> <input type="submit" class="nav-link btn btn-light" value=" Logout"> </form></li>
					<%
					} else {
					%>
					<li class="nav-item"><a class="nav-link btn btn-light" href="/HidernateSimpleDemo/pages/login.jsp">Login</a></li>
					<%
					}
					%> 
				</ul>
			</div>
		</div>
    </nav>
</body>
</html>