<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>





<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
<%@include file="/WEB-INF/css/orderPlace.css"%></style>
</head>
<body>
    <h1 style="margin-left: 35%">Order Confirmation page</h1>
    <div id="food_container">
        <div id="your_order">
            <h4>Your Order</h4>
        </div>
        <c:forEach items="${cart.foods}" var="element">
            <div class="food">
                <div class="fd">${element.foodId}</div>
                <div class="fd">${element.foodName}</div>
                <div class="fd">${element.unitPrice}</div>





              <div class="fd">${element.quantity}</div>
                <div class="fd">${element.quantity*element.unitPrice}</div>
            </div>
        </c:forEach>
         <div style="margin-top: 3%">
    <a  id="cancelorder" href="cancelOrder?data=${orderId}">Cancel Order</a>
    <a  id="track" href="trackOrder">Track Order</a>
    </div>
     <div id="cancelpolicy"><h2>Cancelation Policy</h2>
    <div>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
    tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
    quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
    consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
    cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
    proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
    </div>
    </div>
    </div>
    
    
</body>
</html>