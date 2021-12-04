<%-- 
    Document   : home
    Created on : Dec 2, 2021, 11:54:56 PM
    Author     : emanu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@include file="include.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body>
        <h1>Laporan Uang Kas</h1>
        <p>
        <table class="table table-striped table-bordered">
            <tr class="thead-dark">
                <th>ID</th>
                <th>Nama</th>
                <th>Nominal</th>
                <th>Bulan</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${listKas}" var="kas">
                <tr>
                    <td>${kas.id}</td>
                    <td>${kas.nama}</td>
                    <td>${kas.nominal}</td>
                    <td>${kas.bulan}</td>
                    <td>
                        <button class="btn btn-primary" 
                                onclick="window.location.href='kas-form.html?action=edit&id=${kas.id}'">
                            Edit
                        </button>
                        <button class="btn btn-danger" 
                                onclick="window.location.href='mahasiswa-form.html?action=delete&id=${kas.id}'">
                            Delete
                        </button>
                    </td>
                </tr>
            </c:forEach>
        </table>
        </p>
        <p>
            <button class="btn btn-primary" onclick="window.location.href='kas-form.html'">
                Add Data    
            </button>
        </p>
    </body>
</html>
