<%@page import="com.foody.model.Food"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.foody.model.Cart"%>
<html>
<body>
<h2>Hello World!</h2>




<%
ArrayList<Food> fds=new ArrayList<Food>();
Food f1=new Food(1,"roti",75);
Food f2=new Food(2,"Biryani",200);
Food f3=new Food(3,"kabab",100);
fds.add(f1);
fds.add(f2);
fds.add(f3);
Cart cart=new Cart();
cart.setUserId(1);
cart.setRestaurantId(12);
cart.setFoods(fds);

session.setAttribute("cart", cart);


%>
<a href="order">click here look into your order</a>
<a href="MyOrders">My orders</a>
</body>
</html>
