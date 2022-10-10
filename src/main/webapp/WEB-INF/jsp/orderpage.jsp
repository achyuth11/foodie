<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
<%@include file="/WEB-INF/css/orderpage.css"%>
</style>
</head>
<body>
<div id="main_container">





<div id="user_address">





Girish N
<br>
mysore
<br>
near basavanagudi circle
<br>
${cart.userId}
${cart.restaurantId}



</div>






<div id="food_container">
<div id="your_order"><h4> Your Order</h4></div>
<c:forEach items="${cart.foods}" var="element">
<div class="food">
  <div class="fd">${element.foodId}</div>
   <div class="fd">${element.foodName}</div>
    <div class="fd">${element.unitPrice}</div>
    
    <div class="fd"><a  href="decrement?data=${element.foodId}"><button>-</button></a><span id="qun">${element.quantity}</span><a  href="increment?data=${element.foodId}"><button>+</button></a></div>
    
    <div class="fd" id="remover_div"><a id="remover" href="deleteItem?data=${element.foodId}">Remove</a></div>
  </div>






</c:forEach>
</div>
<div id="bill_container">



<span class="left"> Cart Total Price</span> : <span class="right">    ${cartTotal}</span><br>
<span class="left">GST(CGST+SGST)</span> :     <span class="right">${cartTotal*0.06}</span><br>
<span class="left">Deliver Charge </span>:    <span class="right">${deliverCharge}</span><br>
<span class="left" style="color:Crimson">Cart Total Price</span> :    <span class="right" style="color:Crimson">${cartTotal+cartTotal*0.06+deliverCharge}</span><br>



</div>
<div id="p_order">
<a href="orderPlacing" id="placeorder">Place Order</a> </div>



</div>








</body>
<script type="text/javascript">






</script>





</html>