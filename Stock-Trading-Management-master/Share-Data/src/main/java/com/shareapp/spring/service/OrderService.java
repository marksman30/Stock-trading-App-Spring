package com.shareapp.spring.service;
import org.springframework.stereotype.Service;

import com.shareapp.spring.model.Order;
import com.shareapp.spring.model.Share;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

	public List<Order> ShowOrderList(HttpServletRequest request) {
		HttpSession session= request.getSession();
		List<Order> orderList = new ArrayList<>();
		int user_id=(int)session.getAttribute("uid");
		try{
			String query="select s.id,s.name,s.price,o.quantity from share s,orders o where s.id=o.share_id and o.user_id="+user_id+";";
			Connection connection=Jdbc.JdbcConnect();
			Statement st = connection.createStatement();
			ResultSet rs =st.executeQuery(query);
			while(rs.next()) {
				Order order=new Order();
				order.setShare_id(rs.getInt("id"));
				order.setShare_name(rs.getString("name"));
				order.setShare_price(rs.getDouble("price"));
				order.setQuantity(rs.getInt("quantity"));
				orderList.add(order);
			}
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return orderList;
	}

	public double calculateCost(Share share,Order order,String category) {
		double amt = 0.0;
		if(category.equalsIgnoreCase("Buy")) {
			amt = order.getQuantity()*share.getPrice();
		} else {
			amt = order.getQuantity()*share.getPrice();
		}

		return amt;
	}
}
