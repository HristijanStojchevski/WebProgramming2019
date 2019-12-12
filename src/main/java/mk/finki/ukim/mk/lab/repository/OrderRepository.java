package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.Order;

import java.util.ArrayList;
import java.util.List;

public interface OrderRepository {
    public List<Order> getAllOrders();
    public void addOrder(String pizzaType,String pizzaSize, String clientName, String address);
    public void createOrder();
}
