package com.foody.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.foody.model.Cart;
import com.foody.model.FdOrder;
import com.foody.model.FdOrderItems;
import com.foody.model.Food;
import com.foody.service.FdOrderItemService;
import com.foody.service.FdOrderService;

@Controller
public class OrderController {

	@Autowired
	private FdOrderService fdOrderService;
	@Autowired
	private FdOrderItemService fdOrderItemService;
	
	@RequestMapping("/home")
	public String show8(HttpServletRequest req, Model model) {
		
		

		return "home";
	}

	@RequestMapping("/order")
	public String show2(HttpServletRequest req, HttpServletResponse res, Model model) {
		HttpSession session = req.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		model.addAttribute("cart", cart);
		ArrayList<Food> arr = cart.getFoods();
		double cartTotal = 0;
		for (Food arr1 : arr) {
			cartTotal = cartTotal + (double) (arr1.getUnitPrice() * arr1.getQuantity());

		}
		session.setAttribute("cartTotal", cartTotal);
		model.addAttribute("cartTotal", cartTotal);
		int deliverCharge;
		if (cartTotal == 0) {
			deliverCharge = 0;
		} else {
			deliverCharge = (int) (Math.random() * (50 - 30 + 1) + 30);
		}
		model.addAttribute("deliverCharge", deliverCharge);
		session.setAttribute("deliverCharge", deliverCharge);

		return "orderpage";
	}

	@RequestMapping("/orderPlacing")
	public String show5(HttpServletRequest req, HttpServletResponse res, Model model) {
		HttpSession session = req.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		cart.setUserId(1);
		cart.setRestaurantId(5);
		double price=(Double) session.getAttribute("cartTotal");
		int deliverPrice=(Integer) session.getAttribute("deliverCharge");
		double totalPrice=price+price*0.06+deliverPrice;
		FdOrder fdOrder = new FdOrder(cart.getUserId(), 2, cart.getRestaurantId(), "Requested",totalPrice);
		fdOrderService.save(fdOrder);
		model.addAttribute("cart", cart);
		ArrayList<Food> arr = cart.getFoods();
		model.addAttribute("cart", cart);
		session.setAttribute("orderId",fdOrder.getId());

		for (Food arr1 : arr) {
			
			if(arr1.getQuantity()!=0) {

			int n = arr1.getFoodId();
			fdOrderItemService.save(new FdOrderItems(fdOrder.getId(), n,arr1.getQuantity(),arr1.getUnitPrice()));
			}
		}

		return "orderPlaced";
	}

	@RequestMapping("/deleteItem")
	public String show3(HttpServletRequest req, Model model, @RequestParam("data") int val) {

		HttpSession session = req.getSession();
		Cart cart = (Cart) session.getAttribute("cart");

		ArrayList<Food> c = cart.getFoods();

		Food fd = cart.getFoodById(val);
		c.remove(fd);

		return "redirect:/order";
	}

	@RequestMapping("decrement")
	public String show4(HttpServletRequest req, Model model, @RequestParam("data") int val) {

		HttpSession session = req.getSession();
		Cart cart = (Cart) session.getAttribute("cart");

		Food fd = cart.getFoodById(val);
		ArrayList<Food> c = cart.getFoods();
		fd.setQuantity(fd.getQuantity() - 1);
		if (fd.getQuantity() == -1) {
			c.remove(fd);
		}

		return "redirect:/order";
	}

	@RequestMapping("increment")
	public String show5(HttpServletRequest req, Model model, @RequestParam("data") int val) {
		HttpSession session = req.getSession();
		Cart cart = (Cart) session.getAttribute("cart");

		Food fd = cart.getFoodById(val);
		fd.setQuantity(fd.getQuantity() + 1);

		return "redirect:/order";
	}
	
	@RequestMapping("cancelOrder")
	public String show6(HttpServletRequest req, Model model, @RequestParam("data") int val) {
		HttpSession session = req.getSession();
		int orderId=(Integer) session.getAttribute("orderId");
		
		fdOrderService.cancelOrder(orderId);
		return "redirect:/";
	}
	
	@RequestMapping("/MyOrders")
	public String show7(HttpServletRequest req, Model model) {

		HttpSession session = req.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		int userId=cart.getUserId();
		ArrayList<FdOrder> userOrders=fdOrderService.getAllOrders(userId);
		model.addAttribute("userOrders",userOrders);
		
		return "myorders";
	}
	
}
