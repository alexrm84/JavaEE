<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <title>Product details</title>
    <style>
        .table_image {
            max-width:64px;
            max-height:64px;
            width:auto;
            height:auto;
        }
    </style>
<%@include file="head.jsp"%>
</head>

<body>
    <div class="container">
       <%@include file="menu.jsp"%>

        <div class="card" style="width:400px">
            <img class="card-img-top" src="" alt="Card image">
            <div class="card-body">
                <h4 class="card-title">${product.title} </h4>
                <p class="card-text">Бодрое описание товара.</p>
                <h6 class="card-title">${product.price}</h6>
                <c:url value="/cart/add" var="productAddToCartUrl">
                    <c:param name="id" value="${product.id}"/>
                </c:url>
                <a class="btn btn-primary" href="${productAddToCartUrl}"><i class="far fa-trash-alt"></i>Add to cart</a>
            </div>
        </div>

    </div>
</body>
</html>