<%--
  Created by IntelliJ IDEA.
  User: phuocvo
  Date: 07/04/2024
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="urls.Urlutils" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container col-sm-4 ">
    <h1 class="text-primary text-center mt-5"> Register </h1>
    <form action="<%=request.getContextPath() + Urlutils.REGISTER %>" method="post">
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label text-info-emphasis">UserName</label>
            <input name="user" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">

        </div>
        <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label text-info-emphasis">Password</label>
            <input name="password" type="password" class="form-control" id="exampleInputPassword1">
        </div>

        <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label text-info-emphasis"> Config Password</label>
            <input name="configpassword" type="password" class="form-control" id="configInputPassword1">
        </div>

        <div class="alert alert-danger <%= request.getAttribute("Error") == null ? "d-none" : "" %> %> " role="alert">
            <%= request.getAttribute("Error") %>
        </div>
        <div class=" mb-3 form-check">

            <a id="#" class="form-check-label" for="exampleCheck1">Login account</a>
        </div>
        <div class="d-grid gap-2">
            <button type="submit" class="btn btn-primary">Save</button>
        </div>
    </form>

</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</body>
</html>
