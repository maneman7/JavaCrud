<%-- 
    Document   : kas-form
    Created on : Dec 3, 2021, 12:13:56 AM
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
    </head>
    <h2>Add Data ${message}</h2>
    <body>
        <div class="container">
            <div class="col-md-6">
                <form action="kas-form.html" modelAttribute="kas" method="POST">
                    <div class="form-group"> 
                        <input type="text" class="form-control" name="nama" placeholder="NAMA" value="${kas.nama}">
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="nominal" placeholder="NOMINAL" value="${kas.nominal}">
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="bulan" placeholder="BULAN" value="${kas.bulan}">
                    </div>
                    <input type="hidden" name="id" value="${kas.id? kas.id:0}">
                    <button type="submit" class="btn btn-primary">Save</button>
                </form>
            </div>
            <a href="${pageContext.request.contextPath}/home.html">Kembali</a>
        </div>
    </body>
</html>
