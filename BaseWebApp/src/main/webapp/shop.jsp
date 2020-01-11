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
                <c:url value="/shop/create" var="productCreateUrl"/>
                <a class="btn btn-primary" href="${productCreateUrl}">Add Product</a>
            </div>

            <h3>Product list</h3>
            <div class="col-12">
                <table class="table table-bordered my-2">
                    <thead>
                        <tr>
                            <th scope="col">Id</th>
                            <th scope="col">Title</th>
                            <th scope="col">Description</th>
                            <th scope="col">Price</th>
                            <th scope="col">Actions</th>
                        </tr>
                    </thead>
                    <tbody>

                    <c:forEach var="product" items="${requestScope.products}">
                    <tr>
                        <th scope="row"><c:out value="${product.id}"/></th>
                        <td>
                            <c:url value="/shop/details" var="productDetailUrl">
                                <c:param name="id" value="${product.id}"/>
                            </c:url>
                            <a href="${productDetailUrl}" target="_blank">
                                <c:out value="${product.title}"/>
                            </a>
                        </td>
                        <td><c:out value="${product.description}"/></td>
                        <td><c:out value="${product.price}"/></td>
                        <td>
                            <c:url value="/shop/edit" var="productEditUrl">
                                <c:param name="id" value="${product.id}"/>
                            </c:url>
                            <a class="btn btn-success" href="${productEditUrl}"><i class="fas fa-edit"></i>Edit</a>
                            <c:url value="/shop/delete" var="productDeleteUrl">
                                <c:param name="id" value="${product.id}"/>
                            </c:url>
                            <a class="btn btn-danger" href="${productDeleteUrl}"><i class="far fa-trash-alt"></i>Delete</a>
                        </td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>