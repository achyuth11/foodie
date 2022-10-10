<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
<%@include file="/WEB-INF/css/myorder.css"%>
</style>
</head>
<body>
<body>
         <div id="order_his" style="margin-left: 40%">
            <h2>Order History</h2>
        </div>
    <div id="food_container">
        <c:forEach items="${userOrders}" var="element">
            <div class="food">
                <div class="fd">Order ID:${element.id}</div>
                <div class="fd">Restaurant ID:${element.restId}</div>
                <div class="fd">Order Status:${element.orderStatus}</div>
                <div class="fd">Total Price${element.totalPrice}</div>
            </div>



       </c:forEach>
    </div>





</body>
</body>
</html>