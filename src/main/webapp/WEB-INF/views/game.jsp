<%--
  Created by IntelliJ IDEA.
  User: phuocvo
  Date: 08/04/2024
  Time: 12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Player" %>
<%@ page import="urls.Urlutils" %>
<%@ page import="model.Game" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Game page </title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
        <nav class="navbar  bg-dark">
            <div class="container">
                <a class="navbar-brand" href="#">
                   <h4>Mini Game</h4>
                </a>

                <div class="dropdown">
                    <a class="btn btn-secondary dropdown-toggle" href="#" data-bs-toggle="dropdown" aria-expanded="false">
                        <%= ((Player) session.getAttribute("loginuser")).getUsername()
                        %>
                    </a>

                    <ul class="dropdown-menu bg-dark">
                        <li><a class="dropdown-item text-light" href="<%= request.getContextPath() + Urlutils.LOGOUT%><% Object Game; %>">Log out</a></li>
                    </ul>
<%--                    <%= request.getContextPath() + utils.LOGOUT %>--%>
                </div>
            </div>
        </nav>

        <div class="container mt-5">
            <div class="container text-center">
            <div class="row justify-content-between">
                <div class="col-2 text-start">
                 <h4 >

                     ${game.getGameID()}
                 </h4>
                </div>
                <div class="col-4">
                    <h4 class="text-warning text-center">Be happy and not Boring </h4>
<%--                    "?username=" +((Player) session.getAttribute("loginuser")).getUsername()--%>
                    <form action="<%= request.getContextPath() + Urlutils.GAME + "?username=" +((Player) session.getAttribute("loginuser")).getUsername() %>"  method="post">
                        <div class="mt-5 mb-3">
                            <label for="exampleInputEmail1" class="form-label">Enter Number: </label>
                            <input name="number-guess" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                            <div id="emailHelp" class="form-text">We are confident, We will win.</div>
                        </div>
                        <button type="submit" class="btn btn-primary">Guss</button>
                    </form>

                    <table class="table table-dark table-striped opacity-25  mt-5 mb-3">
                        <thead>
                        <tr>
                            <th class="table-light text-center" scope="col">STT</th>
                            <th class="table-light" scope="col">Name</th>
                            <th class="table-light " scope="col">Guess</th>
                            <th class="table-light " scope="col"> correctly</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th scope="row">1</th>
                            <td>admin</td>

                            <td>999</td>
                            <td>Ok, Low, High</td>
                        </tr>
                        <tr>
                            <th scope="row">2</th>
                            <td>admin</td>
                            <td>Thornton</td>
                            <td>@fat</td>
                        </tr>
                        <tr>
                            <th scope="row">3</th>
                            <td colspan="2">999</td>
                            <td>@twitter</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="col-2 text-end">

                    <%-- action form New Game                    --%>
                    <%--   "?username=" + ((Player) session.getAttribute("loginuser")).getUsername() dùng để nhận biết tao tác của người dùng gửi xuống phân thức             --%>
                    <form action="<%= request.getContextPath() + Urlutils.NEW_GAME + "?username=" + ((Player) session.getAttribute("loginuser")).getUsername() %>"  method="post">

                        <button type="submit" class="btn btn-primary">New Game</button>
                    </form>


                </div>
                </div>
            </div>
        </div>




    </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
