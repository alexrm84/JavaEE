<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<%@include file="head.jsp"%>
<body>

    <div class="container">
        <%@include file="menu.jsp"%>

        <div class="row py-2">
            <div class="col-12">
                <c:url value="${requestScope.action}" var="productPostUrl"/>
                <form action="${productPostUrl}" method="post">
                    <input type="hidden" value="${product.id}" id="id" name="id">
                    <div class="form-group">
                        <label>Title</label>
                        <input type="text" value="${product.title}" class="form-control" id="title" name="title" placeholder="Enter title">
                    </div>
                    <div class="form-group">
                        <label>Description</label>
                        <input type="text" value="${product.description}" class="form-control" id="description" name="description" placeholder="Enter description">
                    </div>
                    <div class="form-group">
                        <label>Price</label>
                        <input type="number" value="${product.price}" class="form-control" id="price" name="price" placeholder="Enter price">
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>