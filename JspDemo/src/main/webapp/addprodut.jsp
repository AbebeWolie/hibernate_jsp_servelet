<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>add product</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
	<div class="container mt-5">
        <section class="panel panel-default">
            <div class="panel-heading"> 
            <h3 class="panel-title">Add Product</h3> 
            </div> 
            <div class="panel-body">
                <form action="AddProduct" class="form-horizontal" method="post">
                    <div class="form-group">
                        <label for="name" class="col-sm-3 control-label">ProductId</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="id">
                        </div>
                    </div> 
                    <div class="form-group mb-3">
                        <label for="name" class="col-sm-3 control-label">PrductName</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="name">
                        </div>
                    </div> 
                    <div class="form-group mb-3">
                        <label for="name" class="col-sm-3 control-label">Category</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="category">
                        </div>
                    </div> 
  	
                    <div class="form-group">
                        <label for="name" class="col-sm-3 control-label">Price</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="price">
                        </div>
                    </div> 
                    <br>
                    <div class="form-group">
                        <div class="col-sm-offset-3 col-sm-9">
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </div>
                    </div> 
                </form>
            </div>
        </section>
    </div>
</body>
</html>