<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<body>
<head>
    <title>Cart</title>
    <%@include file="head.jsp"%>
</head>
<body>
    <div class="container">
        <%@include file="menu.jsp"%>


        <div class="col-12">
            <table class="table table-bordered my-2">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">Title</th>
                        <th scope="col">Price</th>
                        <th scope="col">Count</th>
                        <th scope="col">Price</th>
                        <th scope="col">TotalPrice</th>
                        <th scope="col">Actions</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${requestScope.items}">
                <tr>
                    <th scope="row"><c:out value="${item.product.title}"/></th>
                    <th scope="row"><c:out value="${item.product.price}"/></th>
                    <th scope="row"><c:out value="${item.quantity}"/></th>
                    <th scope="row"><c:out value="${item.totalPrice}"/></th>
                    <td>
                        <c:url value="/cart/reduce" var="productReduceUrl">
                            <c:param name="id" value="${item.product.id}"/>
                        </c:url>
                        <a class="btn btn-danger" href="${productDeleteUrl}"><i class="far fa-trash-alt"></i>Reduce</a>
                    </td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
            <c:url value="/order" var="orderUrl"/>
            <a class="btn btn-warning" href="${orderUrl}">Place your order</a>
        </div>
    </div>
</body>
</html>