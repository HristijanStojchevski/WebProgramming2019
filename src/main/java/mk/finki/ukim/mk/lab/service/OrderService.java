package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Order;

public interface OrderService {
    public Order placeOrder(int orderId,String pizzaType,String pizzaSize, String clientName, String address);
    Order updateOrder(int orderId,String pizzaType,String pizzaSize, String clientName, String address);
    Order addOrder(String pizzaType,String pizzaSize, String clientName, String address);
}
