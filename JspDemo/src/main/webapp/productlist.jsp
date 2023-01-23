<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*, com.demo1.Product"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product List</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

</head>
<body>
	
	<div class="container">
		<%@ include file="navigation.jsp" %>
		<div class="products" ng-app="app" ng-controller="AppCtrl">

        <md-content layout-padding >
          <div class="actionpane">
           <% if(auth != null){
        	   
        	   %>
           
           <a href="addprodut.jsp" class="btn btn-success" style="margin:10px;">New Product</a> 
           <%} %>
          </div>
          
          <%if(auth == null){ 
        	  String con = "mt-5";
          %>
          <div class="tables <%= con%>">
          	<%} %>
            <table class="table  table-striped table-bordered table-hover table-checkable order-column dataTable">
            <thead><tr>
              <th>ID</th>
              <th>Name</th>
              <th>Category</th>
              <th>Price</th>
              <% if(auth != null){
        	   
        	   %>
              <th>Action</th>
              <%} %>
              </tr></thead>
               
              <tbody>
              <% 
             
 					List<Product> product = (List<Product>)request.getSession().getAttribute("produ");
              		for(Product pro:product){
              			
              			
 
           		%>
                <tr>
                  <td><%=pro.getId() %></td>
                  <td><span class="name"><%=pro.getName() %></span></td>
                  <td><%=pro.getCategory() %></td>
                  <td><%=pro.getPrice()%></td>
                  <% if(auth != null){
        	   
        	 		  %>
                  <td><a href="DeleteProduct?id=<%=pro.getId()%>" class="btn btn-danger style-none">Delete</a>
                    <span><a href="zupdate?id=<%=pro.getId()%>" class="btn btn-primary style-none">Edit</a></span> 
                  </td>
                  <%} %>
                </tr>
                <%} %>
              </tbody>
            </table>
          </div>
  
        </md-content>
      </div>
	</div>
</body>
</html>