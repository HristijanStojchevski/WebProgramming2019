package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    public List<Order> getAllOrders();
    public Order addOrder(String pizzaType,String pizzaSize, String clientName, String address);
    Order updateOrder(Order order);
    Optional<Order> findById(int orderId);
}
